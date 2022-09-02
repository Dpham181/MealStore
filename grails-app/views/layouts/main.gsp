<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>
        <g:layoutTitle default="Meal Search Page"/>
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <asset:link rel="icon" href="favicon.ico" type="image/x-ico"/>

    <asset:stylesheet src="application.css"/>

    <g:layoutHead/>
</head>


<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
      <li class="nav-item active">
        <a class="nav-link" href="/">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="https://www.themealdb.com/api.php">Api Doc</a>
      </li>
        <li class="nav-item">
              <a class="nav-link" href="https://grails-profiles.github.io/web/latest/guide/index.html">Grails Doc</a>
            </li>
    </ul>
    <form class="form-inline my-2 my-lg-0" action="meal/search" method="POST">
      <input class="form-control mr-sm-2" name="term" type="search" placeholder="Search" aria-label="Search" required>
       <select required name="type"  class="form-control">
              <option value="s">By Name</option>
              <option value="i">By Id</option>
              <option value="f">Letter</option>
            </select>


      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
  </div>
</nav>
<body>



<g:layoutBody/>




<asset:javascript src="application.js"/>

</body>
</html>
