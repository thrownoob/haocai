package com.haocai.web.service;

import java.util.List;

import com.haocai.web.mod.Cat;

public interface Catservice {
	public int inse(Cat cat); 
   
    public List<Cat> getkey();
    public List<Cat> getcatdn(Cat cat);
}
