import java.util.Comparator;

/*Universidad del Valle de Guatemala
 * Algoritmos y Programacion Basica, seccion 20
 * Fecha de entrega: 09/04/2022
 * @author:Andrea Ximena Ramirez Recinos 21874
 * 
 * Programa que simula un diccionario, aplicacion de BST
 * Clase para comparar palabras
 * 
 */
public class WordComparator implements Comparator<String> {
	@Override
	public int compare(String o1, String o2) {
		return o1.compareTo(o2);
	}
}
