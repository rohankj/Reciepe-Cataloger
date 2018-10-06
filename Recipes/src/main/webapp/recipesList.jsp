<%@page import="java.util.Map"%>
<%@page import="java.util.Map.Entry"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%
Map<String, String> recipes = (Map<String, String>) session.getAttribute("recipesList");
if(recipes != null && recipes.size() > 0) {
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <title>Recipes</title>
</head>
<body>
 <div class="panel">
 <h2>Recipe Index</h2>
 <table class="bordered_table">
 <thead>
      <tr align="center"><th></th><th></th><th></th><th></th></tr>
 </thead>
 <tbody>
<%
for(Entry<String, String> est : recipes.entrySet()) {
%>
<tr>
    <td align="center"><span id="rname"><%=est.getKey() %> </span></td>
    <td align="center"><span id=rtext><textarea name="area" ROWS="5" COLS="65" ><%=est.getValue() %></textarea> </span></td>
   
    <td><form action="downloadFileServlet"  method="post" > <input type="submit" value="Download" name="Download"><input type="hidden" name="fileName" value="<%=est.getKey()%>" /></form> </td>
    <td><form action="recipeServlet"  method="post" > <input type="submit" value="Delete" name="Delete"><input type="hidden" name="delete" value="<%=est.getKey()%>" /></form> </td>
</tr>
<%
}
%>
</tbody>
</table>
</div>
</body>
</html>
<% } %>
 

