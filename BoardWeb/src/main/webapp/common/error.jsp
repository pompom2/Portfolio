<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error</title>
<style>
.container { width: 300px; margin: 0 auto;}
table { width: 100%; border: 1px solid #000;}
tr {}
th, td { width: 100%; border: 1px solid #000; padding: 50px;}
th { background: #e9ecef;}
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