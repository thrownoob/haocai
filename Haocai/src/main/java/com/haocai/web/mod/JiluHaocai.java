package com.haocai.web.mod;

import java.io.Serializable;

/**
 * jilu_haocai
 * @author 
 */
public class JiluHaocai implements Serializable {
    private String tid;

    private String name;

    private String ttime;

    private String cnumber;

    private String tzhihang;

    private String tname;

    private String cname;

    private String tip;

    private String gcname;
    
    private String timebegin;
    
    private String timeend;

    public String getTimebegin() {
		return timebegin;
	}

	public void setTimebegin(String timebegin) {
		this.timebegin = timebegin;
	}

	public String getTimeend() {
		return timeend;
	}

	public void setTimeend(String timeend) {
		this.timeend = timeend;
	}

	private static final long serialVersionUID = 1L;

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTtime() {
        return ttime;
    }

    public void setTtime(String ttime) {
        this.ttime = ttime;
    }

    public String getCnumber() {
        return cnumber;
    }

    public void setCnumber(String cnumber) {
        this.cnumber = cnumber;
    }

    public String getTzhihang() {
        return tzhihang;
    }

    public void setTzhihang(String tzhihang) {
        this.tzhihang = tzhihang;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getGcname() {
        return gcname;
    }

    public void setGcname(String gcname) {
        this.gcname = gcname;
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
        JiluHaocai other = (JiluHaocai) that;
        return (this.getTid() == null ? other.getTid() == null : this.getTid().equals(other.getTid()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getTtime() == null ? other.getTtime() == null : this.getTtime().equals(other.getTtime()))
            && (this.getCnumber() == null ? other.getCnumber() == null : this.getCnumber().equals(other.getCnumber()))
            && (this.getTzhihang() == null ? other.getTzhihang() == null : this.getTzhihang().equals(other.getTzhihang()))
            && (this.getTname() == null ? other.getTname() == null : this.getTname().equals(other.getTname()))
            && (this.getCname() == null ? other.getCname() == null : this.getCname().equals(other.getCname()))
            && (this.getTip() == null ? other.getTip() == null : this.getTip().equals(other.getTip()))
            && (this.getGcname() == null ? other.getGcname() == null : this.getGcname().equals(other.getGcname()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTid() == null) ? 0 : getTid().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getTtime() == null) ? 0 : getTtime().hashCode());
        result = prime * result + ((getCnumber() == null) ? 0 : getCnumber().hashCode());
        result = prime * result + ((getTzhihang() == null) ? 0 : getTzhihang().hashCode());
        result = prime * result + ((getTname() == null) ? 0 : getTname().hashCode());
        result = prime * result + ((getCname() == null) ? 0 : getCname().hashCode());
        result = prime * result + ((getTip() == null) ? 0 : getTip().hashCode());
        result = prime * result + ((getGcname() == null) ? 0 : getGcname().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", tid=").append(tid);
        sb.append(", name=").append(name);
        sb.append(", ttime=").append(ttime);
        sb.append(", cnumber=").append(cnumber);
        sb.append(", tzhihang=").append(tzhihang);
        sb.append(", tname=").append(tname);
        sb.append(", cname=").append(cname);
        sb.append(", tip=").append(tip);
        sb.append(", gcname=").append(gcname);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}