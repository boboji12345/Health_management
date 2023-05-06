<#assign ctx=request.contextPath />

<div class="modal fade" id= "upInfoModal" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="panel panel-default">
                <div class="panel-heading" data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
                    <h4 class="panel-title">
							<span>修改学生用户信息
								<span style="color:red;">*</span>
							</span>
                    </h4>
                </div>
                <div class="panel-body">
                    <form class="form-horizontal" role="form">

                        <div class="form-group">
                            <label class="col-sm-2 control-label">姓名:</label>
                            <div class="col-sm-10">
                                <input type="text" class="col-sm-9"
                                       id="uUname" style="width:700px; height:40px;" placeholder="请输入姓名">
                            </div>
                        </div>

                        <div class="form-group" style="margin-top: 5px;">
                            <label class="col-sm-2 control-label">所在班级:</label>
                            <div class="col-sm-10">
                                <select class="form-control selectpicker"
                                        id="uTypeSelector" title="请选择所在班级">
                                </select>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label">电话:</label>
                            <div class="col-sm-10">
                                <input type="number" class="col-sm-9" id="uUtel" style="width:700px; height:40px;" placeholder="请输入电话">
                            </div>
                        </div>

                        <div class="form-group" style="margin-top: 5px;">
                            <label class="col-sm-2 control-label">性别:</label>
                            <div class="col-sm-10">
                                <label class="radio" style="margin-left: 15px;">
                                    <input type="radio" name="usex" value="男" checked="checked">男</label>
                                <label class="radio" style="margin-left: 15px;">
                                    <input type="radio" name="usex" value="女">女</label>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label">年龄:</label>
                            <div class="col-sm-10">
                                <input type="number" class="col-sm-9" id="uUage" style="width:700px; height:40px;"
                                       placeholder="请输入年龄">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label">密码:</label>
                            <div class="col-sm-10">
                                <input type="number" class="col-sm-9" style="width:700px; height:40px;" id="uPwd" placeholder="请输入密码">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label">宿舍号:</label>
                            <div class="col-sm-10">
                                <input type="text" class="col-sm-9" style="width:700px; height:40px;" id="uUroomnumber"
                                       placeholder="请输入宿舍号">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label">学号:</label>
                            <div class="col-sm-10">
                                <input type="text" class="col-sm-9" style="width:700px; height:40px;" id="uUstuids"
                                       placeholder="请输入学号">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label">证件号码:</label>
                            <div class="col-sm-10">
                                <input type="text" class="col-sm-9" style="width:700px; height:40px;" id="uUshen"
                                       placeholder="请输入证件号码">
                            </div>
                        </div>

                        <div class="form-group" style="margin-top: 5px;">
                            <label class="col-sm-2 control-label">图片:</label>
                            <div class="col-sm-10" id="preview">
                                <input id="umyFilePh" type="file" name="myFile" class="fileloading">
                                <input type="hidden" id="ufilepath">
                            </div>
                        </div>

                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="submit" class="btn btn-success" onclick="update()">确认</button>
                </div>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
    $("#umyFilePh").fileinput({
        language : 'zh',
        uploadUrl : "uploadphoto",
        maxFileCount : 1,
        autoReplace : true,
        browseClass : "btn btn-primary",
        previewFileIcon : "<i class='glyphicon glyphicon-king'></i>"
    }).on("fileuploaded", function(e, data) {
        var res = data.response;
        var imgpath = res.success;
        document.querySelector('#ufilepath').value  = imgpath;
    });
</script>
