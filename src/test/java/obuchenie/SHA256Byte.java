package obuchenie;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by aleksandr on 10/10/14.
 */
public class SHA256Byte {

    public SHA256Byte() throws UnsupportedEncodingException, NoSuchAlgorithmException {
        sha256();
        base64(sha256());
    }
    public byte[] sha256() throws NoSuchAlgorithmException, UnsupportedEncodingException {

        MessageDigest md = MessageDigest.getInstance("SHA-256");
        String text = "{}";

        md.update(text.getBytes("UTF-8")); // Change this to "UTF-16" if needed
        byte[] digest = md.digest();
        return digest;
    }


    public byte[] base64(byte[] body) {
        byte[] encodedBytes = org.apache.commons.codec.binary.Base64.encodeBase64(body);
        System.out.println("encodedBytes " + new String(encodedBytes));
        return (encodedBytes);
    }

}
