$(function () {
	$('#downupbtn').click(function () {//记录查询按钮
   	 
    	$("#tb  tr:not(:first)").html("");
        methods.rukuqiyong();
    })
}) 
var methods={
	
	 checkMustMes2:function(){
 	 	

          if ($('#eid').val().trim()==='') {
       	   layer.msg("编号为必选项，请填写");
              return false;
          }
          if ($('#ard').val().trim()==='') {
       	   layer.msg("现所在为必选项，请填写");
              return false;
          }
          
          return true;
  },

	chaxuneid:function(){//判断编号
		var a;
		 $.ajax({
	    		
			 type:"post",
			   url:"http://192.168.1.92:8080/Haocai/equ/equget",
			   dataType:"json",
			   data:$('#eid').serialize(),
			   async: false,
	    	    success : function(data){
	    	    	
	    	    a=data;
	    	    },
	    	    error:function(){
	    	    	alert("查询eid错误");
	    	    }
	    	    })
	    
	    	    return a;
		
	},
	inruku:function(){
		
		$.ajax({
			type:"post",
		    url:"http://192.168.1.92:8080/Haocai/equ/equins",
		    dataType:"json",
		    data:$('#rukuqiyong').serialize(),
		    success:function(data){
		    	layer.msg("入库成功");
		    	
		    },
		    error:function(){
		    	alert("入库添加错误");
		    }
		})
	
	},
	rukuqiyong:function(){
		if(methods.checkMustMes2()){
			var a=$("input[name='sex']:checked").val();
			 if(a=="入库"){
			
				 if(methods.chaxuneid()==""){
					
				methods.inruku();
						 
					 
						
				 }else{
					 layer.msg("编号库内已有");
				 }
			 }else{
				 alert("启用");
			 }
		}
		
	}
}