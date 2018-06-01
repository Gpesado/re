package main;

import properties.PropertiesLoader;
import propertiesTwitter.PropertiesLoaderTwitter;
import mail.MailConfig;
import mail.MailSender;
import modelo.ApiDB;
import modelo.Cantidad;
import modelo.Collector;
import modelo.ControllerInternalDB;
import modelo.Ingrediente;
import modelo.InternalDB;
import modelo.MenuCreator;
import modelo.Solver;
import modelo.Solverfetcher;
import Cache2.APICacheIngredientes;
import Cache2.Cache;
import Filter.FilterAplicator;
import Filter.GenericFilter;
import Interface.DataColectorInterface;
import Stub.ProxyIngredienteStub;
import Stub.ProxyPlatoStub;

public class InyectorDependencias 
{
	public static App crearAPP() throws InstantiationException, IllegalAccessException 
	{
		PropertiesLoader propertyData = new PropertiesLoader();
		PropertiesLoaderTwitter propertyTwitter = new PropertiesLoaderTwitter();
		
		String filtroSeleccionado = propertyData.getDataConfig().getFilter();
		FilterAplicator filterAplicator = new FilterAplicator();
		String rutaAFiltros = "Filter.";
		if (filtroSeleccionado != null)
		{
			filtroSeleccionado = rutaAFiltros + filtroSeleccionado; 
			try 
			{
				Class clazz = Class.forName(filtroSeleccionado);
				GenericFilter filter = (GenericFilter) clazz.newInstance();
				filterAplicator.addFilter(filter);
			} 
			catch (Exception e) 
			{
				System.out.println("FILTRO NO AGREGADO");
			}
		}
		
		//Creacion de cache
		Cache<Ingrediente, Cantidad> cache = new Cache<Ingrediente,Cantidad>();
		ProxyIngredienteStub stub = new ProxyIngredienteStub();
		
		int tamanoBufferCache = propertyData.getDataConfig().getCachesize();
		
		APICacheIngredientes apiCache = new APICacheIngredientes(cache, stub, tamanoBufferCache);
		
		//creacion DB interna
		InternalDB db= new InternalDB();
		ApiDB api = new ApiDB(db);
		ControllerInternalDB controller = new ControllerInternalDB(api,new ProxyPlatoStub());
		
		//creacion de Collector
		DataColectorInterface colector = new Collector(api, apiCache);
		
		//Creacion de appMail
		MailConfig mailConfig = new MailConfig();
		MailSender sender = new MailSender(mailConfig);
		
		//MenuCreator
		MenuCreator menuCreator = new MenuCreator();
		
		//Creacion de app
		App app = new App(colector,menuCreator,filterAplicator,sender);
		
		return app;
	}
}
