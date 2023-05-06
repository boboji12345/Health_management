<#assign ctx=request.contextPath />

<div class="modal fade" id= "addDataInfoModal" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="panel panel-default">
                <div class="panel-heading" data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
                    <h4 class="panel-title">
							<span>添加一键开启健康打卡信息
								<span style="color:red;">*</span>
							</span>
                    </h4>
                </div>
                <div class="panel-body">
                    <form class="form-horizontal" role="form">

                        <div class="form-group">
                            <label class="col-sm-2 control-label">打卡信息:</label>
                            <div class="col-sm-10">
                                <input type="text" class="col-sm-9" id="aftname" style="width:700px; height:40px;"
                                       placeholder="请输入打卡信息">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label">开始时间:</label>
                            <div class="col-sm-10">
                                <input type="time" class="col-sm-9" id="anstarthour" style="width:700px; height:40px;"
                                    step="60000">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label">结束时间:</label>
                            <div class="col-sm-10">
                                <input type="time" class="col-sm-9" id="anendhour" style="width:700px; height:40px;"
                                       step="60000">
                            </div>
                        </div>

                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="submit" class="btn btn-success" onclick="save()">确认</button>
                </div>
            </div>
        </div>
    </div>
</div>
