<html>
    <head>
        <title>Upload</title>
    </head>
    <h2>Con&#355;inutul fi&#351;ierului: </h2>
    <body>
     <%
       String  files=(String)session.getAttribute("files");
       out.println(files);
     %>  
    </body>
</html>