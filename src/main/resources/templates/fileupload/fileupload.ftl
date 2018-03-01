<!DOCTYPE html>
<html>
<head lang="en">
	<title> Spring Boot Demo - FileUpload </title>
	<link href="/css/index.css" rel="stylesheet" />
</head>
<body>
	<form method="POST" enctype="multipart/form-data" action="/file/upload"> 
       	文件上传：<input type="file" name="uploadFile" />
        <input type="submit" value="上传"/>
   	</form>
</body>
</html>
