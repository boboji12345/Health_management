<#assign ctx=request.contextPath />
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
    <title>进出登记信息管理</title>
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
                window.location="${ctx}/admin/deleteUserRinoutsignsInfoById?Id="+aid;
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

                window.location="${ctx}/admin/deleteUserRinoutsignsInfoById2?Id="+endids;
            }
        }

        function selectClick(){
            var name = encodeURI(encodeURI($("#inputName").val()));
            window.location="selectUserRinoutsignsInfo?name="+name;
        }

        function updateInfo(aid){
            $("#userid").val(aid);

            $.ajax({
                url:"${ctx}/admin/getRinoutsignsInfoById",
                type:"get",
                data:{id:aid},
                dataType:"json",
                success:function(data){
                    $("#uctemperature").val(data.obj["ctemperature"]);
                    $("input[name='uctype']").each(function(){
                        if( $.trim($(this).val()) === $.trim(parseInt(data.obj["ctype"])) ){
                            $(this).attr("checked",true);
                        }
                    });

                    $("#ucfromattrs").val(data.obj["cfromattrs"]);
                    $("#ucshentizhuangkuang").val(data.obj["cshentizhuangkuang"]);
                    $("#uctoattrs").val(data.obj["ctoattrs"]);
                }
            });
        }

        function update() { 
            var id = $("#userid").val();
            var ctemperature = $("#uctemperature").val(); 
            var ctype = $("input[name='uctype']:checked").val();
            var cfromattrs = $("#ucfromattrs").val();
            var cshentizhuangkuang = $("#ucshentizhuangkuang").val();
            var ctoattrs = $("#uctoattrs").val(); 

            if(isEmpty(ctemperature) ||isEmpty(cshentizhuangkuang) ||isEmpty(cfromattrs) ||isEmpty(ctoattrs) ){
                alert("进出登记信息不能为空，请确认一下！");
                return;
            }

            $.ajax({
                url:"${ctx}/admin/upAdmininoutsignsInfo",
                type:"get",
                data : {
                    id: id,
                    ctemperature: ctemperature,
                    ctype: ctype,
                    cfromattrs: cfromattrs,
                    cshentizhuangkuang: cshentizhuangkuang,
                    ctoattrs: ctoattrs
                },
                success:function(msg){
                    $('#upDataInfoModal').modal('hide');
                    history.go(0);
                    alert(msg.msg);
                }
            });
        }

        function save() {
            var ctemperature = $("#actemperature").val();
            var ctype = $("input[name='actype']:checked").val();
            var cfromattrs = $("#acfromattrs").val();
            var cshentizhuangkuang = $("#acshentizhuangkuang").val();
            var ctoattrs = $("#actoattrs").val();

            if(isEmpty(ctemperature) ||isEmpty(cshentizhuangkuang) ||isEmpty(cfromattrs) ||isEmpty(ctoattrs) ){
                alert("进出登记信息不能为空，请确认一下！");
                return;
            }

            $.ajax({
                url:"${ctx}/admin/addAdmininoutsignsInfo",
                type:"get",
                data : {
                    ctemperature: ctemperature,
                    ctype: ctype,
                    cfromattrs: cfromattrs,
                    cshentizhuangkuang: cshentizhuangkuang,
                    ctoattrs: ctoattrs
                },
                success:function(msg){
                    $('#addDataInfoModal').modal('hide');
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
                        <li class="nav-item nav-item-has-subnav">
                            <a href="javascript:void(0)"><i class="mdi mdi-file-outline"></i>资讯管理</a>
                            <ul class="nav nav-subnav">
                                <li> <a href='${ctx}/admin/usernewsmana'>新闻信息查看</a> </li>
                                <li> <a href='${ctx}/admin/userknowledgesmana'>防控知识查看</a> </li>
                            </ul>
                        </li>
                        <li class="nav-item nav-item-has-subnav active open">
                            <a href="javascript:void(0)"><i class="mdi mdi-language-javascript"></i>核心业务管理</a>
                            <ul class="nav nav-subnav">
                                <li> <a href='${ctx}/admin/userrholidaysmana'>学生休假管理</a> </li>
                                <li> <a href='${ctx}/admin/userrdailyclocksmana'>健康打卡管理</a> </li>
                                <li class="active"> <a href='${ctx}/admin/userrinoutsignsmana'>进出登记管理</a> </li>
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
                        <span class="navbar-page-title"> 首页 —— 进出登记管理 </span>
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
                                    <a class="btn btn-primary m-r-5" href="#!" data-toggle="modal"
                                       data-target="#addDataInfoModal" >
                                        <i class="mdi mdi-plus"></i>新增</a>
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
                                            <th class="textalign">登记日期</th>
                                            <th class="textalign">宿舍号</th>
                                            <th class="textalign">体温</th>
                                            <th class="textalign">证件号码</th>
                                            <th class="textalign">类型名称</th>
                                            <th class="textalign">出发地</th>
                                            <th class="textalign">身体状况</th>
                                            <th class="textalign">目的地</th>
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
                                                                   value="${databean.cid}"><span></span>
                                                        </label>
                                                    </td>
                                                    <td class="textalign"><img src="http://localhost:8081/bishe${databean.uimg!}" width="50px" height="30px;" ></td>
                                                    <td class="textalign">${databean.cdate?date}</td>
                                                    <td class="textalign">${databean.uroomnumber!}</td>
                                                    <td class="textalign">${databean.ctemperature!}</td>
                                                    <td class="textalign">${databean.cuzhengjianhaoma!}</td>
                                                    <td class="textalign">${databean.ctypename!}</td>
                                                    <td class="textalign">${databean.cfromattrs!}</td>
                                                    <td class="textalign">${databean.cshentizhuangkuang!}</td>
                                                    <td class="textalign">${databean.ctoattrs!}</td>
                                                    <td class="textalign">
                                                        <div class="btn-group">
                                                             <a class="btn btn-primary btn-sm" href="#!" title="编辑" data-toggle="modal"
                                                               data-target="#upDataInfoModal"
                                                                onclick="updateInfo(${databean.cid})">
                                                                <i class="mdi mdi-pencil"></i>编辑</a>
                                                            <a class="btn btn-danger btn-sm" href="#!" title="删除" style="margin-left: 2px"
                                                               onclick="deleteById(${databean.cid})">
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
                                            url="userrinoutsignsmana?key=${Request.selectName}" />
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

<#include "admininoutsign_add.ftl">
<#include "admininoutsign_update.ftl">

</body>
</html>
