$(function () {
    //页面打开时执行
	$('#inse_btn').click(function () {//新增
	       methods.addtna();
	    })
	      $('#search_btn').click(function () {//查询
    	$("#tb  tr:not(:first)").html("");
   methods.seachName();
    })
	//导航
    $('.type-right').click(function(){
        $(this).prev('.type-left').toggleClass('showListType')
    });
    $('.type-left ul li').click(function(){
        $(this).addClass('active').siblings('li').removeClass('active')
    })
})


var addEnter = true,
    noRepeat = true,
    jobArr = [],
    phoneArr = [],
    tdStr = '',
    trIndex,
    hasNullMes = false,
    tarInp = $('#xztb input'),
    tarSel = $('#xztb select');

var methods = {
		
	    addtna: function (){//添加类别
	    	$.ajax({
	    		type:"post",
	    		url:"http://localhost:8080/Haocai/tna/tnains",
	    		 data: $('#form2').serialize(),
	    		dataType:"json",
	    		 success : function(data){
	    			 if(data=='1'){
	    				 alert("成功");
	    			 }
	    			 if(data == '2'){
	    				 alert("已有ENAME");
	    			 }
	    		 },
	    		 error : function(){
	    			 alert("2");
	    		 }
	    	})
	    	
	    },
seachName:function(){
    $.ajax({
    	type:"post",
    	url:"Allowan",
    	dataType:"json",
    	data:$('#f1').serialize(),
       
    	success : function(data){
    		$.each(data,function(index,item){
    			if(item.name== "null"){
    				bootbox.alert({
    	                title: "@gua",
    	                message: "无此记录",
    	                
    	            })
	    		}else{
	    			  var tr;
	    	            tr += "<th>" + item.name + "</th>";
                        tr += "<th>" + item.number + "</th>";
                        tr += "<th>" + item.time + "</th>";
	    	            $("#tb").append("<tr>"+tr+"</tr>");
	    	
	    		}
	      
	    	});
    		
    	},
    error : function() {
		bootbox.alert({
            title: "@gua",
            message: "异常",
            
        })
}
 
 
	
})	
}
}