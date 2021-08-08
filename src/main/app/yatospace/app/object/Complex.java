package yatospace.app.object;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

import yatospace.app.model.Numerable;

/**
 * Complex number.
 * @author MV
 * @version 1.0
 */

public class Complex<T extends Number> implements Serializable, Numerable<Pair<T>>, Cloneable{
	private static final long serialVersionUID = -3880181473043394280L;
	private Pair<T> number;
	
	public Complex(T a, T b) {
		number = new Pair<>(a,b); 
	}
	
	@Override
	public Pair<T> getContetnt() {
		return number;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public void add(Pair<T> other) {
		T real = number.getReal(); 
		T imag = number.getImaginary(); 
		if(real instanceof Integer) {
			Integer iReal = (Integer) real + other.getReal().intValue();
			Integer iImag = (Integer) imag + other.getImaginary().intValue();
			number.setReal((T) iReal);
			number.setImaginary((T) iImag);
		}
		if(real instanceof Short) {
			Short sReal = (short)((int) real + other.getReal().intValue());
			Short sImag = (short) ((int)imag + other.getImaginary().shortValue());
			number.setReal((T) sReal);
			number.setImaginary((T) sImag);
		}
		if(real instanceof Long) {
			Long lReal = (long) real + other.getReal().longValue();
			Long lImag = (long) imag + other.getImaginary().longValue();
			number.setReal((T) lReal);
			number.setImaginary((T) lImag);
		}
		if(real instanceof Float) {
			Float fReal = (float) real + other.getReal().floatValue();
			Float fImag = (float) imag + other.getImaginary().floatValue();
			number.setReal((T) fReal);
			number.setImaginary((T) fImag);
		}
		if(real instanceof Double) {
			Double dReal = (double) real + other.getReal().doubleValue();
			Double dImag = (double) imag + other.getImaginary().doubleValue();
			number.setReal((T) dReal);
			number.setImaginary((T) dImag);
		}
		if(real instanceof BigInteger) {
			BigInteger biReal = (BigInteger) real;
			BigInteger biImag = (BigInteger) imag; 
			biReal = biReal.add((BigInteger) other.getReal()); 
			biImag = biImag.add((BigInteger) other.getImaginary()); 
			number.setReal((T) biReal);
			number.setImaginary((T) biImag);
		}
		if(real instanceof BigDecimal) {
			BigDecimal bdReal = (BigDecimal) real;
			BigDecimal bdImag = (BigDecimal) imag; 
			bdReal = bdReal.add((BigDecimal) other.getReal()); 
			bdImag = bdImag.add((BigDecimal) other.getImaginary()); 
			number.setReal((T) bdReal);
			number.setImaginary((T) bdImag);
		}
	}
	
	
	@Override
	@SuppressWarnings("unchecked")
	public void subtract(Pair<T> other) {
		T real = number.getReal(); 
		T imag = number.getImaginary(); 
		if(real instanceof Integer) {
			Integer iReal = (Integer) real - other.getReal().intValue();
			Integer iImag = (Integer) imag - other.getImaginary().intValue();
			number.setReal((T) iReal);
			number.setImaginary((T) iImag);
		}
		if(real instanceof Short) {
			Short sReal = (short)((int) real - other.getReal().intValue());
			Short sImag = (short) ((int)imag - other.getImaginary().shortValue());
			number.setReal((T) sReal);
			number.setImaginary((T) sImag);
		}
		if(real instanceof Long) {
			Long lReal = (long) real - other.getReal().longValue();
			Long lImag = (long) imag - other.getImaginary().longValue();
			number.setReal((T) lReal);
			number.setImaginary((T) lImag);
		}
		if(real instanceof Float) {
			Float fReal = (float) real - other.getReal().floatValue();
			Float fImag = (float) imag - other.getImaginary().floatValue();
			number.setReal((T) fReal);
			number.setImaginary((T) fImag);
		}
		if(real instanceof Double) {
			Double dReal = (double) real - other.getReal().doubleValue();
			Double dImag = (double) imag - other.getImaginary().doubleValue();
			number.setReal((T) dReal);
			number.setImaginary((T) dImag);
		}
		if(real instanceof BigInteger) {
			BigInteger biReal = (BigInteger) real;
			BigInteger biImag = (BigInteger) imag; 
			biReal = biReal.subtract((BigInteger) other.getReal()); 
			biImag = biImag.subtract((BigInteger) other.getImaginary()); 
			number.setReal((T) biReal);
			number.setImaginary((T) biImag);
		}
		if(real instanceof BigDecimal) {
			BigDecimal bdReal = (BigDecimal) real;
			BigDecimal bdImag = (BigDecimal) imag; 
			bdReal = bdReal.subtract((BigDecimal) other.getReal()); 
			bdImag = bdImag.subtract((BigDecimal) other.getImaginary()); 
			number.setReal((T) bdReal);
			number.setImaginary((T) bdImag);
		}
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public void multiplty(Pair<T> other) {
		T real = number.getReal(); 
		T imag = number.getImaginary(); 
		if(real instanceof Integer) {
			Integer iReal = (Integer) real * other.getReal().intValue();
			Integer iImag = (Integer) imag * other.getReal().intValue();
			iReal -= (Integer) imag * other.getImaginary().intValue();
			iImag += (Integer) real * other.getImaginary().intValue(); 
			number.setReal((T) iReal);
			number.setImaginary((T) iImag);
		}
		if(real instanceof Short) {
			Short sReal = (short)((int) real * other.getReal().shortValue());
			Short sImag = (short) ((int)imag * other.getReal().shortValue());
			sReal = (short) (sReal - (int)imag * other.getImaginary().shortValue());
			sImag = (short) (sImag + (int)real * other.getImaginary().shortValue());
			number.setReal((T) sReal);
			number.setImaginary((T) sImag);
		}
		if(real instanceof Long) {
			Long lReal = (long) real * other.getReal().longValue();
			Long lImag = (long) imag * other.getReal().longValue();
			lReal -= (long) imag * other.getImaginary().longValue();
			lImag += (long) real * other.getImaginary().longValue();
			number.setReal((T) lReal);
			number.setImaginary((T) lImag);
		}
		if(real instanceof Float) {
			Float fReal = (float) real * other.getReal().floatValue();
			Float fImag = (float) imag * other.getReal().floatValue();
			fReal -= (float) imag * other.getImaginary().floatValue();
			fImag += (float) real * other.getImaginary().floatValue();
			number.setReal((T) fReal);
			number.setImaginary((T) fImag);
		}
		if(real instanceof Double) {
			Double dReal = (double) real * other.getReal().doubleValue();
			Double dImag = (double) imag * other.getReal().doubleValue();
			dReal -= (double) imag * other.getImaginary().doubleValue();
			dImag += (double) real * other.getImaginary().doubleValue();
			number.setReal((T) dReal);
			number.setImaginary((T) dImag);
		}
		if(real instanceof BigInteger) {
			BigInteger biReal = (BigInteger) real;
			BigInteger biImag = (BigInteger) imag; 
			biReal = biReal.multiply((BigInteger) other.getReal()); 
			biImag = biImag.multiply((BigInteger) other.getReal()); 
			BigInteger biRealPart = biImag.multiply((BigInteger) other.getImaginary()); 
			BigInteger biImagPart = biReal.multiply((BigInteger) other.getImaginary());
			biReal = biReal.subtract(biImagPart); 
			biImag = biReal.add(biRealPart);
			number.setReal((T) biReal);
			number.setImaginary((T) biImag);
		}
		if(real instanceof BigDecimal) {
			BigDecimal bdReal = (BigDecimal) real;
			BigDecimal bdImag = (BigDecimal) imag; 
			bdReal = bdReal.multiply((BigDecimal) other.getReal()); 
			bdImag = bdImag.multiply((BigDecimal) other.getReal());
			
			BigDecimal bdRealPart = bdImag.multiply((BigDecimal) other.getImaginary()); 
			BigDecimal bdImagPart = bdReal.multiply((BigDecimal) other.getImaginary());
			
			bdReal = bdReal.subtract(bdImagPart); 
			bdImag = bdReal.add(bdRealPart);
			number.setReal((T) bdReal);
			number.setImaginary((T) bdImag);
		}
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public void divide(Pair<T> other) {
		T real = number.getReal(); 
		T imag = number.getImaginary(); 
		if(real instanceof Integer) {
			Integer iReal = (Integer) real * other.getReal().intValue();
			Integer iImag = (Integer) imag * other.getReal().intValue();
			iReal += (Integer) imag * other.getImaginary().intValue();
			iImag -= (Integer) real * other.getImaginary().intValue(); 
			Integer iDiv = other.getReal().intValue() * other.getReal().intValue() 
					     + other.getImaginary().intValue() * other.getImaginary().intValue();
			iReal /= iDiv;
			iImag /= iDiv;
			number.setReal((T) iReal);
			number.setImaginary((T) iImag);
		}
		if(real instanceof Short) {
			Short sReal = (short) ((int) real * other.getReal().shortValue());
			Short sImag = (short) ((int)imag * other.getReal().shortValue());
			sReal = (short) (sReal + (int)imag * other.getImaginary().shortValue());
			sImag = (short) (sImag - (int)real * other.getImaginary().shortValue());
			Short sDiv = (Short)(short)
					((other.getReal().shortValue())
					* (other.getReal().shortValue())
					+ (other.getImaginary().shortValue())
					* (other.getImaginary().shortValue()));
			sReal = (short)((int)sReal/(int)sDiv); 
			sImag = (short)((int)sImag/(int)sDiv); 
			number.setReal((T) sReal);
			number.setImaginary((T) sImag);
		}
		if(real instanceof Long) {
			Long lReal = (long) real * other.getReal().longValue();
			Long lImag = (long) imag * other.getReal().longValue();
			lReal += (long) imag * other.getImaginary().longValue();
			lImag -= (long) real * other.getImaginary().longValue();
			Long lDiv = other.getReal().longValue()* other.getReal().longValue() 
					  + other.getImaginary().longValue()* other.getImaginary().longValue();
			lReal/=lDiv; 
			lImag/=lDiv; 
			number.setReal((T) lReal);
			number.setImaginary((T) lImag);
		}
		if(real instanceof Float) {
			Float fReal = (float) real * other.getReal().floatValue();
			Float fImag = (float) imag * other.getReal().floatValue();
			fReal += (float) imag * other.getImaginary().floatValue();
			fImag -= (float) real * other.getImaginary().floatValue();
			Float fDiv = other.getReal().floatValue() * other.getReal().floatValue() 
					   + other.getImaginary().floatValue() * other.getImaginary().floatValue();
			fReal /= fDiv;
			fImag /= fDiv;
			number.setReal((T) fReal);
			number.setImaginary((T) fImag);
		}
		if(real instanceof Double) {
			Double dReal = (double) real * other.getReal().doubleValue();
			Double dImag = (double) imag * other.getReal().doubleValue();
			dReal += (double) imag * other.getImaginary().doubleValue();
			dImag -= (double) real * other.getImaginary().doubleValue();
			Double dDiv = other.getReal().doubleValue() * other.getReal().doubleValue()
					    + other.getImaginary().doubleValue() * other.getImaginary().doubleValue();
			dReal /= dDiv;
			dImag /= dDiv; 
			
			number.setReal((T) dReal);
			number.setImaginary((T) dImag);
		}
		if(real instanceof BigInteger) {
			BigInteger biReal = (BigInteger) real;
			BigInteger biImag = (BigInteger) imag; 
			BigInteger biRealZ = biReal.multiply((BigInteger) other.getReal());
			BigInteger biImagZ = biImag.multiply((BigInteger) other.getReal());
			BigInteger biRealPart = biImag.multiply((BigInteger) other.getImaginary());
			BigInteger biImagPart = biReal.multiply((BigInteger) other.getImaginary());
			BigInteger biDivA = ((BigInteger) other.getReal()).multiply((BigInteger) other.getReal()); 
			BigInteger biDivB = ((BigInteger) other.getImaginary()).multiply((BigInteger) other.getImaginary());
			BigInteger biDiv = biDivA.add(biDivB);
			biReal = biRealZ.add(biRealPart); 
			biImag = biImagZ.subtract(biImagPart);
			biReal = biReal.divide(biDiv);
			biImag = biImag.divide(biDiv);
			number.setReal((T) biReal);
			number.setImaginary((T) biImag);
		}
		if(real instanceof BigDecimal) {
			BigDecimal bdReal = (BigDecimal) real;
			BigDecimal bdImag = (BigDecimal) imag; 
			BigDecimal bdRealZ = bdReal.multiply((BigDecimal) other.getReal());
			BigDecimal bdImagZ = bdImag.multiply((BigDecimal) other.getReal()); 
			BigDecimal bdRealPart = bdImag.multiply((BigDecimal) other.getImaginary()); 
			BigDecimal bdImagPart = bdReal.multiply((BigDecimal) other.getImaginary());
			BigDecimal bdDivA = ((BigDecimal) other.getReal()).multiply((BigDecimal) other.getReal()); 
			BigDecimal bdDivB = ((BigDecimal) other.getImaginary()).multiply((BigDecimal) other.getImaginary());
			BigDecimal bdDiv = bdDivA.add(bdDivB); 
			bdReal = bdRealZ.add(bdRealPart);
			bdImag = bdImagZ.subtract(bdImagPart);
			bdReal = bdReal.divide(bdDiv);
			bdImag = bdImag.divide(bdDiv);
			number.setReal((T) bdReal);
			number.setImaginary((T) bdImag);
		}
	}
	
	@Override
	public Complex<T> clone() {
		Complex<T> cp = new Complex<T>(number.getReal(), number.getImaginary());
		cp.number = number.clone();
		return cp;
	}
}
