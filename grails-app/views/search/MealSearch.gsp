<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'meal.label', default: 'Meal')}" />
        <title>Search for Meal</title>
    </head>
    <body>
    <div id="content" role="main">
    <div class="d-flex flex-wrap flex-row justify-content-around">


    <g:each var="meal" in="${Meals}">

   <form  action="/meal/save" method="POST" onClick="this.form.reset()">

          <div class="p-2">
               <div class="card" style="width: 18rem;">
                 <img class="card-img-top" src="${meal.image}" alt="meal img">
                 <div class="card-body">
                   <h5 class="card-title">${meal.name}
                     <input type="hidden" name="meal_Id" value="${meal.meal_Id}">
                     <input type="hidden" name="name" value="${meal.name}">
                     <input type="hidden" name="drink" value="${meal.drink}">
                     <input type="hidden" name="category" value="${meal.category}">
                     <input type="hidden" name="area" value="${meal.area}">
                     <input type="hidden" name="tags" value="${meal.tags}">

                     <input type="hidden" name="image" value="${meal.image}">
                     <input type="hidden" name="creative" value="${meal.creative}">
                     <input type="hidden" name="instructions" value="${meal.instructions}">

                   </h5>
                   <p class="card-text">Category: ${meal.category}</p>
                    <p class="card-text">Area: ${meal.area}</p>
            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#meal-details">
              View Details
            </button>

                   <button type="submit" class="btn btn-primary">Save</button>
                 </div>
               </div>
            </div>


            <!-- Modal -->
            <div class="modal fade" id="meal-details" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
              <div class="modal-dialog" role="document">
                <div class="modal-content">
                  <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Name: ${meal.name}</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                      <span aria-hidden="true">&times;</span>
                    </button>
                  </div>
                  <div class="modal-body">
                    <div class="modal-body">
                      <div class="container-fluid">
                        <div class="row">
                          <div class="col-md-4">Area: ${meal.area}</div>
                          <div class="col-md-4 ml-auto">Category:${meal.category}</div>
                        </div>
                        <div class="row">
                         Instructions: ${meal.instructions}
                        </div>
                        <div class="row">
                          <div class="col-sm-9">
                             Tags: ${meal.tags}
                            <div class="row">
                        <g:select type="hidden" name="ingredientss"
                                                    from="${meal.ingredients}"
                                                    value="${meal.ingredients*.name}"
                                                    optionKey="name"
                                                    multiple="true" />

                              <div class="col-4 col-sm-6">
                                Drink: ${meal.drink}
                              </div>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>




                  </div>
                  <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                  </div>
                </div>
              </div>
            </div>
    </form>

     </g:each>

    </div>
    </div>
    </body>
</html>
