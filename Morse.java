package codigomorse;

public class Morse {
	
	private static final String[] code = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", 
			".-..", "--","-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
	
	private static final String[] digits = {"-----", ".----", "..---", "...--", 
			"....-", ".....",  "-....", "--...", "---..", "----."};
	
	public static String toMorse(String message) {
		int index = 0;
		String morseCode = "";
		
		message = message.toLowerCase().replaceAll("[^a-z\\s\\d]", "");
		String[] words = message.split("\\s+");
		
		for(int word = 0; word < words.length; word++) {
			for(int letter = 0; letter < words[word].length(); letter++) {
				
				if(Character.isDigit(words[word].charAt(letter))) {
					index = (int) words[word].charAt(letter) - '0';
					morseCode = morseCode.concat(digits[index] + " ");
				}
				else {
					index = ((int) words[word].charAt(letter)) - 97;
					morseCode = morseCode.concat(code[index] + " ");
				}
			}
			
			morseCode = morseCode.concat((word == words.length - 1) ? "" : "/ ");
		}
		
		return morseCode;
	}
	
	public static String toEnglish(String morseCode) {
		char character;
		String message = "";
		
		morseCode = morseCode.replaceAll("[^.\\-/\\s]", "");
		String[] letters = morseCode.split("\\s+");
		
		for(int letter = 0; letter < letters.length; letter++) {
			
			character = letters[letter].charAt(0);
			if(character == '/') {
				message = message.concat(" ");
				continue;
			}
			
			for(int c = 0; c < code.length; c++) {
				if(letters[letter].equals(code[c])) {
					character = (char) (c + 97);
					message = message.concat(Character.toString(character));
					break;
				}
			}
			
			for(int c = 0; c < digits.length; c++) {
				if(letters[letter].equals(digits[c])) {
					character = (char) (c + 48);
					message = message.concat(Character.toString(character));
					break;
				}
			}
		}
		
		return message;
	}
}
