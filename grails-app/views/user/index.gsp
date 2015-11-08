<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title><g:message code="user.title"/></title>
</head>

<body>
<h1><g:message code="user.title"/></h1>
<ul>
    <g:each in="${users}" var="user">
        <li>
            ${user.name}
        </li>
    </g:each>
</ul>

</body>
</html>