<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${message(code: 'kunde.label', default: 'Kunde')}"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>

</head>

<body>
<h1>Hallo ${params.name}</h1>
<a href="#list-kunde" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                            default="Skip to content&hellip;"/></a>


<div id="list-kunde" class="content scaffold-list" role="main">
    <h1><g:message code="default.list.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <f:table collection="${kundeList}"/>

    <div class="pagination">
        <g:paginate total="${kundeCount ?: 0}"/>
    </div>
</div>
</body>
</html>