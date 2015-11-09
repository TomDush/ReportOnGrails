<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title><g:message code="user.title"/></title>
</head>

<body>
<div class="breadcrumbs">
    <a class="small-link">Users list</a> > User details
</div>

<h1>${user.name}</h1>

<ul class="report-list">
    <g:each in="${user.reports}" var="report">
        <li class="report"><span class="report-name">${report.reportName}</span></li>
    </g:each>
</ul>

</body>
</html>