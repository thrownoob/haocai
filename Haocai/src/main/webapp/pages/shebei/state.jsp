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
    <script type="text/html" id="toolbarDemo">
       <div class="layui-btn-container">
    <button class="layui-btn layui-btn-sm" lay-event="seall">获取记录</button>

  </div>
</script>

    <br /><br />
  <ul class="layui-timeline">
      
     
                <div class="demoTable">
    型号：
    <div class="layui-inline">
        <input class="layui-input" name="eid" id="eid" autocomplete="off">
   </div>
     支行： <div class="layui-inline">
        <input class="layui-input" name="categary" id="categary" autocomplete="off">
    </div>
   
    <button class="layui-btn" data-type="reload">搜索</button>
</div>

<table class="layui-hide" id="LAY_table_user" lay-filter="useruv" style=" height:420px;"></table>
           
        
    </ul>

    <script>
   
    layui.use('table', function(){
        var table = layui.table;

        //方法级渲染
        table.render({
            elem: '#LAY_table_user'
                ,url: '/Haocai/equ/equdny'
                	 ,toolbar: true
            ,cols: [[
                {checkbox: true, fixed: true}
                ,{field:'eid', title: '编号', width:100, sort: true, fixed: true}
                ,{field:'categary', title: '型号', width:100, sort: true}
                ,{field:'ard', title: '现所在', width:100, sort: true,edit:true}
                ,{field:'gettime', title: '入库时间', width:100}
                ,{field:'usetime', title: '归属', width:100}
                ,{field:'yr', title: '状态', width:100}
                ,{field:'fixed', title: '是否超出年限', width:80}
                ,{fixed: 'right', title:'操作', toolbar: '#toolbarDemo', width:150}
               
            ]]
            ,id: 'testReload'
            ,page: true
            
        });

        var $ = layui.$, active = {
                reload: function(){
                    var eid = $('#eid');
                    var categary = $('#categary');
                    table.reload('testReload', {
                        where: {
                            eid: eid.val(),
                            categary: categary.val(),
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
            if(obj.event === 'seall'){
            
            	layer.open({
            		type: 1 //此处以iframe举例
                    ,title: '当你选择该窗体时，即会在最顶端'
                    ,area: ['390px', '260px']
                    ,shade: 0
                    ,maxmin: true
                  ,content: '<div><table id="jilutable"></table></div>'
                    ,success : function(index, layero) {
                            alert(data);
                              table.render({
                                elem: '#jilutable'
                                ,height: 300
                                ,width:'100%'
                               ,url: '/Haocai/jilu/sejilu' //数据接口
                               
                                ,page: true //开启分页
                                ,cols: [[ //表头
                                    {type:'radio'}
                                  ,{field: 'eid', title: '编号名称', width:200, sort: true}
                                  ,{field: 'user', title: '操作员', width:330}
                                   ,{field: 'sex', title: '操作', width:200}
                                   ,{field: 'time', title: '时间', width:200}
                                  
                                ]]
                              ,id: 'jilutab'
                              });
                              table.reload('jilutab', {
                                  where: {
                                      eid: data.eid,
                                      
                                  }
                              });
                        }
                    ,btn: ['继续弹出', '全部关闭'] //只是为了演示
                    ,yes: function(){
                      $(that).click(); 
                    }
                    ,btn2: function(){
                      layer.closeAll();
                    }
            		});
            	
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