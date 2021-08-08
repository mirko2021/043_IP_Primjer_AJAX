package yatospace.app.object;

/**
 * Pair. 
 * @author MV
 * @version 1.0
 */
public class Pair<T extends Number> extends Number{
	private static final long serialVersionUID = 8086195471690687211L;
	private T real; 
	private T imaginary;
	
	public Pair(T a, T b){
		if(a==null) throw new NullPointerException(); 
		if(b==null) throw new NullPointerException(); 
		real      = a; 
		imaginary = b;  
	}
	
	public T getReal() {
		return real;
	}
	
	public void setReal(T real) {
		if(real==null) throw new NullPointerException(); 
		this.real = real;
	}
	
	public T getImaginary() {
		return imaginary;
	}
	
	public void setImaginary(T imaginary) {
		if(imaginary==null) throw new NullPointerException();
		this.imaginary = imaginary;
	}
	
	public double effective() {
		double d1 = (double) real; 
		double d2 = (double) imaginary; 
		return Math.sqrt(Math.pow(d1, d1)+Math.pow(d2, d2)); 
	}

	@Override
	public int intValue() {
		return (int) effective();
	}

	@Override
	public long longValue() {
		return (long) effective();
	}

	@Override
	public float floatValue() {
		return (float) effective();
	}

	@Override
	public double doubleValue() {
		return (double) effective();
	}
	
	@Override 
	public Pair<T> clone(){
		Pair<T> pair = new Pair<>(real, imaginary);
		return pair;
	}
}
