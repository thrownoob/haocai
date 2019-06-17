	$(function () {

		$('#search_btn').click(function () {//记录查询按钮
	    	 
	    	$("#tb  tr:not(:first)").html("");
	        methods.seachHaocaijilu();
	    })
	    
	  
  $('#back_btn').click(function () {
        $('.form-control').val('');
       
        window.location.reload();
        methods.resectList();
    })
	})
	
	var methods = {
	    seachHaocaijilu: function(){
	    	$.ajax({
	    		type:"post",
	    		url:"/Haocai/hao/getallhaocaibyname",
	    	    dataType:"json",
	    	    data: $('#getallhaocaiform').serialize(),
	    	    
	    	    success : function(data){
	    	    	alert(data);
	    	    	  if(data== "368"){
	      	     	window.location.href="/Haocai/";
	    	    	  }
//	    	    	 var tb = document.getElementById("tb");
//	 	    	    //删除原先数据，2 为保留表头，值为表头行数减1
//	 	    	    for (var n = tb.rows.length ; n > 1; n--) { 
//	 	    	        tb.deleteRow(n);
//	 	    	    }
	    	    	$.each(data,function(index,item){
	    	    		if(item.name== "null"){
	    	    			bootbox.alert({
	        	                title: "@gua",
	        	                message: "无此记录",
	        	                
	        	            })
	    	    		}else{
	    	    			  var tr;
	    	    	            tr += "<th>" + item.name + "</th>";
	    	    	          tr += "<th>" + item.cnumber + "</th>";
	    	    	            tr += "<th>" + item.ctime + "</th>";
	    	    	            $("#tb").append("<tr>"+tr+"</tr>");
	    	    		}
	    	      
	    	    	});
	    	    	},
	    	error : function(XMLHttpRequest, textStatus, errorThrown)  {
	    		alert(XMLHttpRequest.status);
	            alert(XMLHttpRequest.readyState);
	            alert(textStatus);
	    		bootbox.alert({
	                title: "@gua",
	                message: "异常",
	                
	            })
	        }
	    	     
	    	    
	    		
	    	})
	    	


	    },  
	    addbtn: function(){
	    	  if( methods.checkMustMes1()== true){
	    	$.ajax({
	    		type:"post",
	    		url:"/Haocai/hao/gethaocaibyname",
	    	    dataType:"json",
	    	    data: $('#addform').serialize(),
	    	    
	    	    success : function(data){
	    	    	alert(data);
	    	    	  if(data== "368"){
	      	     	window.location.href="/Haocai/";
	    	    	  }
         
                            if(data==1){
                            	$.ajax({
                            		type:"post",
                    	    		url:"/Haocai/hao/addhaocai",
                    	    	    dataType:"json",
                    	    	    data: $('#addform').serialize(),
                    	    	    success : function(data1){
                    	    	    	if(data1==1){
                    	    	    		bootbox.alert({
                    	    	                title: "@gua",
                    	    	                message: "添加成功",
                    	    	                
                    	    	            })
                    	    	    		
                    	    	    	}else{
                    	    	    		bootbox.alert({
                    	    	                title: "@gua",
                    	    	                message: "添加失败",
                    	    	                
                    	    	            })
                    	    	    	}
                    	    	    }
                            	})
                            }

                            if(data==0){
                            	bootbox.alert({
        	    	                title: "@gua",
        	    	                message: "库内已有",
        	    	                
        	    	            })
                            }
	    	    	}
	    	})
	    	  }
	    	    	},
	    	error : function(XMLHttpRequest, textStatus, errorThrown)  {
	    		alert(XMLHttpRequest.status);
	            alert(XMLHttpRequest.readyState);
	            alert(textStatus);
	    		bootbox.alert({
	                title: "@gua",
	                message: "异常",
	                
	            })
	        },
	        checkMustMes1: function () {
	       	
	       		  if ($('.Name1').val().trim()==='') {
	       	            bootbox.alert({
	       	                title: "@gua",
	       	                message: "姓名为必选项，请填写",
	       	                closeButton:false
	       	            })
	       	            hasNullMes = true;
	       	            return
	       	        }
	       		  if ($('.Number1').val().trim()==='') {
	       	            bootbox.alert({
	       	                title: "@gua",
	       	                message: "数量为必选项，请填写",
	       	                closeButton:false
	       	            })
	       	            hasNullMes = true;
	       	            return
	       	        }
	     
	     	 return true;
	       },
	       checkMustMes2:function(){
	    	 	
		       	  if ($('.Name2').val().trim()==='') {
		               bootbox.alert({
		                   title: "@gua",
		                   message: "姓名为必选项，请填写",
		                   closeButton:false
		               })
		               hasNullMes = true;
		               return
		           }
		           if ($('.Zhi2').val().trim()==='') {
		               bootbox.alert({
		                   title: "@gua",
		                   message: "支行为必选项，请填写",
		                   closeButton:false
		               })
		               hasNullMes = true;
		               return
		           }
		           if ($('.Number2').val().trim()==='') {
		               bootbox.alert({
		                   title: "@gua",
		                   message: "数量为必选项，请填写",
		                   closeButton:false
		               })
		               hasNullMes = true;
		               return
		           }
		       
		           if ($('.Tname2').val().trim()==='') {
		               bootbox.alert({
		                   title: "@gua",
		                   message: "领取人为必选项，请填写",
		                   closeButton:false
		               })
		               hasNullMes = true;
		               return
		           }
		           return true;
	       },
	        downup:function(){
	       	  if( methods.checkMustMes2()== true){
	        	var aa=document.getElementById("tip").value;
	        	if(aa=="1"){
	          
	        		$.ajax({
		        		type:"post",
			    		url:"/Haocai/hao/downhaocai",
			    	    dataType:"json",
			    	    data: $('#downup').serialize(),
		        		success : function(data){
		        			  if(data== "368"){
		      	      	     	window.location.href="/Haocai/";
		      	    	    	  }
		        			alert(data);
		        			if(data==1){
		        		 $.ajax({
		        		   type:"post",
			    		   url:"/Haocai/jiluhaocai/addjilu",
			    	       dataType:"json",
			    	       data: $('#downup').serialize(),
			    	       success : function(data){	    
		
			    	    	   if(data==1){
			    	    		   bootbox.alert({
					                   title: "@gua",
					                   message: "OJBK",
					                 
					               })
					               
			    	    	   }
			    	       },
			    	       error:function(){
			    	    	   alert("222");
			    	       }
		        		 
			    	       
		        			})
		        			}
		        		}
		        	})
	        	}
                if(aa=="0"){
	        	$.ajax({
	        		type:"post",
		    		url:"/Haocai/hao/uphaocai",
		    	    dataType:"json",
		    	    data: $('#downup').serialize(),
		    	    success : function(data){
		    	    	  if(data== "368"){
		  	      	     	window.location.href="/Haocai/";
		  	    	    	  }
		    	    	$.ajax({
		    	    		type:"post",
				    		url:"/Haocai/jiluhaocai/addjilu",
				    	    dataType:"json",
				    	    data: $('#downup').serialize(),
				    	    success : function(data){
				    	  
				    	    	if(data==1){
				    	    	     bootbox.alert({
						                   title: "@gua",
						                   message: "OJBK",
						                 
						               })
				    	    	}
				    	    }
		    	    	})
		    	    }
	        	})
	        	}       	
	        }
	        }
	  }
