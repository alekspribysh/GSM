package Signature;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.json.simple.JSONObject;
import sun.tools.java.BinaryCode;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by aleksandr on 10/8/14.
 */
public class Signature {
    public Signature() {
        date();
        nonce();

    }

    String password = "aleksandr1985";
    String request_method = "POST";
    String random;
    String timestamp;
    String user = "aleksandr";
    String host = "173.1.164.3";

    /*
    This method calculate MD5 Value
     */

    public byte[] getMD5(String md5Value) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(md5Value.getBytes());
        byte byteData[] = md.digest();
       /* StringBuffer sb = new StringBuffer();
        for (
                int i = 0;
                i < byteData.length; i++) {
            sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
        md5Value = sb.toString();
        //System.out.println("Digest MD5   " +md5Value /*sb.toString());*/
        return byteData;
    }

    public void date() {
        Calendar cal = Calendar.getInstance();
        DateFormat dfm = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        dfm.setTimeZone(TimeZone.getTimeZone("GMT"));
        timestamp = dfm.format(cal.getTime());
        //System.out.println(timestamp);
    }


    public void nonce() {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < 50; i++) {
            buffer.append(String.valueOf((int) (Math.random() * 10)));
        }
        random = buffer.toString();
        // System.out.println(random);
    }


/*
    public String canonicalURIRfc3986(String s) {
        String out;
        try {
            out = URLEncoder.encode(s, UTF8_CHARSET)
                    .replace("+", "%20")
                    .replace("*", "%2A")
                    .replace("%7E", "~");
        } catch (UnsupportedEncodingException e) {
            out = s;
        }
        return out;

    }*/

    public String uriEncoder(String s) throws URISyntaxException {
        URI uri = new URI(s);
        String urlString = uri.toASCIIString();
        //  System.out.println(urlString);
        return urlString;
    }

    public String signature(JSONObject jo, String uri) throws NoSuchAlgorithmException, URISyntaxException {


        byte[] sha256 = getSHA256Body(body(jo).toJSONString());
        String signatureString = request_method + '\n' +
                uriEncoder(uri) + '\n' +
                '\n' +
                canonicalHeaders(jo) + '\n' +
                base64(sha256);
        //  System.out.println("Signature String"+ signatureString);


        return signatureString;


    }

    public String signatureUpload(String uri, byte [] file) throws NoSuchAlgorithmException, URISyntaxException {


        String signatureString = request_method + '\n' +
                uriEncoder(uri) + '\n' +
                '\n' +
                canonicalHeadersUpload(file) + '\n' +
                base64(getSHA256Body(""));
       // System.out.println("Signature_String" + signatureString);


        return signatureString;


    }

    public String canonicalHeaders(JSONObject jo) throws NoSuchAlgorithmException {

        String sign = "content-length:" + leng(jo) + '\n' +
                "content-type:application/json; charset=ISO-8859-1" + '\n' +
                "host:" + host + '\n' +
                "x-gsm-date:" + timestamp + '\n' +
                "x-gsm-nonce:" + random + '\n' +
                "x-gsm-user:" + user;
        return sign;
    }

    public String canonicalHeadersUpload(byte [] file) throws NoSuchAlgorithmException {

        String sign = "content-length:" + lengUpload(file) + '\n' +
                "content-type:application/zip; charset=ISO-8859-1" + '\n' +
                "host:" + host + '\n' +
                "x-gsm-contentsha256:" + base64(getSHA256String(file)) + '\n' +
                "x-gsm-date:" + timestamp + '\n' +
                "x-gsm-nonce:" + random + '\n' +
                "x-gsm-user:" + user;
        return sign;
    }

    public Map<String, String> getHeaders(JSONObject jo, String uri) throws Exception {
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Content-type", "application/json");
        headers.put("Host", host);
        headers.put("X-GSM-User", user);
        headers.put("X-GSM-Date", timestamp);
        headers.put("X-GSM-Nonce", random);
        headers.put("X-GSM-Signature", "GSM-V1," + getSignature(jo, uri));
        return headers;

    }


    public Map<String, String> getHeadersUpload(String uri, byte[] file) throws Exception {
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Content-type", "application/zip");
        headers.put("Host", host);
        headers.put("X-GSM-ContentSHA256", base64(getSHA256String(file)));
        headers.put("X-GSM-User", user);
        headers.put("X-GSM-Date", timestamp);
        headers.put("X-GSM-Nonce", random);
        headers.put("X-GSM-Signature", "GSM-V1," + getSignatureUpload(uri, file));
        return headers;

    }

    public JSONObject body(JSONObject json) {
        JSONObject jo;
        jo = json;
        return jo;

    }

    public String leng(JSONObject jo) {
        String leng = String.valueOf(body(jo).toJSONString().length());
        return leng;

    }

    public String lengUpload(byte[] file) throws NoSuchAlgorithmException {
        int l = file.length;
        String leng = String.valueOf(l);
        return leng;

    }

    public byte[] getSHA256Body(String body) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(body.getBytes());
        byte byteData[] = md.digest();
        return byteData;

    }

    public byte[] getSHA256String(byte[] body) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(body);
        byte[] byteData = md.digest();
        return byteData;

    }

    public String base64(byte[] body) {
        byte[] encodedBytes = Base64.encodeBase64(body);
        // System.out.println("encodedBytes " + new String(encodedBytes));
        return new String(encodedBytes);
    }

    public byte[] hmacSHA256(byte[] key, String data) throws Exception {
        String algorithm = "HmacSHA256";
        byte[] byteData = data.getBytes("UTF-8");
        Mac mac = Mac.getInstance(algorithm);
        mac.init(new SecretKeySpec(key, algorithm));
        byte[] digest = mac.doFinal(byteData);
        // System.out.println(mac.doFinal(data));
        return digest;
    }

    public String getSignature(JSONObject jo, String uri) throws Exception {
        byte[] md5Password = getMD5(password);
        byte[] shaPassword = getSHA256String(md5Password);

        String result = base64(hmacSHA256(shaPassword, signature(jo, uri)));
        return result;

    }

    public String getSignatureUpload(String uri, byte[] file) throws Exception {
        byte[] md5Password = getMD5(password);
        byte[] shaPassword = getSHA256String(md5Password);

        String result = base64(hmacSHA256(shaPassword, signatureUpload(uri, file)));
        return result;

    }


}
