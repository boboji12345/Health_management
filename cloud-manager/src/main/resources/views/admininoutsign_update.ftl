<#assign ctx=request.contextPath />

<div class="modal fade" id= "upDataInfoModal" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="panel panel-default">
                <div class="panel-heading" data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
                    <h4 class="panel-title">
							<span>修改进出登记信息
								<span style="color:red;">*</span>
							</span>
                    </h4>
                </div>
                <div class="panel-body">
                    <form class="form-horizontal" role="form">

                        <div class="form-group">
                            <label class="col-sm-2 control-label">体温:</label>
                            <div class="col-sm-10">
                                <input type="text" class="col-sm-9" id="uctemperature" style="width:700px; height:40px;" placeholder="请输入体温">
                            </div>
                        </div>

                        <div class="form-group" style="margin-top: 5px;">
                            <label class="col-sm-2 control-label">进or入:</label>
                            <div class="col-sm-10">
                                <label class="radio" style="margin-left: 15px;">
                                    <input type="radio" name="uctype" value="0" checked="checked">进</label>
                                <label class="radio" style="margin-left: 15px;">
                                    <input type="radio" name="uctype" value="1">入</label>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label">出发地:</label>
                            <div class="col-sm-10">
                                <input type="text" class="col-sm-9" id="ucfromattrs" style="width:700px; height:40px;" placeholder="请输入出发地">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label">身体状况:</label>
                            <div class="col-sm-10">
                                <input type="text" class="col-sm-9" id="ucshentizhuangkuang" style="width:700px; height:40px;" placeholder="请输入身体状况">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label">目的地:</label>
                            <div class="col-sm-10">
                                <input type="text" class="col-sm-9" id="uctoattrs" style="width:700px; height:40px;" placeholder="请输入目的地">
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
