<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>素材管理</title>
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/bootstrap-theme.min.css" rel="stylesheet">
    <link href="../css/global.css" rel="stylesheet">
    <link href="../css/common.css" rel="stylesheet">
</head>

<body>
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">Brand</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">素材管理 <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li class="active"><a href="#">获取素材总数</a>
                            </li>
                            <li><a href="#">修改图文素材</a>
                            </li>
                            <li><a href="#">删除指定素材</a>
                            </li>
                            <li role="separator" class="divider"></li>
                            <li><a href="#">新增永久素材</a>
                            </li>
                            <li role="separator" class="divider"></li>
                            <li><a href="#">新增图文素材</a>
                            </li>
                            <li><a href="#">获取永久素材列表</a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>
    <button onclick="getAccessToken()">获取AccessToken</button>


    <div class="container">
        <button class="btn btn-primary btn-lg" onclick="getMaterialCount()">获取素材总数</button>
        <p></p>
        <div class="table-responsive">
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>音频</th>
                        <th>视频</th>
                        <th>图片</th>
                        <th>图文</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td id="voice_count"></td>
                        <td id="video_count"></td>
                        <td id="image_count"></td>
                        <td id="news_count"></td>
                    </tr>
                </tbody>

            </table>
        </div>
    </div>
    <div class="container">
        <button class="btn btn-primary btn-lg">批量获取素材</button>
        <p></p>
        <div class="form-inline" action="">
            <div class="form-group">
                <label for="type">类型</label>
                <input type="text" class="form-control" id="type" name="type" placeholder="想要查询永久素材的类型..">
            </div>
            <div class="form-group">
                <label for="offset">开始位置</label>
                <input type="text" class="form-control" id="offset" name="offset" placeholder="0表示从第一个素材返回 ">
            </div>
            <div class="form-group">
                <label for="count">返回素材的数量</label>
                <input type="text" class="form-control" id="count" name="count" placeholder="返回素材的数量，取值在1到20之间">
            </div>
            <button type="submit" class="btn btn-default" onclick="batchGetMaterial()">批量获取素材</button>
        </div>
        <p></p>
        <div class="table-responsive">
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>素材总数</th>
                        <th>显示个数</th>
                    </tr>
                    <tr>
                        <th id="total_count">1</th>
                        <th id="item_count">1</th>
                    </tr>
                    <tr>
                        <th>标题</th>
                        <th>封面图片素材media_id</th>
                        <th>是否显示封面(0/1)</th>
                        <th>作战</th>
                        <th>图文消息摘要</th>
                        <th>内容</th>
                        <th>URL</th>
                        <th>原文地址(跳转地址)</th>
                        <th>最后更新时间</th>
                        <th>文件名称</th>
                    </tr>
                </thead>
                <tbody>
                    <tr class="material_tr">
                        <td class="title"></td>
                        <td class="thumb_media_id"></td>
                        <td class="show_cover_pic"></td>
                        <td class="author"></td>
                        <td class="digest"></td>
                        <td class="content"></td>
                        <td class="url"></td>
                        <td class="content_source_url "></td>
                        <td class="update_time"></td>
                        <td class="name "></td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
    <script src="../js/jquery-1.11.2.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    <script src="../js/util.js"></script>
    <script src="../js/MaterialCount.js"></script>
</body>

</html>