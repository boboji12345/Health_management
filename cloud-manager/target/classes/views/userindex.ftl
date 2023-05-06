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

    <script type="text/javascript" src="${ctx}/admin/js/jquery.min.js"></script>
    <script type="text/javascript" src="${ctx}/admin/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${ctx}/admin/js/perfect-scrollbar.min.js"></script>
    <script type="text/javascript" src="${ctx}/admin/js/main.min.js"></script>
    <script type="text/javascript" src="${ctx}/admin/js/Chart.js"></script>

</head>
<body>
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
                        <li class="nav-item active"> <a href='${ctx}/admin/userindex'><i class="mdi mdi-home"></i> 首页</a> </li>
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
                        <span class="navbar-page-title"> 首页 </span>
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

                    <div class="col-lg-3" style="background: #0c5460; text-align: center; height: 120px;">
                        <h6 class="text-white text-uppercase" style="line-height: 40px; font-size: 20px">健康打卡数</h6>
                        <h1 class="text-white counter" style="line-height: 70px">${Request.rdailyclocksnums}</h1>
                    </div>

                    <div class="col-lg-3" style="background: #0d0d0d; text-align: center; height: 120px;">
                        <h6 class="text-white text-uppercase" style="line-height: 40px; font-size: 20px">外出登记数</h6>
                        <h1 class="text-white counter" style="line-height: 70px">${Request.rinoutsignsnums}</h1>
                    </div>

                    <div class="col-lg-3" style="background: #0d8ddb; text-align: center; height: 120px;">
                        <h6 class="text-white text-uppercase" style="line-height: 40px; font-size: 20px">疫情数据数</h6>
                        <h1 class="text-white counter" style="line-height: 70px">${Request.snewsnums}</h1>
                    </div>

                    <div class="col-lg-3" style="background: #00bf72; text-align: center; height: 120px;">
                        <h6 class="text-white text-uppercase" style="line-height: 40px; font-size: 20px">疫情新闻分类数</h6>
                        <h1 class="text-white counter" style="line-height: 70px">${Request.rtypesnums}</h1>
                    </div>
                </div>

                <div>
                    <div>
                        <p style="text-align: center; font-weight: bold; font-size: 25px; margin-top: 20px">
                            十条措施请牢记
                        </p>
                    </div>

                    <div>
                        <p style="font-size: 16px">
                            第一：不麻痹、不大意。千里之堤，溃于蚁穴。在疫情防控方面，一个小小的疏忽，就可能毁掉来之不易的抗疫成果。不麻痹、不松懈、不大意，坚持做好防护，才能阻断新冠病毒传播。
                        </p>
                    </div>

                    <div>
                        <p style="font-size: 16px">
                            第二：戴口罩、要坚持。科学佩戴口罩是预防呼吸道传染病最有效的措施之一。尤其是前去公共场所、密闭空间，乘坐公共交通工具时务必正确佩戴口罩。
                        </p>
                    </div>

                    <div>
                        <p style="font-size: 16px">
                            第三：打喷嚏、讲礼仪。咳嗽、喷嚏时产生的飞沫常常携带病毒，可直接或间接导致病毒传播。因此，咳嗽、喷嚏时一定要用纸巾、手绢来捂住口鼻。
                        </p>
                    </div>

                    <div>
                        <p style="font-size: 16px">
                            第四：勤洗手、讲卫生。勤洗手、讲卫生是保证身体健康最重要的方法。饭前便后、接触外界物品后，触摸口眼鼻之前，请务必认真清洗双手，遵循七步洗手法，用肥皂（洗手液）和流水搓揉至少20秒。
                        </p>
                    </div>

                    <div>
                        <p style="font-size: 16px">
                            第五：常通风、不可少。开窗通风，保持室内空气流动，可有效降低空气中病毒和细菌的浓度，减少疾病传播风险。每天应开窗通风2-3次，每次20-30分钟，尤其是密闭的空调房一定要定期开窗通风。
                        </p>
                    </div>

                    <div>
                        <p style="font-size: 16px">
                            第六：一米距、更安全。呼吸道传染病主要通过近距离呼吸道飞沫传播，保持一米以上社交距离可在一定程度上预防病毒感染。守住一米线，出行勿拥挤，保持安全距离，于人于己都有益。
                        </p>
                    </div>

                    <div>
                        <p style="font-size: 16px">
                            第七：少出门、不聚集。公共场所人员多、流动大，聚餐、聚会易导致呼吸道传染病传播。因此人多场所不要去，拥挤场所要回避。少出门、不扎堆。
                        </p>
                    </div>

                    <div>
                        <p style="font-size: 16px">
                            第八：打疫苗，很重要。接种疫苗是预防疾病最经济、最有效、最便捷的手段。防控新冠病毒，接种疫苗和个人防护一个都不能少。凡是符合接种条件的人员要积极接种新冠病毒疫苗，为构建免疫屏障贡献一臂之力。
                        </p>
                    </div>

                    <div>
                        <p style="font-size: 16px">
                            第九：讲科学、强免疫。饮食营养均衡、适度运动锻炼，坚持规律作息，不熬夜，保证睡眠充足，保持良好心态，可以有效增强人体免疫力。
                        </p>
                    </div>

                    <div>
                        <p style="font-size: 16px">
                            第十：有症状，早就医。主动做好健康监测，如有发热、咳嗽等症状，及时前往发热门诊就诊，途中避免乘坐公共交通工具，主动告知旅居史、接触史，不隐瞒、不回避，并遵医嘱留观排查。
                        </p>
                    </div>

                </div>
            </div>
        </main>
    </div>
</div>

</body>
</html>
