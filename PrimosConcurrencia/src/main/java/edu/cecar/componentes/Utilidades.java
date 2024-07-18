/**
 * Class: Utilidades.java
 * 
 * @since 5/07/2024
 * @version 0.1
 * @author Ing. Jhon Jaime Mendez
 * @copyrigth JASOFT
 **/


package edu.cecar.componentes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Clase Utilidades
 */

public class Utilidades {

	private Utilidades() {
		throw new IllegalStateException("Clase de Utilidades");
	}
	
	/**
	 * 
	 * @return -1 : No recupero exitosamente el numero de procesadores
	 *         >0 : Numero de procesadores
	 */
	public static int getNumberProcessor() {
		
		int numberProcess = -1;
		
		try {
		
			String command = "systeminfo";
			Process process = Runtime.getRuntime().exec(command);
			process.waitFor();

			
			BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
			StringBuffer result = new StringBuffer();
			String line = null;
			while((line = in.readLine()) != null)
				result.append(line+"\n");
			
			
			String lineProcessor = getMatcher(result.toString(),"(Procesador|Processor)\\s*(?-s).*");
			String numberProcessorText = lineProcessor == null ? null : getMatcher(lineProcessor,"\\d+");
			
			numberProcess = Integer.parseInt(numberProcessorText);
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		return numberProcess;
		
	}
	
	
	public static int getNumberCores() {
		
		return Runtime.getRuntime().availableProcessors();
	}
	
	
	public static String getMatcher(String texto, String regex) {
		
		Matcher matcher = Pattern.compile(regex).matcher(texto);
		return matcher.find() ? matcher.group() : null ;
		
	}
	
	public static void createPathWithNameFromText(String path, String text) throws IOException {
		
		Files.write(Paths.get(path), text.getBytes());
		
	}
	
}
