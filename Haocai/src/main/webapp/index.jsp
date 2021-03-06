<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% 
   if (session.getAttribute("user") == null) { 

response.sendRedirect("/Haocai/login.jsp"); 

return; 
} 
%> 
<!DOCTYPE html>
<html lang="zh-CN">

<head>
    <meta charset="utf-8">
    <title>LayuiCMSluyun</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta http-equiv="Access-Control-Allow-Origin" content="*">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="icon" href="favicon.ico">
    <link rel="stylesheet" href="plugins/layui/css/layui.css" media="all" />
    <link rel="stylesheet" href="css/font_tnyc012u2rlwstt9.css" media="all" />
    <link rel="stylesheet" href="css/main.css" media="all" />
    <link rel="stylesheet" href="css/index.css" media="all" />
</head>

<body class="main_body">

    <script src="plugins/jquery.min.js"></script>
    <script src="plugins/layui/layui.js"></script>


    <script src="js/jquery.util.js"></script>
    <script src="js/javascript.util.js"></script>
    <script src="js/dataCache.js"></script>
    <script src="js/layui.util.js"></script>

    <script src="js/index.js"></script>


    <div class="layui-layout layui-layout-admin">
        <!-- 顶部 -->
        <div class="layui-header header">
            <div class="layui-main">
                <a href="index.html" class="logo" style="font-size:16px;font-weight:600;">LayuiCMSluyun</a>
                <!-- 显示/隐藏菜单 -->
                <a href="javascript:;" class="iconfont hideMenu icon-menu1"></a>
                <!-- 搜索 -->
                <div class="layui-form component">

                    <select name="modules" lay-verify="required" lay-search="" lay-filter="component">
                        <option value="">搜索组件或模块</option>
                        <option value="element/layout.html">grid 栅格布局</option>
                        <option value="element/layout.html#admin">admin 后台布局</option>
                        <option value="element/color.html">color 颜色</option>
                        <option value="element/icon.html">iconfont 字体图标</option>
                        <option value="element/anim.html">animation 动画</option>
                        <option value="element/button.html">button 按钮</option>
                        <option value="element/form.html">form 表单组</option>
                        <option value="element/form.html#input">input 输入框</option>
                        <option value="element/form.html#select">select 下拉选择框</option>
                        <option value="element/form.html#checkbox">checkbox 复选框</option>
                        <option value="element/form.html#switch">switch 开关</option>
                        <option value="element/form.html#radio">radio 单选框</option>
                        <option value="element/form.html#textarea">textarea 文本域</option>
                        <option value="element/nav.html">nav 导航菜单</option>
                        <option value="element/nav.html#breadcrumb">breadcrumb 面包屑</option>
                        <option value="element/tab.html">tabs 选项卡</option>
                        <option value="element/progress.html">progress 进度条</option>
                        <option value="element/collapse.html">collapse 折叠面板/手风琴</option>
                        <option value="element/table.html">table 表格元素</option>
                        <option value="element/badge.html">badge 徽章</option>
                        <option value="element/timeline.html">timeline 时间线</option>
                        <option value="element/auxiliar.html#blockquote">blockquote 引用块</option>
                        <option value="element/auxiliar.html#fieldset">fieldset 字段集</option>
                        <option value="element/auxiliar.html#hr">hr 分割线</option>
                        <option value="modules/layer.html">layer 弹出层/弹窗综合</option>
                        <option value="modules/laydate.html">laydate 日期时间选择器</option>
                        <option value="modules/layim.html">layim 即时通讯/聊天</option>
                        <option value="modules/laypage.html">laypage 分页</option>
                        <option value="modules/laytpl.html">laytpl 模板引擎</option>
                        <option value="modules/form.html">form 表单模块</option>
                        <option value="modules/table.html">table 数据表格</option>
                        <option value="modules/upload.html">upload 文件/图片上传</option>
                        <option value="modules/element.html">element 常用元素操作</option>
                        <option value="modules/rate.html">rate 评分</option>
                        <option value="modules/colorpicker.html">colorpicker 颜色选择器</option>
                        <option value="modules/slider.html">slider 滑块</option>
                        <option value="modules/carousel.html">carousel 轮播/跑马灯</option>
                        <option value="modules/layedit.html">layedit 富文本编辑器</option>
                        <option value="modules/tree.html">tree 树形菜单</option>
                        <option value="modules/flow.html">flow 信息流/图片懒加载</option>
                        <option value="modules/util.html">util 工具集</option>
                        <option value="modules/code.html">code 代码修饰</option>
                    </select>

                    <i class="layui-icon" id="kscx">&#xe615;</i>
                </div>
                <!-- 顶部右侧菜单 -->
                <ul class="layui-nav top_menu">
                    <li class="layui-nav-item showNotice" id="showNotice" pc>
                        <a href="javascript:;"><i class="iconfont icon-gonggao"></i><cite>系统公告</cite></a>
                    </li>
                    <li class="layui-nav-item indexHelper" id="indexHelper" pc>
                        <a href="javascript:;" data-url="pages/helper/helper.html"><i data-icon="&#xe607;"
                                class="layui-icon">&#xe607;</i><cite>常见问题</cite></a>
                    </li>
                    <li class="layui-nav-item" mobile>
                        <a href="javascript:;" class="mobileAddTab" data-url="pages/user/userInfo.html">
                            <i class="iconfont icon-zhanghu" data-icon="icon-zhanghu"></i>
                            <cite>个人资料</cite>
                        </a>
                    </li>
                    <li class="layui-nav-item" mobile>
                        <a href="login.jsp" class="signOut"><i class="iconfont icon-loginout"></i> 退出</a>
                    </li>
                    <li class="layui-nav-item lockcms" pc>
                        <a href="javascript:;"><i class="iconfont icon-lock1"></i><cite>锁屏</cite></a>
                    </li>
                    <li class="layui-nav-item" pc>
                        <a href="javascript:;">
                            <img src="images/face.jpg" onerror="javascript:this.src='images/face.jpg'"
                                class="layui-circle userIconAs" width="35" height="35">
                            <cite class="userNameAs">admin</cite>
                        </a>
                        <dl class="layui-nav-child">
                            <dd>
                                <a href="javascript:;" data-url="pages/user/userInfo.html">
                                    <i class="iconfont icon-zhanghu" data-icon="icon-zhanghu"></i>
                                    <cite>个人资料</cite>
                                </a>
                            </dd>
                            <dd>
                                <a href="javascript:;" data-url="pages/user/changePwd.html">
                                    <i class="iconfont icon-shezhi1" data-icon="icon-shezhi1"></i>
                                    <cite>修改密码</cite>
                                </a>
                            </dd>
                            <dd>
                                <a href="javascript:;" data-url="pages/headIcon/headIcon.html">
                                    <i class="layui-icon" data-icon="&#xe650;">&#xe650;</i>
                                    <cite>更换头像</cite>
                                </a>
                            </dd>
                            <dd>
                                <a href="javascript:;" class="changeSkin">
                                    <i class="iconfont icon-huanfu"></i>
                                    <cite>更换皮肤</cite>
                                </a>
                            </dd>
                            <dd>
                                <a href="login.jsp" class="signOut">
                                    <i class="iconfont icon-loginout"></i>
                                    <cite>安全退出</cite>
                                </a>
                            </dd>
                        </dl>
                    </li>
                </ul>
            </div>
        </div>
        <!-- 左侧导航 -->
        <div class="layui-side layui-bg-black">
            <!-- <div class="user-photo">
                <a class="img" title="我的头像"><img src="/images/face.jpg" class="userIconAs" onerror="javascript:this.src='/images/face.jpg'"></a>
                <p>你好！<strong><span class="userName userNameAs">admin</span></strong>, 欢迎登录</p>
            </div> -->
            <div class="navBar layui-side-scroll"></div>
        </div>
        <!-- 右侧内容 -->
        <div class="layui-body layui-form">
            <div class="layui-tab marg0" lay-filter="bodyTab" id="top_tabs_box">
                <ul class="layui-tab-title top_tab" id="top_tabs">
                    <li class="layui-this" lay-id=""><i class="layui-icon">&#xe68e;</i> <cite>主页</cite></li>
                </ul>
                <ul class="layui-nav closeBox">
                    <li class="layui-nav-item">
                        <a href="javascript:;"><i class="iconfont icon-caozuo"></i> 页面操作</a>
                        <dl class="layui-nav-child">
                            <dd><a href="javascript:;" class="refresh refreshThis"><i class="layui-icon">&#xe669;</i>
                                    刷新当前</a></dd>
                            <dd><a href="javascript:;" class="closePageOther"><i class="iconfont icon-prohibit"></i>
                                    关闭其他</a></dd>
                            <dd><a href="javascript:;" class="closePageAll"><i class="iconfont icon-guanbi"></i>
                                    关闭全部</a></dd>
                        </dl>
                    </li>
                </ul>
                <div class="layui-tab-content clildFrame">
                    <div class="layui-tab-item layui-show">
                        <iframe src="pages/main/main.html"></iframe>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- 移动导航 -->
    <div class="site-tree-mobile layui-hide"><i class="layui-icon">&#xe602;</i></div>
    <div class="site-mobile-shade"></div>

    <script>


        (function () {
            if (getIsWeb() === false) {
                alert('建议在web服务容器中打开此网页，如iis、Apache Tomcat、Nginx、node server等。当前状态下被限制了很多功能。');
            }

            pageKeepTop();
        }());

        $(function () {
            //可在这里加载用户信息
            console.log("%c开源地址：https://gitee.com/cluyun/LayuiCMSluyun ,有什么建议或者bug,欢迎issues。", "color:red");

            layui.use('form', function () {
                layui.form.on('select(component)', function (data) {
                    //左上角下拉框
                    window.open('https://www.layui.com/doc/' + data.value);
                });
            });
        });
    </script>

</body>

</html>