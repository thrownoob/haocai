package com.haocai.web.mod;

import java.io.Serializable;
import java.util.Date;

/**
 * equipment
 * @author 
 */
public class Equipment implements Serializable {
    private String eid;

    private String categary;

    private Date gettime;

    private String ard;

    private String usetime;

    private String yr;

    private String fixed;
    
    private Integer page;
    
    private Integer limit;

    public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	private static final long serialVersionUID = 1L;

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public String getCategary() {
        return categary;
    }

    public void setCategary(String categary) {
        this.categary = categary;
    }

    public Date getGettime() {
        return gettime;
    }

    public void setGettime(Date gettime) {
        this.gettime = gettime;
    }

    public String getArd() {
        return ard;
    }

    public void setArd(String ard) {
        this.ard = ard;
    }

    public String getUsetime() {
        return usetime;
    }

    public void setUsetime(String usetime) {
        this.usetime = usetime;
    }

    public String getYr() {
        return yr;
    }

    public void setYr(String yr) {
        this.yr = yr;
    }

    public String getFixed() {
        return fixed;
    }

    public void setFixed(String fixed) {
        this.fixed = fixed;
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
        Equipment other = (Equipment) that;
        return (this.getEid() == null ? other.getEid() == null : this.getEid().equals(other.getEid()))
            && (this.getCategary() == null ? other.getCategary() == null : this.getCategary().equals(other.getCategary()))
            && (this.getGettime() == null ? other.getGettime() == null : this.getGettime().equals(other.getGettime()))
            && (this.getArd() == null ? other.getArd() == null : this.getArd().equals(other.getArd()))
            && (this.getUsetime() == null ? other.getUsetime() == null : this.getUsetime().equals(other.getUsetime()))
            && (this.getYr() == null ? other.getYr() == null : this.getYr().equals(other.getYr()))
            && (this.getFixed() == null ? other.getFixed() == null : this.getFixed().equals(other.getFixed()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getEid() == null) ? 0 : getEid().hashCode());
        result = prime * result + ((getCategary() == null) ? 0 : getCategary().hashCode());
        result = prime * result + ((getGettime() == null) ? 0 : getGettime().hashCode());
        result = prime * result + ((getArd() == null) ? 0 : getArd().hashCode());
        result = prime * result + ((getUsetime() == null) ? 0 : getUsetime().hashCode());
        result = prime * result + ((getYr() == null) ? 0 : getYr().hashCode());
        result = prime * result + ((getFixed() == null) ? 0 : getFixed().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", eid=").append(eid);
        sb.append(", categary=").append(categary);
        sb.append(", gettime=").append(gettime);
        sb.append(", ard=").append(ard);
        sb.append(", usetime=").append(usetime);
        sb.append(", yr=").append(yr);
        sb.append(", fixed=").append(fixed);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}