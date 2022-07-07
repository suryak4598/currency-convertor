<!-- Currency Converter html -->

<!-- jstl core tag library -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<!-- jstl form tag library --> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

    
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Currency Converter</title>

<!-- Bootstrap 5 css -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet" >

<!-- Custome style css -->
<link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/style.css" />">

<!-- google fonts -->
<link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,300;0,400;1,100;1,300&family=Ubuntu:ital,wght@0,300;0,400;1,300;1,400;1,700&display=swap" rel="stylesheet">
<link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"
    />
     <link rel="stylesheet" type="text/css" href="http://cdn.datatables.net/1.11.3/css/jquery.dataTables.min.css">
   </head>
<body>

    <!-- Navigation header -->
	<header>
		<nav class="navbar navbar-expand-lg fixed-top navbar-dark" id="nav_bar">
  			<div class="container-fluid">
    			<a id ="brand_name" class="navbar-brand" href="#">Currency <span>Converter</span></a>
    			<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="true" aria-label="Toggle navigation">
      				<span class="navbar-toggler-icon"></span>
    			</button>
    			<div class="collapse navbar-collapse" id="navbarSupportedContent">
      				<ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-5 ">
      					<c:forEach items="${navbar_list}" var="navbarList" >
    						<li class="nav-item">
          						<a class="nav-link ms-4" aria-current="page" href="#${navbarList}">${navbarList}</a>
        					</li>
  						</c:forEach>
      				</ul>
    			</div>
  			</div>
		</nav>
	</header>
	
	<!-- main container -->
	<section id="Home">
		<video id="home_video" poster="" muted autoplay loop>
        	<source src="<c:url value="/resources/videos/home-video.mp4"/>" type="video/mp4" />
      	</video>
      	<div id="overlay"></div>
      	<div id="home-content">
      		<div id="home-inner-content" >
				<div class="container  card p-5 shadow shadow-lg custom-card main" id="home_section">
					<div class="row">
					
					    <!-- Currency input div -->
						<div class="col-8 border-end border-secondary">
							<form method="post">
			  					<div class="form-group mt-1 w-75 ">
			    					<h3>Amount</h3>
			    					<input type="text" class="form-control border border-secondary" id="amount" placeholder="1.00" required="required" value="1">
			    					<small id="amountHelp" class="form-text text-white">Enter the amount to be converted</small>
			  					</div>
					  			<div class="mt-1 w-75">
					    			<h3 >From </h3>
					    			<div class="d-flex justify-content-between align-items-center bg-white rounded-2 custom border border-secondary">
					    				<img class="countryFlags rounded-2 ms-2" id="flag1">
			    						<select class="form-select select" id="fromCountry" >
							 				<c:forEach items="${countryList}" var="countryName" >
			    								<option value="${countryName.currencyCode}">${countryName.countryName}</option>
			  								</c:forEach>
										</select>
									</div>
			  					</div>
			  					<div class=" mt-1 w-75 ">
					    			<h3>To </h3>
					        		<div class="d-flex justify-content-between align-items-center bg-white rounded-2 custom border border-secondary">
					    				<img class="countryFlags rounded-2 ms-2" id="flag2">
			    						<select class="form-select select" id="toCountry">
							  				<c:forEach items="${countryDbList}" var="countryDbName" >
			    								<option value="${countryDbName.currencyCode}" >${countryDbName.countryName}</option>
			  								</c:forEach>
										</select>
									</div>
								</div>
			  					<div>
			  						<button type="button" class="btn btn-outline-warning mt-5 p-2 w-25" id="currency_button">Convert</button>
								</div>
							</form>
						</div>
			
						<!-- Result div -->
						<div class="col-4 d-flex align-items-center justify-content-center">
							<h1 id="result" class="text-center">Result</h1>
						</div>
					</div>
				</div>
			</div>
		</div>
	
	</section>
	
	<section class="country-list-section" id="Country List">
		<div id="country-list-content"> 
			<div class="text-center text-dark">
				<h1>Country List</h1>
			</div>
			<div id="country-list-inner-content"> 
				<table class="table table-striped responsive table-togglable table-hover" id="country-table">
  					<thead style="background-color: #ffc107; color:white">
    					<tr>
      						<th scope="col">S.No</th>
      						<th scope="col">CountryName</th>
      						<th scope="col">Country Code</th>
      						<th scope="col">Currency Code</th>
    					</tr>
  					</thead>
  					<tbody>
  						<c:forEach items="${countryDbList}" var="country" >		  								
    						<tr>
      							<td scope="row">${country.id}</td>
      							<td>${country.countryName}</td>
      							<td>${country.countryCode}</td>
      							<td>${country.currencyCode}</td>
    						</tr>
    					</c:forEach>
  					</tbody>
				</table>
			</div>
		</div>
	</section>
	
	<!-- Bootstrap 5 js -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/js/bootstrap.bundle.min.js" ></script>

	<!-- jquery 3 -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

	<!-- custom script -->
	<script type="text/javascript" src="<c:url value="/resources/js/script.js" />"></script>
    <script type="text/javascript" charset="utf8" src="http://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>
   
</body>
</html>