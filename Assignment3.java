import java.security.*;
import javax.crypto.Cipher;

public class Assignment3 {

    public static void main(String[] args) throws Exception {

        int[] keySizes = {1024, 2048, 3072};
        int[] messageSizes = {64, 128, 256, 384};

        for (int size : keySizes) {

            KeyPairGenerator generator =
                    KeyPairGenerator.getInstance("RSA");

            generator.initialize(size);

            long start = System.nanoTime();

            KeyPair pair = generator.generateKeyPair();

            long keyTime = System.nanoTime() - start;

            PublicKey publicKey = pair.getPublic();
            PrivateKey privateKey = pair.getPrivate();

            System.out.println("\nRSA Key Size: " + size);
            System.out.println("Key Generation Time: "
                    + keyTime / 1e6 + " ms");

            System.out.println("Message Bits | Encryption | Decryption");

            for (int bits : messageSizes) {

                byte[] message = new byte[bits / 8];

                // Encryption
                Cipher encrypt = Cipher.getInstance(
                        "RSA/ECB/PKCS1Padding");

                encrypt.init(Cipher.ENCRYPT_MODE, publicKey);

                start = System.nanoTime();

                byte[] encrypted = encrypt.doFinal(message);

                long encTime = System.nanoTime() - start;

                // Decryption
                Cipher decrypt = Cipher.getInstance(
                        "RSA/ECB/PKCS1Padding");

                decrypt.init(Cipher.DECRYPT_MODE, privateKey);

                start = System.nanoTime();

                byte[] decrypted = decrypt.doFinal(encrypted);

                long decTime = System.nanoTime() - start;

                System.out.println(bits + " bits       | "
                        + encTime / 1e6 + " ms     | "
                        + decTime / 1e6 + " ms");
            }
        }
    }
}
