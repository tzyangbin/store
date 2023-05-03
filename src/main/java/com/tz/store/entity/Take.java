package com.tz.store.entity;

import java.io.Serializable;

/**
 * 打药实体类
 *
 * @author yang
 * @version 2023/5/2 22:50
 * @ClassName Daoyao
 * @since jdk11
 */
public class Take extends BaseEntity implements Serializable {
    private Integer id;
    private String date;
    private String area;
    private String emp;
    private String take;
    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getEmp() {
        return emp;
    }

    public void setEmp(String emp) {
        this.emp = emp;
    }

    public String getTake() {
        return take;
    }

    public void setTake(String take) {
        this.take = take;
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

        Take take1 = (Take) o;

        if (getId() != null ? !getId().equals(take1.getId()) : take1.getId() != null) return false;
        if (getDate() != null ? !getDate().equals(take1.getDate()) : take1.getDate() != null) return false;
        if (getArea() != null ? !getArea().equals(take1.getArea()) : take1.getArea() != null) return false;
        if (getEmp() != null ? !getEmp().equals(take1.getEmp()) : take1.getEmp() != null) return false;
        if (getTake() != null ? !getTake().equals(take1.getTake()) : take1.getTake() != null) return false;
        return getStatus() != null ? getStatus().equals(take1.getStatus()) : take1.getStatus() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getDate() != null ? getDate().hashCode() : 0);
        result = 31 * result + (getArea() != null ? getArea().hashCode() : 0);
        result = 31 * result + (getEmp() != null ? getEmp().hashCode() : 0);
        result = 31 * result + (getTake() != null ? getTake().hashCode() : 0);
        result = 31 * result + (getStatus() != null ? getStatus().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Take{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", area='" + area + '\'' +
                ", emp='" + emp + '\'' +
                ", take='" + take + '\'' +
                ", status=" + status +
                '}';
    }
}
