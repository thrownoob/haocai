package com.haocai.web.service;

import java.util.List;

import com.haocai.web.mod.Haocai;
import com.haocai.web.mod.JiluHaocai;

public interface Haocaiservice {
       
	public Haocai getbyname(String aname);
	public List<Haocai> getallhaocai(String name);
	public int  addHaocai(Haocai haocai);
	public int uphaocainumberup(Haocai haocai);//出入库改变数量
	public int uphaocainumberdown(Haocai haocai);//出入库改变数量
	public List<Haocai> getname();
	public String getnumber(String name);
	
	public List<Haocai> gethaocainumber(Haocai haocai);
	public int getcountnumber(Haocai haocai);
}
