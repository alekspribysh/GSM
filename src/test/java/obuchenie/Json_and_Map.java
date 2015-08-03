package obuchenie;

import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by aleksandr on 11/6/14.
 */
public class Json_and_Map {
    public static void main(String[] args) {
        Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        ArrayList <String> array = new ArrayList<String>();
        array.add("Privet");
        array.add("Kak dela");
        map.put("id", array);
        jso(map);
    }

    public static JSONObject jso (Map map){
        JSONObject jo =new JSONObject();
        jo.putAll(map);
        System.out.println(jo);
        return jo;

    }
}
