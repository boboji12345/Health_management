<#assign ctx=request.contextPath />

<div class="modal fade" id= "upDataInfoModal1" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="panel panel-default">
                <div class="panel-heading" data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
                    <h4 class="panel-title">
							<span>提交审批结果信息
								<span style="color:red;">*</span>
							</span>
                    </h4>
                </div>
                <div class="panel-body">
                    <form class="form-horizontal" role="form">

                        <div class="form-group">
                            <label class="col-sm-2 control-label">审批结果:</label>
                            <div class="col-sm-10">
                                <input type="text" class="col-sm-9" id="uname1" style="width:700px; height:40px;" placeholder="请输入审批结果">
                            </div>
                        </div>

                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="submit" class="btn btn-success" onclick="update1()">确认</button>
                </div>
            </div>
        </div>
    </div>
</div>
