<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title><g:message code="user.title"/></title>
</head>

<body>
<h1><g:message code="user.title"/></h1>

<ul class="user-list">
    <g:each in="${users}" var="user">
        <li><span class="user-name">${user.name}</span> :
            <g:if test="${user.reports == null || user.reports.isEmpty()}">
                <span class="user-message">No report for this user.</span>
            </g:if>
            <ul class="report-list">
                <g:each in="${user.reports}" var="report">
                    <li class="report"><span class="report-name">${report.reportName}</span></li>
                </g:each>
            </ul>
        </li>
    </g:each>
</ul>

</body>
</html>