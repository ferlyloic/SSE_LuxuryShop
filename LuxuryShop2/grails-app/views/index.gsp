<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Welcome to Luxury Shop</title>
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
    <div>
        <br/>
    Login as : ${session.user} Available Controllers:| <g:link action="logout">Logout</g:link>
    </div>
</g:if>
<g:else>
    <g:form controller="user" action="login" style="padding-left:220px">
        <div style="width:220px">
            <label>Name:</label><input type="text" name="username"/>
            <label>Password:</label><input type="password" name="password"/>
            <label>&nbsp;</label><input type="submit" value="Login"/>
        </div>
    </g:form>
</g:else>

<div id="content" role="main">
    <section class="row colset-2-its">
        <h1>Welcome to the famous Luxury Shop</h1>

        <p>
            ...developed by 4 students from Hochschule Mannheim in order to sell and publish luxury items. Enjoy shopping!
        </p>

        <div id="controllers" role="navigation">
            <h2>Available Controllers:</h2>
            <ul>
                <g:each var="c" in="${grailsApplication.controllerClasses.sort { it.fullName }}">
                    <li class="controller">
                        <g:link controller="${c.logicalPropertyName}">${c.fullName}</g:link>
                    </li>
                </g:each>
                <li class>
                    <button>Aktionen</button><input type="submit" value="Login"/>
                </li>
            </ul>
        </div>

    </section>
</div>

</body>
</html>
