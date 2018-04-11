<!DOCTYPE html>
<html>
<head lang="en">
<title>Spring Boot Demo - FileUpload</title>
<link href="/css/index.css" rel="stylesheet" />
</head>
<body>
	<form id="tf" method="POST" enctype="multipart/form-data"
		action="/file/upload">
		文件上传：<input type="file" name="uploadFile" /> username：<input
			type="text" name="userName" /> <input type="submit" value="同步上传" />
	</form>
	<button onclick="asyncFromData()">FormData异步上传</button>
	<button onclick="jqueryFormJs()">jqueryFormJs异步上传</button>
	<hr />
</body>

<script type="text/javascript" src="/webjars/jquery/2.1.4/jquery.min.js"></script>
<script src="http://malsup.github.io/jquery.form.js"
	type="text/javascript"></script>


<script type="text/javascript">

	
	
	<!-- 使用FormData异步上传 -->
	function asyncFromData() {
		var tf = new FormData(document.getElementById("tf"));
	    $.ajax({
             url:"/file/upload",
             type:"post",
             data:tf,
             processData:false,
             contentType:false,
             success:function(data){
            	 alert(data);
                 console.log("over..");
             },
             error:function(e){
                 alert("错误！！");
             }
       });
	   return false;//最好返回false，因为如果按钮类型是submit,则表单自己又会提交一次;返回false阻止表单再次提交
	}
	
	<!-- 使用jquery.form.js -->
	function jqueryFormJs() {
		　var option = {
			 url:"/file/upload",
             type:"post",
             //dataType:'json', 定义返回类型
             success:function(data){
            	 alert(data);
                 console.log("over..");
             },
             error:function(e){
                 alert("错误！！");
             }
		 }
     	 $("#tf").ajaxSubmit(option);
         return false; //最好返回false，因为如果按钮类型是submit,则表单自己又会提交一次;返回false阻止表单再次提交
	}
	
</script>

</html>
