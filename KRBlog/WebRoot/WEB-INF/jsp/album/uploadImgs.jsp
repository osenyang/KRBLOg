<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 上传照片 -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/style/css/basic.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/style/css/dropzone.min.css" />
<!-- 文件上传 JS -->
<script src="${pageContext.request.contextPath}/js/dropzone.min.js"></script>
<script src="${pageContext.request.contextPath}/js/dropzone-amd-module.min.js"></script>
<script>
     //Dropzone.options.myDropzone = false;
     Dropzone.autoDiscover = false;
     
     $(function(){//jquery 方式，必须反正jQuery 内部(fuck 非query 方式也需要反正这里面)
        
        $("#kr-form-dropzone").dropzone({
            url: "${pageContext.request.contextPath}/album/dropzoneImg.action",
            addRemoveLinks: true,//移除按钮
            method: 'post',
            acceptedFiles: ".jpg,.gif,.png,.jpeg,.bmp", //上传的类型
            autoProcessQueue: false,//当设置为false,你必须自身调用myDropzone.processQueue()上传文件。有关更多信息,请参见下面有关处理队列。
            maxFiles: 20, //设置最多上传多少个
            maxFilesize: 4,//单位 MB
            //uploadMultiple: true,
            parallelUploads: 100,//同时上传，选择1那么就不会存在同时冲进去一个线程几个图片了（如果不是1，那么会在第一次上传的时候出现一个bug，就是session还没加入元素，几个图片就都跑进来了。从而有一些图片没有加入到session里面）
            paramName: "file",
            filesizeBase: 1024,
            dictDefaultMessage: "点击这里上传图片或者拖拽图片到这里",//任何文件被拖拽进区域之前显示的信息。这通常是被一个图像,但默认为“Drop files here to upload”。
            dictInvalidFileType: "请上传图片格式：.jpg, .gif, .png, .jpeg, .bmp",
            init: function() {//因为听事件只能是Dropzone实例,设置你的事件侦听器,最好的地方是在init函数。
                var submitButton =  document.querySelector("#btn-beginUpload")          
                krDropzone = this; 
                /* krDropzone.on("addedfile", function(file) { 
                	$.ajax({
                        type: 'POST',
                        url: "${pageContext.request.contextPath}/album/setIdInsession.action",
                        data: {id : $("#album_id").val()},
                        dataType: 'html'
                    });
                });   */              
                //为上传按钮添加点击事件           
                submitButton.addEventListener("click", function () {
                	// 把album id 反正request 或者 session 域里面先
                    //手动上传所有文件               
                    krDropzone.processQueue();
                	//$("#kr-form-dropzone").submit();//这样跳转太快了，无法上传全部的图片
                    
                });
            } // end init:function()
        });
        
        
    }); // -----jquery 
    
    
</script>

    
<!-- Modal -->
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">上传图片 into 『 ${album.name} 』</h4>
      </div>
      <div class="modal-body">
      
        <form id="kr-form-dropzone"
		    method="post" enctype="multipart/form-data" 
		    action="${pageContext.request.contextPath}/album/detail.action"
		    class="dropzone">
		    <input type="hidden" name="id" id="album_id" value="${album.id}" />
		    
		    <div class="fallback">
		        <input type="file" name="file" multiple/>
		    </div> 
		</form>        

      </div>
      
      
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">返回</button>
        <button id="btn-beginUpload" class="btn btn-primary" >开始上传</button>
      </div>
