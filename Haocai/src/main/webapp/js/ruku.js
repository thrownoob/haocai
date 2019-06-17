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
			   url:"/Haocai/equ/equget",
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
		    url:"/Haocai/equ/equins",
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
	injilu:function(){
		$.ajax({
			type:"post",
		    url:"/Haocai/jilu/jiluins",
		    dataType:"json",
		    data:$('#rukuqiyong').serialize(),
		    success:function(data){
		    	layer.msg("jilu成功");
		    	
		    },
		    error:function(){
		    	alert("记录添加错误");
		    }
		})
	},
	upqiyong:function(){
		var r1=0;
		$.ajax({
			type:"post",
		    url:"/Haocai/equ/equupt",
		    dataType:"json",
		    async : false,
		    data:$('#rukuqiyong').serialize(),
		    success:function(data){
		    	r1=data
		    	if(data==0){
		    	
		    		layer.msg("该设备已启用");
		    	}else{
			    	layer.msg("启用成功");
		    	}

		    	
		    },
		    error:function(){
		    	alert("启用失败错误");
		    }
		});
		return r1;
	},
	
	rukuqiyong:function(){
		if(methods.checkMustMes2()){
			var a=$("input[name='sex']:checked").val();
			 if(a=="入库"){
			
				 if(methods.chaxuneid()==""){
					
				methods.inruku();
				methods.injilu();
				
			
						 
					 
						
				 }else{
					 layer.msg("编号库内已有");
				 }
			 }else{
				 if(methods.chaxuneid()==""){
					 layer.msg("未找到eid");
				 }else{
					
					 if (methods.upqiyong()==1){
						 methods.injilu();
					 }
					 
				 }
				 alert("启用");
			 }
		}
		
	}
}