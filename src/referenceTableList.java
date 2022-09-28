import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class referenceTableList {
	
	private List<Character> referenceTableList = new ArrayList<Character>(Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
			'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3',
			'4', '5', '6', '7', '8', '9', '(', ')', '*', '+', ',', '-', '.', '/'));
	
	private HashMap<Integer, Character> referenceTable = new HashMap<>();
	
	public static boolean invalidOffset;
		

	public List<Character> getReferenceTableList() {
		return referenceTableList;
	}

	public HashMap<Integer, Character> getReferenceTable() {
		return referenceTable;
	}



}
