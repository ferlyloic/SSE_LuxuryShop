<%--
  Created by IntelliJ IDEA.
  User: jacquelinefranssen
  Date: 05.01.18
  Time: 17:08
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main" />
    <g:set var="entityName" value="${message(code: 'bank.label', default: 'Kunden')}" />
    <title><g:message code="default.list.label" args="[entityName]" /></title>
</head>
<body>
<a href="#list-bank" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>

<div id="list-bank" class="content scaffold-list" role="main">
    <h1><g:message code="default.list.label" args="[entityName]" /></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <f:table collection="${bankList}" />

    <div class="pagination">
        <g:paginate total="${bankCount ?: 0}" />
    </div>
</div>
</body>
</html>