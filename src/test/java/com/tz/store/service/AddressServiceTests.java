package com.tz.store.service;


import com.tz.store.entity.Address;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressServiceTests {
    @Autowired
    private IAddressService addressService;

    @Test
    public void addNewAddress() {
        Integer uid = 19;
        String username = "管理员";
        Address address = new Address();
        address.setName("张三");
        address.setPhone("17858805555");
        address.setAddress("雁塔区小寨华旗");
        addressService.addNewAddress(uid, username, address);
        System.out.println("OK.");
    }

    @Test
    public void getByUid() {
        Integer uid = 19;
        List<Address> list = addressService.getByUid(uid);
        System.out.println("count=" + list.size());
        for (Address item : list) {
            System.out.println(item);
        }
    }

    @Test
    public void setDefault() {
        Integer aid = 7;
        Integer uid = 19;
        String username = "系统管理员";
        addressService.setDefault(aid, uid, username);
        System.out.println("OK.");
    }


}
