<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'mataPelajaran.label', default: 'MataPelajaran')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#create-mataPelajaran" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="create-mataPelajaran" class="content scaffold-create" role="main">
            <h1>Create new Mata Pelajaran</h1>
            <g:form action="save">
                Kode Mata Pelajaran:    <g:textField name="mapelKode" /><br />
                Mata Pelajaran:         <g:textField name="mapelName" /><br />
                <g:actionSubmit value="Save" />
            </g:form>
        </div>
    </body>
</html>
