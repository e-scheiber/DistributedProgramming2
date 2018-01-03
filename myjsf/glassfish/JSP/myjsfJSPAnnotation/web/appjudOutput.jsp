<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<html>
<body>
<f:view>
 <h:outputText value="Referintele despre judetul " />
 <h:outputText value="#{judBean.jud}" />
 <p>
 <h:outputText value="Capitala : " />
 <h:outputText value="#{judBean.capit}" />
 <p>
 <h:outputText value="Abrevierea : " />
 <h:outputText value="#{judBean.abrev}" />
</f:view>
</body>
</html>
