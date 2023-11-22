<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h1>Index</h1>
		<form action="insert.mytbl" method = "post">
		<input type="text" placeholder="col1 추가할 정보" name="col1"> 
		<input type="text" placeholder="col2 추가할 정보" name="col2"> 
		<input type="text" placeholder="col3 추가할 정보" name="col3"> 
		<input type="submit" value="추가">
		</form>
		<form action="update.mytbl" method = "post">
		<input type="text" placeholder="col1 수정할 정보" name="col1"> 
		<input type="text" placeholder="col2 수정할 정보" name="col2"> 
		<input type="text" placeholder="col3 수정할 정보" name="col3"> 
		<input type="submit" value="수정">
		</form>
		<form action="delete.mytbl" method = "post">
		<input type="text" placeholder="col1 삭제할 정보" name="col1"> 
		<input type="text" placeholder="col2 삭제할 정보" name="col2"> 
		<input type="text" placeholder="col3 삭제할 정보" name="col3"> 
		<input type="submit" value="삭제">
		</form>
		<a href="select.mytbl"><button type="submit" >조회</button></a>
</body>
</html>