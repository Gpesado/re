import org.junit.Assert;
import org.junit.Test;

import main.InyectorDependencias;
import main.Main;
public class mainTest 
{
	@Test
	public void testArmarInstancia() 
	{
		Assert.assertTrue(Main.run());
	}
}
