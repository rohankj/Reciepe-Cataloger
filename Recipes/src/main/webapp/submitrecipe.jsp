<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
	<head>
	    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	    <title>Submit Recipe</title>
	    <script type="text/javascript" src="/js/jquery-3.3.1.min.js"></script>
</head>
<body>
<form action="recipeServlet"  method="post" >
  <span >Recipe name:</span>
<input type="text" name="recipename" ><br>
  <span >Description:</span><br>
<textarea name="area" ROWS="8" COLS="100" ></textarea><br><br>
<input type="submit" value="Submit">
</form>
<div class="panel">
  <jsp:directive.include file="recipesList.jsp"/>
</div>         
</body>
</html>

