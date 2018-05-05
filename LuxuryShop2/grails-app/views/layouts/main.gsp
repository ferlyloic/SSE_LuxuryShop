<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>
        <g:layoutTitle default="Grails"/>
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <asset:link rel="icon" href="favicon.ico" type="image/x-ico" />

    <asset:stylesheet src="application.css"/>

    <g:layoutHead/>
</head>
<body>

    <div class="navbar navbar-default navbar-static-top" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="/#">
		    <asset:image src="grails.svg" alt="Grails Logo"/>
                </a>
            </div>
            <div class="navbar-collapse collapse" aria-expanded="false" style="height: 0.8px;">
                <ul class="nav navbar-nav navbar-right">
                    <g:pageProperty name="page.nav" />
                    <g:if test="${session.role}">
                        <li><g:link controller="login" action="logout">Logout</g:link></li>
                    </g:if>
                </ul>
            </div>
        </div>
    </div>
<g:if test="${session.role== "Kunde"}">
<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="create" controller="kunde" action="order">Bestellung ansehen</g:link></li>
        <li><g:link class="create" controller="kunde" action="newOrder">Bestellung machen</g:link></li>
        <li><g:link class="create" controller="kunde" action="payOrder">Bestellung bezahlen</g:link></li>
    </ul>
</div>
</g:if>
<g:if test="${session.role== "Admin"}">
    <div class="nav" role="navigation">
        <ul>
            <li><g:link class="home" controller="admin" action="dashboard">Home</g:link></li>
            <li><g:link class="list" controller="admin" action="index">Adminverwaltung</g:link></li>
            <li><g:link class="list" controller="admin" action="kundenverwaltung">Kundenverwaltung</g:link></li>
            <li><g:link class="list" controller="admin" action="bestellungsverwalung">Bestellungsverwaltung</g:link></li>
            <li><g:link class="list" controller="admin" action="produktverwaltung">Produktverwaltung</g:link></li>
        </ul>
    </div>
</g:if>

    <g:layoutBody/>

    <div class="footer" role="contentinfo"></div>

    <div id="spinner" class="spinner" style="display:none;">
        <g:message code="spinner.alt" default="Loading&hellip;"/>
    </div>

    <asset:javascript src="application.js"/>

</body>
</html>
