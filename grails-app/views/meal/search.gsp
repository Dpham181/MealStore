<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'meal.label', default: 'Meal')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
    <div id="content" role="main">


        <g:each var="meal" in="${Meals}">
               <div class="card" style="width: 18rem;">
                 <img class="card-img-top" src="${meal.image}" alt="Card image cap">
                 <div class="card-body">
                   <h5 class="card-title">${meal.name}</h5>
                   <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                   <a href="#" class="btn btn-primary">Go somewhere</a>
                 </div>
               </div>

          </g:each>


    </div>
    </body>
</html>
