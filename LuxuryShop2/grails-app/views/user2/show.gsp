<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main" />
    <title>LS - Startseite</title>
</head>
<body>
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
            </ul>
        </div>

    </section>
</div>
</body>
</html>