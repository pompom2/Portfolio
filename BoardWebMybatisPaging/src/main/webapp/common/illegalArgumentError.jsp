<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>IllegalArgumentException</title>
<style>
.container { width: 300px; margin: 0 auto;}
table { width: 100%; border: 1px solid #000;}
tr { width: 120px;}
th, td { border: 1px solid #000;}
</style>
</head>
<body>

<div class="container">
	<table>
		<tr>
			<th>${exception.message }</th>
		</tr>
	</table>
</div>

</body>
</html>