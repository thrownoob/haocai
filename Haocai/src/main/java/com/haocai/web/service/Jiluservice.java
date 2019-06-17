package com.haocai.web.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.haocai.web.mod.Jilu;
import com.haocai.web.mod.JiluHaocai;

public interface Jiluservice {
   public int jiluins(Jilu jilu,HttpServletRequest request);
   public List<Jilu> sejilu(Jilu jilu);
   public int getcount(Jilu jilu);

}
