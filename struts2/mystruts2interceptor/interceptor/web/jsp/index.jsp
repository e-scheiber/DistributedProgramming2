<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
  <head>
    <title>Guess the number</title>
  </head>
  <body>
    <h1> Ghici&#355;i num&#259;rul &#238;n 3 &#238;ncerc&#259;ri</h1>
   <p/> 
     <s:if test="#session.incercari!=null">
        &#206;ncercarea <s:property value="#session.incercari"/>
     </s:if>     
     <s:else>  
       &#206;ncercarea 1
     </s:else>    
    <p>
    <s:form action="guess">
      <s:textfield name="numar" label="Alegerea mea" />
      <br/>
      <!--
      <s:if test="%{incercari > 0}">
			  <s:hidden name="incercari" value="%{incercari}"></s:hidden>
      </s:if>
      -->
      <s:submit value="Verifica numarul"/>  
    </s:form>   
    <p/>
    <s:if test="#session.incercari>1">
       Ghici&#355;i num&#259;rul (<s:property value="#session.guess"/>)
    </s:if>   
  </body>
</html>