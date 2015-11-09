<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title><g:message code="user.title"/></title>
</head>

<body>
<h1><g:message code="user.title"/></h1>

<g:if test="${flash.message}">
    <div class="alert">${flash.message}</div>
</g:if>

<ul class="user-list">
    <g:each in="${users}" var="user">
        <li><a class="user-name" href="show/${user.id}">${user.name}</a> <span class="user-lang">(${user.locale})</span> :
            <g:if test="${user.reports == null || user.reports.isEmpty()}">
                <span class="user-message">No report for this user.</span>
            </g:if>
            <g:else>
                <span class="user-message">${user.reports.size()} report(s)</span>
            </g:else>
        </li>
    </g:each>
</ul>

</body>
</html>