package modelo;
import java.util.List;

public class Menu 
{
	List<Plato> platos;
	
	public Menu(List<Plato> platos)
	{
		this.platos = platos;
	}
	
	
	public List<Plato> getMenu(){
		return this.platos;
	}
	
}
