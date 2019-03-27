package com.haocai.web.mod;

import java.io.Serializable;

/**
 * cat
 * @author 
 */
public class Cat implements Serializable {
    private String categary;

    private String ename;

    private Integer cnumber;

    private static final long serialVersionUID = 1L;

    public String getCategary() {
        return categary;
    }

    public void setCategary(String categary) {
        this.categary = categary;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Integer getCnumber() {
        return cnumber;
    }

    public void setCnumber(Integer cnumber) {
        this.cnumber = cnumber;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Cat other = (Cat) that;
        return (this.getCategary() == null ? other.getCategary() == null : this.getCategary().equals(other.getCategary()))
            && (this.getEname() == null ? other.getEname() == null : this.getEname().equals(other.getEname()))
            && (this.getCnumber() == null ? other.getCnumber() == null : this.getCnumber().equals(other.getCnumber()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCategary() == null) ? 0 : getCategary().hashCode());
        result = prime * result + ((getEname() == null) ? 0 : getEname().hashCode());
        result = prime * result + ((getCnumber() == null) ? 0 : getCnumber().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", categary=").append(categary);
        sb.append(", ename=").append(ename);
        sb.append(", cnumber=").append(cnumber);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}