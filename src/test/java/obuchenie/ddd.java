package obuchenie;

import org.apache.commons.codec.binary.Base64;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by aleksandr on 10/25/14.
 */
public class ddd {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        basd();

    }

    public static String  basd() throws NoSuchAlgorithmException {
        String b = base64(getSHA256Body(base641(getSHA256String11(readZipFile()))));
                return b;
    }




    public static byte[] getSHA256Body(byte [] body) throws NoSuchAlgorithmException {

        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(body);
        byte byteData[] = md.digest();
        return byteData;

    }

    public static String base64(byte[] body) {
        byte[] encodedBytes = Base64.encodeBase64(body);
         System.out.println("encodedBytes " + new String(encodedBytes));
        return new String(encodedBytes);

    }

    public static  byte[] getSHA256String11(byte[] body) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(body);
        byte byteData[] = md.digest();
        return byteData;

    }

    public static byte[] base641(byte[] body) {
        byte[] encodedBytes = Base64.encodeBase64(body);
        // System.out.println("encodedBytes " + new String(encodedBytes));
        return encodedBytes;
    }
    public static byte[] readZipFile ()
    {
        File file = new File("/Users/aleksandr/Desktop/Project/Rotator.zip");

        byte[] b = new byte[(int) file.length()];
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(b);
            fileInputStream.close();
        }catch (FileNotFoundException e) {
            System.out.println("File Not Found.");
            e.printStackTrace();
        }catch (IOException e1) {
            System.out.println("Error Reading The File.");
            e1.printStackTrace();
        }
        return b;

    }

}
