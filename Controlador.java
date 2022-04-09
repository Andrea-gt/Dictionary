import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;

public class Controlador {
	private BinarySearchTree<String, String> ingles = new BinarySearchTree<String, String>(new WordComparator());
	private BinarySearchTree<String, String> frances = new BinarySearchTree<String, String>(new WordComparator());
	private FileReader fr = new FileReader();
	private ArrayList<String> lines = new ArrayList<String>();
	
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
}

