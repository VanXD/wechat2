<%@ page language="java" contentType="text/html; charset=UTF-8"%>
        <!DOCTYPE HTML>
        <html>

        <head>

            <title>Vanxd Wechat Tool Kit</title>
            <meta http-equiv="pragma" content="no-cache">
            <meta http-equiv="cache-control" content="no-cache">
            <meta http-equiv="expires" content="0">
            <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
            <meta http-equiv="description" content="This is my page">
            <meta charset="utf-8">
            <script src="js/jquery-1.11.2.min.js"></script>
        </head>
	
        <body>
        	<p>获取素材总数</p>
        	<form action="material/getMaterialCount" method="get">
        		<input type="submit">
        	</form>
        
            <p>修改图文素材</p>
            <form action="#" method="POST" class="add_news">
                <span class="intro">
			Title: <input type="text" class="title" name="title"> 
			Introduction: <input type="text" class="introduction" name="introduction">
			media_id: <input type="text" class="media_id" name="media_id">
			index: <input type="text" class="index" name="index">
			<br>
		</span>
                <span class="news"> 
			thumb_media_id: <input class="thumb_media_id" name="thumb_media_id" type="text">
			author: <input class="author" name="author" type="text"> 
			title: <input class="title" name="title" type="text"> 
			content_source_url: <input class="content_source_url" name="content_source_url" type="text"> 
			content: <input class="content" name="content" type="text"> 
			digest: <input class="digest" name="digest" type="text"> 
			show_cover_pic: <input class="show_cover_pic" name="show_cover_pic" type="text">
		</span>
                <br>
                <input type="button" value="submit" onclick="udpateNewsJsonData(this)">
            </form>
            
        	<!-- 测试删除指定素材 -->
        	<p>删除指定素材</p>
        	<form method="post" action="material/delMatrial">
        		<input type="text" name="media_id">
        		<input type="submit" value="submit">
        	</form>
        	
            <!-- start 新增永久素材 -->
            <!-- https://api.weixin.qq.com/cgi-bin/material/add_material?access_token=ACCESS_TOKEN -->
            <p>新增永久素材</p>
            <form action="https://api.weixin.qq.com/cgi-bin/material/add_material" method="POST" enctype="multipart/form-data">
                access_token:
                <input class="accessToken" type="text" name="access_token"> <br> type:
                <input type="text" name="type" value="image"> <br> media:
                <input type="file" name="media">
                <br>
                <input type="submit" value="submit"> <br>
            </form>
            <!-- 新增永久素材 end -->

            <!-- start 获取永久素材列表 -->
            <!-- https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token=ACCESS_TOKEN -->
            <p>获取永久素材列表</p>
            <form action="material/batchGetMaterial" method="POST">
                 type: <input type="text" name="type" value="image"> <br> 
                 offset: <input type="text" name="offset" value="0"> <br> 
                 count: <input type="text" name="count" value="10">
                <br>
                <input type="submit" value="submit"> <br>
            </form>
            <!-- 获取永久素材列表 end -->
            <!-- start 上传图文消息素材 -->
            <!-- https://api.weixin.qq.com/cgi-bin/media/uploadnews?access_token=ACCESS_TOKEN -->
            <form action="https://api.weixin.qq.com/cgi-bin/media/uploadnews" method="POST"></form>
            <!-- 上传图文消息素材 end -->

            <!-- start 获取永久素材 -->
            <p>获取永久素材</p>
            <form action="https://api.weixin.qq.com/cgi-bin/material/get_material" method="POST">
                access_token:
                <input class="accessToken" type="text" name="access_token"> <br> media_id:
                <input type="text" name="media_id"> <br>
                <input type="submit" value="submit">
                <br>
            </form>
            <!-- 获取永久素材 end -->

            <!-- start 获取用户列表 -->
            <!-- https://api.weixin.qq.com/cgi-bin/user/get?access_token=ACCESS_TOKEN&next_openid=NEXT_OPENID -->
            <form action="https://api.weixin.qq.com/cgi-bin/user/get" method="get">
                access_token:
                <input class="accessToken" type="text" name="access_token"> <br> next_openid:
                <input type="text" name="next_openid"> <br>
                <input type="submit" value="submit">
            </form>
            <!-- 获取用户列表 end -->


            <h1>Native Native Native</h1>

            <br>
            <p>上传文件素材,自动判断文件类型</p>
            <form action="material/addMaterial" method="POST" enctype="multipart/form-data">
                Title:
                <input type="text" name="title"> <br> Introduction:
                <input type="text" name="introduction"> <br> File:
                <input type="file" name="file"> <br>
                <input type="submit" value="submit">
            </form>

            <p>上传图文素材</p>
            <form action="material/addNews" method="POST" class="add_news">
                <span class="intro">
			Title: <input type="text" class="title" name="title"> 
			Introduction: <input type="text" class="introduction" name="introduction">
			article_count:<input type="text" class="article_count" name="article_count"><br>
		</span>
                <span class="news"> 
			thumb_media_id: <input class="thumb_media_id" name="thumb_media_id" type="text">
			author: <input class="author" name="author" type="text"> 
			title: <input class="title" name="title" type="text"> 
			content_source_url: <input class="content_source_url" name="content_source_url" type="text"> 
			content: <input class="content" name="content" type="text"> 
			digest: <input class="digest" name="digest" type="text"> 
			show_cover_pic: <input class="show_cover_pic" name="show_cover_pic" type="text">
		</span>
                <br>
                <span class="news"> 
			thumb_media_id: <input class="thumb_media_id" name="thumb_media_id" type="text">
			author: <input class="author" name="author" type="text"> 
			title: <input class="title" name="title" type="text"> 
			content_source_url: <input class="content_source_url" name="content_source_url" type="text"> 
			content: <input class="content" name="content" type="text"> 
			digest: <input class="digest" name="digest" type="text"> 
			show_cover_pic: <input class="show_cover_pic" name="show_cover_pic" type="text">
		</span>
                <br>
                <input type="button" value="submit" onclick="newsJsonData(this)">
            </form>

            <p>上传图文素材2</p>
            <form action="material/addNews" method="POST" class="">
                Title:
                <input type="text" name="title"> <br> Introduction:
                <input type="text" name="introduction"> <br>
                <input type="text" name="article_count">
                <br>
                <span class=""> 
			thumb_media_id: <input class="thumb_media_id" name="articles[0].thumb_media_id" type="text">
			author: <input class="author" name="articles[0].author" type="text"> 
			title: <input class="title" name="articles[0].title" type="text"> 
			content_source_url: <input class="content_source_url" name="articles[0].content_source_url" type="text"> 
			content: <input class="content" name="articles[0].content" type="text"> 
			digest: <input class="digest" name="articles[0].digest" type="text"> 
			show_cover_pic: <input class="show_cover_pic" name="articles[0].show_cover_pic" type="text">
		</span>
                <br>
                <input type="submit" value="submit" onclick="testAjaxS()">
            </form>

            <p>上传临时素材</p>
            <form action="material/addTempMaterial" method="POST" enctype="multipart/form-data">
                File:
                <input type="file" name="file"> <br>
                <input type="submit" value="submit">
            </form>

            <p>测试AJAX</p>
            <form action="#" method="get">
                <input type="submit" value="submit" onclick="testAjaxS()">
            </form>

            <p>测试addObject</p>
            <form action="material/addObject" method="POST" enctype="multipart/form-data">
                Title:
                <input type="text" name="title"> <br>
                Introduction:
                <input type="text" name="introduction"> <br>
                File:
                <input type="file" name="file"> <br>
                <input type="submit" value="submit">
            </form>
            <script>
                //access_token global var
                var access_token = getAccessToken();

                function getAccessToken() {
                    var ajax = getAjax();
                    ajax.open("GET", "/wechat2/accesstoken", true);
                    ajax.send();
                    ajax.onreadystatechange = function () {
                        if (ajax.readyState == 4) {
                            if (ajax.status == 200) {
                                access_token = ajax.responseText;
                                var accessTokenClass = document
                                    .getElementsByClassName("accessToken");
                                for (var i = 0; i < accessTokenClass.length; i++) {
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
            <script>
                function udpateNewsJsonData(e){
                    var resultObject = new Object();
                    var resultArray = new Array();
                    var form = e.parentNode;
                    var newsSpan = form.getElementsByClassName("news");
                    for (var i = 0; i < newsSpan.length; i++) {
                        var object = new Object();
                        object.thumb_media_id = newsSpan[i]
                            .getElementsByClassName("thumb_media_id")[0].value;
                        object.author = newsSpan[i].getElementsByClassName("author")[0].value;
                        object.title = newsSpan[i].getElementsByClassName("title")[0].value;
                        object.content_source_url = newsSpan[i]
                            .getElementsByClassName("content_source_url")[0].value;
                        object.content = newsSpan[i].getElementsByClassName("content")[0].value;
                        object.digest = newsSpan[i].getElementsByClassName("digest")[0].value;
                        object.show_cover_pic = newsSpan[i]
                            .getElementsByClassName("show_cover_pic")[0].value;
                        resultArray.push(object);
                    }
                    
                    var introSpan = form.getElementsByClassName("intro")[0];
                    var title     = introSpan.getElementsByClassName("title")[0].value;
                    var introduction     = introSpan.getElementsByClassName("introduction")[0].value;
                    var media_id     = introSpan.getElementsByClassName("media_id")[0].value;
                    var index     = introSpan.getElementsByClassName("index")[0].value;
                    
                    resultObject.title = title;
                    resultObject.introduction = introduction; 
                    resultObject.media_id = media_id; 
                    resultObject.index = index;
                    resultObject.articles = getArray(e);
                    
                    var ajax = getAjax();
                    var url = "material/updateArticle";


                    $.ajax({
                        type: 'post',
                        url: url,
                        //请求是key/value这里不需要指定contentType，因为默认就 是key/value类型
                        contentType: 'application/json;charset=utf-8',
                        //数据格式是json串，商品信息
                        data: JSON.stringify(resultObject),
                        success: function (data) { //返回json结果
                            alert("success");
                        }
                    });
                }
            </script>
            <script>
                /* 添加永久图文素材 */
                function newsJsonData(e) {
                    var resultObject = new Object();
                    var resultArray = new Array();
                    var form = e.parentNode;
                    var newsSpan = form.getElementsByClassName("news");
                    for (var i = 0; i < newsSpan.length; i++) {
                        var object = new Object();
                        object.thumb_media_id = newsSpan[i]
                            .getElementsByClassName("thumb_media_id")[0].value;
                        object.author = newsSpan[i].getElementsByClassName("author")[0].value;
                        object.title = newsSpan[i].getElementsByClassName("title")[0].value;
                        object.content_source_url = newsSpan[i]
                            .getElementsByClassName("content_source_url")[0].value;
                        object.content = newsSpan[i].getElementsByClassName("content")[0].value;
                        object.digest = newsSpan[i].getElementsByClassName("digest")[0].value;
                        object.show_cover_pic = newsSpan[i]
                            .getElementsByClassName("show_cover_pic")[0].value;
                        resultArray.push(object);
                    }
                    
                    var introSpan = form.getElementsByClassName("intro")[0];
                    var title     = introSpan.getElementsByClassName("title")[0].value;
                    var introduction     = introSpan.getElementsByClassName("introduction")[0].value;
                    var article_count     = introSpan.getElementsByClassName("article_count")[0].value;
                    
                    resultObject.title = title;
                    resultObject.introduction = introduction;
                    resultObject.article_count = parseInt(article_count); 
                    resultObject.articles = getArray(e);
                    var ajax = getAjax();
                    var url = "material/addNews";


                    $.ajax({
                        type: 'post',
                        url: url,
                        //请求是key/value这里不需要指定contentType，因为默认就 是key/value类型
                        contentType: 'application/json;charset=utf-8',
                        //数据格式是json串，商品信息
                        data: JSON.stringify(resultObject),
                        success: function (data) { //返回json结果
                            alert("success");
                        }

                    });
                }
                
                function getArray(e){
                    var form = e.parentNode;
                    var newsSpan = form.getElementsByClassName("news");
                    var resultArray = new Array();
                    for (var i = 0; i < newsSpan.length; i++) {
                        var object = new Object();
                        object.thumb_media_id = newsSpan[i]
                            .getElementsByClassName("thumb_media_id")[0].value;
                        object.author = newsSpan[i].getElementsByClassName("author")[0].value;
                        object.title = newsSpan[i].getElementsByClassName("title")[0].value;
                        object.content_source_url = newsSpan[i]
                            .getElementsByClassName("content_source_url")[0].value;
                        object.content = newsSpan[i].getElementsByClassName("content")[0].value;
                        object.digest = newsSpan[i].getElementsByClassName("digest")[0].value;
                        object.show_cover_pic = newsSpan[i]
                            .getElementsByClassName("show_cover_pic")[0].value;
                        resultArray.push(object);
                    }
                    return resultArray;
                }
            </script>
            <script>
                var object = new Object();
                object.articles = [{
                    "author": "aaa",
                    "thumb_media_id" : "thumb_media_id",
                    "title" : "title",
                    "content_source_url" : "content_source_url",
                    "content" : "content",
                    "digest" : "digest",
                    "show_cover_pic" : "1"
                }, {
                    "author": "aaa",
                    "thumb_media_id" : "thumb_media_id",
                    "title" : "title",
                    "content_source_url" : "content_source_url",
                    "content" : "content",
                    "digest" : "digest",
                    "show_cover_pic" : "1"
                }];
                object.title = "title";
                object.introduction = "introduction";
                object.article_count = "2";
                alert(JSON.stringify.object);

                function testAjaxS() {
                        $.ajax({
                        type: 'post',
                        url: "material/addNews",
                        //请求是key/value这里不需要指定contentType，因为默认就 是key/value类型
                        contentType: 'application/json;charset=utf-8',
                        //数据格式是json串，商品信息
                        data: JSON.stringify(object),
                        success: function (data) { //返回json结果
                            alert("success");
                        }

                    });

                }
            </script>

        </body>

        </html>