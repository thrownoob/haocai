package com.haocai.web.UUID;

import java.util.UUID;

public class Uuid {
 
	public static String getUUID(){
        UUID uuid=UUID.randomUUID();
        String str = uuid.toString(); 
        String uuidStr=str.replace("-", "");
        return uuidStr;
      }
	
}
