"UTF-8"

/**
 * Calculator IO. 
 */

function calculate(app_path){	
	var number_type_doc = document.getElementsByName('number_type')[0]; 
	var calculator_type_doc = document.getElementsByName('calculator_type')[0];
	var operation_doc = document.getElementsByName('operation')[0]; 
	var operation = ''; 
	
	var back_function = function(response) {
		if(response.response.success){
			if(number_type_doc.value==='SIMPLE'){
				document.getElementById('result').innerHTML = response.response['result_re']; 
			}
			else if(number_type_doc.value==='COMPLEX'){
				document.getElementById('result').innerHTML = response.response['result_re']+'+i'+response.response['result_im']; 
			}else{
				document.getElementById('result').innerHTML = 'НЕПОЗНАТ.';
			}
		}else{
			document.getElementById('result').innerHTML = 'НЕПОЗНАТ.';
		}
	}
	
	switch(operation_doc.value){
		case 'Сабирање':
			operation = 'PLUS'; 
			break;  	
		case 'Одузимање':
			operation = 'MINUS'; 
			break;  	
		case 'Множење':
			operation = 'MULTIPLY'; 
			break;  	
		case 'Дијељење':
			operation = 'DIVIDE'; 
			break;  	
	}
	
	
	var request = form_ajax_request(); 
	request.request.beanName = "simpleCalculatorBean";
	request.request.functionName = "calculate";
	if(number_type_doc.value === 'SIMPLE'){
		var operand_1_doc = document.getElementsByName('operand_1')[0]; 
		var operand_2_doc = document.getElementsByName('operand_2')[0]; 
		request.request.parameters = {
			number_type:number_type_doc.value, 
			data_type:calculator_type_doc.value, 
			operand_1_re: operand_1_doc.value,
			operand_2_re: operand_2_doc.value,
			operation: operation
		};  
	}
	if(number_type_doc.value === 'COMPLEX'){
		var operand_1_re_doc = document.getElementsByName('operand_1_re')[0]; 
		var operand_2_re_doc = document.getElementsByName('operand_2_re')[0]; 
		var operand_1_im_doc = document.getElementsByName('operand_1_im')[0]; 
		var operand_2_im_doc = document.getElementsByName('operand_2_im')[0]; 
		request.request.parameters = {
			number_type:number_type_doc.value, 
			data_type:calculator_type_doc.value, 
			operand_1_re: operand_1_re_doc.value,
			operand_2_re: operand_2_re_doc.value, 
			operand_1_im: operand_1_im_doc.value,
			operand_2_im: operand_2_im_doc.value, 
			operation: operation
		};
	}
	
	ajax_exe(app_path, request.request.beanName, request.request.functionName, request.request.parameters, back_function);
}