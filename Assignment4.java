
import java.util.Random;
import java.util.Scanner;

public class Assignment4 {

    static int[] key = new int[16];

    // Generate secret key
    static void generateKey() {
        Random random = new Random();

        for (int i = 0; i < key.length; i++) {
            key[i] = random.nextInt(256);
        }
    }

    // Encryption
    static String encrypt(String message) {

        byte[] data = message.getBytes();
        StringBuilder encrypted = new StringBuilder();

        for (int i = 0; i < data.length; i++) {

            int value = data[i] & 255;

            // XOR operation
            value = value ^ key[i % key.length];

            // Position transformation
            value = (value + i) % 256;

            encrypted.append(String.format("%02X", value));
        }

        return encrypted.toString();
    }

    // Decryption
    static String decrypt(String ciphertext) {

        StringBuilder decrypted = new StringBuilder();

        for (int i = 0; i < ciphertext.length(); i += 2) {

            int value = Integer.parseInt(
                ciphertext.substring(i, i + 2), 16
            );

            // Reverse position transformation
            value = (value - (i / 2) + 256) % 256;

            // Reverse XOR operation
            value = value ^ key[(i / 2) % key.length];

            decrypted.append((char) value);
        }

        return decrypted.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        generateKey();

        System.out.print("Enter plaintext: ");
        String message = sc.nextLine();

        String ciphertext = encrypt(message);

        System.out.println("\nEncrypted: " + ciphertext);

        String original = decrypt(ciphertext);

        System.out.println("Decrypted: " + original);

        if (message.equals(original)) {
            System.out.println("Verification: Successful");
        } else {
            System.out.println("Verification: Failed");
        }

        sc.close();
    }
}
