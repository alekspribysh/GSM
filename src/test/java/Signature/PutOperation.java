package Signature;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by aleksandr on 10/17/14.
 */
public class PutOperation  {

   //Advertiser

    public JSONObject jAdvertiserPUT() {
        JSONObject jobj = new JSONObject();
        jobj.put("name", "Sergey");
        jobj.put("contactName", "Sergey");
        jobj.put("contactPhone", "612345678");
        jobj.put("email", "sergey@gmail.com");
        return jobj;
    }
    public JSONObject jAdvertiserUpdate() {
        JSONObject jobj = new JSONObject();
        jobj.put("id","1315");
        jobj.put("name", "Aleksandr");
      //  jobj.put("contactName", "Sergey");
       // jobj.put("contactPhone", "612345678");
       // jobj.put("email", "sergey@gmail.com");
        return jobj;
    }


    //Asset_group

    public JSONObject jAsset_groupPut() {
        JSONObject jobj = new JSONObject();
        jobj.put("advertiser_id", 1316);
        jobj.put("name", "Sergey");
        return jobj;

    }
    public JSONObject jAsset_groupUpdate() {
        JSONObject jobj = new JSONObject();
        jobj.put("id",1117);
        jobj.put("advertiser_id", 1316);
        jobj.put("name", "Roma");
        return jobj;

    }

    //Asset

    public JSONObject jAssetPutImageRotator() {
        JSONObject jobj = new JSONObject();
        JSONObject jo = new JSONObject();
        jo.put("binary",1298);

        jobj.put("asset_group_id",1116);
        jobj.put("advertiser_id",1315);
        jobj.put("asset_type",1);
        jobj.put("screen",1);
        jobj.put("asset_1",jo);


        return jobj;

    }

    public JSONObject jAssetPutHTML5Rotator() {
        JSONObject jobj = new JSONObject();
        JSONObject jo = new JSONObject();
        JSONObject j1  = new JSONObject();
        JSONObject j1size = new JSONObject();
        JSONObject j2 = new JSONObject();
        JSONObject j2size = new JSONObject();


        jobj.put("asset_group_id",1116);
        jobj.put("advertiser_id",1315);
        jobj.put("asset_type",2);
        jobj.put("screen",1);
        jobj.put("asset_2",jo);


            jo.put("1",j1);
            jo.put("2",j2);

               j1.put("type", 2);
               j1.put("binary", 1298);
               j1.put("size",j1size);
                 j1size.put("width", 320);
                 j1size.put("height", 250);

               j2.put("type", 2);
               j2.put("binary", 1327);
               j2.put("size",j2size);
                  j2size.put("width", 320);
                  j2size.put("height", 250);


        return jobj;

    }



    //AdUnit

    public JSONObject jAdUnitPutRotator() {
        JSONObject jobj = new JSONObject();
        JSONObject jcon = new JSONObject();
        JSONObject jscreen = new JSONObject();
        JSONObject jrotator = new JSONObject();
        JSONObject jsides = new JSONObject();
        JSONArray list1 = new JSONArray();
        JSONArray list2 = new JSONArray();
        JSONArray list3 = new JSONArray();

        jobj.put("advertiser_id", 1315);
        jobj.put("asset_group_id",1116);
        jobj.put("adunit_type",7);
        jobj.put("name", "Proba");
        jobj.put("insight",1);
        jobj.put("contents", jcon);
            jcon.put(1,jscreen );
               jscreen.put("trackers", list1);
               jscreen.put("rotator", jrotator );
                   list1.add("http://");
                   list1.add("trackers");
                   list1.add(".com");
                     jrotator.put("animation_duration_limit",-1);
                     jrotator.put("sides", list3);
                        list3.add(jsides);
                        jsides.put("asset_side",2);
                        jsides.put("trackers", list2);
                        list2.add("http://");
                        list2.add("trackers");
                        list2.add(".com");


        return jobj;

    }


    //Binary

    public byte[] readZipFile(String filebytes) {
        File file = new File(filebytes);

        try {
            InputStream fileInputStream = new FileInputStream(file);
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            byte [] buf = new byte[4096];
            while (true) {
                int nr  = fileInputStream.read(buf);
                if (nr < 0) { break; }
                os.write(buf, 0, nr);
            }

            fileInputStream.close();
            return os.toByteArray();

        /*
            for (int i = 0; i < b.length; i++) {
                System.out.print((char)b[i]);
            }

            System.out.println("Done");*/

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


    // Campaign


    public JSONObject jCampaignPut() {
        JSONObject jobj = new JSONObject();
        Calendar start_date = new GregorianCalendar(2014, 10, 07);//Calendar.getInstance();
        Calendar end_date = new GregorianCalendar(2014, 11, 12);
        DateFormat dfm = new SimpleDateFormat("yyyy-MM-dd");
        //System.out.println(dfm.format(cal1.getTime()));

        jobj.put("advertiser_id", 1315);
        jobj.put("name","honda");
        jobj.put("io_number","3");
        jobj.put("start_date", dfm.format(start_date.getTime()));
        jobj.put("end_date", dfm.format(end_date.getTime()));

        return jobj;
    }

    //Tag

    public JSONObject jTagPut() {
        JSONObject jobj = new JSONObject();
        jobj.put("no_api[S]", true);
        jobj.put("campaign_id", 1016);
        jobj.put("advertiser_id", 1315);
        jobj.put("adunit_id",1033);
        jobj.put("impression_goal",1);
        jobj.put("site_id", 1001);
        jobj.put("assetgroup_id", 1116);
        jobj.put("easy_touch", 0);

        return jobj;
    }



}
