package com.haocai.web.service;

import java.util.List;

import com.haocai.web.mod.Jilu;
import com.haocai.web.mod.JiluHaocai;

public interface Jiluservice {
   public int jiluins(Jilu jilu);
   public List<Jilu> sejilu(Jilu jilu);
   public int getcount(Jilu jilu);

}
