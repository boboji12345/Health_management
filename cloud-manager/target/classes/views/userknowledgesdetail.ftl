<#assign ctx=request.contextPath />
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
    <title>疫情防控知识信息查看学习</title>
    <link href="${ctx}/admin/css/bootstrap.min.css" rel="stylesheet">
    <link href="${ctx}/admin/css/materialdesignicons.min.css" rel="stylesheet">
    <link href="${ctx}/admin/css/style.min.css" rel="stylesheet">
    <link href="${ctx}/css/textalign.css" rel="stylesheet">

    <script type="text/javascript" src="${ctx}/admin/js/jquery.min.js"></script>
    <script type="text/javascript" src="${ctx}/admin/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${ctx}/admin/js/perfect-scrollbar.min.js"></script>
    <script type="text/javascript" src="${ctx}/admin/js/main.min.js"></script>
    <script type="text/javascript" src="${ctx}/admin/js/Chart.js"></script>

    <link href="${ctx}/bootstrapfileinputs/fileinput.min.css" rel="stylesheet">
    <script src="${ctx}/bootstrapfileinputs/sortable.min.js" type="text/javascript"></script>
    <script src="${ctx}/bootstrapfileinputs/purify.min.js" type="text/javascript"></script>
    <script src="${ctx}/bootstrapfileinputs/fileinput.min.js" type="text/javascript"></script>
    <script src="${ctx}/bootstrapfileinputs/zh.js" type="text/javascript"></script>

    <script type="text/javascript" src="${ctx}/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" src="${ctx}/ueditor/ueditor.all.min.js"></script>

    <script type="text/javascript">

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
<input type="hidden" id="selectxialaGType">
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
                        <li class="nav-item nav-item-has-subnav">
                            <a href="javascript:void(0)"><i class="mdi mdi-palette"></i>用户管理</a>
                            <ul class="nav nav-subnav">
                                <li> <a href='${ctx}/admin/useroneinfomana'>个人信息管理</a> </li>
                            </ul>
                        </li>
                        <li class="nav-item nav-item-has-subnav active open">
                            <a href="javascript:void(0)"><i class="mdi mdi-file-outline"></i>资讯管理</a>
                            <ul class="nav nav-subnav">
                                <li> <a href='${ctx}/admin/usernewsmana'>新闻信息查看</a> </li>
                                <li class="active"> <a href='${ctx}/admin/userknowledgesmana'>防控知识查看</a> </li>
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
                        <span class="navbar-page-title"> 首页 —— 疫情防控知识查看学习 </span>
                    </div>
                    <ul class="topbar-right">
                        <li class="dropdown dropdown-profile">
                            <a href="javascript:void(0)" data-toggle="dropdown">
                                <img class="img-avatar img-avatar-48 m-r-10" src="${ctx}/images/top.jpg" style="width:30px; height:30px;"/>

                                <span style="color: #000"><#if Session["oneuser"]?exists> ${Session.oneuser.uname}</#if>
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

                                    <#if admininfo??>
                                    <#list admininfo.list as databean >

                                        <div style="text-align: center">
                                            <p style="font-size: 20px; color: red; font-weight: bold">${databean.rktitle!}</p>
                                        </div>
                                    <div style="text-align: center">
                                        <p>${databean.rkinstroduces!}</p>
                                    </div>

                                        <div style="margin-left: 10%; margin-top: 50px">
                                            <p>${databean.rkcont!}</p>
                                        </div>

                                    </#list>
                                    </#if>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </main>

    </div>
</div>

<#include "adminknowledges_add.ftl">
<#include "adminknowledges_update.ftl">

</body>
</html>
