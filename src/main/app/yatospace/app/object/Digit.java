package yatospace.app.object;

import java.math.BigDecimal;
import java.math.BigInteger;

import yatospace.app.model.Numerable;

/**
 * Siample Representation of the managable numbar. 
 * @author MV
 * @version 1.0
 * @param <T> number type. 
 */
public class Digit<T extends Number> implements Numerable<T>, Comparable<Digit<T>>, Cloneable{
	private static final long serialVersionUID = 1996944175250994702L;
	private T number; 
	
	public Digit(T number) {
		if(number==null) throw new NullPointerException(); 
		this.number = number; 
	}
	
	public T getNumber() {
		return number;
	}

	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public int compareTo(Digit<T> o) {
		if(number instanceof Comparable)    throw new ClassCastException();
		if(o.number instanceof Comparable)  throw new ClassCastException(); 
		Comparable c1 = (Comparable) number;
		Comparable c2 = (Comparable) o.number;
		return c1.compareTo(c2);
	}
	
	public String toString() {
		return number.toString();
	}
	
	@Override
	public T getContetnt() {
		return number;
	}
	
	@Override
	public int hashCode() {
		return number.hashCode(); 
	}

	@Override
	public Digit<T> clone() {
		Digit<T> digit = new Digit<T>(number);
		return digit;
	}
	
	@Override
	@SuppressWarnings({ "unchecked" })
	public void add(T other) {
		if(other instanceof Integer) number = (T) (Integer) (number.intValue()+other.intValue());
		if(other instanceof Double)  number = (T) (Double)  (number.doubleValue()+other.doubleValue());
		if(other instanceof Short)   number = (T) (Short) (short) (number.shortValue()+other.shortValue());
		if(other instanceof Long)    number = (T) (Long) (long) (number.longValue()+other.longValue()); 
		if(other instanceof Float)   number = (T) (Float) (number.floatValue()+other.floatValue()); 
		if(other instanceof BigInteger) {
			BigInteger b1 = (BigInteger) number; 
			BigInteger b2 = (BigInteger) other;
			number = (T) b1.add(b2); 
		}
		if(other instanceof BigDecimal) {
			BigDecimal b1 = (BigDecimal) number; 
			BigDecimal b2 = (BigDecimal) other; 
			number = (T) b1.add(b2);
		}
	}

	@Override
	@SuppressWarnings({ "unchecked"})
	public void subtract(T other) {
		if(other instanceof Integer) number = (T) (Integer) (number.intValue()-other.intValue());
		if(other instanceof Double)  number = (T) (Double)  (number.doubleValue()-other.doubleValue());
		if(other instanceof Short)   number = (T) (Short) (short) (number.shortValue()-other.shortValue());
		if(other instanceof Long)    number = (T) (Long) (long) (number.longValue()-other.longValue()); 
		if(other instanceof Float)   number = (T) (Float) (number.floatValue()-other.floatValue()); 
		if(other instanceof BigInteger) {
			BigInteger b1 = (BigInteger) number; 
			BigInteger b2 = (BigInteger) other;
			number = (T) b1.subtract(b2);
		}
		if(other instanceof BigDecimal) {
			BigDecimal b1 = (BigDecimal) number; 
			BigDecimal b2 = (BigDecimal) other; 
			number = (T) b1.subtract(b2);
		}
	}

	@Override
	@SuppressWarnings({ "unchecked"})
	public void multiplty(T other) {
		if(other instanceof Integer) number = (T) (Integer) (number.intValue()*other.intValue());
		if(other instanceof Double)  number = (T) (Double)  (number.doubleValue()*other.doubleValue());
		if(other instanceof Short)   number = (T) (Short) (short) (number.shortValue()*other.shortValue());
		if(other instanceof Long)    number = (T) (Long) (long) (number.longValue()*other.longValue()); 
		if(other instanceof Float)   number = (T) (Float) (number.floatValue()*other.floatValue()); 
		if(other instanceof BigInteger) {
			BigInteger b1 = (BigInteger) number; 
			BigInteger b2 = (BigInteger) other;
			number = (T) b1.multiply(b2);
		}
		if(other instanceof BigDecimal) {
			BigDecimal b1 = (BigDecimal) number; 
			BigDecimal b2 = (BigDecimal) other; 
			number = (T) b1.multiply(b2);
		}
	}

	@Override
	@SuppressWarnings({ "unchecked"})
	public void divide(T other) {
		if(other instanceof Integer) number = (T) (Integer) (number.intValue()/other.intValue());
		if(other instanceof Double)  number = (T) (Double)  (number.doubleValue()/other.doubleValue());
		if(other instanceof Short)   number = (T) (Short) (short) (number.shortValue()/other.shortValue());
		if(other instanceof Long)    number = (T) (Long) (long) (number.longValue()/other.longValue()); 
		if(other instanceof Float)   number = (T) (Float) (number.floatValue()/other.floatValue());
		if(other instanceof BigInteger) {
			BigInteger b1 = (BigInteger) number; 
			BigInteger b2 = (BigInteger) other;
			number = (T) b1.divide(b2);
		}
		if(other instanceof BigDecimal) {
			BigDecimal b1 = (BigDecimal) number; 
			BigDecimal b2 = (BigDecimal) other; 
			number = (T) b1.divide(b2);
		}
	}
}
