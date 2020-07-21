import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import jarroba.FootballPlayer;

public class Prueba1 {
	public static void main(String[] args) {
		//String url = "https://api.biblia.com/v1/bible/find.txt?key=fd37d8f28e95d3be8cb4fbc37e15e18e";
		Scanner fileIn = null;
		String respuesta = "";
		try {
			//respuesta = peticionHttpGet(url);
			
			fileIn = new Scanner(new FileReader("resources/json/find.json"));
			
			while(fileIn.hasNextLine()){
				respuesta = fileIn.nextLine();
			}
			
			Gson gson = new Gson();
	        Biblias biblias = gson.fromJson(respuesta, Biblias.class);

	        for (Biblia biblia : biblias.bibles) {
	            System.out.println(biblia.bible);
	            System.out.println(biblia.title);
	            System.out.println(biblia.getDescription());
	            System.out.println();
	        }
//			
//			JsonParser parser = new JsonParser();
//			// Obtain Array
//	        JsonArray gsonArr = parser.parse(respuesta).getAsJsonArray();
//	        // for each element of array
//	        for (JsonElement obj : gsonArr) {
//
//	            // Object of array
//	            JsonObject gsonObj = obj.getAsJsonObject();
//
//	            // Primitives elements of object
//	            String bible = gsonObj.get("bible").getAsString();
//	            String title = gsonObj.get("title").getAsString();
//	            String description = gsonObj.get("description").getAsString();
//
//	            // List of primitive elements
//	           // JsonArray demarcation = gsonObj.get("demarcation").getAsJsonArray();
////	            List listDemarcation = new ArrayList();
////	            for (JsonElement demarc : demarcation) {
////	                listDemarcation.add(demarc.getAsString());
////	            }
//
////	            // Object Constructor
////	            Biblia biblia = new Biblia();
////	            biblia.setBiblia(bible);
////	            biblia.setTitulo(title);
////	            biblia.setDescripcion(description);
//	            
////	            System.out.println(biblia);
//	        }
	        
	        
			//System.out.println("La respuesta es:\n" + respuesta);
		} catch (Exception e) {
			// Manejar excepción
			e.printStackTrace();
		}
	}

	public static String peticionHttpGet(String urlParaVisitar) throws Exception {
		// Esto es lo que vamos a devolver
		StringBuilder resultado = new StringBuilder();
		// Crear un objeto de tipo URL
		URL url = new URL(urlParaVisitar);

		// Abrir la conexión e indicar que será de tipo GET
		HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
		conexion.setRequestMethod("GET");
		// Búferes para leer
		BufferedReader rd = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
		String linea;
		// Mientras el BufferedReader se pueda leer, agregar contenido a resultado
		while ((linea = rd.readLine()) != null) {
			resultado.append(linea);
		}
		// Cerrar el BufferedReader
		rd.close();
		// Regresar resultado, pero como cadena, no como StringBuilder
		return resultado.toString();
	}
}
