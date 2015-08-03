package obuchenie;
import org.apache.commons.codec.binary.*;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;


/**
 * Created by aleksandr on 10/8/14.
 */
public class Sha256 {
    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        String md5Value = "aleksandr";

        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(md5Value.getBytes());
        //md.update(Jsono);

        byte byteData[] = md.digest();

      /*  StringBuffer sb = new StringBuffer();
        for (
                int i = 0;
                i < byteData.length; i++)

        {
            sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));


        }
        System.out.println("Digest MD5   " + sb.toString());
        md5Value = sb.toString();*/

        // return md5Value;
    }


}
