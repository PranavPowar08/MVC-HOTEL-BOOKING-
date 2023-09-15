<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>USER DETAILS</title>
</head>
<body>

<h1>Registered User's</h1>

<%@page import="java.sql.*" %>

<table border="1">
<tr>
<th>Name</th>
<th>Email</th>
<th>Mobile No.</th>
<th>Room NO</th>
<th>Entry Date</th>
<th>STAYING DAYS </th>

</tr>



<%

Class.forName("com.mysql.cj.jdbc.Driver");
Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/project1","root","root");

String str="select * from user";
Statement st=conn.createStatement();

ResultSet rs=st.executeQuery(str);%>


<%while (rs.next()){%>
<tr>

<td><%	out.println(rs.getString(1));%></td>

<td><%	out.println(rs.getString(2));%></td>

<td><%	out.println(rs.getLong(3));%></td>

<td><%	out.println(rs.getInt(4));%></td>

<td><%	out.println(rs.getString(5));%></td>



<td><%	out.println(rs.getInt(6));
}

%></td>

</tr>
</table>

<br>

<b><a href="index.html">NEW ENTRY</a></b>


</body>
</html>