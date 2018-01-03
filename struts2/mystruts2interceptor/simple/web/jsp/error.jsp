<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
  <head>
    <title>Guess the number</title>
  </head>

  <body>
    <h1> Ghici&#355;i num&#259;rul &#238;n <s:property value="%{maxIncercari}-1"/> &#238;ncerc&#259;ri</h1>
    <p/>
    Ati dep&#259;&#351;it num&#259;rul de &#238;ncerc&#259;ri !
    </p>
    Num&#259;rul nu a fost ghicit!
    <br/>
    <a href="http://localhost:8080/guess">&#206;nc&#259; o dat&#259;</a>
  </body>
</html>