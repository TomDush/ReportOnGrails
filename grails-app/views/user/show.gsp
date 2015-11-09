<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title><g:message code="user.title"/></title>
</head>

<body>
<h1><g:message code="user.title"/>: ${user.name}</h1>

<ul class="report-list">
    <g:each in="${user.reports}" var="report">
        <li class="report"><span class="report-name">${report.reportName}</span></li>
    </g:each>
</ul>

</body>
</html>