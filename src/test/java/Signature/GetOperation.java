package Signature;

import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by aleksandr on 10/17/14.
 */
public class GetOperation  {


    public JSONObject jsonGet() {
        JSONObject jobj = new JSONObject();
        return jobj;
    }


    public JSONObject jsonGetId(int id) {
        JSONObject jobj = new JSONObject();
        jobj.put("id",id);
        return jobj;
    }

    public JSONObject jsonGetName(String str) {
        JSONObject jobj = new JSONObject();
        jobj.put("name",str);
        return jobj;
    }


    public JSONObject jsonGetAdvFull(int id, String str) {
        JSONObject jobj = new JSONObject();
        jobj.put("id", id);
        jobj.put("name", str);
        return jobj;

    }

    public JSONObject jsonGetAdvertiserId (int id){
        JSONObject jobj = new JSONObject();
        jobj.put("advertiser_id", id);
        return jobj;
    }

    public JSONObject jsonGetAsset_groupFull (int id, int id1, String str){
        JSONObject jobj = new JSONObject();
        jobj.put("id", id);
        jobj.put("advertiser_id", id1);
        jobj.put("name", str);
        return jobj;

    }








    public JSONObject jsonCreate() {
        JSONObject jobj = new JSONObject();
       jobj.put("extension", "zip");
        return jobj;

    }



     /*

        public JSONObject jsonGet1(Map map) {
        JSONObject jobj = new JSONObject();
        jobj.putAll(map);
        return jobj;
    }*/
}
