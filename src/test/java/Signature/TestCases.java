package Signature;

import org.hamcrest.CoreMatchers;
import org.junit.*;
import org.junit.Test;

import java.util.Map;

/**
 * Created by aleksandr on 10/16/14.
 */
public class TestCases {
    Data data = new Data();
    DataJsonObject datajs = new DataJsonObject();
    ServiceCall call = new ServiceCall();
    GetOperation operGet = new GetOperation();
    DeleteOperation operDel = new DeleteOperation();
    PutOperation operPUT = new PutOperation();


    //Advertiser

    @ Test
    public void advertiserGet() throws Exception {

            call.getJson(data.uriAdvertiserGet, operGet.jsonGet());
            Map<String, String> response = call.json.getMap("$");
            System.out.println(response);
            Assert.assertThat(response.toString(), CoreMatchers.containsString("Alksandr"));


    }


    @Test
    public void advertiserPut() throws Exception {
        try {
            call.getJson(data.uriAdvertiserPut, operPUT.jAdvertiserPUT());
            Map<String, String> response = call.json.getMap("$");
            System.out.println(response);

            Assert.assertThat(response.toString(), CoreMatchers.containsString("Aleksandr"));
        } catch (AssertionError e) {
            System.out.println("Test advertiserPut is failed");
        }

    }

    @Test
    public void advertiserDelete() throws Exception {
        call.getJson(data.uriAdvertiserDelete, operDel.jAdvertiserDelete());
        Map<String, String> response = call.json.getMap("$");
        System.out.println(response);

    }


    //    Asset_group
    @Test
    public void asset_groupGet() throws Exception {
        call.getJson(data.uriAsset_groupGet, operGet.jsonGet());
        Map<String, String> response = call.json.getMap("$");
        System.out.println(response);
    }


    @Test
    public void asset_groupPut() throws Exception {
        call.getJson(data.uriAsset_groupPut, operPUT.jAsset_groupPut());
        Map<String, String> response = call.json.getMap("$");
        System.out.println(response);

    }

    @Test
    public void asset_groupUpdate() throws Exception {
        call.getJson(data.uriAsset_groupPut, operPUT.jAsset_groupUpdate());
        Map<String, String> response = call.json.getMap("$");
        System.out.println(response);

    }

    @Test
    public void asset_groupDelete() throws Exception {
        call.getJson(data.uriAsset_groupDelete, operDel.jAsset_groupDelete());
        Map<String, String> response = call.json.getMap("$");
        System.out.println(response);

    }

    //  Asset
    @Test
    public void assettGet() throws Exception {
        call.getJson(data.uriAssetGet, operGet.jsonGet());
        Map<String, String> response = call.json.getMap("$");
        System.out.println(response);
    }

    @Test
    public void assettPutRotator() throws Exception {
        call.getJson(data.uriAssetPut, operPUT.jAssetPutImageRotator());
        Map<String, String> response = call.json.getMap("$");
        System.out.println(response);
    }


    @Test
    public void assettPutHTML5() throws Exception {
        call.getJson(data.uriAssetPut, operPUT.jAssetPutHTML5Rotator());
        Map<String, String> response = call.json.getMap("$");
        System.out.println(response);
    }


    @Test
    public void assettDelete() throws Exception {
        call.getJson(data.uriAssetDelete, operDel.jAssetDelete());
        Map<String, String> response = call.json.getMap("$");
        System.out.println(response);
    }


    //  AdUnnit

    @Test
    public void adUnittGet() throws Exception {
        call.getJson(data.uriAdUnitGet, operGet.jsonGet());
        Map<String, String> response = call.json.getMap("$");
        System.out.println(response);
    }

    @Test
    public void adUnittPutRotator() throws Exception {
        call.getJson(data.uriAdUnitPut, operPUT.jAdUnitPutRotator());
        Map<String, String> response = call.json.getMap("$");
        System.out.println(response);
    }

    @Test
    public void adUnittDelete() throws Exception {
        call.getJson(data.uriAdUnitDelete, operDel.jAdUnitDelete());
        Map<String, String> response = call.json.getMap("$");
        System.out.println(response);
    }


    //  Binary

    @Test
    public void BinaryGet() throws Exception {
        call.getJson(data.uriBinaryGet, operGet.jsonGet());
        Map<String, String> response = call.json.getMap("$");
        System.out.println(response);
    }


    @Test
    public void BinaryCreate() throws Exception {
        call.getJson(data.uriBinaryCreate, operGet.jsonCreate());
        Map<String, String> response = call.json.getMap("$");
        System.out.println(response);
    }


    @Test
    public void BinaryUpload() throws Exception {
        call.getJson1(data.uriBinaryUpload, operPUT.readZipFile(data.rotatorHTML5_300x250));

    }


    // Site

    @Test
    public void siteGet() throws Exception {
        call.getJson(data.uriSiteGet, operGet.jsonGet());
        Map<String, String> response = call.json.getMap("$");
        System.out.println(response);
    }


    // Campaign

    @Test
    public void campaignGet() throws Exception {
        call.getJson(data.uriCampaignGet, operGet.jsonGet());
        Map<String, String> response = call.json.getMap("$");
        System.out.println(response);
    }


    @Test
    public void campaignDelete() throws Exception {
        call.getJson(data.uriCampaignDelete, operDel.jCampaignDelete());
        Map<String, String> response = call.json.getMap("$");
        System.out.println(response);
    }


    @Test
    public void campaignPut() throws Exception {
        call.getJson(data.uriCampaignPut, operPUT.jCampaignPut());
        Map<String, String> response = call.json.getMap("$");
        System.out.println(response);
    }

    //Tag

    @Test
    public void tagGet() throws Exception {
        call.getJson(data.uriTagGet, operGet.jsonGet());
        Map<String, String> response = call.json.getMap("$");
        System.out.println(response);
    }


    @Test
    public void tagDelete() throws Exception {
        call.getJson(data.uriTagDelete, operDel.jTagDelete());
        Map<String, String> response = call.json.getMap("$");
        System.out.println(response);
    }

    @Test
    public void tagPut() throws Exception {
        call.getJson(data.uriTagPut, operPUT.jTagPut());
        Map<String, String> response = call.json.getMap("$");
        System.out.println(response);
    }




}
