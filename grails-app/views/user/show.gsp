<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title><g:message code="user.title"/></title>
    <r:require modules="jquery"/>
</head>

<body>
<div class="breadcrumbs">
    <a class="small-link" href="../"><g:message code="user.title"/></a> > <g:message code="user.details.title"/>
</div>

<div class="refresh-btn">
    <a onclick="refreshUserReport(${user.id})" class="link"><g:message code="generic.refresh"/></a>
</div>

<h1 class="user-name">${user.name}</h1>

<div>
    <ul id="report-list" class="report-list">
        <!-- Content is generated with JS -->
    </ul>
</div>

<div id="generationInProgress"><g:message code="user.details.inProgress"/>: <span id="generationNumber">0</span></div>

<div class="generate-btn">
    <a onclick="generateNewReport(${user.id})" class="link add-report"><g:message code="report.generate"/></a>
</div>


<r:script>
// Manage generation counter
var generation = 0;
function updateGenerationCount(diff) {
    generation += diff;
    $('#generationNumber').text(generation);
    if(generation == 0){
        $('#generationInProgress').hide();
    } else {
        $('#generationInProgress').show();
    }
}

// Add a report in UL list
function addReportName(ul, reportName) {
    ul.append('<li class="report-name">' + reportName + '</li>');
}

// Refresh report name lists
function refreshUserReport(userId) {
    // Call updated
    $.ajax({
        url:"${g.createLink(controller: 'user', action: 'getReports')}",
        data: {id: userId},
        success: function(reports) {

            var ul = $('#report-list');
            // Remove all elements
            ul.empty();
            // Refill it...
            for (var i = 0; i < reports.length; i++) {
                var report = reports[i];
                addReportName(ul, report.name);
            }
        }
    })
}

function generateNewReport(userId) {
    // Increment generation count
    updateGenerationCount(1);

    // Request new report
    $.ajax({
        url:"${g.createLink(controller: 'user', action: 'addReport')}",
        data: {id: userId},
        success: function(report) {
            // Decrement generation count
            updateGenerationCount(-1);

            // Add new report name
            addReportName($('#report-list'), report.name);
        }
    });
}

// Initial loading
refreshUserReport(${user.id});
updateGenerationCount(0);
</r:script>
</body>
</html>