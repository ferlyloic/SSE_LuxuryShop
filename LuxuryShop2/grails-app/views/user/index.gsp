<%--
  Created by IntelliJ IDEA.
  User: jacquelinefranssen
  Date: 06.01.18
  Time: 12:08
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name = "layout" content = "main"/>
    <title></title>
    <style type = "text/css">
        label{
            float: left;
            width: 65px;
        }
    </style>
</head>

<body>
<g:if test="${flash.message}">
    <div class="message">
        ${flash.message}
    </div>
</g:if>

${flash.message}
<g:if test="${session.user}">
    <br/>
    Login as : ${session.user} | <g:link action="logout">Logout</g:link>
</g:if>
<g:else>

    <g:form controller = "user" action="login" style="padding-left:220px">
        <div style = "width:220px">
        <label>Name:</label><input type="text" name="username"/>
        <label>Password:</label><input type="password" name="password"/>
        <label>&nbsp;</label><input type="submit" value="Login"/>
        </div>

    </g:form>
</g:else>


</body>
</html>
