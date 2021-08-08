<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<h3>КОМПЛЕКСНИ РАЧУН / DOUBLE</h3>
<form id='calculator' name='calculator'>
	<table>
		<tr>
			<td>Први операнд: </td>
			<td><input type='number' name='operand_1_re' value='0'/> + i <input type='number' name='operand_1_re' value='0'/></td>
		</tr>
		<tr>
			<td>Други операнд: </td>
			<td><input type='number' name='operand_2_re' value='0'/> + i <input type='number' name='operand_2_re' value='0'/></td>
		</tr>
		<tr>
			<td>Операција: </td>
			<td>
				<select name='operation'>
					<option selected>Сабирање</option>
					<option>Одузимање</option>
					<option>Множење</option>
					<option>Дијељење</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>Резултат: </td>
			<td><div id='result'></div></td>
		</tr>
	</table>
	<br>
	<input type='hidden' value='COMPLEX'     name='number_type'/>
	<input type='hidden' value='DOUBLE' name='calculator_type'/>
	<input type='button' value='Рачунање' onclick='calculate("${pageContext.request.contextPath}")'/>
</form><br>
<div>
	Резултати можда нису тачни. Апликација је показна за потребе 
	увјерења о раду са AJAX технологијом. Радови на апликацији у току.
</div>