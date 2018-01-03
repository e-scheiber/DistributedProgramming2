<html>
     <body>
     <form method="post">
         <table>
           <tr>
             <td>Primul numar este </td>
             <td><input type="text" name="m" size=5 value="1"> </td>
           </tr>
           <tr>
             <td>Al doilea numar este </td>
             <td><input type="text" name="n" size=5 value="1"> </td>
           </tr>
           <tr>
             <td><input type="submit" value="Calculeaza"></td>
             <td/>
           </tr>
         </table>
     </form>

     <%
     try {
       cmmdc.client.CmmdcWSService service=new cmmdc.client.CmmdcWSService();
       cmmdc.client.CmmdcWS port=service.getCmmdcWSPort();
       String sm = request.getParameter("m");
       String sn = request.getParameter("n");
       long m=((sm==null)||("".equals(sm)))?1:Long.parseLong(sm);
       long n=((sn==null)||("".equals(sn)))?1:Long.parseLong(sn);
       long rez=port.cmmdc(m,n);
       String result=Long.valueOf(rez).toString();
       out.println("Result = "+result);
     }
     catch (Exception e) {
       out.println("Exception : "+e.getMessage());
     }
     %>
     <hr/>
     </body>
</html>
