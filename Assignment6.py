import hashlib

def calculateSHA1(text):
    hash_object=hashlib.sha1(text.encode('utf-8'))
    return hash_object.hexdigest()

original_text=input("Enter the Original Text: ")
modified_text=input("Enter the Modified Text: ")

original_hash=calculateSHA1(original_text)
modified_hash=calculateSHA1(modified_text)

print("\n=======SHA-1 Message Digest==========")
print("Original Text: ",original_text)
print("SHA1 Digest: ",original_hash)
print("Modified Text: ",modified_text)
print("SHA1 Digest: ",modified_hash)


if original_hash==modified_hash:
    print("Both message have the same SHA-1 digest")
else:
    print("SHA 1 digest are different")
    print("Avalanche effect is demostrated")