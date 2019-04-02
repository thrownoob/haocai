$(function () {
    //页面打开时执行
	
	$.ajax({//查询种类
		type:"post",
		url:"http://localhost:8080/Haocai/cat/catsec",
		success:function(data){
		
			  var unitObj=document.getElementById("categary2");
			  if(data!=null){ //后台传回来的select选项
				  
	                for(var i=0;i<data.length;i++){
	                    //遍历后台传回的结果，一项项往select中添加option
	                    unitObj.options.add(new Option(data[i].categary,data[i].categary));
	                }
	            }

		}
	})
	    
	$.ajax({//查询型号
		type:"post",
		url:"http://localhost:8080/Haocai/tna/gettna",
		success:function(data){
	
			  var unitObj=document.getElementById("ename2");
			  if(data!=null){ //后台传回来的select选项
				  
	                for(var i=0;i<data.length;i++){
	                    //遍历后台传回的结果，一项项往select中添加option
	                    unitObj.options.add(new Option(data[i].ename,data[i].ename));
	                }
	            }

		}
	})
	
		$.ajax({//查询id
		type:"post",
		url:"http://localhost:8080/Haocai/equ/equget",
		success:function(data){
		
			  var unitObj=document.getElementById("eid2");
			  if(data!=null){ //后台传回来的select选项
				  
	                for(var i=0;i<data.length;i++){
	                    //遍历后台传回的结果，一项项往select中添加option
	                    unitObj.options.add(new Option(data[i].eid,data[i].eid));
	                }
	            }

		}
	})
	

    $('#add_btn').click(function () {//出入库按钮
        methods.addHandle()
    })

    $('#show_tbody').on('click','.edit', function () {
        trIndex = $('.edit', '#show_tbody').index($(this));
        addEnter = false;
        $(this).parents('tr').addClass('has_case');
        methods.editHandle(trIndex);
    })

    $('#search_btn').click(function () {//记录查询按钮
    	 
    	$("#tb  tr:not(:first)").html("");
        methods.seachName();
    })
        $('#searchequ').click(function () {//记录查询按钮
    	 
    	$("#tb  tr:not(:first)").html("");
        methods.s1equ();
    })
    
    $('#search_btn1').click(function () {//余量查询
    	$("#tb  tr:not(:first)").html("");
   methods.seachName1();
    })
  
        $('#inse1_btn').click(function () {//余量查询
       methods.addcat();
    })
    $('#inse2_btn').click(function () {//余量查询
    	alert(1111);
       methods.addequ();
    })
      $('#inse3_btn').click(function () {//余量查询
    	alert(1111);
       methods.addjilu();
    })
    $('#back_btn').click(function () {
        $('.form-control').val(' ');
       
        window.location.reload();
        methods.resectList();
    })

    $('.del').click(function () {
        $(this).parents('tr').remove();
    })

    $('#renyuan').on('hide.bs.modal',function() {
        addEnter = true;
        $('#show_tbody tr').removeClass('has_case');
        $('#xztb input').val(' ');
        $('#xztb select').find('option:first').prop('selected', true)
    });
	//导航
    $('.type-right').click(function(){
        $(this).prev('.type-left').toggleClass('showListType')
    });
    $('.type-left ul li').click(function(){
        $(this).addClass('active').siblings('li').removeClass('active')
    })
})

    function b1(eid){//table内按钮查询记录弹出
    	alert(eid);
	$.ajax({
		type:"post",
		url:"http://localhost:8080/Haocai/jilu/sejilu?a="+eid,
		data: {},
		dataType:"json",
		success:function(data){
			bootbox.alert({
                title: "@gua",
                message: "<div class='table-wrapper'><table class='fl-table' id='jilutab' class=’table‘> <thead><tr> <th>姓名</th> <th>支行</th><th>数量</th> <th>操作员</th></tr> </thead></table><div>",
                
            })
            
               $.each(data,function(index,item){
            var tr;
            tr += "<th>" + item.eid + "</th>";
            tr += "<th>" + item.bname+ "</th>";
            tr += "<th>" + item.cname + "</th>";
            tr += "<th>" + item.tname + "</th>";
    
            $("#jilutab").append("<tr>"+tr+"</tr>");
		})
               },
		error:function(){
			alert("2");
		}
	})
}
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
	
		addjilu:function(){
			$.ajax({
				type:"post",
	    		url:"http://localhost:8080/Haocai/jilu/jiluins",
	    		 data: $('#fd4').serialize(),
	    		dataType:"json",
	    		success:function(data){
	    			if(data=='1'){
	    				alert("成");
	    				$.ajax({
	    					type:"post",
	    		    		url:"http://localhost:8080/Haocai/equ/equupt",
	    		    		 data: $('#fd4').serialize(),
	    		    		dataType:"json",
	    		    		success:function(data1){
	    		    			if(data1=='1'){
	    		    				alert("功");
	    		    			}else{
	    		    				alert("改变状态失败");
	    		    			}
	    		    		},
	    				 error : function(){
	    	    			 alert("2");
	    	    		 }
	    				})
	    			}
	    		}
			})
		},
		addcat:function(){
			$.ajax({
	    		type:"post",
	    		url:"http://localhost:8080/Haocai/cat/catins",
	    		 data: $('#fd2').serialize(),
	    		dataType:"json",
	    		 success : function(data){
	    			 if(data == '1'){
	    				 alert("成功");
	    			 }
	    			 if(data=='2'){
	    				 alert("库内已有");
	    			 }
	    			
	    		 },
	    		 error : function(){
	    			 alert("2");
	    		 }
	    	})
		},
	addequ:function(){
		$.ajax({
    		type:"post",
    		url:"http://localhost:8080/Haocai/equ/equins",
    		 data: $('#fd3').serialize(),
    		dataType:"json",
    		 success : function(data){
    			 if(data == '1'){
    				 alert("成功");
    			 }
    			 if(data=='0'){
    				 alert("库内已有");
    			 }
    			
    		 },
    		 error : function(){
    			 alert("2");
    		 }
    	})
		
   			
   
	},
   s1equ:function(){
	   $.ajax({
		   type:"post",
		   url:"http://localhost:8080/Haocai/equ/equdny",
		   dataType:"json",
		   data:$('#s1form').serialize(),
		   success:function(data){
			   alert(data);
			   $.each(data,function(index,item){
				 
				   if(data== " "){
					  
	    				bootbox.alert({
	    	                title: "@gua",
	    	                message: "无此记录",
	    	                
	    	            })
				   }
				   else{
		    			  var tr;
		    	            tr += "<th>" + item.eid + "</th>";
	                        tr += "<th>" + item.categary+ "</th>";
	                        tr += "<th>" + item.ard + "</th>";
	                        tr += "<th>" + item.gettime + "</th>";
	                        tr += "<th>" + item.usetime + "</th>";
	                        tr += "<th>" + item.yr + "</th>";
	                        tr += "<th>" + item.fixed + "</th>";
	                        tr += "<th>" + "<button type='button'  onclick='b1("+item.eid+")'  class='btn btn-primary search_btn' id=‘s1b’>获取记录</button>"+ "</th>";
		    	            $("#tb").append("<tr>"+tr+"</tr>");
				   }
			   })
		   },
	   
	   error:function(){
		alert("1");   
	   }
		   })
		   
	   
 
   },
    addHandle: function (the_index) {//出入库
    	
    	 
    	 
    if( methods.checkMustMes()== true){//非空判断为真
    		
    	$.ajax({
    		
    		type:"post",
    		url:"dexservlet",
    	    dataType:"",
    	    data: $('#form2').serialize(),
    	    success : function(data){
//    	    	if(data=='ok'){
//    	    		 bootbox.alert({
//    	 	                title: "@gua",
//    	 	                message: "操作成功",
//    	 	               callback: function(){window.location.href="haocai.jsp"}
//    	 	            })
//    	 	            
//    	    	}else{
//    	    		if(data== 'nokey' ){ //库内有此数据
//    	    			 bootbox.alert({
//     	 	                title: "@gua",
//     	 	                message: "库内已有请进行出入库操作",
//     	 	                callback: function(){window.location.href="haocai.jsp"}
//     	 	            })
//    	    		}else{
//    	    	 bootbox.alert({
// 	                title: "@gua",
// 	                message: "无此耗材请新增",
// 	            })
//    	    		}
//    	    	}
    	    	if(data=='ok'){
    	    		bootbox.alert({
	 	                title: "@gua",
	 	                message: "操作成功",
	 	               callback: function(){window.location.href="haocai.jsp"}
	 	            })
    	    	}
    	    	if(data== 'nokey'){
    	    		 bootbox.alert({
  	 	                title: "@gua",
  	 	                message: "库内已有请进行出入库操作",
  	 	            
    	    	})
    	    	}
    	    	if(data== 'numer'){
   	    		 bootbox.alert({
 	 	                title: "@gua",
 	 	                message: "余量不足",
 	 	                
   	    	})
   	    	}
    	    	if(data== 'fail'){
      	    		 bootbox.alert({
    	 	                title: "@gua",
    	 	                message: "无此耗材请新增",
    	 	                
      	    	})
      	    	}
    	    },
    	error : function() {
               bootbox.alert({
	                title: "@gua",
	                message: "错误",
	            })
            return false;
        }
    	})
    }
    	
//        hasNullMes = false;
//        methods.checkMustMes();
//        if (hasNullMes) {
//            return;
//        }
//        if (addEnter) {
//            methods.checkRepeat();
//            if (noRepeat) {
//                methods.setStr();
//                $('#show_tbody').append('<tr>' + tdStr + '</tr>');
//                $('#renyuan').modal('hide');
//            }
//        }else{
//            methods.setStr();
//            $('#show_tbody tr').eq(trIndex).empty().append(tdStr);
//            $('#renyuan').modal('hide');
//        }
    },
    
    addtna: function (){//添加类别
    	$.ajax({
    		type:"post",
    		url:"http://localhost:8080/Haocai/tna/tnains",
    		 data: $('#fd1').serialize(),
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
    
    editHandle: function (the_index) {

        var tar = $('#show_tbody tr').eq(the_index);
        var nowConArr = [];
        for (var i=0; i<tar.find('td').length-1;i++) {
            var a = tar.children('td').eq(i).html();
            nowConArr.push(a);
        }

        $('#renyuan').modal('show');

        for (var j=0;j<tarInp.length;j++) {
            tarInp.eq(j).val(nowConArr[j])
        }
        for (var p=0;p<tarSel.length;p++) {
            var the_p = p+tarInp.length;
            tarSel.eq(p).val(nowConArr[the_p]);
        }

    },
    setStr: function () {

        tdStr = '';
        for (var a=0; a<tarInp.length; a++) {
            tdStr+= '<td>' + tarInp.eq(a).val() + '</td>'
        }
        for (var b=0; b<tarSel.length; b++) {
            tdStr+= '<td>' + tarSel.eq(b).val() + '</td>'
        }
        tdStr+= '<td><a href="#" class="edit">编辑</a> <a href="#" class="del">删除</a></td>';

    },
    seachName1:function(){
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
    },
    seachName: function () {
    	$.ajax({
    		type:"post",
    		url:"jilu/checkLogin.do",
    	    dataType:"json",
    	    data: $('#form1').serialize(),
    	    
    	    success : function(data){
//    	    	 var tb = document.getElementById("tb");
// 	    	    //删除原先数据，2 为保留表头，值为表头行数减1
// 	    	    for (var n = tb.rows.length ; n > 1; n--) { 
// 	    	        tb.deleteRow(n);
// 	    	    }
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
    	    	            tr += "<th>" + item.number + "</th>";
    	    	            tr += "<th>" + item.cname + "</th>";
    	    	            tr += "<th>" + item.tname + "</th>";
    	    	            if(item.tip == 0){
    	    	            	 tr += "<th>入库</th>";
    	    	            }
    	    	            
    	    	            if(item.tip == 1){
    	    	            	tr += "<th>出库</th>";
							}
    	    	           
    	    	            tr += "<th>" + item.gcnum + "</th>";
    	    	            tr += "<th>" + item.time + "</th>";
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
    resectList: function () {
        $('#show_tbody tr').show();
    },
    checkMustMes: function () {
    	 
    	var aa=document.getElementById("tip").value;
    	 if(aa == "10"){
    		  if ($('.Name').val().trim()==='') {
    	            bootbox.alert({
    	                title: "@gua",
    	                message: "姓名为必选项，请填写",
    	                closeButton:false
    	            })
    	            hasNullMes = true;
    	            return
    	        }
    		  if ($('.Number').val().trim()==='') {
    	            bootbox.alert({
    	                title: "@gua",
    	                message: "数量为必选项，请填写",
    	                closeButton:false
    	            })
    	            hasNullMes = true;
    	            return
    	        }
    	 }
    	 
    	 if(aa=="1"){
    	
    	  if ($('.Name').val().trim()==='') {
            bootbox.alert({
                title: "@gua",
                message: "姓名为必选项，请填写",
                closeButton:false
            })
            hasNullMes = true;
            return
        }
        if ($('.Zhi').val().trim()==='') {
            bootbox.alert({
                title: "@gua",
                message: "支行为必选项，请填写",
                closeButton:false
            })
            hasNullMes = true;
            return
        }
        if ($('.Number').val().trim()==='') {
            bootbox.alert({
                title: "@gua",
                message: "数量为必选项，请填写",
                closeButton:false
            })
            hasNullMes = true;
            return
        }
        if ($('.Cname').val().trim()==='') {
            bootbox.alert({
                title: "@gua",
                message: "操作员为必选项，请填写",
                closeButton:false
            })
            hasNullMes = true;
            return
        }
        if ($('.Tname').val().trim()==='') {
            bootbox.alert({
                title: "@gua",
                message: "领取人为必选项，请填写",
                closeButton:false
            })
            hasNullMes = true;
            return
        }
    	 }
    	 
    	 if(aa=="0"){
    		 if ($('.Name').val().trim()==='') {
    	            bootbox.alert({
    	                title: "@gua",
    	                message: "姓名为必选项，请填写",
    	                closeButton:false
    	            })
    	            hasNullMes = true;
    	            return
    	        }
   		  if ($('.Number').val().trim()==='') {
	            bootbox.alert({
	                title: "@gua",
	                message: "数量为必选项，请填写",
	                closeButton:false
	            })
	            hasNullMes = true;
	            return
	            
	        }
   		 if ($('.Cname').val().trim()==='') {
             bootbox.alert({
                 title: "@gua",
                 message: "操作员为必选项，请填写",
                 closeButton:false
             })
             hasNullMes = true;
             return
         }
	 
    	 }
    	 
    	 
    	 return true;
    },
    checkRepeat: function () {

        jobArr = [], phoneArr = [];

        for (var i = 0; i<$('#show_tbody tr:not(".has_case")').length;i++) {
            var par = '#show_tbody tr:not(".has_case"):eq(' + i + ')';
            var a = $('td:eq(1)', par).html().trim(),
                b = $('td:eq(2)', par).html().trim();
            jobArr.push(a);
            phoneArr.push(b);
        }
        var jobNum = $('.jobNum').val().trim(),
            phoneNum = $('.phoneNum').val().trim();

        if (jobArr.indexOf(jobNum)>-1) {
            noRepeat = false;
            bootbox.alert({
                title: "来自火星的提示",
                message: "工号重复了，请重新输入",
                closeButton:false
            })
            return;
        }
        if (phoneArr.indexOf(phoneNum)>-1) {
            noRepeat = false;
            bootbox.alert({
                title: "来自火星的提示",
                message: "手机号码重复了，请重新输入",
                closeButton:false
            })
            return;
        }
        noRepeat = true;
    }
}