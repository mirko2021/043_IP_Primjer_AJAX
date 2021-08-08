package yatospace.app.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import yatospace.app.model.Calculator;
import yatospace.app.model.Operation;
import yatospace.app.object.Complex;
import yatospace.app.object.Digit;
import yatospace.web.ajax.anotation.AjaxAccessable;
import yatospace.web.ajax.anotation.AjaxSecurity;
import yatospace.web.ajax.element.AjaxRequestContext;
import yatospace.web.ajax.listener.AjaxRegisterListener;
import yatospace.web.ajax.model.AjaxExecutable;

/**
 * Calculator beans. 
 * @author MV
 * @version 1.0
 */
public class SimpleCalculatorBean implements Serializable, AjaxExecutable{
	private static final long serialVersionUID = -7810188438430854330L;
	
	private Calculator<BigDecimal, Digit<BigDecimal>> bigDecimalBasicCalculator = new Calculator<>(); 
	private Calculator<BigInteger, Digit<BigInteger>> bigIntegerBasicCalculator = new Calculator<>(); 
	private Calculator<Double, Digit<Double>>         doubleBasicCalculator     = new Calculator<>(); 
	private Calculator<Long, Digit<Long>>             longBasicCalculator       = new Calculator<>();
	private Calculator<Float, Digit<Float>>           floatBasicCalculator      = new Calculator<>();
	private Calculator<Integer, Digit<Integer>>       integerBasicCalculator    = new Calculator<>(); 
	private Calculator<Short, Digit<Short>>	          shortBasicCalculator      = new Calculator<>(); 
	
	private Complex<BigDecimal> bigDecimalComplexCalculator = new Complex<>(new BigDecimal("0"), new BigDecimal("0")); 
	private Complex<BigInteger> bigIntegerComplexCalculator = new Complex<>(new BigInteger("0"), new BigInteger("0")); 
	private Complex<Double>     doubleComplexCalculator     = new Complex<>(0.0d, 0.0d); 
	private Complex<Float>      floatComplexCalculator      = new Complex<>(0.0f, 0.0f);
	private Complex<Long>       longComplexCalculator       = new Complex<>(0l, 0l);
	private Complex<Integer>    integerComplexCalculator    = new Complex<>(0, 0); 
	private Complex<Short>	    shortComplexCalculator      = new Complex<>((short)0, (short)0);
	
	public Calculator<BigDecimal, Digit<BigDecimal>> getBigDecimalBasicCalculator() {
		return bigDecimalBasicCalculator;
	}
	public Calculator<BigInteger, Digit<BigInteger>> getBigIntegerBasicCalculator() {
		return bigIntegerBasicCalculator;
	}
	public Calculator<Double, Digit<Double>> getDoubleBasicCalculator() {
		return doubleBasicCalculator;
	}
	public Calculator<Long, Digit<Long>> getLongBasicCalculator() {
		return longBasicCalculator;
	}
	public Calculator<Float, Digit<Float>> getFloatBasicCalculator() {
		return floatBasicCalculator;
	}
	public Calculator<Integer, Digit<Integer>> getIntegerBasicCalculator() {
		return integerBasicCalculator;
	}
	public Calculator<Short, Digit<Short>> getShortBasicCalculator() {
		return shortBasicCalculator;
	}
	public Complex<BigDecimal> getBigDecimalComplexCalculator() {
		return bigDecimalComplexCalculator;
	}
	public Complex<BigInteger> getBigIntegerComplexCalculator() {
		return bigIntegerComplexCalculator;
	}
	public Complex<Double> getDoubleComplexCalculator() {
		return doubleComplexCalculator;
	}
	public Complex<Float> getFloatComplexCalculator() {
		return floatComplexCalculator;
	}
	public Complex<Long> getLongComplexCalculator() {
		return longComplexCalculator;
	}
	public Complex<Integer> getIntegerComplexCalculator() {
		return integerComplexCalculator;
	}
	public Complex<Short> getShortComplexCalculator() {
		return shortComplexCalculator;
	}
	
	
	@Override
	public void importFrom(AjaxRequestContext request) {}
	
	@Override
	public void exportTo(AjaxRequestContext request) {} 
	
	
	public void initialize(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		AjaxRegisterListener.getAjaxRegister(session).put("simpleCalculatorBean", this);
	}
	
