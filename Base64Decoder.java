public class Base64Decoder {
	public static void main(String[] args) {
		String input = "SGFsbG8gQ2VtaWw==";
		String var1 = "";	//ASCII-Decimals
		String store = "";	//just a storage variable
		String var2 = "";	//BASIC-Decimals
		String var3 = ""; 	//BinaryBasicString
		String var4 = "";	//Binary8-Bit-Length-Parts
		String var5 = "";	//Decoded-Message
		
		//Turning the input-string into ASCII-Decimal-Values
		for (int i = 0; i != input.length() - 2; i++) {
			var1 += (int) (input.charAt(i)) + " ";
			}
		
		//Turning the ASCII-Decimal-Values into  Basic-Decimal-Values
		for (int i = 0; i != var1.length(); i++) {
			if (var1.charAt(i) != ' ') {
				store += var1.charAt(i);
				}
			else {
				int a = Integer.parseInt(store);
				if (a == 43) {
					a = 62;
					var2 += a + " ";
					}
				else if (a == 47) {
					a = 63;
					var2 += a + " ";
					}
				else if (a >= 48 && a <= 57) {
					a += 4;
					var2 += a + " ";
					}
				else if (a >= 65 && a <= 90) {
					a -= 65;
					var2 += a + " ";
					}
				else if (a >= 97 && a <= 122) {
					a -= 71;
					var2 += a + " ";
					}
				store = "";
				}
			}
		store = "";		//For secure deleting the value of storage variable
		
		//Turning Basic-Decimals into BinaryString	
		for (int i = 0; i != var2.length(); i++) {
			if (var2.charAt(i) != ' ') {
				store += var2.charAt(i);
				}
			else {
				int a = Integer.parseInt(store);
				String store2 = ""; 		//one more storage for this operation
				while (a != 0) {
					store2 += a % 2;
					a = (a - (a % 2)) / 2;
					}
				while (store2.length() != 6) {
					store2 += 0;
					}
				for (int b = store2.length(); b != 0; b--) {
					var3 += store2.charAt(b-1);
					} 
				store = "";
				}
			}
		store = ""; 		//For secure deleting the value of storage variable
		
		//Deviding String 8-Bit-Length parts
		for (int i = 0; i != var3.length(); i++) {
			if (i % 8 == 0 && i != 0) {
				var4 += " " + var3.charAt(i);
				}
			else {
				var4 += var3.charAt(i);
				}
			}
		
		//Turning in ASCII
		for (int i = 0; i != var4.length(); i++) {
			if (var4.charAt(i) != ' ') {
				store += var4.charAt(i);
				}
			else {
				var5 += (char) (Integer.parseInt(store,2));
				store = "";
			}
		}
		System.out.println("Deine Eingabe lautete: " +input);
		System.out.println("Deine Ausgabe lautet: " +var5);
	}
}

