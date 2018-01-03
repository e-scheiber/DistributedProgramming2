<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<html>
  <body>
    <h1> Calculul Cmmdc </h1>
    <f:view>
      <p>      
      <h:form >
        <h:panelGrid columns="3">
          <h:outputText value="Primul numar este" />
          <h:inputText id="m" value="#{cb.sm}" required="true"
             validator="#{cb.validateString}" />
          <h:message for="m" />
          <h:outputText value="Al doilea numar este" />
          <h:inputText id="n" value="#{cb.sn}" required="true" 
             validator="#{cb.validateString}" />
          <h:message for="n" />
          <h:commandButton id="submit" value="Calculeaza" action="#{cb.compute}"/>
        </h:panelGrid>  
      </h:form>
    </f:view>.
  </body>
</html>

