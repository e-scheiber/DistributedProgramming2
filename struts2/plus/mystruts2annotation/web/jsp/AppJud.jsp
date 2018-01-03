<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  <head>
    <title>Referinte Judet</title>
  </head>
  <body>
    <h1> Referinte despre judete </h1>
    <p/>
    <s:form action="/mystruts2-anapp/judbean">
      <s:select name="selectat" label="Judete" 
				list="judeteList" listKey="%{jud}" listValue="%{jud}"/>
      <s:submit/>
    </s:form>
  </body>
</html>
