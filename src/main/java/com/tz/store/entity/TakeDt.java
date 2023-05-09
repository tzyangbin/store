package com.tz.store.entity;

import java.io.Serializable;

/**
 * @author yang
 * @version 2023/5/3 11:08
 * @since jdk11
 */
public class TakeDt extends BaseEntity implements Serializable {
    private Integer id;
    private Integer did;
    private String name;
    private String param;
    private String dosage;
    private Integer volume;
    private Integer dose;
    private Integer charge;
    private String weight;
    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public Integer getDose() {
        return dose;
    }

    public void setDose(Integer dose) {
        this.dose = dose;
    }

    public Integer getCharge() {
        return charge;
    }

    public void setCharge(Integer charge) {
        this.charge = charge;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
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
        if (!(o instanceof TakeDt)) return false;

        TakeDt takeDt = (TakeDt) o;

        if (getId() != null ? !getId().equals(takeDt.getId()) : takeDt.getId() != null) return false;
        if (getDid() != null ? !getDid().equals(takeDt.getDid()) : takeDt.getDid() != null) return false;
        if (getName() != null ? !getName().equals(takeDt.getName()) : takeDt.getName() != null) return false;
        if (getParam() != null ? !getParam().equals(takeDt.getParam()) : takeDt.getParam() != null) return false;
        if (getDosage() != null ? !getDosage().equals(takeDt.getDosage()) : takeDt.getDosage() != null) return false;
        if (getVolume() != null ? !getVolume().equals(takeDt.getVolume()) : takeDt.getVolume() != null) return false;
        if (getDose() != null ? !getDose().equals(takeDt.getDose()) : takeDt.getDose() != null) return false;
        if (getCharge() != null ? !getCharge().equals(takeDt.getCharge()) : takeDt.getCharge() != null) return false;
        if (getWeight() != null ? !getWeight().equals(takeDt.getWeight()) : takeDt.getWeight() != null) return false;
        return getStatus() != null ? getStatus().equals(takeDt.getStatus()) : takeDt.getStatus() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getDid() != null ? getDid().hashCode() : 0);
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getParam() != null ? getParam().hashCode() : 0);
        result = 31 * result + (getDosage() != null ? getDosage().hashCode() : 0);
        result = 31 * result + (getVolume() != null ? getVolume().hashCode() : 0);
        result = 31 * result + (getDose() != null ? getDose().hashCode() : 0);
        result = 31 * result + (getCharge() != null ? getCharge().hashCode() : 0);
        result = 31 * result + (getWeight() != null ? getWeight().hashCode() : 0);
        result = 31 * result + (getStatus() != null ? getStatus().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TakeDt{" +
                "id=" + id +
                ", did=" + did +
                ", name='" + name + '\'' +
                ", param='" + param + '\'' +
                ", dosage='" + dosage + '\'' +
                ", volume=" + volume +
                ", dose=" + dose +
                ", charge=" + charge +
                ", weight='" + weight + '\'' +
                ", status=" + status +
                '}';
    }
}
