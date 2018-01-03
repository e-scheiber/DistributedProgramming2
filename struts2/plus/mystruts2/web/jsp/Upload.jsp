<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  <head><title>Upload</title>     
  </head>
  <body>
    <h3> Incarcarea unui fisier text(upload) </h3>
    
    <s:form action="doUpload.action"
       method="post" enctype="multipart/form-data">
        <s:file name="myFile" label="File"/>
        <s:submit/>
    </s:form> 
     
  </body>
</html>