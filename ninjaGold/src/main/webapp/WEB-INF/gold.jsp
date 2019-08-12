<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ninja Gold Game</title>
</head>
<body>
	<h1>Your Gold: <%= session.getAttribute("yourGold") %></h1>
	<table>		
		<tr>
			<td>
				<fieldset style="text-align: center;">
				<legend>Farm</legend>
				<br/><br/>
				<h3>(earns 10-20 gold)</h3><br/><br/>
				<form action="find" method="post">
					<button>Find Gold!</button>					
					<input type="hidden" name="location" value="farm">
				</form>
				</fieldset>
			</td>
			<td >
				<fieldset style="text-align:center;">
				<legend>Cave</legend>
				<br/><br/>
				<H3>(earns 5-10 gold)</H3><br/><br/>
				<form action="find" method="post">
					<button>Find Gold!</button>	
					<input type="hidden" name="location" value="cave">
				</form>
				</fieldset>
			</td>
			<td>
				<fieldset style="text-align:center;">
				<legend>House</legend>
				<br/><br/>
				<h3>(earns 2-5 gold)</h3><br/><br/>
				<form action="find" method="post">
					<button>Find Gold!</button>	
					<input type="hidden" name="location" value="house">
				</form>
				</fieldset>
			</td>
			<td>
				<fieldset style="text-align:center;">
				<legend>Casino</legend>
				<br/><br/>
				<h3>(win/lose 0-50 gold)</h3><br/><br/>
				<form action="find" method="post">
					<button>Find Gold!</button>	
					<input type="hidden" name="location" value="casino">
				</form>
				</fieldset>
			</td>
		</tr>
</table>	
	<p><c:out value="${foundGold}" /></p>		
</body>
</html>