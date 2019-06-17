<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>LayuiCMSluyun</title>
    <link href="../../plugins/layui/css/layui.css" rel="stylesheet" media="all" />
    <link rel="stylesheet" type="text/css" href="/loginjs/css/style.css"/>
	
    <link rel="stylesheet" type="text/css" href="https://cdn.bootcss.com/twitter-bootstrap/4.2.1/css/bootstrap.min.css"/>
	<link rel="stylesheet" type="text/css" href="/loginjs/css/index.css">
    <script >
    
    </script>
</head>

<body>
    <script src="../../plugins/jquery.min.js"></script>
    <script src="../../plugins/layui/layui.js"></script>
	<script src="../../loginjs/haocai.js"></script>
	   <script src="../../loginjs/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
    <script src="../../loginjs/bootbox.min.js"></script>
    <br /><br />
    <ul class="layui-timeline">
        <li class="layui-timeline-item">
            <i class="layui-icon layui-anim layui-anim-rotate layui-anim-loop layui-timeline-axis"></i>
            <div class="layui-timeline-content layui-text">
            
              <form class="layui-form" id="downup">

<div class="layui-form-item">
  <label class="layui-form-label">型号</label>
  <div class="layui-input-block">
       <div class="layui-input-inline">
   <input type="text"  id="name" name="name" required lay-verify="required" placeholder="请输入型号" autocomplete="off" class="layui-input">  
  </div>
  </div>
</div>
    <div class="layui-form-item">
    <label class="layui-form-label">支行</label>
    <div class="layui-input-block">
     <div class="layui-input-inline">
      <select  id="tzhihang" name="tzhihang" lay-verify="required">
      <option ></option>
        <option value="财务会计部">财务会计部</option>
        <option value="事后监督部">事后监督部</option>
        <option value="合规风险部">合规风险部</option>
        <option value="资产管理部">资产管理部</option>
        <option value="内审部">内审部</option>
        <option value="电子银行部">电子银行部</option>
        <option value="综合部">综合部</option>
          <option value="安全保卫部">安全保卫部</option>
            <option value="科技部">科技部</option>
            <option value="业务部">业务部</option>
            <option value="营业部">营业部</option>
            <option value="释之支行">释之支行</option>
            <option value="凤瑞支行">凤瑞支行</option>
             <option value="中南厂支行">中南厂支行</option>
             <option value="广阳支行">广阳支行</option>
             <option value="赵河支行">赵河支行</option>
             <option value="独树支行">独树支行</option>
             <option value="北环支行">北环支行</option>
             <option value="拐河支行">拐河支行</option>
         </select>
         </div>
    </div>
  </div>
<div class="layui-form-item">
  <label class="layui-form-label">领取人</label>
  <div class="layui-input-block">
    <div class="layui-input-inline">
   <input type="text"  id="tname" name="tname" required lay-verify="required" placeholder="请输入领取人" autocomplete="off" class="layui-input">  
   </div>
  </div>
</div>


<div class="layui-form-item">
  <label class="layui-form-label">数量</label>
  <div class="layui-input-block">
  <div class="layui-input-inline">
   <input type="text"  id="cnumber" name="cnumber"  onkeyup="value=zhzs(this.value)" required lay-verify="number" placeholder="请输入数量" autocomplete="off" class="layui-input">  
  </div>
  </div>
</div>



    <div class="layui-form-item">
    <label class="layui-form-label">出入库</label>
    <div class="layui-input-block">
    <div class="layui-input-inline">
      <select  id="tip" name="tip" lay-verify="required">

          <option value="出库">出库</option>
          <option value="入库">入库</option>
         </select>
         </div>
    </div>
  </div>
  <div class="layui-form-item">
    <div class="layui-input-block">
      <button  id="downupbtn" class="layui-btn"  lay-submit  lay-filter="downupbtn">立即提交</button>
      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
    </div>
  </div>
</form>
            </div>
        </li>
    </ul>

   <script>
   function zhzs(value){

	    value = value.replace(/[^\d]/g,'');
	    if(''!=value){
	        value = parseInt(value);
	    }
	    return value;

	}

   $(function () {
   	
		$.ajax({//查询种类
			type:"post",
			url:"/Haocai/hao/getname",
			success:function(data){
			
				  var unitObj=document.getElementById("name");
				  if(data!=null){ //后台传回来的select选项
					  
		                for(var i=0;i<data.length;i++){
		                    //遍历后台传回的结果，一项项往select中添加option
		                    unitObj.options.add(new Option(data[i].name,data[i].name));
		                }
		            }

			}
		})
});
//Demo
layui.use('form', function(){
  var form = layui.form;
  
  form.on('submit(downupbtn)', function(){
	 
	    return false;
	  });
	 

});

</script>

</body>

</html>