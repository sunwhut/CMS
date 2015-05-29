<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="main.CmsNews2"%>
<%@ page import="java.sql.*"%>

<%
	String column =request.getParameter("id");
	String name = null;
	if(column.equals("health")){
		name = "健康新闻"  ;
	}else if(column.equals("finance")){
		name = "财经新闻" ;
	}else if(column.equals("sports")){
		name = "体育新闻"  ;
	}else if(column.equals("military")){
		name = "军事新闻" ;
	}
%>

<head>
<title>新闻首页</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="default.css" rel="stylesheet" type="text/css" media="screen" />
</head>

<body>
<!-- start header -->
<div id="header">
	<h1>新闻首页</h1>
	<form name="search" method="get">
	<p>站内搜索<input type="text" name="keyword">
	<input type="submit" value="搜索"></p>
	</form>
</div>
<!-- end header -->
<!-- star menu -->
<div id="menu">
	<ul>
		<li class="current_page_item"><a href="index.html">首页</a></li>
		<li><a target="_blank" href="\test\column.jsp?id=health">健康</a></li>
		<li><a target="_blank" href="\test\column.jsp?id=finance">财经</a></li>
		<li><a target="_blank" href="\test\column.jsp?id=sports">体育</a></li>
		<li><a target="_blank" href="\test\column.jsp?id=military">军事</a></li>
	</ul>
</div>
<!-- end menu -->
<br>
<div  style="text-align:center">
<h1>
<p>
<% out.print(name);
%>
</p>
</h1>
</div>
<br>
<div  style="text-align:center">
<%
CmsNews2 cms2 = new CmsNews2();
cms2.connectDB();
ResultSet rs = null;
rs = cms2.selectColumn(column);
try {
	while(rs.next()){
		out.print("<p>");
		out.print("<a target=\"_blank\" ");
		out.print("href=\"");
		out.print("\\test\\news.jsp?id=");
		out.print(rs.getString("id"));
		out.print("\">");
		out.print(rs.getString("newsTitle"));
		out.print(" </a></p>");
	}
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
cms2.closeDB();
%>
</div>
</body>

<br><br><br><br><br>
<div  style="text-align:center">
<div id="footer">
	<p class="legal"> &copy;2014 Newsprint. All Rights Reserved.
		&nbsp;&nbsp;&bull;&nbsp;&nbsp;
		Design by ZY1101 魏睐组   <a href="#">意见反馈</a></p>
	<p class="links"> <a href="http://validator.w3.org/check/referer" class="xhtml" title="This page validates as XHTML">Valid <abbr title="eXtensible HyperText Markup Language">XHTML</abbr></a> &nbsp;&bull;&nbsp; <a href="http://jigsaw.w3.org/css-validator/check/referer" class="css" title="This page validates as CSS">Valid <abbr title="Cascading Style Sheets">CSS</abbr></a> </p>
</div>
</div>
<!-- end footer -->