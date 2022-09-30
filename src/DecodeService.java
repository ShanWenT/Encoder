import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DecodeService implements Decoder {

	@Override
	public String decode(String encodedText) {

		Table rtl = new Table();
		List<Character> referenceTableList = rtl.getReferenceTableList();
		HashMap<Integer, Character> referenceTable = rtl.getReferenceTable();
		List<Integer> decodeKeys = new ArrayList<Integer>();

		int index = 0;

		Integer offSetInt;
		StringBuilder decodeText = new StringBuilder();
		

		for (Character values : referenceTableList) {
			referenceTable.put(index, values);
			index++;
		}

		offSetInt = referenceTableList.indexOf(encodedText.charAt(0));

		for (int i = 1; i < encodedText.length(); i++) {
			decodeKeys.add(i - 1, referenceTableList.indexOf(encodedText.charAt(i)));
//			System.out.println(decodeKeys);
		}

		for (int j = 0; j < decodeKeys.size(); j++) {

			if (decodeKeys.get(j) == -1)
				decodeText.insert(j, " ");
			else if (decodeKeys.get(j) + offSetInt >= referenceTableList.size())
				decodeText.insert(j, referenceTableList.get(decodeKeys.get(j) + offSetInt - referenceTableList.size()));

			else
				decodeText.insert(j, referenceTableList.get(decodeKeys.get(j) + offSetInt));
//			System.out.println(decodeText);
		}

		return decodeText.toString();

	}

}
