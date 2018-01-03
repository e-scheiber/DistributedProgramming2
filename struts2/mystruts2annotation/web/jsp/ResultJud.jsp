<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  <head>
    <title>Referite Judet</title>
  </head>
  <body>
    <h2>Referintele despre judetul </h2>
    <s:property value="jud"/>
    <p/>
    Capitala:
    <s:property value="capit"/>
    <p/>
    Abrevierea:
    <s:property value="abrev"/>
  </body>
</html>