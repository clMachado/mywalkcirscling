var maps;
      
      function initMap() {
    	var posit = {lat: -25.833924 , lng: -52.726102};  
    	  
        var mapOptions = {
        		//center: new google.maps.LatLng(-25.833924, -52.726102),
        		center: posit,
          zoom: 8,
          mapTypeId: google.maps.MapTypeId.ROADMAP
        };
        maps = new google.maps.Map(document.getElementById('map'), mapOptions);
        //maps = map;
        
        var marker = new google.maps.Marker({position: posit,
        	                                 map: maps});
        //var listPontos = ${pontos};
        //listPontos.forEach(addMarkerPonto(${pontos.getPonto}))
      }
      
      function addMarker(lati, lngi) {
    	  
    	  var posit = {lat: lati , lng: lngi};  
    	  
    	  var marker = new google.maps.Marker({position: posit,
              map: maps});
      }
      
      function addMarkerList(pontos) {
    	  alert("ola");
    	  
    	  for(var indice in pontos ) { 
    		  
    		  
    		  
    	/*	  addMarker(indice.getLatitude(),
    				    indice.getLongitude());
    		   }*/
    		}

      } 