<#assign ctx=request.contextPath />
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
    <title>新闻信息管理</title>
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
                window.location="${ctx}/admin/deleteNewsInfoById?Id="+aid;
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

                window.location="${ctx}/admin/deleteNewsInfoById2?Id="+endids;
            }
        }

        function selectClick(){
            var name = encodeURI(encodeURI($("#inputName").val()));
            window.location="selectNewsInfoByTname?name="+name;
        }

        $(function(){
            UE.getEditor('myAddEditor');
            $.ajax({
                url:"${ctx}/admin/getAllTypes",
                type:"get",
                data:{},
                dataType:"json",
                success:function(data){
                    var srtEleadd  =  document.getElementById("aTypeSelector");
                    var srtEleup  =  document.getElementById("uTypeSelector");

                    for(var i = 0 ;i < data.obj.length;i ++ ) {
                        var option  =  document.createElement("option");
                        var text  =  document.createTextNode(data.obj[i]["rtname"]);
                        option.appendChild(text);
                        option.value = data.obj[i]["rtname"];
                        srtEleadd.appendChild(option);
                    }

                    for(var j = 0 ;j < data.obj.length;j ++ ) {
                        var option1  =  document.createElement("option");
                        var text1  =  document.createTextNode(data.obj[j]["rtname"]);
                        option1.appendChild(text1);
                        option1.value = data.obj[j]["rtname"];
                        srtEleup.appendChild(option1);
                    }

                    $("#selectxialaGType").val(data.obj[0]["rtname"]);

                    srtEleadd.onchange = function(){
                        var index = srtEleadd.options.selectedIndex;
                        var value = srtEleadd.options[index].value;
                        $("#selectxialaGType").val(value);
                    }

                    srtEleup.onchange = function(){
                        var index = srtEleup.options.selectedIndex;
                        var value = srtEleup.options[index].value;
                        $("#selectxialaGType").val(value);
                    }

                },
                eror:function(dtta){
                    alert(data);
                }
            });
        });

        function updateInfo(aid){
            $("#userid").val(aid);

            $.ajax({
                url:"${ctx}/admin/getNewsInfoById",
                type:"get",
                data:{id:aid},
                dataType:"json",
                success:function(data){
                    $("#uname").val(data.obj["rntitle"]);
                    $("#uinstroduces").val(data.obj["rinstroduces"]);

                    var ue = UE.getEditor('myUpEditor');
                    ue.addListener("ready", function () {
                        ue.setContent(data.obj["rcont"]);
                    });

                    var obj=document.getElementById("uTypeSelector");
                    for(var i =0; i<obj.options.length; i++){
                        if($.trim(obj.options[i].value) === $.trim(data.obj["rtname"]))
                            obj.options[i].selected=true;
                    }
                }
            });
        }

        function update() {
            var rntitle = $("#uname").val();
            var rinstroduces = $("#uinstroduces").val();
            var id = $("#userid").val();
            var tname = $("#selectxialaGType").val();
            var nimg = $("#ufilepath").val();

            var ue = UE.getEditor('myUpEditor');
            var content = ue.getContent();
            content = content.replace(new RegExp("<","g"),"<").replace(new RegExp(">","g"),">").replace(new RegExp('\"',"g"),'"');

            if(isEmpty(rntitle)){
                alert("新闻信息不能为空，请确认一下！");
                return;
            }

            $.ajax({
                url:"${ctx}/admin/upAdminNewssInfo",
                type:"get",
                data : {
                    id: id,
                    rntitle: rntitle,
                    rinstroduces: rinstroduces,
                    rtname: tname,
                    rcont: content,
                    rimg: nimg
                },
                success:function(msg){
                    $('#upDataInfoModal').modal('hide');
                    history.go(0);
                    alert(msg.msg);
                }
            });
        }

        function save() {
            var rntitle = $("#aname").val();
            var rinstroduces = $("#ainstroduces").val();
            var tname = $("#selectxialaGType").val();
            var nimg = $("#afilepath").val();

            var ue = UE.getEditor('myAddEditor');
            var content = ue.getContent();
            content = content.replace(new RegExp("<","g"),"<").replace(new RegExp(">","g"),">").replace(new RegExp('\"',"g"),'"');

            if(isEmpty(rntitle)){
                alert("新闻信息不能为空，请确认一下！");
                return;
            }

            $.ajax({
                url:"${ctx}/admin/addAdminNewssInfo",
                type:"get",
                data : {
                    rntitle: rntitle,
                    rinstroduces: rinstroduces,
                    rtname: tname,
                    rcont: content,
                    rimg: nimg
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
                                <li> <a href='${ctx}/admin/adminrclocknotificatsmana'>一键开启健康打卡</a> </li>
                                <li> <a href='${ctx}/admin/admintypesmana'>类型信息管理</a> </li>
                                <li class="active"> <a href='${ctx}/admin/adminnewsmana'>新闻信息管理</a> </li>
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
                        <span class="navbar-page-title"> 首页 —— 疫情新闻管理 </span>
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
                                            <th>
                                                <label class="lyear-checkbox checkbox-primary">
                                                    <input type="checkbox" id="check-all"><span></span>
                                                </label>
                                            </th>
                                            <th>图片</th>
                                            <th>疫情标题</th>
                                            <th>简介</th>
                                            <th>类型名称</th>
                                            <th>发布时间</th>
                                            <th>浏览数</th>
                                            <th>操作</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <#if admininfo??>
                                            <#list admininfo.list as databean >
                                                <tr>
                                                    <td>
                                                        <label class="lyear-checkbox checkbox-primary">
                                                            <input type="checkbox" name="ids" id="uid_${databean_index}"
                                                                   value="${databean.rnid}"><span></span>
                                                        </label>
                                                    </td>
                                                    <td><img src="http://localhost:8081/bishe${databean.rimg!}" width="50px" height="30px;" ></td>
                                                    <td>${databean.rntitle!}</td>
                                                    <td>${databean.rinstroduces!}</td>
                                                    <td>${databean.rtname!}</td>
                                                    <td>${databean.rdate?date}</td>
                                                    <td>${databean.rnums!}</td>
                                                    <td>
                                                        <div class="btn-group">
                                                             <a class="btn btn-primary btn-sm" href="#!" title="编辑" data-toggle="modal"
                                                               data-target="#upDataInfoModal"
                                                                onclick="updateInfo(${databean.rnid})">
                                                                <i class="mdi mdi-pencil"></i>编辑</a>
                                                            <a class="btn btn-danger btn-sm" href="#!" title="删除" style="margin-left: 2px"
                                                               onclick="deleteById(${databean.rnid})">
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
                                            url="adminnewsmana?key=${Request.selectName}" />
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

<#include "adminnews_add.ftl">
<#include "adminnews_update.ftl">

</body>
</html>
