import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class encryption_dcryption {

    public static String encrypt(String message, Map<Character, Integer> key) {
        StringBuilder encryptedCode = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            if (key.containsKey(c)) {
                encryptedCode.append(key.get(c)).append(" ");
            }
        }
        return encryptedCode.toString().trim();
    }

    public static String decrypt(String code, Map<Integer, Character> key) {
        StringBuilder decryptedMessage = new StringBuilder();
        String[] codes = code.split(" ");
        for (String s : codes) {
            int encryptedValue = Integer.parseInt(s);
            if (key.containsKey(encryptedValue)) {
                decryptedMessage.append(key.get(encryptedValue));
            }
        }
        return decryptedMessage.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Map<Character, Integer> hashTable = new HashMap<>();
        hashTable.put('a', 21);
        hashTable.put('b', 23);
        hashTable.put('c', 36);
        hashTable.put('d', 44);
        hashTable.put('e', 58);
        hashTable.put('f', 66);
        hashTable.put('g', 77);
        hashTable.put('h', 83);
        hashTable.put('i', 9);
        hashTable.put('j', 11);
        hashTable.put('k', 19);
        hashTable.put('l', 12);
        hashTable.put('m', 8);
        hashTable.put('n', 14);
        hashTable.put('o', 15);
        hashTable.put('p', 26);
        hashTable.put('q', 37);
        hashTable.put('r', 8);
        hashTable.put('s', 16);
        hashTable.put('t', 3);
        hashTable.put('u', 1);
        hashTable.put('v', 5);
        hashTable.put('w', 31);
        hashTable.put('x', 28);
        hashTable.put('y', 25);
        hashTable.put('z', 29);
        
        Map<Integer, Character> decryptionKey = new HashMap<>();
        for (Map.Entry<Character, Integer> entry : hashTable.entrySet()) {
            decryptionKey.put(entry.getValue(), entry.getKey());
        }
        
        System.out.print("Enter Your Message: ");
        String message = scanner.nextLine().toLowerCase();

        String encryptedCode = encrypt(message, hashTable);
        System.out.println("Your Encrypted Code is: " + encryptedCode);

        System.out.print("Enter Your Encrypted Code: ");
        String code = scanner.nextLine();

        String decryptedMessage = decrypt(code, decryptionKey);
        System.out.println("Decrypted message is: " + decryptedMessage);
    }
}
