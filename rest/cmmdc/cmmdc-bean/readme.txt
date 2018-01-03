apache-tomcat-8-5.4 !!!


1. 
Dupa caz, pentru clientul Jersey, se creaza cataloagele
 lib, libJackson, libMoxy, libJettison
2.
Catalogul web/WEB-INF/lib (lib | libJackson | libMoxy | libJettison)
se completeaza cu TOATE fisierele distributiei jaxrs-ri (jersey).
3.
Dupa caz atat web/WEB-INF/lib cat si (libJackson | libMoxy | libJettison)
se completeaza cu continutul catalogului lib-bean-rest-jackson,
lib-bean-rest-moxy, respectiv lib-bean-rest-jettison.
