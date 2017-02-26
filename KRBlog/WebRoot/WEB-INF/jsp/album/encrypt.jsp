<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script type="text/javascript">
$(function(){
	//TODO 回显下拉选择框
    /* var _code = ${album.isSecret};
    if(_code == 0){
        $(".selector").find("option:contains('所有人可见')").attr("selected",true);
    }
    if(_code == 5){
        $(".selector").find("option:contains('自己可见')").attr("selected",true);
    } */
}
);
</script>

<!-- <div class="modal-header">
    <button type="button" class="close" data-dismiss="modal"
        aria-label="Close">
        <span aria-hidden="true">&times;</span>
    </button>
    <h4 class="modal-title" id="myModalLabel">加密</h4>
</div> -->
<!-- form-horizontal 水平排列 -->
<form class="form" id="album_encrypt_form"  role="form"
    action="${pageContext.request.contextPath}/album/encrypt.action"
    method="post">

    <div class="modal-body">
        <input type="hidden" name="id" value="${album.id }" />

        <div class="form-group">
            <label class="control-label" for="secret_code">类型</label>
            <select class="form-control selector select2" id="secret_code" name="secretCode">
               <option value="0" ${album.isSecret == 0 ? "selected" : ""}>所有人可见</option>
               <option value="5" ${album.isSecret == 5 ? "selected" : ""}>自己可见</option>
            </select>
        </div>
        
        <div class="form-group">
            <label class="control-label" for="secret">密码</label>
            <input class="form-control" id="secret" type="text" name="secret"></input>
        </div>
        <div class="form-group">
            <label class="control-label" for="secret_question">高级加密</label>
            <a class="btn btn-success form-control" id="secret_question">问题加密</a>
        </div>

    </div>
    <!-- <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="submit" class="btn btn-primary">确认</button>
    </div> -->

</form>