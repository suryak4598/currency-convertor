// Script js using jQuery
$(function() {
	
	$('#country-table').dataTable( {
		ordering:  false,
    } );
	
	 // Country flags loads on initial page load
	 getCountryFlags("ad", "both");
	
	 // Getting the country flags from flagcdn url
	 function getCountryFlags(data , id) {
		
		const url = `https://flagcdn.com/${data}.svg`;
		if(id=="both"){
			$("#flag1").attr("src", url);
			$("#flag1").attr("width", 30);
			$("#flag1").attr("height", 20);
			$("#flag2").attr("src", url);
			$("#flag2").attr("width", 30);
			$("#flag2").attr("height", 20);
		}
		else{
			$(`#${id}`).attr("src", url);
			$(`#${id}`).attr("width", 30);
			$(`#${id}`).attr("height", 20);
		}
	}
	
    // Getting country code for selecting the country flags using ajax
	$("#fromCountry, #toCountry").on("change",function(){
		
		const countryName = $(this).find(":selected").text();;
		var dataToBeSent  = { countryName : countryName }; 
		var targetId = $(this).attr("id");
		if (targetId == "fromCountry"){
			id="flag1"
		}
		else{
			id="flag2"
		}
        $.ajax({
			url : 'GetCountryCodeServlet', 
            data :dataToBeSent, 
            type : 'POST',
            dataType : 'text', 
            success : function(response) {
				getCountryFlags(response, id);
            },
            error : function() {
                console.log("Failed");
            }
        });
    });

    // Calling getExchangeData method on action
//	$(document).ready(function(){
//		$("#amount, select, #currency_button").on('change change click',function(){
//			getExchangeData();
//		});
//	});

    // Currency convert method to call getExchangeDataServlet using ajax
	function getExchangeData() {
		let temp = $("#amount").val().trim();
     	if (temp==null || temp==''){
	   		temp = 1;
	 	}

		var dataToBeSent  = {
								amount : temp , 
								fromCountry: $("#fromCountry").val(),
								toCountry: $("#toCountry").val()
            				}; 

        $.ajax({
        	url : 'getExchangeDataServlet', 
            data :dataToBeSent, 
            type : 'POST',
            dataType : 'text', 
            success : function(response) {
											$("#result").html(response);
                						 },
            error : function() {
                    			 console.log("Failed");
                			   }
        });
	}
	
	if ($(window).scrollTop() > 60)  {
      $('#nav_bar').addClass('navbar-fixed-top');
    }
	
	$(window).scroll(function () { 

    if ($(window).scrollTop() > 60)  {
      $('#nav_bar').addClass('navbar-fixed-top');
    }
	else{
		$('#nav_bar').removeClass('navbar-fixed-top');
	}

  });

});
