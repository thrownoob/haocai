package com.haocai.web.service;

import com.haocai.web.mod.Haocai;

public interface Haocaiservice {
       
	public Haocai getbyname(String aname);
	public int  addHaocai(Haocai haocai);
	public int uphaocainumberup(Haocai haocai);//出入库改变数量
	public int uphaocainumberdown(Haocai haocai);//出入库改变数量
	
}
