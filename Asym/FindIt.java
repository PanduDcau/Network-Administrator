import java.security.*;
//import javax.crypto.*;
import javax.crypto.spec.*;
import java.util.Base64;

public class FindIt {

public static void main(String args[]) throws Exception {

  //Complete this programme to decrypt the
  //following base64 encoded cipher text
  String cText="A1TEAJWqY8c=";
  //Decode the cyber text
  byte[] ciphertext = Base64.getDecoder().decode(cText);

  //This ramdom generate is used to get key and iv
   SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
   sr.setSeed("1234".getBytes());
   byte[] k = new byte[128/8];
   sr.nextBytes(k);
   SecretKeySpec key = new SecretKeySpec(k,"AES");

   //Set a IV
   //byte[] i = Base64.getDecoder().decode(cText);
   IvParameterSpec iv = new IvParameterSpec(ciphertext);

   //decryption pass
  String plainText = new String(Base64.getDecoder().decode(cText.getBytes()));
  System.out.println(iv);
  System.out.println(key);
  System.out.println("Plain text length: "+plainText.length());
  String s= new String(plainText);
  System.out.println("plain text: " + s);

 }
}