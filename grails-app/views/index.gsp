<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Welcome to Grails</title>
    <style type="text/css" media="screen">
    #status {
        background-color: #eee;
        border: .2em solid #fff;
        margin: 2em 2em 1em;
        padding: 1em;
        width: 12em;
        float: left;
        -moz-box-shadow: 0px 0px 1.25em #ccc;
        -webkit-box-shadow: 0px 0px 1.25em #ccc;
        box-shadow: 0px 0px 1.25em #ccc;
        -moz-border-radius: 0.6em;
        -webkit-border-radius: 0.6em;
        border-radius: 0.6em;
    }

    .ie6 #status {
        display: inline; /* float double margin fix http://www.positioniseverything.net/explorer/doubled-margin.html */
    }

    #status ul {
        font-size: 0.9em;
        list-style-type: none;
        margin-bottom: 0.6em;
        padding: 0;
    }

    #status li {
        line-height: 1.3;
    }

    #status h1 {
        text-transform: uppercase;
        font-size: 1.1em;
        margin: 0 0 0.3em;
    }

    #page-body {
        margin: 2em 1em 1.25em 18em;
    }

    h2 {
        margin-top: 1em;
        margin-bottom: 0.3em;
        font-size: 1em;
    }

    p {
        line-height: 1.5;
        margin: 0.25em 0;
    }

    #controller-list ul {
        list-style-position: inside;
    }

    #controller-list li {
        line-height: 1.3;
        list-style-position: inside;
        margin: 0.25em 0;
    }

    @media screen and (max-width: 480px) {
        #status {
            display: none;
        }

        #page-body {
            margin: 0 1em 1em;
        }

        #page-body h1 {
            margin-top: 0;
        }
    }
        div{
            margin-bottom: 10px;
        }
        li{
            margin-left:20px;
            margin-bottom: 5px;
        }
    </style>
</head>

<body>
<a href="#page-body" class="skip"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>

<div id="status" role="complementary">
    <h1>Application Status</h1>
    <ul>
        <li>App version: <g:meta name="app.version"/></li>
        <li>Grails version: <g:meta name="app.grails.version"/></li>
        <li>Groovy version: ${GroovySystem.getVersion()}</li>
        <li>JVM version: ${System.getProperty('java.version')}</li>
        <li>Reloading active: ${grails.util.Environment.reloadingAgentEnabled}</li>
        <li>Controllers: ${grailsApplication.controllerClasses.size()}</li>
        <li>Domains: ${grailsApplication.domainClasses.size()}</li>
        <li>Services: ${grailsApplication.serviceClasses.size()}</li>
        <li>Tag Libraries: ${grailsApplication.tagLibClasses.size()}</li>
    </ul>

    <h1>Installed Plugins</h1>
    <ul>
        <g:each var="plugin" in="${applicationContext.getBean('pluginManager').allPlugins}">
            <li>${plugin.name} - ${plugin.version}</li>
        </g:each>
    </ul>
</div>

<div id="page-body" role="main">
    <h1>Welcome to the Validis Coding Exercise</h1>

    <div>
        The following tasks need to be performed:
    </div>

    <ul>
        <li>Create a User entity with name, locale and a list of Reports as attributes.</li>
        <li>The Report is also an entity with the report name as it attribute.</li>
    </ul>
    <br>
    <div>
        To start you off the above has already been completed. The following still needs to be done:
    </div>

    <ul>
        <li>The report name must be in the format 'report_${report_number}' where report number is an incremental number starting at 1 and is relative to the number of reports that particular user has.</li>
        <li>Create a web page to display the user and list the reports that the user has.</li>
        <li>The report name should be presented in ROT13 if the user has an fr_FR locale.</li>
        <li>There should be a way to generate a new report and add it to the list for each user. When clicked it should generate the report.</li>
        <li>The number of active report generation requests should be displayed.</li>
        <li>The report generation should be simulated by a 3 second wait (not by a setTimeout on the client side) before displaying the new report in the list for the correct user, in the correct format.</li>
        <li>Refreshing the page should show all reports that have previously been generated.</li>
    </ul>


    <div id="controller-list" role="navigation">
        <h2>Available Controllers:</h2>

        <div>
            Also we have created the first controller and action here (but the rest is up to you!!!):
        </div>
        <ul>
            <g:each var="c" in="${grailsApplication.controllerClasses.sort { it.fullName }}">
                <li class="controller"><g:link controller="${c.logicalPropertyName}">${c.fullName}</g:link></li>
            </g:each>
        </ul>
    </div>
</div>
</body>
</html>
