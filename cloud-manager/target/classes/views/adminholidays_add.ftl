<#assign ctx=request.contextPath />

<div class="modal fade" id= "addDataInfoModal" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="panel panel-default">
                <div class="panel-heading" data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
                    <h4 class="panel-title">
							<span>添加休假理由信息
								<span style="color:red;">*</span>
							</span>
                    </h4>
                </div>
                <div class="panel-body">
                    <form class="form-horizontal" role="form">

                        <div class="form-group">
                            <label class="col-sm-2 control-label">休假理由:</label>
                            <div class="col-sm-10">
                                <input type="text" class="col-sm-9" id="auname" style="width:700px; height:40px;" placeholder="请输入休假理由">
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
