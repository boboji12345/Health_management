<#assign ctx=request.contextPath />
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
    <title>本班学生信息查看</title>
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

    <script type="text/javascript">

        function selectClick(){
            var name = encodeURI(encodeURI($("#inputName").val()));
            window.location="selectTeacherUsersInfoByFuzzyquery?name="+name;
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
<input type="hidden" id="selectdatas">
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
                        <li class="nav-item"> <a href='${ctx}/admin/teacherindex'><i class="mdi mdi-home"></i> 首页</a> </li>
                        <li class="nav-item nav-item-has-subnav active open">
                            <a href="javascript:void(0)"><i class="mdi mdi-palette"></i>用户管理</a>
                            <ul class="nav nav-subnav">
                                <li> <a href='${ctx}/admin/teacheroneinfomana'>个人信息管理</a> </li>
                                <li class="active"> <a href='${ctx}/admin/teachermemberusersmana'>本班学生信息查看</a> </li>
                            </ul>
                        </li>
                        <li class="nav-item nav-item-has-subnav">
                            <a href="javascript:void(0)"><i class="mdi mdi-file-outline"></i>资讯管理</a>
                            <ul class="nav nav-subnav">
                                <li> <a href='${ctx}/admin/teachernewsmana'>新闻信息查看</a> </li>
                                <li> <a href='${ctx}/admin/teacherknowledgesmana'>防控知识查看</a> </li>
                            </ul>
                        </li>
                        <li class="nav-item nav-item-has-subnav">
                            <a href="javascript:void(0)"><i class="mdi mdi-language-javascript"></i>核心业务管理</a>
                            <ul class="nav nav-subnav">
                                <li> <a href='${ctx}/admin/teacherholidaysmana'>学生休假管理</a> </li>
                                <li> <a href='${ctx}/admin/teacherrdailyclocksmana'>健康打卡信息查看</a> </li>
                                <li> <a href='${ctx}/admin/teacherrinoutsignsmana'>进出登记管理</a> </li>
                                <li> <a href='${ctx}/admin/teacherclockedusersmana'>当日已打卡学生</a> </li>
                                <li> <a href='${ctx}/admin/teachernoclockedusersmana'>当日未打卡学生</a> </li>
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
                        <span class="navbar-page-title"> 首页 —— 本班学生信息查看 </span>
                    </div>

                    <ul class="topbar-right">
                        <li class="dropdown dropdown-profile">
                            <a href="javascript:void(0)" data-toggle="dropdown">
                                <img class="img-avatar img-avatar-48 m-r-10" src="${ctx}/images/top.jpg" style="width:30px; height:30px;"/>

                                <span style="color: #000">
                                    <#if Session["teacheruser"]?exists> ${Session.teacheruser.tuname}</#if>
                                    <span class="caret"></span></span>
                            </a>
                            <ul class="dropdown-menu dropdown-menu-right">
                                <li> <a href='${ctx}/admin/teacheroneinfomana'><i class="mdi mdi-account"></i> 个人信息</a> </li>
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
                            <div class="card-toolbar clearfix">
                                <div class="pull-right search-bar">
                                    <div class="input-group">
                                        <a class="btn btn-success m-r-5" style="float:right" href="#!" onclick="selectClick()">
                                            <i class="mdi mdi-check"></i>查询</a>
                                        <#if Request["selectName"]?exists>
                                            <input type="text" class="form-control" id="inputName"
                                                   style="float:right; width:60%;" placeholder="${Request.selectName}">
                                        <#else>
                                            <input type="text" class="form-control" id="inputName"
                                                   style="float:right; width:60%;" placeholder="请输入查询关键字">
                                        </#if>

                                    </div>
                                </div>
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-bordered">
                                        <thead>
                                        <tr>
                                            <th class="textalign">
                                                <label class="lyear-checkbox checkbox-primary">
                                                    <input type="checkbox" id="check-all"><span></span>
                                                </label>
                                            </th>
                                            <th class="textalign">头像</th>
                                            <th class="textalign">姓名</th>
                                            <th class="textalign">电话</th>
                                            <th class="textalign">密码</th>
                                            <th class="textalign">性别</th>
                                            <th class="textalign">年龄</th>
                                            <th class="textalign">宿舍号</th>
                                            <th class="textalign">学号</th>
                                            <th class="textalign">证件号码</th>
                                            <th class="textalign">所在班级</th>
                                        </tr>
                                        </thead>
                                        <tbody>

                                        <#if memberusers??>
                                            <#list memberusers.list as user >
                                                <tr>
                                                    <td class="textalign">
                                                        <label class="lyear-checkbox checkbox-primary">
                                                            <input type="checkbox" name="ids" id="uid_${user_index}"
                                                                   value="${user.uid}"><span></span>
                                                        </label>
                                                    </td>
                                                    <td class="textalign"><img src="http://localhost:8081/bishe${user.uimg!}" width="50px" height="30px;" ></td>
                                                    <td class="textalign">${user.uname!}</td>
                                                    <td class="textalign">${user.utel!}</td>
                                                    <td class="textalign">${user.upwd!}</td>
                                                    <td class="textalign">${user.usex!}</td>
                                                    <td class="textalign">${user.uage!}</td>
                                                    <td class="textalign">${user.uroomnumber!}</td>
                                                    <td class="textalign">${user.ustuids!}</td>
                                                    <td class="textalign">${user.ushen!}</td>
                                                    <td class="textalign">${user.bname!}</td>
                                                </tr>
                                            </#list>
                                        </#if>

                                        </tbody>
                                    </table>
                                </div>

                                <nav aria-label="Page navigation example">
                                    <ul class="pagination">
                                        <#import "importpage.ftl" as fpage />
                                        <@fpage.fpage page=memberusers.page pagesize=memberusers.pagesize totalpages=memberusers.totalpages totalrecords=memberusers.totalrecords
                                            url="teachermemberusersmana?key=${Request.selectName}" />
                                    </ul>
                                </nav>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </main>
    </div>
</div>

</body>
</html>
