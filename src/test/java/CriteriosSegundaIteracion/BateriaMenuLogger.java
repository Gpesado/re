package CriteriosSegundaIteracion;


import Etiquetado.Tagger;
import Historial.MenuRecord;
import Historial.ProxyRecordInterface;
import Historial.ProxyRecordStub;
import Historial.ProxyRecordStubVacio;
import modelo.Etiqueta;
import modelo.Ingrediente;

public class BateriaMenuLogger {
	
	public static MenuRecord MenuRecordEscenario1() {
		MenuRecord ret = new MenuRecord(3);
		return ret;
	}
	
	public static ProxyRecordInterface ProxyRecordStubEscenario1() {
		ProxyRecordInterface ret = new ProxyRecordStub();
		return ret;
	}
	
	public static MenuRecord MenuRecordEscenario2() {
		MenuRecord ret = new MenuRecord(3);
		ret.agregar(BateriaDeTest.menuPrueba1());
		ret.agregar(BateriaDeTest.menuPrueba2());
		ret.agregar(BateriaDeTest.menuPrueba3());
		return ret;
	}
	
	public static ProxyRecordInterface ProxyRecordStubEscenario3() {
		ProxyRecordInterface ret = new ProxyRecordStubVacio();
		ProxyRecordStub ret1 = new ProxyRecordStub();
		ret1.agregar(BateriaDeTest.menuPrueba3());
		ret1.agregar(BateriaDeTest.menuPrueba4());
		ret1.agregar(BateriaDeTest.menuPrueba5());
		return ret1;
	}
}
