import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import junit.framework.Assert;
import modelo.Cantidad;
import modelo.DataColector;
import modelo.IdentyMap;
import modelo.Ingrediente;
import modelo.Medicion;
import modelo.Plato;
import modelo.StockCantidad;

public class DataColectorTest {

	@SuppressWarnings("deprecation")
	@Test
	public void test() {
		DataColector data= new DataColector();
		StockCantidad a = new StockCantidad ();
		a = data.getStockIngredientes();
	
		assertEquals(false, a.isEmpty());
		 
	}
	
	
	@SuppressWarnings("deprecation")
	@Test
	public void test2() { 
		DataColector data= new DataColector();
		StockCantidad a = new StockCantidad ();
		a = data.getStockIngredientes();
	    ArrayList<Ingrediente> b = a.getIngredientes();
	    
	    for(Ingrediente c: b) {
	    	System.out.println( c.getNombre());
	    }
		
		
		assertEquals("papa", b.get(2).getNombre());
		 
	}
	
	
	@Test
	public void test3() { 
		DataColector data= new DataColector();
		StockCantidad a = new StockCantidad ();
		a = data.getStockIngredientes();
	    
		ArrayList<Ingrediente> b = a.getIngredientes();
		System.out.println(b.get(0).getNombre() + data.getCantidad(b.get(0)).getValor() );
		Cantidad c= new Cantidad (Medicion.Kg,5.5);
	    
		
		assertEquals(c, data.getCantidad(b.get(0)));
		assertFalse(c.equals(data.getCantidad(b.get(1))) );
		
		
		  
	}
	
	

}