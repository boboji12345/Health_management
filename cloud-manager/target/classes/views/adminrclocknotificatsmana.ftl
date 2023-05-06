<#assign ctx=request.contextPath />
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
    <title>一键开启健康打卡</title>
    <link href="${ctx}/admin/css/bootstrap.min.css" rel="stylesheet">
    <link href="${ctx}/admin/css/materialdesignicons.min.css" rel="stylesheet">
    <link href="${ctx}/admin/css/style.min.css" rel="stylesheet">
    <link href="${ctx}/css/textalign.css" rel="stylesheet">

    <link href="${ctx}/bootstrapfileinputs/fileinput.min.css" rel="stylesheet">
    <script src="${ctx}/bootstrapfileinputs/sortable.min.js" type="text/javascript"></script>
    <script src="${ctx}/bootstrapfileinputs/purify.min.js" type="text/javascript"></script>
    <script src="${ctx}/bootstrapfileinputs/fileinput.min.js" type="text/javascript"></script>
    <script src="${ctx}/bootstrapfileinputs/zh.js" type="text/javascript"></script>

    <script type="text/javascript">

        function deleteById(aid){
            if(confirm("是否删除"))
                window.location="${ctx}/admin/deleterclocknotificatsInfoById?Id="+aid;
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

                window.location="${ctx}/admin/deleterclocknotificatsInfoById2?Id="+endids;
            }
        }

        function selectClick(){
            var name = encodeURI(encodeURI($("#inputName").val()));
            window.location="selectrclocknotificatsInfo?name="+name;
        }

        function updateInfo(aid){
            $("#userid").val(aid);

            $.ajax({
                url:"${ctx}/admin/getRclocknotificatsInfoById",
                type:"get",
                data:{id:aid},
                dataType:"json",
                success:function(data){
                    $("#uftname").val(data.obj["ntitle"]);
                    $("#unstarthour").val(data.obj["nstarthour"]);
                    $("#unendhour").val(data.obj["nendhour"]);
                }
            });
        }

        function update() {
            var tname = $("#uftname").val();
            var tid = $("#userid").val();

            if(isEmpty(tname)){
                alert("一键打卡信息不能为空，请确认一下！");
                return;
            }

            $.ajax({
                url:"${ctx}/admin/upAdminRclocknotificatsInfo",
                type:"get",
                data : {
                    tid: tid,
                    tname: tname,
                    nstarthour: nstarthour,
                    nendhour: nendhour
                },
                success:function(msg){
                    $('#upDataInfoModal').modal('hide');
                    history.go(0);
                    alert(msg.msg);
                }
            });
        }

        function save() {
            var tname = $("#aftname").val();
            var nstarthour = $("#anstarthour").val();
            var nendhour = $("#anendhour").val();

            if(isEmpty(tname) || isEmpty(nstarthour) || isEmpty(nendhour)){
                alert("一键打卡信息不能为空，请确认一下！");
                return;
            }

            if(compareTimeInSameDay(getcurrhourminutes(),nstarthour)){
                alert("打卡时间输入错误，请重新输入！");
                return;
            }

            if(compareTimeInSameDay(nstarthour,nendhour)){
                alert("打卡时间输入错误，请重新输入！");
                return;
            }

            $.ajax({
                url:"${ctx}/admin/addAdminRclocknotificatsInfo",
                type:"get",
                data : {
                    tname: tname,
                    nstarthour: nstarthour,
                    nendhour: nendhour
                },
                success:function(msg){
                    $('#addDataInfoModal').modal('hide');
                    history.go(0);
                    alert(msg.msg);
                }
            });
        }

        const compareTimeInSameDay = (t1, t2) => {
            let d = new Date()
            let ft1 = d.setHours(t1.split(":")[0], t1.split(":")[1])
            let ft2 = d.setHours(t2.split(":")[0], t2.split(":")[1])
            return ft1 > ft2
        }

        function getcurrhourminutes() {
            var myDate = new Date();
            var currhour = myDate.getHours();
            var currminute = myDate.getMinutes();
            return currhour+":"+currminute;
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
                        <li class="nav-item nav-item-has-subnav">
                            <a href="javascript:void(0)"><i class="mdi mdi-palette"></i>用户管理</a>
                            <ul class="nav nav-subnav">
                                <li> <a href='${ctx}/admin/adminoneinfomana'>个人信息管理</a> </li>
                                <li> <a href='${ctx}/admin/adminmemberusersmana'>学生信息管理</a> </li>
                                <li> <a href='${ctx}/admin/adminteachersmana'>班主任信息管理</a> </li>
                            </ul>
                        </li>
                        <li class="nav-item nav-item-has-subnav active open">
                            <a href="javascript:void(0)"><i class="mdi mdi-file-outline"></i>新闻资讯管理</a>
                            <ul class="nav nav-subnav">
                                <li class="active"> <a href='${ctx}/admin/adminrclocknotificatsmana'>一键开启健康打卡</a> </li>
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
                        <span class="navbar-page-title"> 首页 —— 一键开启健康打卡 </span>
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
                                <div class="toolbar-btn-action">
                                    <a class="btn btn-primary m-r-5" href="#!" data-toggle="modal" data-target="#addDataInfoModal" >
                                        <i class="mdi mdi-plus"></i>一键开启健康打卡</a>
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
                                            <th class="textalign">打卡信息</th>
                                            <th class="textalign">打卡日期</th>
                                            <th class="textalign">开始时间</th>
                                            <th class="textalign">结束时间</th>
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
                                                                   value="${databean.nid}"><span></span>
                                                        </label>
                                                    </td>
                                                    <td class="textalign">${databean.ntitle!}</td>
                                                    <td class="textalign">${databean.ndate!}</td>
                                                    <td class="textalign">${databean.nstarthour!}</td>
                                                    <td class="textalign">${databean.nendhour!}</td>
                                                    <td class="textalign">
                                                        <div class="btn-group">
                                                            <a class="btn btn-primary btn-sm" href="#!" title="编辑" data-toggle="modal"
                                                               data-target="#upDataInfoModal" onclick="updateInfo(${databean.nid})">
                                                                <i class="mdi mdi-pencil"></i>编辑</a>
                                                            <a class="btn btn-danger btn-sm" href="#!" title="删除" style="margin-left: 2px"
                                                               onclick="deleteById(${databean.nid})">
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
                                            url="admintypesmana?key=${Request.selectName}" />
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

<#include "adminrclocknotificats_add.ftl">
<#include "adminrclocknotificats_update.ftl">

<script type="text/javascript" src="${ctx}/admin/js/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/admin/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${ctx}/admin/js/perfect-scrollbar.min.js"></script>
<script type="text/javascript" src="${ctx}/admin/js/main.min.js"></script>
<script type="text/javascript" src="${ctx}/admin/js/Chart.js"></script>

</body>
</html>
