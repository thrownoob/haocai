$(function () {
    //页面打开时执行
	$('#inse_btn').click(function () {//新增型号
	       methods.addcat();
	    })
	    //根据名称插叙
	      $('#search_btn').click(function () {//查询
    	$("#tb  tr:not(:first)").html("");
   methods.seachName();
    })
    //重置
    $('#back_btn').click(function () {
        $('.form-control').val('');
       
        window.location.reload();
        methods.resectList();
    })

	//导航
    $('.type-right').click(function(){
        $(this).prev('.type-left').toggleClass('showListType')
    });
    $('.type-left ul li').click(function(){
        $(this).addClass('active').siblings('li').removeClass('active')
    })
})
	$.ajax({//查询型号
		type:"post",
		url:"http://localhost:8080/Haocai/tna/getname",
		success:function(data){
	
			  var unitObj=document.getElementById("ename");
			  if(data!=null){ //后台传回来的select选项
				  
	                for(var i=0;i<data.length;i++){
	                    //遍历后台传回的结果，一项项往select中添加option
	                    unitObj.options.add(new Option(data[i].ename,data[i].ename));
	                }
	            }

		}
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
		
	    addcat: function (){//添加型号
	    	$.ajax({
	    		type:"post",
	    		url:"http://localhost:8080/Haocai/cat/catins",
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
    	url:"http://localhost:8080/Haocai/cat/getallCats",
    	dataType:"json",
    	data:$('#fd1').serialize(),
       
    	success : function(data){
    		$.each(data,function(index,item){
    			if(item.categary== "null"){
    				bootbox.alert({
    	                title: "@gua",
    	                message: "无此记录",
    	                
    	            })
	    		}else{
	    			  var tr;
	    	            tr += "<th>" + item.ename + "</th>";
                        tr += "<th>" + item.categary + "</th>";
                        tr += "<th>" + item.cnumber + "</th>";
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