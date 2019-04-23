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
  <script src="laydate/laydate.js"></script> 
     <script >
     lay('#version').html('-v'+ laydate.v);

   //执行一个laydate实例
   laydate.render({
     elem: '#ttime',
     range: true
   });
     
     </script>
     <script>
 
</script>

<body>
<!--  -->
 <div class="change-type">
        <div class="type-left" :class="showType == true ? 'showListType':''">
            <ul>
                <li><a href="http://localhost:8080/Haocai/allowance.jsp">余量查询</a><span></span></li>
                <li ><a href="http://localhost:8080/Haocai/haocai.jsp">耗材出入库查询</a><span></span></li>
                <li class="active"><a>设备查询</a><span></span></li>
                <li><a></a><span></span></li>
                <li><a></a><span></span></li>
                <li><a></a><span></span></li>
                <li><a></a><span></span></li>
            </ul>
        </div>
        <div class="type-right">
            <p>
                <i class="el-icon-menu"></i>
                耗材出入库查询
            </p>
        </div>
    </div>
    
    


<div class="box">

   <form id="equ_se">
    <div class="title">耗材出入库查询</div>
    
        
        <div class="container content_width">
            <div class="person_search">
                <div class="search_input">
                    <div class="input-group mb-3">
                        <span>编号：</span>
                        <input id="eid" name="eid"  type="text" onkeyup="this.value=this.value.replace(/\s+/g,'')" class="form-control"  >
                          <span>型号：</span>
                        <input id="categary" name="categary" onkeyup="this.value=this.value.replace(/\s+/g,'')" type="text" class="form-control" >
                         <span>状态：</span>
                        <select id="yr"name="yr" class="form-control" style="font-size: 13px; color: #666;">
                                            <option value="已启用">已启用</option>
	                                        <option value="报废">报废</option>
	                                         <option value="出借">出借</option>
                                        </select>
                        <span>当前所在地：</span>
                        <input id="ard" name="ard"  type="text" onkeyup="this.value=this.value.replace(/\s+/g,'')" class="form-control" >
                         <span>是否超出年限：</span>
                        <input id="fixed" name="fixed"  type="text" onkeyup="this.value=this.value.replace(/\s+/g,'')" class="form-control" >
                    </div>
                     
                </div>
                <div class="search_input">
                    <div class="input-group mb-3" hidden>
                        <span>工号：</span>
                        <input id="job_num" type="text" class="form-control" placeholder="请输入工号">
                    </div>
                </div>
                <div class="search_input">
                    <button class="btn btn-primary search_btn" type="button" id="searchequ">查询</button>
                    <button class="btn btn-primary search_btn" type="button" id="back_btn">重置</button>
                </div>
            </div>
            <div class="line"></div>
        </div>
        </form>

        <form action="" id="equ_add">
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
                                    <td class="tb_bg"><label for=""><font style="font-size: 14px; color: red;">*</font>编号</label>
                                    </td>
                                    <td><input class="eid" id="eid" name="eid" type="text" onkeyup="this.value=this.value.replace(/\s+/g,'')" placeholder="请输入名称"/></td>
                                    
                                      <td class="tb_bg"><label for="">型号</label></td>
                                      <td>
                                    <select id="categary1" name="categary" class="form-control" style="font-size: 13px; color: #666;">
                                            <option >请选择型号</option>
	                               </select>
	                                  </td>
                                </tr>
                            
                                <tr>
                                    <td class="tb_bg"><label for=""><font style="font-size: 14px; color: red;">*</font>现所在</label>
                                    </td>
                                    <td><input class="ard" type="text" id="ard" name="ard" oninput = "value=value.replace(/[^\d]/g,'')" onkeyup="this.value=this.value.replace(/\s+/g,'')" placeholder="请输入数量"/></td>
                                    <td class="tb_bg"><label for="">状态</label></td>
                                    <td><input class="yr" type="text" name="yr" id="yr" onkeyup="this.value=this.value.replace(/\s+/g,'')" placeholder="请输入操作员姓名" > </td>
                                   
                                </tr>
                  
                                </tbody>
                            </table>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
                            <button id="add_btn" type="button" class="btn btn-secondary">确定</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        </form>
   <form action="" id="equ_up">
        <div class="export">
            <button id="new_add" type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#renyuan">
                <img src="img/add_two.png"/>
                <span>启用</span>
            </button>
            <div class="modal fade" id="renyuan">
                <div class="modal-dialog modal-lg modal_position">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title">启用</h4>
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                        </div>
                        <div class="modal-body">
                            <table id="xztb" class="table">
               
                                <tbody>
                                
                                
                                <tr>
                                    <td class="tb_bg"><label for=""><font style="font-size: 14px; color: red;">*</font>编号</label>
                                    <td>
                                       <select id="eid2" name="eid" class="form-control" style="font-size: 13px; color: #666;">
                                            <option >请选择</option>
	                               </select>
	                               </td>
                             
                                    
                                      <td class="tb_bg"><label for="">型号</label></td>
                                      <td>
                                    <select id="categary1" name="categary" class="form-control" style="font-size: 13px; color: #666;">
                                            <option >请选择型号</option>
	                               </select>
	                                  </td>
                                </tr>
                            
                                <tr>
                                    <td class="tb_bg"><label for=""><font style="font-size: 14px; color: red;">*</font>现所在</label>
                                    </td>
                                    <td><input class="ard" type="text" id="ard" name="ard" oninput = "value=value.replace(/[^\d]/g,'')" onkeyup="this.value=this.value.replace(/\s+/g,'')" placeholder="请输入数量"/></td>
                                    <td class="tb_bg"><label for="">状态</label></td>
                                    <td><input class="yr" type="text" name="yr" id="yr" onkeyup="this.value=this.value.replace(/\s+/g,'')" placeholder="请输入操作员姓名" > </td>
                                   
                                </tr>
                  
                                </tbody>
                            </table>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
                            <button id="add_btn" type="button" class="btn btn-secondary">确定</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        </form>
        <table id="tb" class="table">
            <thead>
            <tr>
                <th>编号</th>
                <th>型号</th>
                <th>入库时间</th>
                <th>现所在</th>
                <th>启用时间</th>
                <th>状态</th>
                <th>fix</th>
                <th>历史记录</th>
             </tr>
            </thead>
            <tbody id="show_tbody">
             
            
            </tbody>
        </table>
    </div>




<script src="js/shebei.js"></script>
</body>
</html>