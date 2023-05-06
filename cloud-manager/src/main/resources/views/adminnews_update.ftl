<#assign ctx=request.contextPath />

<div class="modal fade" id= "upDataInfoModal" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="panel panel-default">
                <div class="panel-heading" data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
                    <h4 class="panel-title">
							<span>修改疫情新闻信息
								<span style="color:red;">*</span>
							</span>
                    </h4>
                </div>
                <div class="panel-body">
                    <form class="form-horizontal" role="form">

                        <div class="form-group">
                            <label class="col-sm-2 control-label">新闻名称:</label>
                            <div class="col-sm-10">
                                <input type="text" class="col-sm-9" id="uname" style="width:700px; height:40px;" placeholder="请输入疫情新闻名称">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label">新闻简介:</label>
                            <div class="col-sm-10">
                                <input type="text" class="col-sm-9" id="uinstroduces"
                                       style="width:700px; height:40px;" placeholder="请输入疫情新闻简介">
                            </div>
                        </div>
                         
                        <div class="form-group" style="margin-top: 5px;">
                            <label class="col-sm-2 control-label">疫情新闻分类:</label>
                            <div class="col-sm-10">
                                <select class="form-control selectpicker"
                                        id="uTypeSelector" title="请选择疫情新闻分类">
                                </select>
                            </div>
                        </div>

                        <div class="form-group" style="margin-top: 5px;">
                            <label class="col-sm-2 control-label">图片:</label>
                            <div class="col-sm-10" id="preview">
                                <input id="umyFilePh" type="file" name="myFile" class="fileloading">
                                <input type="hidden" id="ufilepath">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label">详情:</label>
                            <div class="col-sm-10">
                                <script id="myUpEditor" type="text/plain" style="width:730px;height:500px;"></script>
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
