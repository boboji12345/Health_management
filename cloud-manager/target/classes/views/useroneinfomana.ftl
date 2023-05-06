<#assign ctx=request.contextPath />
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
    <title>个人信息管理</title>
    <link href="${ctx}/admin/css/bootstrap.min.css" rel="stylesheet">
    <link href="${ctx}/admin/css/materialdesignicons.min.css" rel="stylesheet">
    <link href="${ctx}/admin/css/style.min.css" rel="stylesheet">
    <link href="${ctx}/css/textalign.css" rel="stylesheet">

    <script type="text/javascript" src="${ctx}/admin/js/jquery.min.js"></script>
    <script type="text/javascript" src="${ctx}/admin/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${ctx}/admin/js/perfect-scrollbar.min.js"></script>
    <script type="text/javascript" src="${ctx}/admin/js/main.min.js"></script>
    <script type="text/javascript" src="${ctx}/admin/js/Chart.js"></script>

    <script type="text/javascript">
        function updateInfo(aid){
            $("#userid").val(aid);

            $.ajax({
                url:"${ctx}/admin/getUserOneInfoById",
                type:"get",
                data:{id:aid},
                dataType:"json",
                success:function(data){
                    $("#uUname").val(data.obj["uname"]);
                    $("#uUtel").val(data.obj["utel"]);
                    $("#uPwd").val(data.obj["upwd"]);
                    $("#uUage").val(parseInt(data.obj["uage"]));
                    $("#uUroomnumber").val(data.obj["uroomnumber"]);

                    $("input[name='usex']").each(function(){
                        if( $.trim($(this).val()) === $.trim(data.obj["usex"]) ){
                            $(this).attr("checked",true);
                        }
                    });
                }
            });
        }

        function update() {
            var utel = $("#uUtel").val();
            var upwd = $("#uPwd").val();
            var uname = $("#uUname").val();
            var uid = $("#userid").val();
            var uage = $("#uUage").val();
            var uroomnumber = $("#uUroomnumber").val();
            var uimg = $("#ufilepath").val();
            var usex = $("input[name='usex']:checked").val();

            if(isEmpty(upwd) || isEmpty(utel) || isEmpty(uname) || isEmpty(uroomnumber)
                || isEmpty(uage)){
                alert("用户信息不能为空，请确认一下！");
                return;
            }

            $.ajax({
                url:"${ctx}/admin/upMemberUserInfo",
                type:"POST",
                data : {
                    upwd: upwd,
                    utel: utel,
                    uid: uid,
                    uname: uname,
                    uage: uage,
                    uroomnumber: uroomnumber,
                    usex: usex,
                    uimg: uimg
                },
                success:function(msg){
                    $('#upInfoModal').modal('hide');
                    history.go(0);
                    alert(msg.msg);
                }
            });
        }

        function isEmpty(obj){
            if(typeof obj == "undefined" || obj == null || obj == ""){
                return true;
            }else{
                return false;
            }
        }
    </script>