	@AjaxSecurity
	@AjaxAccessable("calculate")
	public synchronized void calculate(AjaxRequestContext request) {
		try {
			String numberType = request.getRequest().get("parameters").getAsJsonObject().get("number_type").getAsString();
			String dataTypeString = request.getRequest().get("parameters").getAsJsonObject().get("data_type").getAsString(); 
			String operationString = request.getRequest().get("parameters").getAsJsonObject().get("operation").getAsString();
			Class<?> dataType = null;
			switch(dataTypeString.intern()) {
				case "BIGDECIMAL":
					dataType = BigDecimal.class; 
					break;
				case "BIGINTEGER":
					dataType = BigInteger.class; 
					break;	
				case "DOUBLE": 
					dataType = Double.class; 
					break;
				case "FLOAT": 
					dataType = Float.class; 
					break;
				case "LONG":
					dataType = Long.class; 
					break;
				case "INTEGER":
					dataType= Integer.class; 
					break;
				case "SHORT":
					dataType = Short.class; 
					break;
			}
			Operation operation = Operation.valueOf(operationString); 
			String resultRe = ""; 
			String resultIm = ""; 
			if(numberType.contentEquals("SIMPLE")) {
				String operand1Real = request.getRequest().get("parameters").getAsJsonObject().get("operand_1_re").getAsString();
				String operand2Real = request.getRequest().get("parameters").getAsJsonObject().get("operand_2_re").getAsString(); 
				if(dataType==BigDecimal.class) {
					BigDecimal bd1Re = new BigDecimal(operand1Real);
					BigDecimal bd2Re = new BigDecimal(operand2Real);
					Digit<BigDecimal> dBd1 = new Digit<BigDecimal>(bd1Re); 
					Digit<BigDecimal> dBd2 = new Digit<BigDecimal>(bd2Re);
					bigDecimalBasicCalculator.setOperand1(dBd1);
					bigDecimalBasicCalculator.setOperand2(dBd2);
					bigDecimalBasicCalculator.setOperation(operation);
					Digit<BigDecimal> res = bigDecimalBasicCalculator.calculate();
					resultRe = res.toString(); 
				}else if(dataType==BigInteger.class) {
					BigInteger bd1Re = new BigInteger(operand1Real);
					BigInteger bd2Re = new BigInteger(operand2Real);
					Digit<BigInteger> dBd1 = new Digit<BigInteger>(bd1Re); 
					Digit<BigInteger> dBd2 = new Digit<BigInteger>(bd2Re);
					bigIntegerBasicCalculator.setOperand1(dBd1);
					bigIntegerBasicCalculator.setOperand2(dBd2);
					bigIntegerBasicCalculator.setOperation(operation);
					Digit<BigInteger> res = bigIntegerBasicCalculator.calculate();
					resultRe = res.toString();
				}else if(dataType==Double.class) {
					Double bd1Re = Double.parseDouble(operand1Real);
					Double bd2Re = Double.parseDouble(operand2Real);
					Digit<Double> dBd1 = new Digit<Double>(bd1Re); 
					Digit<Double> dBd2 = new Digit<Double>(bd2Re);
					doubleBasicCalculator.setOperand1(dBd1);
					doubleBasicCalculator.setOperand2(dBd2);
					doubleBasicCalculator.setOperation(operation);
					Digit<Double> res = doubleBasicCalculator.calculate();
					resultRe = res.toString();
				}else if(dataType==Float.class) {
					Float bd1Re = Float.parseFloat(operand1Real);
					Float bd2Re = Float.parseFloat(operand2Real);
					Digit<Float> dBd1 = new Digit<Float>(bd1Re); 
					Digit<Float> dBd2 = new Digit<Float>(bd2Re);
					floatBasicCalculator.setOperand1(dBd1);
					floatBasicCalculator.setOperand2(dBd2);
					floatBasicCalculator.setOperation(operation);
					Digit<Float> res = floatBasicCalculator.calculate();
					resultRe = res.toString();
				}else if(dataType==Long.class) {
					Long bd1Re = Long.parseLong(operand1Real);
					Long bd2Re = Long.parseLong(operand2Real);
					Digit<Long> dBd1 = new Digit<Long>(bd1Re); 
					Digit<Long> dBd2 = new Digit<Long>(bd2Re);
					longBasicCalculator.setOperand1(dBd1);
					longBasicCalculator.setOperand2(dBd2);
					longBasicCalculator.setOperation(operation);
					Digit<Long> res = longBasicCalculator.calculate();
					resultRe = res.toString();
				}else if(dataType==Integer.class) {
					Integer bd1Re = Integer.parseInt(operand1Real);
					Integer bd2Re = Integer.parseInt(operand2Real);
					Digit<Integer> dBd1 = new Digit<Integer>(bd1Re); 
					Digit<Integer> dBd2 = new Digit<Integer>(bd2Re);
					integerBasicCalculator.setOperand1(dBd1);
					integerBasicCalculator.setOperand2(dBd2);
					integerBasicCalculator.setOperation(operation);
					Digit<Integer> res = integerBasicCalculator.calculate();
					resultRe = res.toString();
				}else if(dataType==Short.class) {
					Short bd1Re = Short.parseShort(operand1Real);
					Short bd2Re = Short.parseShort(operand2Real);
					Digit<Short> dBd1 = new Digit<Short>(bd1Re); 
					Digit<Short> dBd2 = new Digit<Short>(bd2Re);
					shortBasicCalculator.setOperand1(dBd1);
					shortBasicCalculator.setOperand2(dBd2);
					shortBasicCalculator.setOperation(operation);
					Digit<Short> res = shortBasicCalculator.calculate();
					resultRe = res.toString();
				}
			}else if(numberType.contentEquals("COMPLEX")){
				String operand1Real = request.getRequest().get("parameters").getAsJsonObject().get("operand_1_re").getAsString();
				String operand2Real = request.getRequest().get("parameters").getAsJsonObject().get("operand_2_re").getAsString(); 
				String operand1Imag = request.getRequest().get("parameters").getAsJsonObject().get("operand_1_im").getAsString();
				String operand2Imag = request.getRequest().get("parameters").getAsJsonObject().get("operand_2_im").getAsString(); 
				if(dataType==BigDecimal.class) {
					BigDecimal bd1Re = new BigDecimal(operand1Real);
					BigDecimal bd2Re = new BigDecimal(operand2Real);
					BigDecimal bd1Im = new BigDecimal(operand1Imag);
					BigDecimal bd2Im = new BigDecimal(operand2Imag);
					Complex<BigDecimal> dBd1 = new Complex<BigDecimal>(bd1Re, bd1Im); 
					Complex<BigDecimal> dBd2 = new Complex<BigDecimal>(bd2Re, bd2Im);
					switch(operation) {
						case PLUS: 
							dBd1.add(dBd2.getContetnt());
							break;
						case MINUS: 
							dBd1.subtract(dBd2.getContetnt());
							break;
						case MULTIPLY:
							dBd1.multiplty(dBd2.getContetnt());
							break;
						case DIVIDE:
							dBd1.divide(dBd2.getContetnt());
							break;
					}
					
					resultRe = dBd1.getContetnt().getReal().toString(); 
					resultIm = dBd1.getContetnt().getImaginary().toString();
				}else if(dataType==BigInteger.class) {
					BigInteger bd1Re = new BigInteger(operand1Real);
					BigInteger bd2Re = new BigInteger(operand2Real);
					BigInteger bd1Im = new BigInteger(operand1Real);
					BigInteger bd2Im = new BigInteger(operand2Real);
					Complex<BigInteger> dBd1 = new Complex<BigInteger>(bd1Re, bd1Im); 
					Complex<BigInteger> dBd2 = new Complex<BigInteger>(bd2Re, bd2Im);
					switch(operation) {
						case PLUS: 
							dBd1.add(dBd2.getContetnt());
							break;
						case MINUS: 
							dBd1.subtract(dBd2.getContetnt());
							break;
						case MULTIPLY:
							dBd1.multiplty(dBd2.getContetnt());
							break;
						case DIVIDE:
							dBd1.divide(dBd2.getContetnt());
							break;
					}
					
					resultRe = dBd1.getContetnt().getReal().toString(); 
					resultIm = dBd1.getContetnt().getImaginary().toString();
				}else if(dataType==Double.class) {
					Double bd1Re = Double.parseDouble(operand1Real);
					Double bd2Re = Double.parseDouble(operand2Real);
					Double bd1Im = Double.parseDouble(operand1Real);
					Double bd2Im = Double.parseDouble(operand2Real);
					Complex<Double> dBd1 = new Complex<Double>(bd1Re, bd1Im); 
					Complex<Double> dBd2 = new Complex<Double>(bd2Re, bd2Im);
					switch(operation) {
						case PLUS: 
							dBd1.add(dBd2.getContetnt());
							break;
						case MINUS: 
							dBd1.subtract(dBd2.getContetnt());
							break;
						case MULTIPLY:
							dBd1.multiplty(dBd2.getContetnt());
							break;
						case DIVIDE:
							dBd1.divide(dBd2.getContetnt());
							break;
					}
					
					resultRe = dBd1.getContetnt().getReal().toString(); 
					resultIm = dBd2.getContetnt().getImaginary().toString();
				}else if(dataType==Float.class) {
					Float bd1Re = Float.parseFloat(operand1Real);
					Float bd2Re = Float.parseFloat(operand2Real);
					Float bd1Im = Float.parseFloat(operand1Real);
					Float bd2Im = Float.parseFloat(operand2Real);
					Complex<Float> dBd1 = new Complex<Float>(bd1Re, bd1Im); 
					Complex<Float> dBd2 = new Complex<Float>(bd2Re, bd2Im);
					switch(operation) {
						case PLUS: 
							dBd1.add(dBd2.getContetnt());
							break;
						case MINUS: 
							dBd1.subtract(dBd2.getContetnt());
							break;
						case MULTIPLY:
							dBd1.multiplty(dBd2.getContetnt());
							break;
						case DIVIDE:
							dBd1.divide(dBd2.getContetnt());
							break;
					}
					
					resultRe = dBd1.getContetnt().getReal().toString(); 
					resultIm = dBd1.getContetnt().getImaginary().toString();
				}else if(dataType==Long.class) {
					Long bd1Re = Long.parseLong(operand1Real);
					Long bd2Re = Long.parseLong(operand2Real);
					Long bd1Im = Long.parseLong(operand1Real);
					Long bd2Im = Long.parseLong(operand2Real);
					Complex<Long> dBd1 = new Complex<Long>(bd1Re, bd1Im); 
					Complex<Long> dBd2 = new Complex<Long>(bd2Re, bd2Im);
					switch(operation) {
						case PLUS: 
							dBd1.add(dBd2.getContetnt());
							break;
						case MINUS: 
							dBd1.subtract(dBd2.getContetnt());
							break;
						case MULTIPLY:
							dBd1.multiplty(dBd2.getContetnt());
							break;
						case DIVIDE:
							dBd1.divide(dBd2.getContetnt());
							break;
					}
					
					resultRe = dBd1.getContetnt().getReal().toString(); 
					resultIm = dBd1.getContetnt().getImaginary().toString();
				}else if(dataType==Integer.class) {
					Integer bd1Re = Integer.parseInt(operand1Real);
					Integer bd2Re = Integer.parseInt(operand2Real);
					Integer bd1Im = Integer.parseInt(operand1Real);
					Integer bd2Im = Integer.parseInt(operand2Real);
					Complex<Integer> dBd1 = new Complex<Integer>(bd1Re, bd1Im); 
					Complex<Integer> dBd2 = new Complex<Integer>(bd2Re, bd2Im);
					switch(operation) {
						case PLUS: 
							dBd1.add(dBd2.getContetnt());
							break;
						case MINUS: 
							dBd1.subtract(dBd2.getContetnt());
							break;
						case MULTIPLY:
							dBd1.multiplty(dBd2.getContetnt());
							break;
						case DIVIDE:
							dBd1.divide(dBd2.getContetnt());
							break;
					}
					
					resultRe = dBd1.getContetnt().getReal().toString(); 
					resultIm = dBd1.getContetnt().getImaginary().toString();
				}else if(dataType==Short.class) {
					Short bd1Re = Short.parseShort(operand1Real);
					Short bd2Re = Short.parseShort(operand2Real);
					Short bd1Im = Short.parseShort(operand1Real);
					Short bd2Im = Short.parseShort(operand2Real);
					Complex<Short> dBd1 = new Complex<Short>(bd1Re, bd1Im); 
					Complex<Short> dBd2 = new Complex<Short>(bd2Re, bd2Im);
					switch(operation) {
						case PLUS: 
							dBd1.add(dBd2.getContetnt());
							break;
						case MINUS: 
							dBd1.subtract(dBd2.getContetnt());
							break;
						case MULTIPLY:
							dBd1.multiplty(dBd2.getContetnt());
							break;
						case DIVIDE:
							dBd1.divide(dBd2.getContetnt());
							break;
					}
					
					resultRe = dBd1.getContetnt().getReal().toString(); 
					resultIm = dBd1.getContetnt().getImaginary().toString();
				}
			} else {
				throw new RuntimeException("Parameters mismatch.");
			}
			request.getResponse().addProperty("result_re", resultRe);
			request.getResponse().addProperty("result_im", resultIm);
			request.getResponse().addProperty("success", true);
		}catch(Exception ex) {
			request.getResponse().addProperty("success", false);
		}
	}
}
