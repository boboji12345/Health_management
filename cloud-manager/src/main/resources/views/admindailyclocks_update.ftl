<#assign ctx=request.contextPath />

<div class="modal fade" id= "upDataInfoModal" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="panel panel-default">
                <div class="panel-heading" data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
                    <h4 class="panel-title">
							<span>修改健康打卡信息
								<span style="color:red;">*</span>
							</span>
                    </h4>
                </div>
                <div class="panel-body">
                    <form class="form-horizontal" role="form">

                        <div class="form-group">
                            <label class="col-sm-2 control-label">所在位置:</label>
                            <div class="col-sm-10">
                                <input type="text" class="col-sm-9" id="upattr" style="width:700px; height:40px;" placeholder="请输入所在位置">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label">体温:</label>
                            <div class="col-sm-10">
                                <input type="text" class="col-sm-9" id="uptemperature"
                                       style="width:700px; height:40px;" placeholder="请输入体温">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label">证件号码:</label>
                            <div class="col-sm-10">
                                <input type="number" class="col-sm-9" id="upuzhengjianhaoma"
                                       style="width:700px; height:40px;" placeholder="请输入证件号码">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label">来源:</label>
                            <div class="col-sm-10">
                                <input type="text" class="col-sm-9" id="uplaiyuan"
                                       style="width:700px; height:40px;" placeholder="请输入来源">
                            </div>
                        </div>

                        <div class="form-group" style="margin-top: 5px;">
                            <label class="col-sm-2 control-label">身体状况:</label>
                            <div class="col-sm-10">
                                <label class="radio" style="margin-left: 15px;">
                                    <input type="radio" name="uzhuangkuang" value="非常健康" checked="checked">非常健康</label>
                                <label class="radio" style="margin-left: 15px;">
                                    <input type="radio" name="uzhuangkuang" value="良好">良好</label>
                                <label class="radio" style="margin-left: 15px;">
                                    <input type="radio" name="uzhuangkuang" value="身体不适">身体不适</label>
                                <label class="radio" style="margin-left: 15px;">
                                    <input type="radio" name="uzhuangkuang" value="感冒发烧">感冒发烧</label>
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
