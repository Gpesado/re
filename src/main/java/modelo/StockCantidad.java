package modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StockCantidad {
	
	Map<Ingrediente,Cantidad> stock;
	

	public StockCantidad() {
		
		stock = new HashMap<Ingrediente,Cantidad>();
		
	}
	
	public void addStock(Ingrediente arg0, Cantidad arg1) {
		if(stock.containsKey(arg0))RemovedorRepetido.addRepetido(arg0);
		
		else{
			stock.put(arg0, arg1);
		}
		
	}
	
	public Cantidad getCantidad(Ingrediente arg0) {
		
		return stock.get(arg0);
	}
	
	public ArrayList<Ingrediente> getIngredientes() {
		
		stock = RemovedorRepetido.removeRepetido(stock);
		
		ArrayList<Ingrediente> ret = new ArrayList<Ingrediente>();
		
		for(Map.Entry<Ingrediente, Cantidad> entry : stock.entrySet()) {
			ret.add(entry.getKey());
		}
		
		return ret;
	}
	
	
	public boolean isEmpty() {
		return stock.isEmpty();
	}
	
	public boolean contains(Ingrediente arg0) {
		return stock.containsKey(arg0);
	}
	
}
