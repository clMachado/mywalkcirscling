/*<![CDATA[*/

function renderGoogleMap() {
	var start_point = new google.maps.LatLng(0, 0);
	
	// Creating a new map
	var map = new google.maps.Map(document.getElementById("map_canvas"), {
		center : start_point,
		zoom : 8,
		mapTypeId : google.maps.MapTypeId.ROADMAP
	});
	
	//alert("ola");
	

	// Creating a global infoWindow object that will be reused by all markers
	var infoWindow = new google.maps.InfoWindow();

	function setMarkerPoints(map, marker) {
		var bounds = new google.maps.LatLngBounds();
		
		var idRota = $("#idRotas").val();
		
		

		$.ajax({
			type : "GET",
			//url : '/products/json',
			url : '/reposit/pontos/getPontos/' + idRota,
			dataType : "json",
			success : function(data) {
				
				//alert(data.length);
				start_point = null;

				if (data.length !== 0) {

					$.each(data, function(marker, data) {
						
						//alert(data.latitude + " -- " + data.longitude);

						var latLng = new google.maps.LatLng(data.latitude,
								data.longitude);
						//bounds.extend(latLng);
						
						if(start_point == null){
							start_point = latLng;
						} 

						// Creating a marker and putting it on the map
						var marker = new google.maps.Marker({
							position : latLng,
							map : map,
							title : data.latitude + " " + data.longitude + " " + data.data
						});

						var windowContent = '<h3>' + data.latitude + '</h3>' + '<p>'
								+ data.velocidade + '</p>';

//						// Attaching a click event to the current marker
//						infobox = new InfoBox({
//							content : infoWindow.setContent(windowContent),
//							alignBottom : true,
//							pixelOffset : new google.maps.Size(-160, -45)
//						});

//						google.maps.event.addListener(marker, 'click',
//								function() {
//
//									// Open this map's infobox
//									infobox.open(map, marker);
//									infobox.setContent(windowContent);
//									map.panTo(marker.getPosition());
//									infobox.show();
//								});
//						google.maps.event.addListener(map, 'click', function() {
//							infobox.setMap(null);
//						});
					});

				}
				
				
			},
			error : function(data) {
				console.log('Por Favor recarregue a pagina ou tente Novamente ...');
			}
		});
		// END MARKER DATA

		// end loop through json

		map.setCenter(start_point);
		map.fitBounds(bounds);
	}
	setMarkerPoints(map);
}

/* ]]> */

// google.maps.event.addDomListener(window, 'load', renderGoogleMap);
