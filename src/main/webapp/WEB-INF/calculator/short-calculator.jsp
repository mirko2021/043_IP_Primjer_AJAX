<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<h3>КЛАСИЧНИ РАЧУН / LONG</h3>
<form id='calculator' name='calculator'>
	<table>
		<tr>
			<td>Први операнд: </td>
			<td><input type='number' name='operand_1' value='0'/></td>
		</tr>
		<tr>
			<td>Други операнд: </td>
			<td><input type='number' name='operand_2' value='0'/></td>
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
	<input type='hidden' value='SIMPLE'  name='number_type'/>
	<input type='hidden' value='SHORT'  name='calculator_type'/>
	<input type='button' value='Рачунање' onclick='calculate("${pageContext.request.contextPath}")'/>
</form>