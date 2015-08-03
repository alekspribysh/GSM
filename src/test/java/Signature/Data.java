package Signature;

import org.json.simple.JSONObject;

/**
 * Created by aleksandr on 10/15/14.
 */
public class Data {
    String uri = "/mispot/api/1/";
    String host = "173.1.164.3";
    String get = "/get";
    String put = "/put";
    String delete = "/delete";
    String advertiser = "advertiser";
    String assetGroup = "asset_group";
    String asset = "asset";
    String adunit = "adunit";
    String campaign = "campaign";
    String tag = "tag";
    String binary = "binary";
    String create = "/create";
    String upload = "/upload/";
    String site = "site";
    String rotatorHTML5_300x250 = "/Users/aleksandr/Desktop/Project/300x250_html5_qube.zip";
    String rotatorImage_320x75 = "/Users/aleksandr/Desktop/Project/Rotator1.zip";
    String rotatorHTML5_320x75 = "/Users/aleksandr/Desktop/Project/HouseFront1-320x75.gif";
    String rotatorImage_320x250 = "/Users/aleksandr/Desktop/Project/yogurt320x250.jpg";

    //Advertiser
    String uriAdvertiserGet = uri + advertiser + get;
    String uriAdvertiserPut = uri + advertiser + put;
    String uriAdvertiserDelete = uri + advertiser + delete;

    //Asset_group
    String uriAsset_groupGet = uri + assetGroup + get;
    String uriAsset_groupPut = uri + assetGroup + put;
    String uriAsset_groupDelete = uri + assetGroup + delete;

    //Asset
    String uriAssetGet = uri + asset + get;
    String uriAssetPut = uri + asset + put;
    String uriAssetDelete = uri + asset + delete;

    //AdUnit
    String uriAdUnitGet = uri + adunit + get;
    String uriAdUnitPut = uri + adunit + put;
    String uriAdUnitDelete = uri + adunit + delete;

    //Binary
    String uriBinaryGet = uri + binary + get;
    String uriBinaryCreate = uri + binary + create;
    String uriBinaryUpload = uri + binary + upload + 1327;
    //String getUriBinaryDelete = uri + binary + download + 1265


    //Site
    String uriSiteGet = uri + site + get;

    //Campaign

    String uriCampaignGet = uri + campaign + get;
    String uriCampaignDelete = uri + campaign + delete;
    String uriCampaignPut = uri + campaign + put;


    // Get

    String uriTagGet = uri + tag + get;
    String uriTagDelete = uri + tag + delete;
    String uriTagPut = uri + tag + put;

}