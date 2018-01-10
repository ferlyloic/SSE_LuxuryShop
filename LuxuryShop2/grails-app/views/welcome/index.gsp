<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Test</title>
</head>
<body>
<div id="content" role="main">
    <section class="row colset-2-its">
        <h1>Welcome to the famous Luxury Shop</h1>

        <h1>
            ...please wait while Programm is starting...
        </h1>
    </section>
        <img src="/assets/images/load.gif" alt="please wait">
        <img src="/assets/grails.svg" alt="please wait">



    <g:if test="${flash.message}">
        <div class="message">
            ${flash.message}
        </div>
    </g:if>
</div>

</body>
</html>