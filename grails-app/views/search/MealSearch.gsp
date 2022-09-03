<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'meal.label', default: 'Meal')}" />
        <title>Search for Meal</title>
    </head>
    <body>
    <div id="content" role="main">
    <div class="d-flex flex-row justify-content-around">


        <g:each var="meal" in="${Meals}">
         <div class="p-2">
               <div class="card" style="width: 18rem;">
                 <img class="card-img-top" src="${meal.image}" alt="meal img">
                 <div class="card-body">
                   <h5 class="card-title">${meal.name}</h5>
                   <p class="card-text">Category: ${meal.category}</p>
                    <p class="card-text">Area: ${meal.area}</p>

                   <button href="#" class="btn btn-primary">Save</button>
                 </div>
               </div>
            </div>
          </g:each>

    </div>
    </div>
    </body>
</html>
