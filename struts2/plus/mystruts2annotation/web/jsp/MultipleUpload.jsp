<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  <head><title>Upload</title>     
  </head>
  <body>
    <h3> Incarcarea unui fisier (upload) </h3>
    
    <s:form action="mupload"
       method="post" enctype="multipart/form-data">
        <s:file name="myFile" label="Primul fisier"/>
        <s:file name="myFile" label="Al doilea fisier"/>
        <s:submit/>
    </s:form> 
     
  </body>
</html>