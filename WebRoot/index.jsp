<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">

<title>Vanxd Wechat Tool Kit</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
</head>

<body>
	<!-- start 新增永久素材 -->
	<!-- https://api.weixin.qq.com/cgi-bin/material/add_material?access_token=ACCESS_TOKEN -->
	<p>新增永久素材</p>
	<form action="https://api.weixin.qq.com/cgi-bin/material/add_material" method="POST" enctype ="multipart/form-data">
		access_token:<input class="accessToken" type="text" name="access_token"></br>
		type:<input type="text" name="type" value="image"></br>
		media:<input type="file" name="media"></br>
		<input type="submit" value="submit"></br>
	</form>
	<!-- 新增永久素材 end -->
	
	<!-- start 获取永久素材列表 -->
	<!-- https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token=ACCESS_TOKEN -->
	<p>获取永久素材列表</p>
	<form action="https://api.weixin.qq.com/cgi-bin/material/batchget_material" method="POST">
		access_token:<input class="accessToken" type="text" name="access_token"></br>
		type:<input type="text" name="type" value="image"></br>
		offset:<input type="text" name="offset" value="0"></br>
		count:<input type="text" name="count" value="10"></br>
		<input type="submit" value="submit"></br>
	</form>
	<!-- 获取永久素材列表 end -->
	<!-- start 上传图文消息素材 -->
	<!-- https://api.weixin.qq.com/cgi-bin/media/uploadnews?access_token=ACCESS_TOKEN -->
	<form action="https://api.weixin.qq.com/cgi-bin/media/uploadnews" method="POST">
		
	</form>
	<!-- 上传图文消息素材 end -->
	
	<!-- start 获取永久素材 -->
	<p>获取永久素材</p>
	<form action="https://api.weixin.qq.com/cgi-bin/material/get_material" method="POST">
		access_token:<input class="accessToken" type="text" name="access_token"></br>
		media_id:<input type="text" name="media_id"></br>
		<input type="submit" value="submit"></br>
	</form>
	<!-- 获取永久素材 end -->
	
	<!-- start 获取用户列表 -->
	<!-- https://api.weixin.qq.com/cgi-bin/user/get?access_token=ACCESS_TOKEN&next_openid=NEXT_OPENID -->
	<form action="https://api.weixin.qq.com/cgi-bin/user/get" method="get">
		access_token:<input class="accessToken" type="text" name="access_token"></br>
		next_openid:<input type="text" name="next_openid"></br>
		<input type="submit" value="submit">
	</form>
	<!-- 获取用户列表 end -->
	
	
	
	<script>
	//access_token global var
	var access_token = getAccessToken();
	function getAccessToken() {
		var ajax = getAjax();
		ajax.open("GET", "/wechat2/accesstoken", true);
		ajax.send();
		ajax.onreadystatechange = function() {
			if (ajax.readyState == 4) {
				if (ajax.status == 200) {
					access_token = ajax.responseText;
					var accessTokenClass = document.getElementsByClassName("accessToken");
					for(var i = 0;i < accessTokenClass.length;i++){
						accessTokenClass[i].value = access_token;
					}
				} else {
					alert("获取accesstoken失败")
				}
			}
		};
	}

	function getAjax() {
		var oAjax = null;
		if (window.XMLHttpRequest) {
			oAjax = new XMLHttpRequest();
		} else {
			oAjax = new ActiveXObject('Microsoft.XMLHTTP');
		}
		return oAjax;
	}
</script>
</body>
</html>
