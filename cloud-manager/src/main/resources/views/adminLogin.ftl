<#assign ctx=request.contextPath />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>登录</title>

    <link type="text/css" rel="stylesheet" href="${ctx}/login/css/login.css" />
    <script rel="stylesheet" type="text/javascript" src="${ctx}/js/jquery.js"></script>

    <link type="text/css" rel="stylesheet" href="${ctx}/Verifications/style.css" />
    <script rel="stylesheet" type="text/javascript" src="${ctx}/Verifications/nav.js"></script>

    <script type="text/javascript">

        $(function() {
            loadCheckCode();
        });

        function loadCheckCode(){
            var show_num = [];
            draw(show_num);
            $("#canvas").on('click',function(){
                draw(show_num);
            })
            $(".btn").on('click',function(){
                var val = $("#yzcode").val().toLowerCase();
                var num = show_num.join("");
                if(val==='0'){
                    alert('请输入验证码！');
               }else if(val == num ){

                    var tel = $("#atel").val();
                    var pwd = $("#apwd").val();
                    var userType = $("input[name='userType']:checked").val();

                    if(isEmpty(tel)){
                        alert("用户名不能为空，请确认一下！");
                        return;
                    }

                    if(isEmpty(pwd)){
                        alert("用户密码不能为空，请确认一下！");
                        return;
                    }

                    $.ajax({
                        url:"${ctx}/admin/adminLogin",
                        type:"get",
                        data : {
                            tel: tel,
                            pwd: pwd,
                            userType: userType
                        },
                        success:function(msg){
                            alert(msg.msg);
                            if(parseInt(msg.code) === 200)
                                window.location="${ctx}/admin/index";
                            if(parseInt(msg.code) === 201)
                                window.location="${ctx}/admin/teacherindex";
                            if(parseInt(msg.code) === 202)
                                window.location="${ctx}/admin/userindex";
                        }
                    });


                }else{
                    alert('验证码错误！请重新输入！');
                    $(".input-val").val('');
                }
            })
        }

        $(document).ready(function () {
            var height=$(document).height();
            $('.main').css('height',height);
        })

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
<div class="main">
    <div class="main0">
        <div class="main_left">
            <img src="${ctx}/login/images/login-image-2.png" style="width:500px; margin-left: -130px; margin-top: -70px" class="secimg"/>
        </div>
        <div class="main_right">
            <form id="Login">
                <div class="main_r_up">
                    <img src="${ctx}/login/images/user.png" />
                    <div class="pp">用户登录</div>
                </div>
                <div class="txt">
                    <span style="letter-spacing:8px;">用户名:</span>
                    <input id="atel" type="text" class="txtphone" placeholder="请输入用户名"/>
                </div>
                <div class="txt">
                    <span style="letter-spacing:4px;">登录密码:</span>
                    <input id="apwd" type="password" class="txtphone" placeholder="请输入登录密码"/>
                </div>

                <div class="txt" style="width:330px;">
                    <input  type="radio" name="userType" checked="checked" value="1" style="vertical-align:middle; margin-top:0;" />
                    <label style="color:#000; font-weight:bold; font-size:14px;">管理员</label>
                    &nbsp;|
                    <input  type="radio" name="userType"  value="2" style="vertical-align:middle; margin-top:0;"  />
                    <label style="color:#000; font-weight:bold; font-size:14px;">&nbsp;班主任</label>
                    |
                    <input  type="radio" name="userType"  value="3" style="vertical-align:middle; margin-top:0;"  />
                    <label style="color:#000; font-weight:bold; font-size:14px;">&nbsp;学生</label>
                </div>

                <div class="txt">
                    <span style=" float:left;letter-spacing:8px;">验证码:</span>
                    <input type="text" value="" placeholder="请输入验证码" id="yzcode" class="input-val">
                    <canvas id="canvas" width="100" height="30"></canvas>
                </div>

                </br></br>
                <input class="xiayibu btn" type="button" value="用户登录" >

            </form>

        </div>
    </div>
</div>

<div class="footer">
    <div class="footer0">
        <div class="footer_l"></div>
        <div class="footer_r"></div>
    </div>
</div>
</body>
</html>
