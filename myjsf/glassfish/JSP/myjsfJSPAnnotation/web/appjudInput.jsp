<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>

<html>
  <body>
    <f:view>
       <h:outputText value="Informatii despre judete" styleClass="title" />
       <br>
       <h:form>
       <h:outputText value="Referinte despre judetul : " styleClass="heading" />
       <h:selectOneMenu  required="true" value="#{judBean.jud}">
          <f:selectItems value="#{countyBean.judete}" />        
       </h:selectOneMenu> 
       <p>
       <h:commandButton id="submit" value="Afiseaza" action="#{judBean.execute}" />
       </h:form>
    </f:view>
  </body>
</html>

