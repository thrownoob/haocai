package com.haocai.web.mod;

import java.io.Serializable;

/**
 * tna
 * @author 
 */
public class Tna implements Serializable {
    private String ename;

    private Integer enumber;

    private static final long serialVersionUID = 1L;

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Integer getEnumber() {
        return enumber;
    }

    public void setEnumber(Integer enumber) {
        this.enumber = enumber;
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
        Tna other = (Tna) that;
        return (this.getEname() == null ? other.getEname() == null : this.getEname().equals(other.getEname()))
            && (this.getEnumber() == null ? other.getEnumber() == null : this.getEnumber().equals(other.getEnumber()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getEname() == null) ? 0 : getEname().hashCode());
        result = prime * result + ((getEnumber() == null) ? 0 : getEnumber().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", ename=").append(ename);
        sb.append(", enumber=").append(enumber);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}