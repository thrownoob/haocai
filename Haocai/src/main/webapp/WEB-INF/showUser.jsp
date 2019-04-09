<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
   <script src="js/jquery.min.js"></script>
<script src="js/mejs.js"></script>
</head>
  <script src="laydate/laydate.js"></script> 
     <script >
     lay('#version').html('-v'+ laydate.v);

   //执行一个laydate实例

laydate.render({
  elem: '#usetime'
  ,format: 'yyyy年MM月dd日'
});
     </script>

<body>
<form action="" id="fd1">
<div>

    <span>型号：</span>
                        <input id="ename1" name="ename"  type="text" onkeyup="this.value=this.value.replace(/\s+/g,'')" class="form-control" placeholder="请输入型号">
                          <span>支行：</span>
                        <input id="enumber" name="enumber" onkeyup="this.value=this.value.replace(/\s+/g,'')" type="text" class="form-control" placeholder="请输入支行">
                       <button class="btn btn-primary search_btn" type="button" id="inse_btn">提交</button>
 </div>
 </form>
 <form action="" id="fd2">
<div>

    <span>型号：</span>
                        <input id="categary1" name="categary"  type="text" onkeyup="this.value=this.value.replace(/\s+/g,'')" class="form-control" placeholder="请输入型号">
                          <span>支行：</span>
                     
                          <select id="ename2" name="ename" class="form-control" style="font-size: 13px; color: #666;">
                                            <option >请选择</option>
	                                       
                                        </select>
                        <input id="cnumber" name="cnumber" onkeyup="this.value=this.value.replace(/\s+/g,'')" type="text" class="form-control" placeholder="请输入支行">
                       <button class="btn btn-primary search_btn" type="button" id="inse1_btn">提交</button>
 </div>

 </form>
 <form action="" id="fd3">
  <div>

                        <input id="eid1" name="eid"  type="text" onkeyup="this.value=this.value.replace(/\s+/g,'')" class="form-control" placeholder="请输入型号">
                         <select id="categary2" name="categary" class="form-control" style="font-size: 13px; color: #666;">
                                            <option >请选择</option>
	                     </select>
                        <input id="ard" name="ard"  type="text" onkeyup="this.value=this.value.replace(/\s+/g,'')" class="form-control" placeholder="请输入型号">
              
                        <input id="yr" name="yr"  type="text" onkeyup="this.value=this.value.replace(/\s+/g,'')" class="form-control" placeholder="请输入型号">
                         <input id="fixed" name="fixed"  type="text" onkeyup="this.value=this.value.replace(/\s+/g,'')" class="form-control" placeholder="请输入型号">
                       <button class="btn btn-primary search_btn" type="button" id="inse2_btn">提交</button>
 </div>
 </form>
  <form action="" id="fd4">
  <div>

                      
                         <select id="eid2" name="eid" class="form-control" style="font-size: 13px; color: #666;">
                                            <option >请选择</option>
	                     </select>
	                      <input id="usetime" name="usetime"  type="text" onkeyup="this.value=this.value.replace(/\s+/g,'')" class="form-control" placeholder="请输入型号">
                        <input id="ard" name="ard"  type="text" onkeyup="this.value=this.value.replace(/\s+/g,'')" class="form-control" placeholder="请输入型号">
                       <input id="bname" name="bname"  type="text" onkeyup="this.value=this.value.replace(/\s+/g,'')" class="form-control" placeholder="请输入型号">
                        <input id="cname" name="cname"  type="text" onkeyup="this.value=this.value.replace(/\s+/g,'')" class="form-control" placeholder="请输入型号">
                         <input id="tname" name="tname"  type="text" onkeyup="this.value=this.value.replace(/\s+/g,'')" class="form-control" placeholder="请输入型号">
                       <button class="btn btn-primary search_btn" type="button" id="inse3_btn">提交</button>
 </div>
 </form>
</body>
</html>