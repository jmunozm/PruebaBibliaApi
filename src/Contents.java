import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class Contents {
	public static void main(String[] args) {
		//String url = "https://api.biblia.com/v1/bible/contents/RVR60?key=fd37d8f28e95d3be8cb4fbc37e15e18e";
		Scanner fileIn = null;
		String respuesta = "";
		try {
			//respuesta = peticionHttpGet(url);
			
			fileIn = new Scanner(new FileReader("resources/json/RVR60.json"));
			
			while(fileIn.hasNextLine()){
				respuesta = fileIn.nextLine();
			}			
			
			Gson gson = new Gson();
			Libros libros = gson.fromJson(respuesta, (Libros.class));

	        for (Libro libro : libros.getBooks()) {
	            System.out.println(libro.passage);
	            for(JsonElement capitulo : libro.getChapters()){
	            	JsonObject gsonObj = capitulo.getAsJsonObject();
	            	System.out.println(gsonObj.get("passage").getAsString());
	            }
	            System.out.println();
	        }
	        	        
			//System.out.println("La respuesta es:\n" + respuesta);
		} catch (Exception e) {
			// Manejar excepci�n
			e.printStackTrace();
		}
	}

	public static String peticionHttpGet(String urlParaVisitar) throws Exception {
		// Esto es lo que vamos a devolver
		StringBuilder resultado = new StringBuilder();
		// Crear un objeto de tipo URL
		URL url = new URL(urlParaVisitar);

		// Abrir la conexi�n e indicar que ser� de tipo GET
		HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
		conexion.setRequestMethod("GET");
		// B�feres para leer
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
