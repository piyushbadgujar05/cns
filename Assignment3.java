import java.security.*;
import javax.crypto.Cipher;

public class Assignment3{
    public static void main(String[] args){
        int keySizes={1024,2048,3072};
        int messageSizes={64,126,256,384};

        for(int size: keySizes){
            KeyPairGenerator generator=KeyPairGenerator.getInstance("RSA");
            generator.initialize(size);

            long start=System.nonoTime();
            keyPair pair=generator.generateKeyPair();
            long keyTime=System.nonoTime()-start;

            PublicKey publicKey=pair.getPublic();
            PrivateKey privateKey=pair.getPrivate();

            System.out.println("\nRSA key Size: "+size);
            System.out.println("Key Generation time: "+keyTime/1e6+" ms");
            System.out.println("Message Bits | Encryption | Decryption");
            for(int bits:messageSizes){
                byte[] message=new byte[bits/8];
                Cipher encrypt=Cipher.getInstance("RSA/ECB/PKCS1Padding");
                encrypt.init(Cipher.ENCRYPT_MODE,publicKey);

                start=System.nonoTime();
                byte[] encrypted=encrypt.doFinal(message);
                long encTime=System.nonoTime()-start;

                Cipher decrypt=Cipher.getInstance("RSA/ECB/PKCS1Padding");
                decrpyt.init(Cipher.DECRYPT_MODE,privateKey);

                start=System.nonoTime();
                byte[] decrpyted=decrpyt.doFinal(encrypted);
                long decTime=System.nonoTime()-start;

                System.out.println(bits+" bits      |")
            }

        }
    }
}