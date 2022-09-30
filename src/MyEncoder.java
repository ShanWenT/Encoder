import java.util.Scanner;

public class MyEncoder {

	public static void main(String[] args) {
		

		Scanner sc= new Scanner(System.in);
		String plainText="";
		String encodedText="";
		String decodedText="";
		System.out.println("Enter input text :");
		plainText = sc.nextLine().toUpperCase();
		
		
		Encoder encode = new EncodeService();
		Decoder decode = new DecodeService();
		
		encodedText = encode.encode(plainText);
		if(Table.invalidOffset) {
			System.out.println(encodedText);
			sc.close();
			return;
		}
			
		decodedText = decode.decode(encodedText);
		System.out.print("Encoded Text: ");
		System.out.println(encodedText);
		System.out.print("Decoded Text: ");
		System.out.println(decodedText);
		
		sc.close();
		
		
		
		
		
	}

}
