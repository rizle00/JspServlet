<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>여기는 HelloJspServlet Kmj</h3>
	 
	 <table border = "1">
	 <tr>
	 	<td>get방식</td>
	 	<td>
	 		<form action="Ex03" method = "post">
	 		<input type="text" name = "id" />
	 		<input type="text" name = "pw" />
	 		<input type="submit" value = "전송"/>
	 		</form>
	 	</td>
	 	<!-- <td><input type = text><input type = "submit"  value = "전송"> </td> -->
	 </tr>
	 	<tr>
	 	<td>post방식</td>
	 	<td>
	 		<form action = "Ex03" method="post">
	 		<input type="text" name = "param1"/> <!-- 폼마다의 name 임 -->
	 		<input type="submit" value = "전송"/>
	 		</form>
	 	</td>
	 </tr>
	 </table>
	 
</body>
</html>