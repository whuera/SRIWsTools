package com.saap.webservice.sri;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.namespace.QName;
import javax.xml.ws.WebServiceException;

public class RecepcionComprobantesService {
	
	public static Object getWebService(String wsdlLocation) {
	    try {
	        QName qname = new QName("http://ec.gob.sri.ws.recepcion", "RecepcionComprobantesService");
	        URL url = new URL(wsdlLocation);
	      //  RecepcionComprobantesService service = new RecepcionComprobantesService(url, qname);
	        return null;
	    } catch (MalformedURLException ex) {
	        return ex;
	    } catch (WebServiceException ws) {
	        return ws;
	    }
	}
	
	public static boolean existeConexion(String url) {
	    int i = 0;
	    boolean respuesta = false;
	    while (i < 3) {
	        Object obj = getWebService(url);
	        if (obj  == null) {
	            return true;
	        }
	        if ((obj  instanceof WebServiceException)) {
	            respuesta = false;
	        }
	        i++;
	    }
	    return respuesta;
	}
	
	public boolean testConnectionWebservice(String wsURL) throws IOException{
		// Create SOAP Connection
		//String wsURL = "https://celcer.sri.gob.ec/comprobantes-electronicos-ws/RecepcionComprobantes?wsdl";

		try {
			URL url = new URL(wsURL);
			URLConnection connection = url.openConnection();
			connection.connect();
			HttpURLConnection httpConn = (HttpURLConnection)connection;
			System.out.println(connection.toString());
			return true;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		catch(Exception e2){			
			System.out.println(e2.getMessage().toString());
			return false;
		}
		
	}
	
	public static void main(String[] args)
	{
		//System.out.println(existeConexion("https://celcer.sri.gob.ec/comprobantes-electronicos-ws/RecepcionComprobantes?wsdl"));
		RecepcionComprobantesService service = new RecepcionComprobantesService();
		try{
			//String wsUrl = "http://127.0.0.1:7101/Client/VisitantesPort?wsdl";
			String wsUrl ="https://celcer.sri.gob.ec/comprobantes-electronicos-ws/RecepcionComprobantes?wsdl";
		System.out.println("Test: "+service.testConnectionWebservice(wsUrl));
		}catch(IOException e)
		{
			e.getStackTrace();
		}
	}

}


