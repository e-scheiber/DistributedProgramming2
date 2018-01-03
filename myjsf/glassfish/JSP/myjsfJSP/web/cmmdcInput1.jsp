<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<html>
<body>
  <h1> Calculul Cmmdc </h1>
  <f:view>
  <p>
     <h:messages  />

  <h:form id="myform">
    <h:panelGrid columns="2">
      <h:outputText value="Primul numar este" />
      <h:inputText id="sm" required="true" />  
      <h:outputText value="Al doilea numar este" />
      <h:inputText id="sn" required="true" />
      <h:commandButton value="Calculeaza" action="#{cb1.compute}" />
    </h:panelGrid>
  </h:form>
  </f:view>
</body>
</html>

