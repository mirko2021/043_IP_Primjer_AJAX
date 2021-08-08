package yatospace.app.model;

import java.io.Serializable;

/**
 * Оквир који обиљежава пројеве који имају операцитивност према 
 * свом скупу, махом садржај им мора бити број. 
 * @author MV
 * @version 1.0
 */
public interface Numerable<T extends Number> extends Serializable{
	public T getContetnt(); 
	public void add(T other); 
	public void subtract(T other);
	public void multiplty(T other); 
	public void divide(T other);
}
