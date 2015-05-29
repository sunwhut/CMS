<%@page language="java" contentType="text/html;charset=utf-8"%>
<%@page import="main.CmsNews2"%>
<%@page import="java.sql.ResultSet"%>

<%
String time = new String(request.getParameter("time").getBytes("ISO-8859-1"),"utf-8");
String kinds = new String(request.getParameter("kinds").getBytes("ISO-8859-1"),"utf-8");
String title = new String(request.getParameter("title").getBytes("ISO-8859-1"),"utf-8");
String content = new String(request.getParameter("content").getBytes("ISO-8859-1"),"utf-8");
%>

<%
CmsNews2 cms2 = new CmsNews2();
cms2.connectDB();
ResultSet rs = null;
cms2.insertNews(title, content, kinds, time);
%>
<p>添加新闻成功</p>