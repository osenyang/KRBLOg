<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<script type="text/javascript" src="${pageContext.request.contextPath}/js/fckeditor/fckeditor.js"></script>
<script type="text/javascript">
	$(function(){
		/* 默认的bootstrapValidator fckeditor 冲突，并且，不管输入是否正确，都没法执行提交 */
		var fck = new FCKeditor('advanced_content') ; // 提交表单时本字段使用的参数名
		fck.BasePath	= "${pageContext.request.contextPath}/js/fckeditor/" ; // 必须要有，这是指定editor文件夹所在的路径，一定要以'/'结尾
		//fck.Height	= "200" ;//貌似200，所以不用设置
		fck.Width	= "100%" ;
		fck.ToolbarSet = "mood" ;//设置要应用的功能组（myconfig.js里面设置并且对应）
		fck.ReplaceTextarea(); // 替换id或name为指定值的textarea
		
		var id = "${mood.id}";
		if(!id){
			$.copyContent();
		}
		
		//$('form.kr_validate').bootstrapValidator();//如果是模态框载入的内容，需要重新加上这个开启验证
		
		$(".select2").select2({
			language: 'zh-CN'
		});   //如果是模态框，必须在自己的页面去调用开启
	});
	
</script>

<!-- <div class="modal-header">
  <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
  <h4 class="modal-title" id="myModalLabel">我的心情</h4>
</div> -->
      
<form class="form kr_validate" id="mood_form_modal"
    action="${pageContext.request.contextPath }/mood/save.action"
    method="post" enctype="multipart/form-data">
            
      <div class="modal-body">
           <input type="hidden" name="id" value="${mood.id }" />

           <div class="form-group">
               <label class="control-label sr-only" for="advanced_content">我的心情</label>
               <!-- <div class="col-sm-10"> -->
                   <textarea data-bv-notempty
                   	   class="form-control" id="advanced_content" rows="2" name="content"
                       placeholder="随便说一句呗">${mood.content}</textarea>
               <!-- </div> -->
           </div>
           
           <div class="form-group">
               <label class="control-label" for="type_select">标签（按住 Ctrl 可以多选）</label> 
               <!-- <div class="col-sm-10"> -->
                   <select class="select2 form-control" id="type_select" name="tagIds" multiple style="width: 100%;">
                   		<c:forEach items="${types}" var="type">
                   			<option value="${type.id}">${type.type}</option>
                   		</c:forEach>
                   </select>
               <!-- </div> -->
           </div>

      </div>
      <!-- <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="submit" class="btn btn-primary">确认</button>
      </div> -->

</form>