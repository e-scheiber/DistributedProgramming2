<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
  <head>
    <title>Guess the number</title>
  </head>
  <body>
    <h1> Ghici&#355;i num&#259;rul &#238;n <s:property value="%{maxIncercari}-1"/> &#238;ncerc&#259;ri</h1>
    <p/>
    Num&#259;rul <s:property value="#session.guess"/> a fost ghicit &#238;n 
      <s:property value="%{incercari-1}"/> &#238;ncerc&#259;ri !
    <br/>
    <a href="guess">&#206;nc&#259; o dat&#259;</a>   
  </body>
</html>