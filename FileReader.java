/*Universidad del Valle de Guatemala
 * Algoritmos y Programacion Basica, seccion 20
 * Fecha de entrega: 09/04/2022
 * @author:Andrea Ximena Ramirez Recinos 21874
 * 
 * Programa que simula un diccionario, aplicacion de BST
 * Clase para leer archivos
 * 
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {
	ArrayList<String> Lines = new ArrayList<String>();

	/**
	 * Metodo para la lectura de datos de un archivo de texto
	 * 
	 * @param fileName nombre del archivo a leer
	 * @return Strings con las lineas del archivo en un ArrayList
	 */
	public ArrayList<String> readingFile(String fileName) throws FileNotFoundException{
		Scanner scanner  = new Scanner(new File(fileName));
		while(scanner.hasNextLine()) {
			String line = scanner.nextLine();
			Lines.add(line);
		}
		return Lines;
	}
}
