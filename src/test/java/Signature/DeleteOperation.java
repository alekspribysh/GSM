package Signature;

import org.json.simple.JSONObject;

/**
 * Created by aleksandr on 10/17/14.
 */
public class DeleteOperation {

    public JSONObject jAdvertiserDelete() {
        JSONObject jobj = new JSONObject();
        jobj.put("id", 1007);
        return jobj;
    }

    public JSONObject jAsset_groupDelete() {
        JSONObject jobj = new JSONObject();
        jobj.put("id",1117);
        return jobj;
    }

    public JSONObject jAssetDelete() {
        JSONObject jobj = new JSONObject();
        jobj.put("id",1117);
        return jobj;
    }

    public JSONObject jAdUnitDelete() {
        JSONObject jobj = new JSONObject();
        jobj.put("id",1117);
        return jobj;
    }


    public JSONObject jCampaignDelete() {
        JSONObject jobj = new JSONObject();
        jobj.put("id",1117);
        return jobj;
    }


    public JSONObject jTagDelete() {
        JSONObject jobj = new JSONObject();
        jobj.put("id",1117);
        return jobj;
    }
}
