package yatospace.app.model;

import java.io.Serializable;

import yatospace.app.object.Complex;
import yatospace.app.object.Digit;

/**
 * Calculator engine and operative storage. 
 * @author MV
 * @version 1.0
 * @param <T> operand (number) type. 
 */
public class Calculator<N extends Number, T extends Numerable<N>> implements Serializable{
	private static final long serialVersionUID = -8190254898795839203L;
	private T operand1; 
	private T operand2; 
	private Operation operation; 
	
	public Calculator() {}

	public T getOperand1() {
		return operand1;
	}

	public void setOperand1(T operand1) {
		this.operand1 = operand1;
	}

	public T getOperand2() {
		return operand2;
	}

	public void setOperand2(T operand2) {
		this.operand2 = operand2;
	}

	public Operation getOperation() {
		return operation;
	}

	public void setOperation(Operation operation) {
		this.operation = operation;
	}
	
	@SuppressWarnings("unchecked")
	public T  add() {
		if(operand1 instanceof Digit) {
			Digit<N> operand = ((Digit<N>) operand1).clone(); 
			operand.add(operand2.getContetnt());
			return (T) operand; 
		}
		if(operand2 instanceof Complex) {
			Complex<N> operand = ((Complex<N>) operand1).clone(); 
			Complex<N> o2 = (Complex<N>) operand2;
			operand.add(o2.getContetnt());
			return (T) operand; 
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public T subtract() {
		if(operand1 instanceof Digit) {
			Digit<N> operand = ((Digit<N>) operand1).clone(); 
			operand.subtract(operand2.getContetnt());
			return (T) operand; 
		}
		if(operand2 instanceof Complex) {
			Complex<N> operand = ((Complex<N>) operand1).clone(); 
			Complex<N> o2 = (Complex<N>) operand2;
			operand.subtract(o2.getContetnt());
			return (T) operand; 
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public T multiply() {
		if(operand1 instanceof Digit) {
			Digit<N> operand = ((Digit<N>) operand1).clone(); 
			operand.multiplty(operand2.getContetnt());
			return (T) operand; 
		}
		if(operand2 instanceof Complex) {
			Complex<N> operand = ((Complex<N>) operand1).clone(); 
			Complex<N> o2 = (Complex<N>) operand2;
			operand.multiplty(o2.getContetnt());
			return (T) operand; 
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public T divide() {
		if(operand1 instanceof Digit) {
			Digit<N> operand = ((Digit<N>) operand1).clone(); 
			operand.divide(operand2.getContetnt());
			return (T) operand;
		}
		if(operand2 instanceof Complex) {
			Complex<N> operand = ((Complex<N>) operand1).clone(); 
			Complex<N> o2 = (Complex<N>) operand2;
			operand.divide(o2.getContetnt());
			return (T) operand; 
		}
		return null;
	}
	
	public T calculate() {
		switch(operation) {
			case PLUS: 
				return add(); 
			case MINUS: 
				return subtract();
			case MULTIPLY: 
				return multiply();
			case DIVIDE:
				return divide();
			default: 
				return null;
		}
	}
}
