"UTF-8"
/**
 * Functionals of loading calculator form. 
 */

function load_empty(){
	var destination  = document.getElementById('calculator_io');
	destination.innerHTML = ''; 
}

function load_calculator(app_path, resource_path_address){
	ajax_load_reactive(app_path, resource_path_address, 'calculator_io', function(){});
}