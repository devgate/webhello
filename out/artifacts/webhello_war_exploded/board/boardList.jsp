<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>
<%@ page import="myboard.entity.Board" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<title></title>
</head>
<body>
<form action="/board/add" method="POST" id="boardForm" name="boardForm">
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
    out.write("<td>"+board.getId()+"</td>\n");
    %>
</tr>
<%
    }
%>
<tr>
    <td>id</td>
    <td><input type="input" id="title" name="title" value=""></td>
    <td><input type="input" id="writer" name="writer" value=""></td>
    <td><input type="input" id="pw" name="pw" value=""></td>
    <td></td>
</tr>
</table>
<input type="button" value="등록" onclick="goSaveForm()" />
</form>
</body>
<script type="text/javascript">

    function goSaveForm(){
        document.boardForm.submit();
    }

</script>

</html>