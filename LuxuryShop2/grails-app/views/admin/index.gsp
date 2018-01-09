<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${message(code: 'admin.label', default: 'Admin')}"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>

</head>

<body>
<h1>Guten Tag Admin</h1>
<div id="list-admin" class="content scaffold-list" role="main">
    <h1><g:message code="default.list.label" args="[entityName]" /></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <f:table collection="${adminList}" />

    <div class="pagination">
        <g:paginate total="${adminCount ?: 0}" />
    </div>
</div>


</body>
</html>