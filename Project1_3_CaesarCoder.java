import java.util.*;

public class Project1_3_CaesarCoder {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		String plainKey = "a b c d e f g h i j k l m n o p q r s t u v w x y z";
		String plainText[] = plainKey.split(" ");
		String cipherKey = "b c d e f g h i j k l m n o p q r s t u v w x y z a";
		String cipher[] = cipherKey.split(" "); 
		
		while (true) {
			System.out.println("Would you like to encode or decode?");
			String answer = keyboard.nextLine();
			
			if(answer.equalsIgnoreCase("encode")) {
				encrypt(keyboard, plainText, cipher);
			} else if(answer.equalsIgnoreCase("decode")) {
				decrypt(keyboard, plainText, cipher);
			} else {
				System.out.println("See ya!");
				break;
			}
			
			System.out.println("");
			System.out.println("");
		}
			
//		for (int i = 0; i < cipher.length; i++) {
//			System.out.println(plainText[i]);
//		}
//		System.out.println(cipher.length);

	}

	// Encryption Logic
	private static void encrypt(Scanner keyboard, String[] plainText, String[] cipher) {
		System.out.println("Plain Text:");
		String userInput = keyboard.nextLine();
		String userInputArray[] = userInput.split("");

		System.out.println("");
		System.out.println("Cipher Text:");

		for (int i = 0; i < userInputArray.length; i++) {
			String letter = userInputArray[i];
			String newLetter;
			int position = findIndex(plainText, letter);
			if (position == -1) {
				newLetter = letter;
			} else {
				newLetter = cipher[position];
			}
			System.out.print(newLetter);
		}
	}
	
	// Decryption Logic
	private static void decrypt(Scanner keyboard, String[] plainText, String[] cipher) {
		System.out.println("Cipher Text:");
		String userInput = keyboard.nextLine();
		String userInputArray[] = userInput.split("");

		System.out.println("");
		System.out.println("Plain Text:");

		for (int i = 0; i < userInputArray.length; i++) {
			String letter = userInputArray[i];
			String newLetter;
			int position = findIndex(cipher, letter);
			if (position == -1) {
				newLetter = letter;
			} else {
				newLetter = plainText[position];
			}
			System.out.print(newLetter);
		}
	}

	// Linear-search function to find the index of an element
    public static int findIndex(String array[], String letter)
    {
  
        // if array is Null
        if (array == null) {
            return -1;
        }
  
        // find length of array
        int arrayLength = array.length;
        int i = 0;
  
        // traverse in the array
        while (i < arrayLength) {
        	
            // if the i-th element is letter
            // then return the index
            if (array[i].equalsIgnoreCase(letter)) {
                return i;
            }
            else {
                i = i + 1;
            }
        }
        return -1;
    }
	
}
