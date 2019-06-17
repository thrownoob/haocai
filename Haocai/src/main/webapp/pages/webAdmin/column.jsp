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
</head>

<body>
    <script src="../../plugins/jquery.min.js"></script>
    <script src="../../plugins/layui/layui.js"></script>

    <br /><br />
    <ul class="layui-timeline">
     
                <div class="demoTable">
    型号：
    <div class="layui-inline">
        <input class="layui-input" name="name" id="name" autocomplete="off">
   </div>
     支行： <div class="layui-inline">
        <input class="layui-input" name="tzhihang" id="tzhihang" autocomplete="off">
    </div>
    开始时间：
    <div class="layui-input-inline">
        <input type="text" class="layui-input" id="timebegin" placeholder="yyyy-MM-dd HH:mm:ss">
      </div>
      结束时间：
       <div class="layui-input-inline">
        <input type="text" class="layui-input" id="timeend" placeholder="yyyy-MM-dd HH:mm:ss">
      </div>
    <button class="layui-btn" data-type="reload">搜索</button>
</div>

<table class="layui-hide" id="LAY_table_user" lay-filter="useruv" style=" height:420px;"></table>
          
    </ul>

    <script>
    layui.use('laydate', function(){
    	  var laydate = layui.laydate;
    	  
    	  //执行一个laydate实例
    	  laydate.render({
    	    elem: '#timebegin' //指定元素
    	    	,type: 'datetime'
    	  });
    	  laydate.render({
      	    elem: '#timeend' //指定元素
      	    	,type: 'datetime'
      	  });
    	});
    layui.use('table', function(){
        var table = layui.table;

        //方法级渲染
        table.render({
            elem: '#LAY_table_user'
                ,url: '/Haocai/jiluhaocai/getjiluhaocai'
            ,cols: [[
                {checkbox: true, fixed: true}
                ,{field:'name', title: '型号', width:100, sort: true, fixed: true}
                ,{field:'tzhihang', title: '支行', width:100, sort: true}
                ,{field:'tname', title: '领取人', width:100, sort: true,edit:true}
                ,{field:'cnumber', title: '数量', width:100}
                ,{field:'gcname', title: '实时余量', width:100}
                ,{field:'cname', title: '办理人', width:100}
                ,{field:'tip', title: '出入库', width:80}
                ,{field:'ttime', title: '日期', width:180, sort: true}
            ]]
            ,id: 'testReload'
            ,page: true
            
        });


        var $ = layui.$, active = {
            reload: function(){
                var name = $('#name');
                var tzhihang = $('#tzhihang');
                var timebegin = $('#timebegin');
                var timeend = $('#timeend');
                table.reload('testReload', {
                    where: {
                        name: name.val(),
                        tzhihang: tzhihang.val(),
                         timebegin: timebegin.val(),
                         timeend: timeend.val()
                    }
                });
            }
        };



        //监听表格复选框选择
        table.on('checkbox(useruv)', function(obj){
            console.log(obj)
        });
        //监听工具条
        table.on('tool(useruv)', function(obj){
            var data = obj.data;
            if(obj.event === 'detail'){
                layer.msg('ID：'+ data.id + ' 的查看操作');
            } else if(obj.event === 'del'){
                layer.confirm('真的删除行么', function(index){
                    console.log(data);
                    $.ajax({
                        url: "UVServlet",
                        type: "POST",
                        data:{"uvid":data.id,"memthodname":"deleteuv","aid":data.aid},
                        dataType: "json",
                        success: function(data){

                            if(data.state==1){
                                obj.del();
                                layer.close(index);
                                layer.msg("删除成功", {icon: 6});
                            }else{
                                layer.msg("删除失败", {icon: 5});
                            }
                        }

                    });
                });
            } else if(obj.event === 'edit'){

                layer.prompt({
                    formType: 2
                    ,title: '修改 ID 为 ['+ data.id +'] 的访问量'
                    ,value: data.uv
                }, function(value, index){
                    EidtUv(data,value,index,obj);
                   


                });



            }
        });

        $('.demoTable .layui-btn').on('click', function(){
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });

        function  EidtUv(data,value,index,obj) {
            $.ajax({
                url: "UVServlet",
                type: "POST",
                data:{"uvid":data.id,"memthodname":"edituv","aid":data.aid,"uv":value},
                dataType: "json",
                success: function(data){

                    if(data.state==1){

                        layer.close(index);
                        //同步更新表格和缓存对应的值
                        obj.update({
                            uv: value
                        });
                        layer.msg("修改成功", {icon: 6});
                    }else{
                        layer.msg("修改失败", {icon: 5});
                    }
                }

            });
        }


    });
    </script>

</body>

</html>