</head>
<body>
<input type="hidden" id="userid">
<div class="lyear-layout-web">
    <div class="lyear-layout-container">
        <aside class="lyear-layout-sidebar" style="margin-top: 20px">
            <div id="logo" class="sidebar-header">
                <a href='${ctx}/admin/userindex'>
                    <span style="font-size:20px;">学生健康管理系统</span>
                </a>
            </div>
            <div class="lyear-layout-sidebar-scroll"  style="margin-top: 30px">
                <nav class="sidebar-main">
                    <ul class="nav nav-drawer">
                        <li class="nav-item"> <a href='${ctx}/admin/userindex'><i class="mdi mdi-home"></i> 首页</a> </li>
                        <li class="nav-item nav-item-has-subnav active open">
                            <a href="javascript:void(0)"><i class="mdi mdi-palette"></i>用户管理</a>
                            <ul class="nav nav-subnav">
                                <li class="active"> <a href='${ctx}/admin/useroneinfomana'>个人信息管理</a> </li>
                            </ul>
                        </li>
                        <li class="nav-item nav-item-has-subnav">
                            <a href="javascript:void(0)"><i class="mdi mdi-file-outline"></i>资讯管理</a>
                            <ul class="nav nav-subnav">
                                <li> <a href='${ctx}/admin/usernewsmana'>新闻信息查看</a> </li>
                                <li> <a href='${ctx}/admin/userknowledgesmana'>防控知识查看</a> </li>
                            </ul>
                        </li>
                        <li class="nav-item nav-item-has-subnav">
                            <a href="javascript:void(0)"><i class="mdi mdi-language-javascript"></i>核心业务管理</a>
                            <ul class="nav nav-subnav">
                                <li> <a href='${ctx}/admin/userrholidaysmana'>学生休假管理</a> </li>
                                <li> <a href='${ctx}/admin/userrdailyclocksmana'>健康打卡管理</a> </li>
                                <li> <a href='${ctx}/admin/userrinoutsignsmana'>进出登记管理</a> </li>
                            </ul>
                        </li>
                    </ul>
                </nav>
            </div>
        </aside>

        <header class="lyear-layout-header">
            <nav class="navbar navbar-default">
                <div class="topbar">
                    <div class="topbar-left">
                        <div class="lyear-aside-toggler">
                            <span class="lyear-toggler-bar"></span>
                            <span class="lyear-toggler-bar"></span>
                            <span class="lyear-toggler-bar"></span>
                        </div>
                        <span class="navbar-page-title"> 后台首页 </span>
                    </div>

                    <ul class="topbar-right">
                        <li class="dropdown dropdown-profile">
                            <a href="javascript:void(0)" data-toggle="dropdown">
                                <img class="img-avatar img-avatar-48 m-r-10" src="${ctx}/images/top.jpg" style="width:30px; height:30px;"/>

                                <span style="color: #000">
                                    <#if Session["oneuser"]?exists> ${Session.oneuser.uname}</#if>
                                    <span class="caret"></span></span>
                            </a>
                            <ul class="dropdown-menu dropdown-menu-right">
                                <li> <a href='${ctx}/admin/useroneinfomana'><i class="mdi mdi-account"></i> 个人信息</a> </li>
                                <li class="divider"></li>
                                <li> <a href='${ctx}/admin/login'><i class="mdi mdi-logout-variant"></i> 退出登录</a> </li>
                            </ul>
                        </li>

                    </ul>
                </div>
            </nav>
        </header>

        <main class="lyear-layout-content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="card">
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-bordered">
                                        <thead>
                                        <tr>
                                            <th class="textalign">头像</th>
                                            <th class="textalign">姓名</th>
                                            <th class="textalign">电话</th>
                                            <th class="textalign">密码</th>
                                            <th class="textalign">性别</th>
                                            <th class="textalign">年龄</th>
                                            <th class="textalign">宿舍号</th>
                                            <th class="textalign">学号</th>
                                            <th class="textalign">证件号码</th>
                                            <th class="textalign">操作</th>
                                        </tr>
                                        </thead>
                                        <tbody>

                                        <#if memberusers??>
                                            <#list memberusers.list as user >
                                                <tr>
                                                    <td class="textalign"><img src="http://localhost:8081/bishe${user.uimg!}" width="50px" height="30px;" ></td>
                                                    <td class="textalign">${user.uname!}</td>
                                                    <td class="textalign">${user.utel!}</td>
                                                    <td class="textalign">${user.upwd!}</td>
                                                    <td class="textalign">${user.usex!}</td>
                                                    <td class="textalign">${user.uage!}</td>
                                                    <td class="textalign">${user.uroomnumber!}</td>
                                                    <td class="textalign">
                                                        <div class="btn-group">
                                                            <a class="btn btn-primary btn-sm" href="#!" title="编辑" data-toggle="modal"
                                                               data-target="#upInfoModal" onclick="updateInfo(${user.uid})">
                                                                <i class="mdi mdi-pencil"></i>编辑</a>
                                                        </div>
                                                    </td>
                                                </tr>
                                            </#list>
                                        </#if>

                                        </tbody>
                                    </table>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </main>

    </div>
</div>

<#include "adminoneuser_update.ftl">

</body>
</html>
