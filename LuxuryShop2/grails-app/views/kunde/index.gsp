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

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <ul>
            <g:each var="c" in="${grailsApplication.controllerClasses.sort { it.fullName }}">
                <li class="controller">
               <g:link controller="${c.logicalPropertyName}">${c.fullName}</g:link>
              <!--  <g:if test="${c.fullName?.luxuryshop2.BankController}">
                    <g:link controller="${c.logicalPropertyName}">Meine Bank</g:link>
                </g:if>-->
                </li>
            </g:each>
        </ul>
        <li><g:link class="create" action="create"><g:message code="default.new.label"
                                                              args="[entityName]"/></g:link></li>
    </ul>
</div>

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