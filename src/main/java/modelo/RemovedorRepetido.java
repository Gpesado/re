package modelo;

import java.util.ArrayList;
import java.util.Map;

public class RemovedorRepetido {
	
	private static ArrayList<Ingrediente> toDelete=new ArrayList<Ingrediente>();
	
	/*public RemovedorRepetido(){
		toDelete=new ArrayList<Ingrediente>();
		
	}*/
	
	public static void addRepetido(Ingrediente arg0) {
		if(!(toDelete.contains(arg0))) toDelete.add(arg0);
	} 
	
	public static Map<Ingrediente,Cantidad> removeRepetido(Map<Ingrediente,Cantidad> arg0) {
		System.out.println(" removedor "+toDelete.size());
		Map<Ingrediente,Cantidad> ret = arg0;
		for(Ingrediente ing: toDelete) {
			ret.remove(ing);
		}
		return ret;
	}

}