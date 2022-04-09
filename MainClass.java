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
			System.out.println("4. Traducir archivo .txt");
			System.out.println("5. Salir");

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
				
				break;
			case 4:
				break;
			case 5:
				System.out.println("Cerrando Programa...");
				System.exit(0);
			default:
				System.out.println("Ingrese una opcion valida");
			}
		}
	}
}
