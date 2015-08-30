<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>


</head>

<body>
    <h1>创建分组</h1>
    <form action="group/create" method="POST">
        name:<input name="name" type="text">
        <input type="submit" value="提交">
    </form>
    <h1>删除分组</h1>
    <form action="group/delete" method="POST">
        name:<input name="id" type="text">
        <input type="submit" value="提交">
    </form>
    <h1>查询所有分组</h1>
    <form action="group/get" method="POST">
        <input type="submit" value="提交">
    </form>
    <h1>查询用户所在分组</h1>
    <form action="group/getUserGroupId" method="POST">
        groupid:<input name="openid" type="text">
        <input type="submit" value="提交">
    </form>
    <h1>获取用户列表</h1>
    <form action="group/getList" method="GET">
        next_openid:<input name="next_openid" type="text">
        <input type="submit" value="提交">
    </form>
</body>
</html>
