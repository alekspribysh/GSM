package obuchenie;
import java.lang.StringBuffer;

import org.apache.commons.codec.binary.Base64;
import org.json.simple.JSONObject;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * Created by aleksandr on 10/8/14.
 */
class StringBufferExample {


    public static void main(String[] args) {
        String str1 = "У кота ";
        String str2 = " лапы";
        int paws = 4;
        StringBuffer sb = new StringBuffer(20);
       sb.append(str1).append(paws).append(str2);

        /*LabelPeer tvInfo = null;
        tvInfo.setText(sb.toString());*/
        System.out.println(sb.toString());
    }



}
