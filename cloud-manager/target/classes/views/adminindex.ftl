<#assign ctx=request.contextPath />
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
    <title>首页</title>
    <link href="${ctx}/admin/css/bootstrap.min.css" rel="stylesheet">
    <link href="${ctx}/admin/css/materialdesignicons.min.css" rel="stylesheet">
    <link href="${ctx}/admin/css/style.min.css" rel="stylesheet">

</head>

<body>
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
                        <li class="nav-item active"> <a href='${ctx}/admin/index'><i class="mdi mdi-home"></i> 后台首页</a> </li>
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
                        <span class="navbar-page-title"> 首页 </span>
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
                    <div class="col-lg-3" style="background: #cc0000; text-align: center; height: 120px; ">
                        <h6 class="text-white text-uppercase" style="line-height: 40px; font-size: 20px">用户数</h6>
                        <h1 class="text-white counter" style="line-height: 70px">${Request.Rusersnums}</h1>
                    </div>

                    <div class="col-lg-3" style="background: #0c5460; text-align: center; height: 120px;">
                        <h6 class="text-white text-uppercase" style="line-height: 40px; font-size: 20px">健康打卡数</h6>
                        <h1 class="text-white counter" style="line-height: 70px">${Request.rdailyclocksnums}</h1>
                    </div>

                    <div class="col-lg-3" style="background: #0d0d0d; text-align: center; height: 120px;">
                        <h6 class="text-white text-uppercase" style="line-height: 40px; font-size: 20px">外出登记数</h6>
                        <h1 class="text-white counter" style="line-height: 70px">${Request.rinoutsignsnums}</h1>
                    </div>

                    <div class="col-lg-3" style="background: #00bf72; text-align: center; height: 120px;">
                        <h6 class="text-white text-uppercase" style="line-height: 40px; font-size: 20px">疫情新闻分类数</h6>
                        <h1 class="text-white counter" style="line-height: 70px">${Request.rtypesnums}</h1>
                    </div>
                </div>

                <div class="row" style="margin-top: 50px">
                    <div class="col-lg-6">
                        <div class="card">
                            <div class="card-header">
                                <h4>每日健康柱状图数据统计</h4>
                            </div>
                            <div class="card-body">
                                <canvas class="js-chartjs-bars" style="height: 300px"></canvas>
                            </div>
                        </div>
                    </div>

                    <div class="col-lg-6">
                        <div class="card">
                            <div class="card-header">
                                <h4>每日健康折线图数据统计</h4>
                            </div>
                            <div class="card-body">
                                <canvas class="js-chartjs-lines" style="height: 300px"></canvas>
                            </div>
                        </div>
                    </div>

                    <div class="col-lg-6">
                        <div class="card">
                            <div class="card-header">
                                <h4>每日健康饼状图数据统计</h4>
                            </div>
                            <div class="card-body">
                                <canvas class="js-chartjs-lines2"></canvas>
                            </div>
                        </div>
                    </div>

               </div>
            </div>
        </main>
    </div>
</div>

<script type="text/javascript" src="${ctx}/admin/js/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/admin/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${ctx}/admin/js/perfect-scrollbar.min.js"></script>
<script type="text/javascript" src="${ctx}/admin/js/main.min.js"></script>
<script type="text/javascript" src="${ctx}/admin/js/Chart.js"></script>

<script type="text/javascript">
    $(document).ready(function(e) {
        var $dashChartBarsCnt  = jQuery( '.js-chartjs-bars' )[0].getContext( '2d' ),
            $dashChartLinesCnt = jQuery( '.js-chartjs-lines' )[0].getContext( '2d' ),
            $dashChartLinesCnt2 = jQuery( '.js-chartjs-lines2' )[0].getContext( '2d' );

        var fts=[];
        var ftnums=[];

        $.ajax({
            url:"${ctx}/admin/selectdailyclocsecharts",
            type:"get",
            data:{},
            dataType:"json",
            success:function(data){
                fts.push("非常健康");
                fts.push("良好");
                fts.push("身体不适");
                fts.push("感冒发烧");

                ftnums.push(parseInt(data.obj[0]));
                ftnums.push(parseInt(data.obj[1]));
                ftnums.push(parseInt(data.obj[2]));
                ftnums.push(parseInt(data.obj[3]));

                var $dashChartBarsData = {
                    labels: fts,
                    datasets: [
                        {
                            label: '数量',
                            data: ftnums,
                            borderColor: 'rgb(75, 192, 192)',
                            backgroundColor:'rgb(255, 0,0)',
                            hoverBackgroundColor: "rgba(51,202,185,0.7)"
                        }
                    ]
                };

                new Chart($dashChartBarsCnt, {
                    type: 'bar',
                    data: $dashChartBarsData,
                    options: {
                        responsive: true, // 设置图表为响应式，根据屏幕窗口变化而变化
                        maintainAspectRatio: false,// 保持图表原有比例
                        scales: {
                            yAxes: [{
                                ticks: {
                                    beginAtZero:true
                                }
                            }]
                        }
                    }
                });
            }
        });

        var cames=[];
        var cnums=[];

        $.ajax({
            url:"${ctx}/admin/selectdailyclocsecharts",
            type:"get",
            data:{},
            dataType:"json",
            success:function(data){
                cames.push("非常健康");
                cames.push("良好");
                cames.push("身体不适");
                cames.push("感冒发烧");

                cnums.push(parseInt(data.obj[0]));
                cnums.push(parseInt(data.obj[1]));
                cnums.push(parseInt(data.obj[2]));
                cnums.push(parseInt(data.obj[3]));

                var $dashChartLinesData = {
                    labels: cames,
                    datasets: [
                        {
                            label: '数量',
                            data: cnums,
                            borderColor: '#358ed7',
                            backgroundColor: 'rgba(53, 142, 215, 0.175)',
                            borderWidth: 1,
                            fill: false,
                            lineTension: 0.5
                        }
                    ]
                };

                var myLineChart = new Chart($dashChartLinesCnt, {
                    type: 'line',
                    data: $dashChartLinesData,
                    options: {
                        responsive: true, // 设置图表为响应式，根据屏幕窗口变化而变化
                        maintainAspectRatio: false,// 保持图表原有比例
                        scales: {
                            yAxes: [{
                                ticks: {
                                    beginAtZero:true
                                }
                            }]
                        }
                    }
                });

            }
        });

        var eames=[];
        var enums=[];

        $.ajax({
            url:"${ctx}/admin/selectdailyclocsecharts",
            type:"get",
            data:{},
            dataType:"json",
            success:function(data){
                eames.push("非常健康");
                eames.push("良好");
                eames.push("身体不适");
                eames.push("感冒发烧");

                enums.push(parseInt(data.obj[0]));
                enums.push(parseInt(data.obj[1]));
                enums.push(parseInt(data.obj[2]));
                enums.push(parseInt(data.obj[3]));

                var $dashChartLinesData2 = {
                    labels: eames,
                    datasets: [
                        {
                            label: '数量',
                            data: enums,
                            backgroundColor: [
                                'rgb(255, 99, 132)',
                                'rgb(54, 162, 235)',
                                'rgb(255, 205, 86)',
                                'rgb(100, 105, 186)'
                            ],
                        }
                    ]
                };

                var myLineChart2 = new Chart($dashChartLinesCnt2, {
                    type: 'pie',
                    data: $dashChartLinesData2
                });

            }
        });

    });
</script>
</body>
</html>
