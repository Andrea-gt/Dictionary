import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;

public class Controlador {
	private BinarySearchTree<String, String> ingles = new BinarySearchTree<String, String>(new WordComparator());
	private BinarySearchTree<String, String> frances = new BinarySearchTree<String, String>(new WordComparator());
	private FileReader fr = new FileReader();
	private FileReader secondaryFR = new FileReader();
	private ArrayList<String> lines = new ArrayList<String>();
	private ArrayList<String> secondaryLines = new ArrayList<String>();

	public void EstablishingWords() {
		try {
			lines = fr.readingFile("diccionario.txt");
		for (int i = 0; i < lines.size(); i++){
			String [] tempArray = lines.get(i).split(",");
			ingles.insert(tempArray[0], tempArray[1]); //Ingresa el Key y Value en diccionario de ingles
			frances.insert(tempArray[2], tempArray[1]); //Ingresa el Key y Value en diccionario de frances
		}

	} catch (FileNotFoundException e) {
		System.out.println("Usted no cuenta con un archivo diccionario");
		System.exit(0);
	}
}

public String SearchWord(String key) {
	if(ingles.find(key) != null) {
		return (String) ingles.find(key);
	}

	else if(frances.find(key) != null) {
		return (String) frances.find(key);
	}
	return null;
}

public ArrayList<String> getIngles() {
	return ingles.getElements();
}

public ArrayList<String> getFrances() {
	return frances.getElements();
}

public String addWord(String addWord, String addWordTrad, String addWordL) {
	if(addWordL.equals("f")) {
		frances.insert(addWordTrad, addWord);
		return "Se ha agregado de manera exitosa la palabra " + addWord;
	}

	if(addWordL.equals("i")) {
		ingles.insert(addWordTrad, addWord);
		return "Se ha agregado de manera exitosa la palabra " + addWord;
	}

	return "Ha ocurrido un error agregando la palabra " + addWord;
}

public void editWord(String editWord, String inSpanish) {
	if(ingles.find(editWord) != null) {
		ingles.delete(editWord);
		ingles.insert(editWord, inSpanish);
		System.out.println("Editada exitosamente en el diccionario de ingles");
	}

	else if(frances.find(editWord) != null) {
		frances.delete(editWord);
		frances.insert(editWord, inSpanish);
		System.out.println("Editada exitosamente en el diccionario de frances");
	}

	else {
		System.out.println("No ha sido ingresada previamente");
	}
}

public void eliminateWord(String searchWorsElim) {
	if(ingles.find(searchWorsElim) != null) {
		ingles.delete(searchWorsElim);
		System.out.println("Eliminada exitosamente en el diccionario de ingles");
	}

	else if(frances.find(searchWorsElim) != null) {
		frances.delete(searchWorsElim);
		System.out.println("Eliminada exitosamente en el diccionario de frances");
	}	
}

public void readingTxt(){
	try {
		secondaryLines = secondaryFR.readingFile("texto.txt");
		for (int i = 0; i < secondaryLines.size(); i++){
			String [] tempArray = secondaryLines.get(i).split(" ");
			for (int j = 0; j < tempArray.length; j++){	
				if(ingles.find(tempArray[j]) != null) {
					System.out.println(ingles.find(tempArray[j]) + " ");
				}

				else if(frances.find(tempArray[j]) != null) {
					System.out.println(frances.find(tempArray[j]) + " ");
				}

				else {
					System.out.println("*" + tempArray[j] + "* ");
				}
			}
		}
	}catch (FileNotFoundException e) {
			System.out.println("Ha ocurrido un error");
		}
	}
}



