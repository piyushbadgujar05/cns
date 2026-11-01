
// import java.math.BigInteger;
// import java.util.Scanner;

// public class Assignment5 {

//     // Calculate (base ^ exponent) % mod
//     static BigInteger power(BigInteger base, BigInteger exponent, BigInteger mod) {
//         return base.modPow(exponent, mod);
//     }

//     public static void main(String[] args) {

//         Scanner sc = new Scanner(System.in);

//         // Public values
//         System.out.print("Enter prime number (p): ");
//         BigInteger p = sc.nextBigInteger();

//         System.out.print("Enter generator (g): ");
//         BigInteger g = sc.nextBigInteger();

//         // Private keys
//         System.out.print("Enter Alice's private key: ");
//         BigInteger a = sc.nextBigInteger();

//         System.out.print("Enter Bob's private key: ");
//         BigInteger b = sc.nextBigInteger();

//         System.out.println("\n========= NORMAL DIFFIE-HELLMAN =========");

//         // Generate public keys
//         BigInteger A = power(g, a, p);
//         BigInteger B = power(g, b, p);

//         // Calculate shared secret keys
//         BigInteger aliceKey = power(B, a, p);
//         BigInteger bobKey = power(A, b, p);

//         System.out.println("Alice Public Key: " + A);
//         System.out.println("Bob Public Key: " + B);

//         System.out.println("Alice Shared Key: " + aliceKey);
//         System.out.println("Bob Shared Key: " + bobKey);

//         if (aliceKey.equals(bobKey)) {
//             System.out.println("Normal DH: Key Exchange Successful!");
//         } else {
//             System.out.println("Normal DH: Key Exchange Failed!");
//         }

//         System.out.println("\n========= MAN-IN-THE-MIDDLE ATTACK =========");

//         // Eve's private keys
//         System.out.print("Enter Eve's first private key: ");
//         BigInteger e1 = sc.nextBigInteger();

//         System.out.print("Enter Eve's second private key: ");
//         BigInteger e2 = sc.nextBigInteger();

//         // Generate Eve's public keys
//         BigInteger E1 = power(g, e1, p);
//         BigInteger E2 = power(g, e2, p);

//         // Eve sends E2 to Alice instead of Bob's public key B
//         // Alice unknowingly shares a key with Eve
//         BigInteger aliceEveKey = power(E2, a, p);

//         // Eve calculates the same key using Alice's public key A
//         BigInteger eveAliceKey = power(A, e2, p);

//         // Eve sends E1 to Bob instead of Alice's public key A
//         // Bob unknowingly shares a key with Eve
//         BigInteger bobEveKey = power(E1, b, p);

//         // Eve calculates the same key using Bob's public key B
//         BigInteger eveBobKey = power(B, e1, p);

//         System.out.println("\nEve Public Key 1: " + E1);
//         System.out.println("Eve Public Key 2: " + E2);

//         System.out.println("Alice-Eve Shared Key: " + aliceEveKey);
//         System.out.println("Eve-Alice Shared Key: " + eveAliceKey);

//         System.out.println("Bob-Eve Shared Key: " + bobEveKey);
//         System.out.println("Eve-Bob Shared Key: " + eveBobKey);

//         if (aliceEveKey.equals(eveAliceKey) &&
//             bobEveKey.equals(eveBobKey)) {

//             System.out.println("\nMITM Attack Successful!");
//             System.out.println("Eve has established separate keys with Alice and Bob.");
//         }

//         if (!aliceEveKey.equals(bobEveKey)) {
//             System.out.println("Alice and Bob do not share the same key.");
//         }

//         sc.close();
//     }
// }
