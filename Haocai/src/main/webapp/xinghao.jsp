<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>表格制作</title>
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no"/>
    <link rel="stylesheet" type="text/css" href="css/style.css"/>
	
    <link rel="stylesheet" type="text/css" href="https://cdn.bootcss.com/twitter-bootstrap/4.2.1/css/bootstrap.min.css"/>
	<link rel="stylesheet" type="text/css" href="css/index.css">
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
    <script src="js/bootbox.min.js"></script>
	  <script src="js/jquery-1.10.1.min.js"></script>
</head>
   <script>
    $(function(){
        $('.type-right').click(function(){
            $(this).prev('.type-left').toggleClass('showListType')
        });
        $('.type-left ul li').click(function(){
            $(this).addClass('active').siblings('li').removeClass('active')
        })
    })
</script>
<body>
 <div class="change-type">
        <div class="type-left" :class="showType == true ? 'showListType':''">
            <ul>
                <li class="active" ><a >余量查询</a><span></span></li>
                <li  ><a href="haocai.jsp">耗材出入库查询</a><span></span></li>
                <li><a href="http://localhost:8080/Haocai/shebei.jsp">設備查詢</a><span></span></li>
                <li><a></a><span></span></li>
                <li><a></a><span></span></li>
                <li><a></a><span></span></li>
                <li><a></a><span></span></li>
            </ul>
        </div>
        <div class="type-right">
            <p>
                <i class="el-icon-menu"></i>
                余量查询
            </p>
        </div>
    </div>

<div class="box">
<form id="fd1">
    <div class="title">余量查询</div>

        <!--搜索输入框及查询、重置按钮-->
        <div class="container content_width">
            <div class="person_search">
                <div class="search_input">
                    <div class="input-group mb-3">
                        <span>种类：</span>
                      <input id="categary" name="categary"  type="text" onkeyup="this.value=this.value.replace(/\s+/g,'')" class="form-control" placeholder="请输入型号">
                       <span>名称/型号：</span>
                     
                    </div>
                </div>
              
                <div class="search_input">
                    <button class="btn btn-primary search_btn" type="button" id="search_btn">查询</button>
                    <button class="btn btn-primary search_btn" type="button" id="back_btn">重置</button>
                </div>
            </div>
            <div class="line"></div>
        </div>
        </form>
       <form action="" id="form2">
        <div class="export">
            <button id="new_add" type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#renyuan">
                <img src="img/add_two.png"/>
                <span>添加</span>
            </button>
            <div class="modal fade" id="renyuan">
                <div class="modal-dialog modal-lg modal_position">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title">添加</h4>
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                        </div>
                        <div class="modal-body">
                            <table id="xztb" class="table">
               
                                <tbody>
                                <tr>
                                    <td class="tb_bg"><label for=""><font style="font-size: 14px; color: red;">*</font>种类</label>
                                    </td>
                                    <td>
                                    <select id="ename" name="ename" class="form-control" style="font-size: 13px; color: #666;">
                                            <option ></option>
	                                       
                                        </select></td>
                                        <td class="tb_bg"><label for=""><font style="font-size: 14px; color: red;">*</font>型号</label>
                                    </td>
                                    <td><input class="categary" id="categary" name="categary" type="text" onkeyup="this.value=this.value.replace(/\s+/g,'')" placeholder="请输入名称"/></td>
                                </tr>
                            
                                </tbody>
                            </table>
                        </div>
                        
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
                           <button class="btn btn-primary search_btn" type="button" id="inse_btn">提交</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        </form>
        <table id="tb" class="table">
            <thead>
            <tr>
                <th>名称</th>
                <th>数量</th>
       

            </tr>
            </thead>
            
        </table>
    </div>
</div>

<script src="js/xinghao.js"></script>
</body>

</html>