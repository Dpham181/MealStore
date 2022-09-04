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
          <div class="p-2">
               <div class="card" style="width: 18rem;">
                 <img class="card-img-top" src="${meal.image}" alt="meal img">
                 <div class="card-body">
                   <h5 class="card-title">${meal.name}</h5>
                   <p class="card-text">Category: ${meal.category}</p>
                    <p class="card-text">Area: ${meal.area}</p>
            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#meal-details">
              View Details
            </button>

                   <button href="#" class="btn btn-primary">Save</button>
                 </div>
               </div>
            </div>


            <!-- Modal -->
            <div class="modal fade" id="meal-details" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
              <div class="modal-dialog" role="document">
                <div class="modal-content">
                  <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Meal Details</h5>
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
                          <div class="col-md-6 ml-auto">Drink: ${meal.drink}</div>
                        </div>
                        <div class="row">
                          <div class="col-sm-9">
                              ${meal.tags}
                            <div class="row">
                              <div class="col-8 col-sm-6">
                              ${meal.creative}
                              </div>
                              <div class="col-4 col-sm-6">
                                 ${meal.dateModified}
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
          </g:each>

    </div>
    </div>
    </body>
</html>
