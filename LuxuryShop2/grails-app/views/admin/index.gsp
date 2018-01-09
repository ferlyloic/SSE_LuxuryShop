<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${message(code: 'admin.label', default: 'Admin')}"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>

</head>

<body>
<h1>Guten Tag Admin</h1>


<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <ul>
            <g:each var="c" in="${grailsApplication.controllerClasses.sort { it.fullName }}">
                <li class="controller">
                    <g:link controller="${c.logicalPropertyName}">${c.fullName}</g:link>
                </li>
            </g:each>
        </ul>
    </ul>
</div>


</body>
</html>