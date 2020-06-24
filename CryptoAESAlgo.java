// Author: Karlis Zars
// Cryprogaphy AES Algorithm class
// Using javax.crypto library

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class CryptoAESAlgo {

    public static String algo = "AES";
    public byte[] keyValue;
    public CryptoAESAlgo(byte key[]) {
        keyValue = key;
    }
// Key generation Method
    public Key generateKey() throws Exception {
        Key key = new SecretKeySpec(keyValue, algo);
        return key;
    }
// Decryption Method
    public String decrypt(String msg) throws Exception{
         Key key = generateKey();
        Cipher c = Cipher.getInstance(algo);
        c.init(Cipher.DECRYPT_MODE, key);
        byte[] decodeValue = new BASE64Decoder().decodeBuffer(msg);
        byte[] decValue = c.doFinal(decodeValue);
        String decryptedValue = new String(decValue);
        return decryptedValue;
    }
// Encryption Method
    public String encrypt(String msg) throws Exception{
        Key key = generateKey();
        Cipher c = Cipher.getInstance(algo);
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] encVal = c.doFinal(msg.getBytes());
        String encryptedValue = new BASE64Encoder().encode(encVal);
        return encryptedValue;
    }
}
