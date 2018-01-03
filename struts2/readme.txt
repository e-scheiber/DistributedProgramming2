Functioneaza doar in jdk1.8.0_*


1.  
Struts 2.5:
Fisierele jar din DISTRrepo lib-struts
se copiaza in catalogul web/WEB-INF/lib.

Struts 2.3:
Fisierele jar din 
STRUTS2_HOME/apps/struts2-blank.war/WEB-INF/lib 
se copiaza in catalogul web/WEB-INF/lib.

2. Pentru aplicatiile cu adnotari este nevoie si de fisierul 
struts2-convention-plugin-*.jar din STRUTS2_HOME\lib

3. Fisierul judete.txt se copiaza in cataloagele:
mystruts2, mystruts2annotation, plus/mystruts2, plus/mystruts2annotation

4. Fisierul log4j2.xml se copiaza in catalogul aplicatiei daca nu
este mentionat in build.xml.
