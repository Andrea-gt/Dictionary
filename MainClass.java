/*Universidad del Valle de Guatemala
 * Algoritmos y Programacion Basica, seccion 20
 * Fecha de entrega: 09/04/2022
 * @author:Andrea Ximena Ramirez Recinos 21874
 * 
 * Programa que simula un diccionario, aplicacion de BST
 * Clase main
 * 
 */

import java.util.Scanner;
public class MainClass {

	public static void main(String[] args) {
		Controlador ctr = new Controlador();
		boolean flag=true;
		Scanner sn = new Scanner(System.in); 

		System.out.println("Bienvenido, daremos inicio al agregado de sus palabras...");
		ctr.EstablishingWords();


		while(flag) {
			System.out.println("\n Ahora, porfavor seleccione una opcion");
			System.out.println("1. Buscar una palabra");
			System.out.println("2. Agregar una palabra");
			System.out.println("3. Modificar una palabra");
			System.out.println("4. Eliminar una palabra");
			System.out.println("5. Traducir archivo .txt");
			System.out.println("6. Salir");

			int option = sn.nextInt();
			sn.nextLine();

			switch(option) {
			case 1:
				System.out.println("Porfavor, ingrese la palabra que busca en el idioma extranjero ");
				String searchWord = sn.nextLine().toLowerCase();

				if(ctr.SearchWord(searchWord) == null) {
					System.out.println("La palabra no ha sido ingresada aun");
				}

				System.out.println("Palabra ingresada: " + searchWord +  ", en Espanol: " + ctr.SearchWord(searchWord));
				break;
				
			case 2:
				System.out.println("Porfavor, ingrese la palabra en espanol: ");
				String addWord = sn.nextLine().toLowerCase();

				System.out.println("Ahora ingrese i para agregarla en el diccionario de ingles y f para el de frances ");
				String addWordL = sn.nextLine().toLowerCase();
				
				System.out.println("Finalmente,agregue su traduccion en el idioma extranjero ");
				String addWordTrad = sn.nextLine().toLowerCase();
			
				System.out.println(ctr.addWord(addWord,addWordTrad,addWordL));
				System.out.println(ctr.getFrances());
				System.out.println(ctr.getIngles());
				
				break;
			case 3:
				System.out.println("Porfavor, ingrese la palabra a modificar en el idioma extranjero ");
				String editWord = sn.nextLine().toLowerCase();
				
				System.out.println("Ahora ingrese la palabra en espanol");
				String inSpanish = sn.nextLine().toLowerCase();
				ctr.editWord(editWord, inSpanish);
				
				break;
			case 4:
				System.out.println("Porfavor, ingrese la palabra a eliminar en el idioma extranjero ");
				String searchWordElim = sn.nextLine().toLowerCase();
				
				if(ctr.SearchWord(searchWordElim) == null) {
					System.out.println("La palabra no ha sido ingresada aun");
				}
				
				else if(ctr.SearchWord(searchWordElim) != null) {
					ctr.eliminateWord(searchWordElim);
				}
				break;
				
			case 5:
				System.out.println("Porfavor, ingrese el nombre del archivo ");
				String fileName = sn.nextLine();
				ctr.readingTxt(fileName);
				break;
			case 6:
				System.out.println("Cerrando Programa...");
				System.exit(0);
			default:
				System.out.println("Ingrese una opcion valida");
			}
		}
	}
}
