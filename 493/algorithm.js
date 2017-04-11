//array of maps to display on timer
var map_array = ["BWheat_1949-min.png", "BWheat_1954-min.png", "BWheat_1959-min.png", "BWheat_1964-min.png", "BWheat_1969-min.png", "BWheat_1974-min.png", "BWheat_1978-min.png", "BWheat_1982-min.png", "BWheat_1987-min.png", "BWheat_1992-min.png", "BWheat_1997-min.png", "BWheat_2002-min.png", "BWheat_2007-min.png", "BWheat_2012-min.png"];

$("#play1").on("click", function() { //Play Fast button is pressed
	$("#play1").prop("disabled", true);//disable button so cannot restart and mess up photo order
	var c = 0;

	interval = setInterval(function() { //setTimeout() does once
		if (c>12) { //once all the maps in the array have been displayed
			clearInterval(interval);//stop interval program
			$("#play1").prop("disabled", false); 
		}
		switch_func(c);
		c++;
	}, 1000);

	function switch_func(c) {
		$("#map").attr("src", "/images/maps/"+map_array[c]); //switch to the next map
	}
});		
		
