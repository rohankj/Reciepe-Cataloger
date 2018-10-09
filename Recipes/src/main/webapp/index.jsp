
<style>
#myHeader {
    background-color: powderblue;
    color: black;
    padding: 5px;
    text-align: center;
} 

body {background-color: powderblue;}
h2   {color: black; text-align: center;}
p    {color: black; font-family: courier;font-size: 100%;}
span {  padding:8px;}
.content {
    max-width: 900px;
    margin: auto;
}
</style>
<html>
<body>
<div class="content">
<h2 id="myHeader">Recipe Catalog</h2>
<p>The purpose of the application is to catalog your recipes. You can add a recipe, delete or download. </p>
<div >
<jsp:directive.include file="submitrecipe.jsp"/>
</div>
</div>
</body>
</html>
