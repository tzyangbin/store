package com.tz.store.service.impl;

import com.tz.store.entity.Address;
import com.tz.store.mapper.AddressMapper;
import com.tz.store.service.IAddressService;
import com.tz.store.service.IDistrictService;
import com.tz.store.service.ex.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author yang
 * 新增收货地址实现类
 * @version 2023/4/27 22:17
 * @ClassName AddressServiceImpl
 * @since jdk11
 */
@Service
public class AddressServiceImpl implements IAddressService {
    //调用AddressMapper层,并装配,可以调用addressMapper方法
    @Autowired
    private AddressMapper addressMapper;
    //在添加用户的收货址的业务层依赖于IDistrictService的业务层接口
    @Autowired
    private IDistrictService districtService;

    @Value("${user.address.max-count}")
    private Integer maxCount;

    @Override
    public void addNewAddress(Integer uid, String username, Address address) {
        // 根据参数uid调用addressMapper的countByUid(Integer uid)方法，统计当前用户的收货地址数据的数量
        Integer count = addressMapper.countByUid(uid);
        // 判断数量是否达到上限值
        if (count > maxCount) {
            // 是：抛出AddressCountLimitException
            throw new AddressCountLimitException("收货地址数量已经达到上限(" + maxCount + ")！");
        }
        // 补全数据：省、市、区的名称,对address对象中的数据进行补全
        String provinceName = districtService.getNameByCode(address.getProvinceCode());
        String cityName = districtService.getNameByCode(address.getCityCode());
        String areaName = districtService.getNameByCode(address.getAreaCode());
        address.setProvinceName(provinceName);
        address.setCityName(cityName);
        address.setAreaName(areaName);

        // 补全数据：将参数uid封装到参数address中
        address.setUid(uid);
        // 补全数据：根据以上统计的数量，得到正确的isDefault值(是否默认：0-不默认，1-默认)，并封装
        Integer isDefault = count == 0 ? 1 : 0;
        address.setIsDefault(isDefault);
        // 补全数据：4项日志
        Date now = new Date();
        address.setCreatedUser(username);
        address.setCreatedTime(now);
        address.setModifiedUser(username);
        address.setModifiedTime(now);

        // 调用addressMapper的insert(Address address)方法插入收货地址数据，并获取返回的受影响行数
        Integer rows = addressMapper.insert(address);
        // 判断受影响行数是否不为1
        if (rows != 1) {
            // 是：抛出InsertException
            throw new InsertException("插入收货地址数据时出现未知错误，请联系系统管理员！");
        }
    }

    @Override
    public List<Address> getByUid(Integer uid) {
        List<Address> list = addressMapper.findByUid(uid);
        for (Address address : list) {
            address.setUid(null);
            address.setProvinceCode(null);
            address.setCityCode(null);
            address.setAreaCode(null);
            address.setCreatedUser(null);
            address.setCreatedTime(null);
            address.setModifiedUser(null);
            address.setModifiedTime(null);
        }
        return list;
    }

    //设置默认收货地址
    @Override
    public void setDefault(Integer aid, Integer uid, String username) {
        // 根据参数aid，调用findByAid()查询收货地址数据
        Address result = addressMapper.findByAid(aid);
        // 判断查询结果是否为null
        if (result == null) {
            // 是：抛出AddressNotFoundException
            throw new AddressNotFoundException("尝试访问的收货地址数据不存在");
        }

        // 检测当前获到的收货地址数据的归属,判断查询结果中的uid与参数uid是否不一致(使用equals()判断)
        if (!result.getUid().equals(uid)) {
            // 是：抛出AccessDeniedException：非法访问
            throw new AccessDeniedException("非常访问");
        }
        // 调用addressMapper的updateNonDefaultByUid()将该用户的所有收货地址全部设置为非默认，并获取返回受影响的行数
        Integer rows = addressMapper.updateNonDefaultByUid(uid);
        // 判断受影响的行数是否小于1(不大于0)
        if (rows < 1) {
            // 是：抛出UpdateException
            throw new UpdateException("设置默认收货地址时出现未知错误[1]");
        }
        // 调用addressMapper的updateDefaultByAid()将指定aid的收货地址设置为默认，并获取返回的受影响的行数
        rows = addressMapper.updateDefaultByAid(aid, username, new Date());
        // 判断受影响的行数是否不为1
        if (rows != 1) {
            // 是：抛出UpdateException
            throw new UpdateException("设置默认收货地址时出现未知错误[2]");
        }
    }
}
