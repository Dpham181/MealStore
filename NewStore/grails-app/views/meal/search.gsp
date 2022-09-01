<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'meal.label', default: 'Meal')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
    <div id="content" role="main">
       <div class="jumbotron">

          <g:form resource="${this.Meal}" method="POST">
                               <fieldset class="form">
                                   <f:all bean="Meal"/>
                               </fieldset>
                               <fieldset class="buttons">
                                   <g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
                               </fieldset>
          </g:form>


        </div>
    </div>
    </body>
</html>
