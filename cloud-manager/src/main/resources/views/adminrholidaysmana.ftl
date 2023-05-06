<#assign ctx=request.contextPath />
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
    <title>学生休假信息管理</title>
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

        function deleteById(aid){
            if(confirm("是否删除"))
                window.location="${ctx}/admin/deleteRholidaysInfoById?Id="+aid;
        }

        function deleteAll(){
            if(confirm("确定要批量删除吗？")){
                var endids = new Array();
                $("input[name='ids']").each(function(index){
                    if($("#uid_"+index).is(":checked")){
                        endids.push($(this).val());
                    }
                });
                if(isEmpty(endids)){
                    alert("请先选中要删除的数据！");
                    return;
                }

                window.location="${ctx}/admin/deleteRholidaysInfoById2?Id="+endids;
            }
        }

        function selectClick(){
            var name = encodeURI(encodeURI($("#inputName").val()));
            window.location="selectRholidaysInfo?name="+name;
        }

        function updateInfo(aid){
            $("#userid").val(aid);
        }

        function updateInfo1(aid){
            $("#userid").val(aid);
        }

        function update() {
            var rntitle = $("#uname").val();
            var id = $("#userid").val();

            if(isEmpty(rntitle)){
                alert("审批结果不能为空，请确认一下！");
                return;
            }

            $.ajax({
                url:"${ctx}/admin/upAdminHolidaysInfo",
                type:"get",
                data : {
                    id: id,
                    rntitle: rntitle
                },
                success:function(msg){
                    $('#upDataInfoModal').modal('hide');
                    history.go(0);
                    alert(msg.msg);
                }
            });
        }

        function update1() {
            var rntitle = $("#uname1").val();
            var id = $("#userid").val();

            if(isEmpty(rntitle)){
                alert("审批结果不能为空，请确认一下！");
                return;
            }

            $.ajax({
                url:"${ctx}/admin/upAdminHolidaysInfo1",
                type:"get",
                data : {
                    id: id,
                    rntitle: rntitle
                },
                success:function(msg){
                    $('#upDataInfoModal').modal('hide');
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
<input type="hidden" id="selectxialaGType">
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
                        <li class="nav-item nav-item-has-subnav">
                            <a href="javascript:void(0)"><i class="mdi mdi-palette"></i>用户管理</a>
                            <ul class="nav nav-subnav">
                                <li> <a href='${ctx}/admin/adminoneinfomana'>个人信息管理</a> </li>
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
                        <li class="nav-item nav-item-has-subnav active open">
                            <a href="javascript:void(0)"><i class="mdi mdi-language-javascript"></i>核心业务管理</a>
                            <ul class="nav nav-subnav">
                                <li class="active"> <a href='${ctx}/admin/adminrdailyclocksmana'>学生休假管理</a> </li>
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
                        <span class="navbar-page-title"> 首页 —— 学生休假管理 </span>
                    </div>
                    <ul class="topbar-right">
                        <li class="dropdown dropdown-profile">
                            <a href="javascript:void(0)" data-toggle="dropdown">
                                <img class="img-avatar img-avatar-48 m-r-10" src="${ctx}/images/top.jpg" style="width:30px; height:30px;"/>

                                <span style="color: #000"><#if Session["adminuser"]?exists> ${Session.adminuser.rname}</#if>
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
                            <div class="card-toolbar clearfix">
                                <div class="pull-right search-bar">
                                    <div class="input-group">
                                        <a class="btn btn-success m-r-5" style="float:right" href="#!"
                                           onclick="selectClick()">
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
                                <div class="toolbar-btn-action">
                                    <a class="btn btn-danger" href="#!"
                                       onclick="deleteAll()"><i class="mdi mdi-window-close"></i>批量删除</a>
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
                                            <th class="textalign">图片</th>
                                            <th class="textalign">学生姓名</th>
                                            <th class="textalign">学生电话</th>
                                            <th class="textalign">班主任姓名</th>
                                            <th class="textalign">所在班级</th>
                                            <th class="textalign">提交日期</th>
                                            <th class="textalign">休假理由</th>
                                            <th class="textalign">审核状态</th>
                                            <th class="textalign">操作</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <#if admininfo??>
                                            <#list admininfo.list as databean >
                                                <tr>
                                                    <td class="textalign">
                                                        <label class="lyear-checkbox checkbox-primary">
                                                            <input type="checkbox" name="ids" id="uid_${databean_index}"
                                                                   value="${databean.hid}"><span></span>
                                                        </label>
                                                    </td>
                                                    <td class="textalign"><img src="http://localhost:8081/bishe${databean.uimg!}" width="50px" height="30px;" ></td>
                                                    <td class="textalign">${databean.uname!}</td>
                                                    <td class="textalign">${databean.utel!}</td>
                                                    <td class="textalign">${databean.tuname!}</td>
                                                    <td class="textalign">${databean.bname!}</td>
                                                    <td class="textalign">${databean.hdate?date}</td>
                                                    <td class="textalign">${databean.hcont!}</td>

                                                    <td class="textalign">
                                                        <#if databean.hflag==0>
                                                            休假申请中
                                                        <#elseif databean.hflag==1>
                                                            班主任通过，审批结果${databean.hteacherresult!}
                                                        <#elseif databean.hflag==2>
                                                            班主任不通过，审批结果${databean.hteacherresult!}
                                                        <#elseif databean.hflag==3>
                                                            班主任通过，审批结果${databean.hteacherresult!}，管理员通过，审批结果${databean.hadminresult!}
                                                        <#else>
                                                            班主任通过，审批结果${databean.hteacherresult!}，管理员不通过，审批结果${databean.hadminresult!}
                                                        </#if>
                                                    </td>
                                                    <td class="textalign">
                                                        <div class="btn-group">
                                                            <#if databean.hflag==1>
                                                                <a class="btn btn-primary btn-sm" href="#!" title="审批通过" data-toggle="modal"
                                                                   data-target="#upDataInfoModal"
                                                                   onclick="updateInfo(${databean.hid})">
                                                                    <i class="mdi mdi-pencil"></i>审批通过</a>
                                                                <a class="btn btn-primary btn-sm" href="#!" title="审批不通过" data-toggle="modal"
                                                                   data-target="#upDataInfoModal1" style="margin-left: 2px"
                                                                   onclick="updateInfo1(${databean.hid})">
                                                                    <i class="mdi mdi-pencil"></i>审批不通过</a>
                                                            </#if>
                                                            <a class="btn btn-danger btn-sm" href="#!" title="删除" style="margin-left: 2px"
                                                               onclick="deleteById(${databean.hid})">
                                                                <i class="mdi mdi-window-close"></i>删除</a>
                                                        </div>
                                                    </td>
                                                </tr>
                                            </#list>
                                        </#if>

                                        </tbody>
                                    </table>
                                </div>

                                <nav aria-label="Page navigation example">
                                    <ul class="pagination">
                                        <#import "importpage.ftl" as fpage />
                                        <@fpage.fpage page=admininfo.page pagesize=admininfo.pagesize totalpages=admininfo.totalpages totalrecords=admininfo.totalrecords
                                            url="adminrholidaysmana?key=${Request.selectName}" />
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
<#include "adminholidays_update.ftl">
<#include "adminholidays_update1.ftl">
</body>
</html>
