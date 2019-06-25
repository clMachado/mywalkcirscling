/*<![CDATA[*/

function renderGoogleMap() {
	var start_point = new google.maps.LatLng(0, 0);
	
	
	console.log('renderGoogleMap -> multimap.js');
	
	// Creating a new map
	var map = new google.maps.Map(document.getElementById("map_canvas"), {
		center : start_point,
		zoom : 14,
		mapTypeId : google.maps.MapTypeId.ROADMAP
	});
	
	map.addListener('zoom_changed', function(){
		   //alert("deu zoom" + map.zoom);	
		});
	

	// Creating a global infoWindow object that will be reused by all markers
	var infoWindow = new google.maps.InfoWindow();

	function setMarkerPoints(map, marker) {
		var bounds = new google.maps.LatLngBounds();

		var idRota = $("#idRotas").val();
		
		$.ajax({
			type : "GET",
			//url : '/products/json',
			url : '/reposit/web/pontos/getPontos/' + idRota,
			dataType : "json",
			success : function(data) {
				
				//alert(data.length);
				start_point = null;

				if (data.length !== 0) {

					$.each(data, function(marker, data) {
						
						var latLng = new google.maps.LatLng(data.latitude,
								data.longitude);
						
						if(start_point == null){
							start_point = latLng;
						} 

						// Creating a marker and putting it on the map
						var marker = new google.maps.Marker({
							position : latLng,
							map : map,
							title : data.latitude + " " + data.longitude + " " + data.data
						});

						var windowContent = 'Latitude:  ' + data.latitude   + '<br/>' +
						                    'Longitude: ' + data.longitude  + '<br/>' +
						                    'Velocidade:' + data.velocidade + '<br/>' +
						                    '<img src="http://www.coasul.com.br/img/logo-50-anos.png" />'
								'';			
						var infowindow = new google.maps.InfoWindow({
					          content: windowContent
					        });

						marker.addListener('click', function() {
						    //map.setZoom(14);
						    //map.setCenter(marker.getPosition());
						    infowindow.open(map, marker);
						  });
						
						map.setCenter(marker.getPosition());
						
					});
				}
								
			},
			error : function(data) {
				console.log('Por Favor recarregue a pagina ou tente Novamente ...');
			}
		});
		// END MARKER DATA

		map.setCenter(start_point);
	}
	
	setMarkerPoints(map);
	map.setCenter(start_point);
}
