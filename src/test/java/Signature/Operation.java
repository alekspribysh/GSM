package Signature;

import org.json.simple.JSONObject;

/**
 * Created by aleksandr on 11/6/14.
 */
public abstract class  Operation {

    public abstract JSONObject jsonGet();
    public abstract JSONObject jsonGetAdv(int id);
    public abstract JSONObject jsonGetAdv(String str);
    public abstract JSONObject jsonGetAdv(int id, String str);
    
}
