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
        function updateOneInfo(aid){
            $("#userid").val(aid);

            $.ajax({
                url:"${ctx}/admin/getAdminOneInfoById",
                type:"get",
                data:{id:aid},
                dataType:"json",
                success:function(data){
                    $("#uaUserName").val(data.obj["rname"]);
                    $("#uauserpwd").val(data.obj["rpwd"]);
                    $("#uainputtel").val(data.obj["rtel"]);
                }
            });
        }

        function update() {
            var uname = $("#uaUserName").val();
            var upwd = $("#uauserpwd").val();
            var utel = $("#uainputtel").val();

            if(isEmpty(utel)){
                alert("电话不能为空，请确认一下！");
                return;
            }

            $.ajax({
                url:"${ctx}/admin/upAdminUserInfo",
                type:"get",
                data : {
                    uname: uname,
                    upwd: upwd,
                    utel: utel
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
                <a href='${ctx}/admin/index'>
                    <span style="font-size:20px;">学生健康管理系统</span>
                </a>
            </div>
            <div class="lyear-layout-sidebar-scroll"  style="margin-top: 30px">
                <nav class="sidebar-main">
                    <ul class="nav nav-drawer">
                        <li class="nav-item"> <a href='${ctx}/admin/index'><i class="mdi mdi-home"></i> 后台首页</a> </li>
                        <li class="nav-item nav-item-has-subnav active open">
                            <a href="javascript:void(0)"><i class="mdi mdi-palette"></i>用户管理</a>
                            <ul class="nav nav-subnav">
                                <li class="active"> <a href='${ctx}/admin/adminoneinfomana'>个人信息管理</a> </li>
                                <li> <a href='${ctx}/admin/adminmemberusersmana'>学生信息管理</a> </li>
                                <li> <a href='${ctx}/admin/adminteachersmana'>班主任信息管理</a> </li>
                            </ul>
                        </li>
                        <li class="nav-item nav-item-has-subnav">
                            <a href="javascript:void(0)"><i class="mdi mdi-file-outline"></i>新闻资讯管理</a>
                            <ul class="nav nav-subnav">
                                <li> <a href='${ctx}/admin/adminrclocknotificatsmana'>一键开启健康打卡</a> </li>
                                <li> <a href='${ctx}/admin/admintypesmana'>类型信息管理</a> </li>
                                <li> <a href='${ctx}/admin/adminnewsmana'>新闻信息管理</a> </li>
                                <li> <a href='${ctx}/admin/adminknowledgesmana'>防控知识管理</a> </li>
                            </ul>
                        </li>
                        <li class="nav-item nav-item-has-subnav">
                            <a href="javascript:void(0)"><i class="mdi mdi-language-javascript"></i>核心业务管理</a>
                            <ul class="nav nav-subnav">
                                <li> <a href='${ctx}/admin/adminrholidaysmana'>学生休假管理</a> </li>
                                <li> <a href='${ctx}/admin/adminrdailyclocksmana'>健康打卡管理</a> </li>
                                <li> <a href='${ctx}/admin/adminrinoutsignsmana'>进出登记管理</a> </li>
                                <li> <a href='${ctx}/admin/adminclockedusersmana'>当日已打卡学生</a> </li>
                                <li> <a href='${ctx}/admin/adminnoclockedusersmana'>当日未打卡学生</a> </li>
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
                        <span class="navbar-page-title"> 首页 —— 个人信息管理 </span>
                    </div>

                    <ul class="topbar-right">
                        <li class="dropdown dropdown-profile">
                            <a href="javascript:void(0)" data-toggle="dropdown">
                                <img class="img-avatar img-avatar-48 m-r-10" src="${ctx}/images/top.jpg" style="width:30px; height:30px;"/>

                                <span style="color: #000">
                                    <#if Session["adminuser"]?exists> ${Session.adminuser.rname}</#if>
                                    <span class="caret"></span></span>
                            </a>
                            <ul class="dropdown-menu dropdown-menu-right">
                                <li> <a href='${ctx}/admin/adminoneinfomana'><i class="mdi mdi-account"></i> 个人信息</a> </li>
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
                                            <th class="textalign">用户名</th>
                                            <th class="textalign">密码</th>
                                            <th class="textalign">电话</th>
                                            <th class="textalign">操作</th>
                                        </tr>
                                        </thead>
                                        <tbody>

                                        <tr>
                                            <td class="textalign"><#if Request["requestadminuser"]?exists> ${Request.requestadminuser.rname}</#if></td>
                                            <td class="textalign"><#if Request["requestadminuser"]?exists> ${Request.requestadminuser.rpwd}</#if></td>
                                            <td class="textalign"><#if Request["requestadminuser"]?exists> ${Request.requestadminuser.rtel}</#if></td>
                                            <td class="textalign">
                                                <div class="btn-group">
                                                    <a class="btn btn-primary btn-sm" href="#!" title="编辑"
                                                       data-toggle="modal" data-target="#upInfoModal"
                                                       onclick="updateOneInfo(<#if Request["requestadminuser"]?exists> ${Request.requestadminuser.rid}</#if>)">
                                                        <i class="mdi mdi-pencil"></i>编辑</a>
                                                </div>
                                            </td>
                                        </tr>

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
