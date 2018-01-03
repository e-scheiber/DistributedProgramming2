<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Calculul celui mai mare divizor comun a dou&#259; numere naturale</title>     
</head>
<body>

<h3> Introduce&#355;i </h3>

<s:form action="Cmmdc.action">
  <s:textfield label="Primul numar" name="m"/>
  <s:textfield label="Al doilea numar" name="n" />
  <s:submit value="Calculeaza"/>
</s:form>
</body>
</html>