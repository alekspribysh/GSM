package obuchenie;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by aleksandr on 10/21/14.
 */
public class zipToByte {
    public static void main(String[] args) {
        readZipFile();
    }


        private static byte[] readZipFile ()
// read in fnm, returning it as a single string
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
