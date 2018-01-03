<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  <head><title>Download</title>     
  </head>
  <body>
    <h3> Descarcarea unui fisier (download) </h3>
   
    <s:form action="doDownload.action">
       <s:select name="file" label="Alege" list="{'capitol.txt','xml-pic.jpg','TomJones.mp3','clock.avi'}" />
       <s:submit value="Descarca"/>
    </s:form> 
  </body>
</html>