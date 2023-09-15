<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>USER DETAILS</title>
</head>
<body>

<h1>Registered User's Entry Date</h1>

<%@page import="java.sql.*" %>

<table border="1">
<tr>

<th>Entry Date</th>


</tr>



<%

Class.forName("com.mysql.cj.jdbc.Driver");
Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/project1","root","root");

String str="select entry from user";
Statement st=conn.createStatement();

ResultSet rs=st.executeQuery(str);

%>


<%while(rs.next()){%>
<tr>


<td><%	out.println(rs.getString(1));}%></td>



</tr>
</table>
<br>

<br>




</body>
</html>