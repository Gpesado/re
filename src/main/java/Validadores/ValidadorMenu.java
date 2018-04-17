package Validadores;
import java.util.Map;

import modelo.Cantidad;
import modelo.Ingrediente;
import modelo.Menu;
import modelo.Plato;

public class ValidadorMenu {

	public static Menu SacaRepetido(Menu menu) {
		Menu ret = new Menu();
		
		for(Map.Entry<Plato, Integer> entry: menu.getPlatos().entrySet()) {
			if(!(ret.getPlatos().containsKey(entry.getKey())) && entry.getValue()>=0){
				ret.getPlatos().put(entry.getKey(), entry.getValue());
			}	
		}
		return ret;
	}
}