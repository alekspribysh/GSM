package Signature;

import com.jayway.restassured.path.json.JsonPath;
import org.json.simple.JSONObject;


import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.path.json.JsonPath.from;
import static org.hamcrest.core.Is.is;


/**
 * Created by aleksandr on 10/8/14.
 */
public class ServiceCall extends AbstractServiceSupport {
    Signature headers = new Signature();
    JsonPath json;



    @Override
   protected void load() {
        load("does not make any difference");
    }

    public JsonPath getJson(String pat, JSONObject jo) throws Exception {
        //System.out.println(headers.canonicalHeaders())
        //System.out.println(headers.signature());
        //System.out.println(headers.body());

        load();

        String path = pat;
        json = from(

                given()
                        .spec(spec())
                        .contentType("application/json")
                        .body(headers.body(jo).toJSONString())
                        .headers(headers.getHeaders(jo, path))
                    //    .log().all()
                        .expect()
                        .statusCode(200)
                        .when()
                        .post(path)
                        .asString());

        return json;


    }

    public JsonPath getJson1 (String pat, byte[] file) throws Exception {

        load();

        String path = pat;
        json = from(

                given()
                        .spec(spec())
                        .contentType("application/zip")
                        .headers(headers.getHeadersUpload(path, file))
                        .body(file)
                     //   .log().all()
                        .expect()
                        .statusCode(201)
                        .when()
                        .post(path)
                        .asString());

        return json;


    }



}

