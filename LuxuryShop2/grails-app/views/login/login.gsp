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

        <p>
            ...developed by 4 students from Hochschule Mannheim in order to sell and publish luxury items. Enjoy shopping!
        </p>

    </section>
    <g:form controller="login" action="login" style="padding-left:220px">
        <div style="width:220px">
            <label>Name:</label><input type="text" name="kundenname"/>
            <label>Password:</label><input type="password" name="password"/>
            <label>&nbsp;</label><input type="submit" value="Login"/>
        </div>
    </g:form>
    <g:if test="${flash.message}">
        <div class="message">
            ${flash.message}
        </div>
    </g:if>
</div>

</body>
</html>