package com.haocai.web.service;


import java.util.List;


import com.haocai.web.mod.Equipment;

public interface Equservice {
	public int inse(Equipment equ); 
	public int equsec(String a);
	public int equupd(Equipment equ);
	 public List<Equipment> getkey(String eid);
	 public List<Equipment> selectByPrimaryKey(Equipment equ);

	 public int getequcount(Equipment equ);
}
