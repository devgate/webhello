<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>
<%@ page import="myboard.entity.Board" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>
  </head>
  <body>
  <table border="1">
    <tr>
        <td>id</td>
        <td>title</td>
        <td>writer</td>
        <td>pw</td>
    </tr>
  <%
    List<Board> boards = (List<Board>) request.getAttribute("boards");

    for (Board board : boards) {
  %>
    <tr>
  <%
   out.write("<td>"+board.getId()+"</td>\n");
   out.write("<td>"+board.getTitle()+"</td>\n");
   out.write("<td>"+board.getWriter()+"</td>\n");
   out.write("<td>"+board.getPw()+"</td>\n");
  %>
    </tr>
  <%
      }


  %>
   </table>

   <input type="button" value="등록" onclick="goSaveForm()" />
  </body>
</html>