<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 这个是模态框弹出来的内容 -->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/fckeditor/fckeditor.js"></script>
<script type="text/javascript">
	$(function(){
		var fck = new FCKeditor('advanced_content') ; // 提交表单时input标签的name 值或者id
		fck.BasePath	= "${pageContext.request.contextPath}/js/fckeditor/" ; // 必须要有，这是指定editor文件夹所在的路径，一定要以'/'结尾
		//fck.Height	= "200" ;
		fck.Width	= "100%" ;
		fck.ToolbarSet = "fast" ;//设置要应用的功能组（myconfig.js里面设置并且对应）
		fck.ReplaceTextarea(); // 替换id或name为指定值的textarea
		
		
		/* var content = $("#content").val();
		$("#advanced_content").val(content); */
		$.copyContent();
	}); 
	
</script>

      
<form class="form-horizontal" id="message_form_modal"
    action="${pageContext.request.contextPath }/message/save/free.action"
    method="post" enctype="multipart/form-data">
            
      <div class="modal-body">
           <input type="hidden" name="id" value="${message.id }" />

           <div class="form-group">
               <label class="control-label sr-only" for="message">发表留言</label>
               <div class="col-sm-12">
                   <textarea class="form-control" id="advanced_content" rows="2" name="content"
                       placeholder="还望大神不吝啬指教...">${message.content}</textarea>
               </div>
           </div>

      </div>

</form>