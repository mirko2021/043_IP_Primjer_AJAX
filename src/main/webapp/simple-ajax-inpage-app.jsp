<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<jsp:useBean id='simpleCalculatorBean' class='yatospace.app.bean.SimpleCalculatorBean' scope='session'></jsp:useBean>

<% 
	yatospace.app.bean.SimpleCalculatorBean bean = (yatospace.app.bean.SimpleCalculatorBean) session.getAttribute("simpleCalculatorBean");
	bean.initialize(request, response); 
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Kalkulatori - forme</title>
		<script type='text/javascript' src='${pageContext.request.contextPath}/PAGE-ZONE/IO/calculator.js'></script>
		<script type='text/javascript' src='${pageContext.request.contextPath}/PAGE-ZONE/SWITCH/loader.js'></script>
		<script type='text/javascript' src='${pageContext.request.contextPath}/JAVASCRIPT/ajax_functionals.js'></script>
		<script type='text/javascript' src='${pageContext.request.contextPath}/JAVASCRIPT/ajax_utils.js'></script>
		<script type='text/javascript' src='${pageContext.request.contextPath}/OBJECT/AjaxMessage.js'></script>
		<script type='text/javascript' src='${pageContext.request.contextPath}/OBJECT/AjaxRequest.js'></script>
		<script type='text/javascript' src='${pageContext.request.contextPath}/OBJECT/AjaxResponse.js'></script>
		<script type='text/javascript' src='${pageContext.request.contextPath}/OBJECT/AjaxType.js'></script>
		<link type='text/css' rel='stylesheet' href='${pageContext.request.contextPath}/PAGE-ZONE/CSS/styles.css'/>
	</head>
	<body>
		<h3>Калкулатори</h3>
		<dl>
			<dt>Комплексни бројеви</dt>
			<dd><a href='javascript:load_calculator("${pageContext.request.contextPath}", "/WEB-INF/calculator/short-complex-calculator.jsp")'>Short</a></dd>
			<dd><a href='javascript:load_calculator("${pageContext.request.contextPath}", "/WEB-INF/calculator/integer-complex-calculator.jsp")'>Integer</a></dd>
			<dd><a href='javascript:load_calculator("${pageContext.request.contextPath}", "/WEB-INF/calculator/long-complex-calculator.jsp")'>Long</a></dd>
			<dd><a href='javascript:load_calculator("${pageContext.request.contextPath}", "/WEB-INF/calculator/float-complex-calculator.jsp")'>Float</a></dd>
			<dd><a href='javascript:load_calculator("${pageContext.request.contextPath}", "/WEB-INF/calculator/double-complex-calculator.jsp")'>Double</a></dd>
			<dd><a href='javascript:load_calculator("${pageContext.request.contextPath}", "/WEB-INF/calculator/big-integer-complex-calculator.jsp")'>Big Integer</a></dd>
			<dd><a href='javascript:load_calculator("${pageContext.request.contextPath}", "/WEB-INF/calculator/big-decimal-complex-calculator.jsp")'>Big Decimal</a></dd>
			<dd><a href='javascript:load_empty()'>Празно</a></dd>
		</dl><br>
		<dl>
			<dt>Обични бројеви</dt>
			<dd><a href='javascript:load_calculator("${pageContext.request.contextPath}", "/WEB-INF/calculator/short-calculator.jsp")'>Short</a></dd>
			<dd><a href='javascript:load_calculator("${pageContext.request.contextPath}", "/WEB-INF/calculator/integer-calculator.jsp")'>Integer</a></dd>
			<dd><a href='javascript:load_calculator("${pageContext.request.contextPath}", "/WEB-INF/calculator/long-calculator.jsp")'>Long</a></dd>
			<dd><a href='javascript:load_calculator("${pageContext.request.contextPath}", "/WEB-INF/calculator/float-calculator.jsp")'>Float</a></dd>
			<dd><a href='javascript:load_calculator("${pageContext.request.contextPath}", "/WEB-INF/calculator/double-calculator.jsp")'>Double</a></dd>
			<dd><a href='javascript:load_calculator("${pageContext.request.contextPath}", "/WEB-INF/calculator/big-integer-calculator.jsp")'>Big Integer</a></dd>
			<dd><a href='javascript:load_calculator("${pageContext.request.contextPath}", "/WEB-INF/calculator/big-decimal-calculator.jsp")'>Big Decimal</a></dd>
			<dd><a href='javascript:load_empty()'>Празно</a></dd>
		</dl>
		<div id='calculator_io'></div>
	</body>
</html>