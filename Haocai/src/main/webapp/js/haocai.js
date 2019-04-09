	$(function () {
		$('#search_btn').click(function () {//记录查询按钮
	    	 
	    	$("#tb  tr:not(:first)").html("");
	        methods.seachHaocaijilu();
	    })
	    
	    	$('#add_btn').click(function () {//记录查询按钮
	    	 
	    	$("#tb  tr:not(:first)").html("");
	        methods.addbtn();
	    })
	})
	
	var methods = {
	    seachHaocaijilu: function(){
	    	$.ajax({
	    		type:"post",
	    		url:"http://localhost:8080/Haocai/jiluhaocai/getjiluhaocai",
	    	    dataType:"json",
	    	    data: $('#haocaijiluform').serialize(),
	    	    
	    	    success : function(data){
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
	    	    	            tr += "<th>" + item.tzhihang + "</th>";
	    	    	            tr += "<th>" + item.tnumber + "</th>";
	    	    	            tr += "<th>" + item.cname + "</th>";
	    	    	            tr += "<th>" + item.tname + "</th>";
	    	    	            if(item.tip == "0"){
	    	    	            	 tr += "<th>入库</th>";
	    	    	            }
	    	    	            
	    	    	            if(item.tip == "1"){
	    	    	            	tr += "<th>出库</th>";
								}
	    	    	           
	    	    	            tr += "<th>" + item.gcnum + "</th>";
	    	    	            tr += "<th>" + item.ttime + "</th>";
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
	    	$.ajax({
	    		type:"post",
	    		url:"http://localhost:8080/Haocai/hao/gethaocaibyname",
	    	    dataType:"json",
	    	    data: $('#addform').serialize(),
	    	    
	    	    success : function(data){
//	    	    	 var tb = document.getElementById("tb");
//	 	    	    //删除原先数据，2 为保留表头，值为表头行数减1
//	 	    	    for (var n = tb.rows.length ; n > 1; n--) { 
//	 	    	        tb.deleteRow(n);
//	 	    	    }
	    	    	if(data==0){
	    	    		alert("1111");
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
	        }
	    	     
	    	    
	    		
	    	})
	    	


	    },
	    resectList: function () {
	        $('#show_tbody tr').show();
	    }
	
	}