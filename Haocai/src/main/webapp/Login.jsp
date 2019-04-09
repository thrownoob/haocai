<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no"/>
    <link rel="stylesheet" type="text/css" href="css/style.css"/>
	
    <link rel="stylesheet" type="text/css" href="https://cdn.bootcss.com/twitter-bootstrap/4.2.1/css/bootstrap.min.css"/>
	 <link rel="stylesheet" type="text/css" href="css/index.css">
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
    <script src="js/bootbox.min.js"></script>
    <script src="js/jquery-1.10.1.min.js"></script>
    
</head>
<body>
<form  id="login">
<div>

    <span>型号：</span>
                        <input id="username" name="username"  type="text" onkeyup="this.value=this.value.replace(/\s+/g,'')" class="form-control" placeholder="请输入型号">
                          <span>支行：</span>
                        <input id="password" name="password" onkeyup="this.value=this.value.replace(/\s+/g,'')" type="text" class="form-control" placeholder="请输入支行">
                       <button class="btn btn-primary search_btn" type="button" id="loginuser">提交</button>
 </div>
 </form>
</body>
<script src="js/login.js"></script>
</html>