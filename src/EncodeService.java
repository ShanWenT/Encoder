import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class EncodeService implements Encoder {

	@Override
	public String encode(String plainText) {
//		List<Character> referenceTableList = new ArrayList(Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
//				'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3',
//				'4', '5', '6', '7', '8', '9', '(', ')', '*', '+', ',', '-', '.', '/'));
		
		referenceTableList rtl = new referenceTableList();
		List<Character> referenceTableList = rtl.getReferenceTableList();
		
//		HashMap<Integer, Character> referenceTable = new HashMap<>();
		
		HashMap<Integer, Character> referenceTable = rtl.getReferenceTable();
		
		int index = 0;

		StringBuilder encodeText = new StringBuilder();
		List<Integer> encodeKeys = new ArrayList<Integer>();
		Character offSetChar;
		Integer offSetInt;
		Scanner sc = new Scanner(System.in);

		for (Character values : referenceTableList) {
			referenceTable.put(index, values);
			index++;
		}

		System.out.println("Enter offset :");
		String offset = sc.next().toUpperCase();

		if (offset.length() == 1) {
			offSetChar = offset.charAt(0);
//			System.out.println(offSetChar);
			encodeText.insert(0, offSetChar);
//			System.out.println(encodeText.toString());
			offSetInt = referenceTableList.indexOf(offSetChar);
//			System.out.println(offSetInt);
		} else
			return "Invalid OffSet";

		for (int i = 0; i < plainText.length(); i++) {
			encodeKeys.add(i, referenceTableList.indexOf(plainText.charAt(i)));
//			System.out.println(encodeKeys);
		}

		for (int j = 1; j <= encodeKeys.size(); j++) {

//			System.out.println(encodeKeys.get(j-1));

			if (encodeKeys.get(j - 1) == -1)
				encodeText.insert(j, " ");
			else if (encodeKeys.get(j - 1) - offSetInt < 0)
				encodeText.insert(j,
						referenceTableList.get(encodeKeys.get(j - 1) - offSetInt + referenceTableList.size()));

			else
				encodeText.insert(j, referenceTableList.get(encodeKeys.get(j - 1) - offSetInt));
		}

		return encodeText.toString();
	}

}
