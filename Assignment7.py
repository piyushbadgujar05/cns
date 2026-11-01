from cryptography.hazmat.primitives.asymmetric import dsa 
from cryptography.hazmat.primitives import hashes
from cryptography.exceptions import InvalidSignature

private_key=dsa.generate_private_key(key_size=2048)
public_key=private_key.public_key()

Message=input("Enter the message: ")
print("Original Message: ",Message)

signature=private_key.sign(
    Message.encode('utf-8'),
    hashes.SHA256()
)

print("\nDigital Signature: ",signature.hex());

try:
    public_key.verify(
        signature,
        Message.encode('utf-8'),
        hashes.SHA256()
    )
    print("\nOriginal Message verification : Successful")
except InvalidSignature:
    print("\nOriginal Message verification : Failed")

modified_message=input("\nEnter the modified message: ")

try:
    public_key.verify(
        signature,
        modified_message.encode('utf-8'),
        hashes.SHA256()
    )

    print("\n Modified Message verification: successful")
except InvalidSignature:
    print("\n Modified message verification: Failed")
    print("Message has been tempered")
