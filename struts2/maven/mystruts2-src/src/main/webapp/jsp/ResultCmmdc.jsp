<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
    <head>
        <title>Cmmdc</title>
    </head>
    <h2>Cmmdc: </h2>
    <body>
    <!-- 
        <s:property value="message" />
     
     <%
       String  rez=(String)session.getAttribute("cmmdc");
       out.println(rez);
     %>  
     -->
     <s:property value="#session.cmmdc"/>
    </body>
</html>