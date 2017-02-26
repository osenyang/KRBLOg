<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script type="text/javascript">
$(function(){
});
</script>

<!-- form-horizontal 水平排列 -->
<form class="form" id="type_encrypt_form"  role="form"
    action="${pageContext.request.contextPath}/manage/type/encrypt.action"
    method="post">

    <div class="modal-body">
        <input type="hidden" name="id" value="${type.id }" />

        <div class="form-group">
            <label class="control-label" for="secret_code">类型</label>
            <select class="form-control selector select2" id="secret_code" name="secretCode">
               <option value="0" ${type.isSecret == 0 ? "selected" : ""}>所有人可见</option>
               <option value="5" ${type.isSecret == 5 ? "selected" : ""}>自己可见</option>
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

</form>