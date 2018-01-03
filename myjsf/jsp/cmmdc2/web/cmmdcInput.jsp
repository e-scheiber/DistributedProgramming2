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
          <h:inputText id="m" value="#{cmmdcController.cmmdcBean.m}" required="true"
             binding="#{cmmdcController.primulNumar}" />
          <h:message for="m" />
          <h:outputText value="Al doilea numar este" />
          <h:inputText id="n" value="#{cmmdcController.cmmdcBean.n}" required="true" 
             binding="#{cmmdcController.alDoileaNumar}"  />
          <h:message for="n" />
          <h:commandButton id="submit" value="Calculeaza" 
             action="#{cmmdcController.cmmdc}"/>
        </h:panelGrid>  
      </h:form>
    </f:view>.
  </body>
</html>

