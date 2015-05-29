<%@ page contentType="text/html; charset=utf-8"%>
<%@page import="main.CmsNews2"%>
<%@page import="java.sql.*"%>

<%
	String id =request.getParameter("id");
%>

<%
CmsNews2 cms2 = new CmsNews2();
cms2.connectDB();
ResultSet rs = null;
rs = cms2.selectDB(id);
try {
	rs.next();
	out.print("<head><title>");
	out.print(rs.getString("newsTitle"));
	out.print("</title></head>");
	out.print("<br>");
	out.print("<body>");
	out.print("<div  style=\"text-align:center\">");
	out.print("<h2>");
	out.print(rs.getString("newsTitle"));
	out.print("</h2>");
	out.print("</div>");
	out.print("<br>");
	out.print("<div  style=\"text-align:center\">");
	out.print(""+rs.getString("newsTime")+"&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp"+rs.getString("newsAuthorName"));
	out.print("</div>");
	out.print("<p>");
	out.print(rs.getString("newsContent"));
	out.print("</p>");
	out.print("<body>");
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
cms2.closeDB();
%>
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

