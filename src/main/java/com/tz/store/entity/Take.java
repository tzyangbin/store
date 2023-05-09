package com.tz.store.entity;

import java.io.Serializable;

/**
 * 打药实体类
 *
 * @author yang
 * @version 2023/5/2 22:50
 * @ClassName Take
 * @since jdk11
 */
public class Take extends BaseEntity implements Serializable {
    private Integer id;
    private Integer uid;
    /**
     * 操作日期
     */
    private String date;
    /**
     * 打药区域
     */
    private String area;
    /**
     * 负责人
     */
    private String manager;
    /**
     * 操作人员
     */
    private String operator;
    /**
     * 状态,是否删除
     */
    private Integer status;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Take)) return false;

        Take take = (Take) o;

        if (getId() != null ? !getId().equals(take.getId()) : take.getId() != null) return false;
        if (getUid() != null ? !getUid().equals(take.getUid()) : take.getUid() != null) return false;
        if (getDate() != null ? !getDate().equals(take.getDate()) : take.getDate() != null) return false;
        if (getArea() != null ? !getArea().equals(take.getArea()) : take.getArea() != null) return false;
        if (getManager() != null ? !getManager().equals(take.getManager()) : take.getManager() != null) return false;
        if (getOperator() != null ? !getOperator().equals(take.getOperator()) : take.getOperator() != null)
            return false;
        return getStatus() != null ? getStatus().equals(take.getStatus()) : take.getStatus() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getUid() != null ? getUid().hashCode() : 0);
        result = 31 * result + (getDate() != null ? getDate().hashCode() : 0);
        result = 31 * result + (getArea() != null ? getArea().hashCode() : 0);
        result = 31 * result + (getManager() != null ? getManager().hashCode() : 0);
        result = 31 * result + (getOperator() != null ? getOperator().hashCode() : 0);
        result = 31 * result + (getStatus() != null ? getStatus().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Take{" +
                "id=" + id +
                ", uid=" + uid +
                ", date='" + date + '\'' +
                ", area='" + area + '\'' +
                ", manager='" + manager + '\'' +
                ", operator='" + operator + '\'' +
                ", status=" + status +
                '}';
    }
}
