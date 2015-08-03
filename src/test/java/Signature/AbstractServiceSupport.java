package Signature;
import com.jayway.restassured.authentication.BasicAuthScheme;
import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.config.LogConfig;
import com.jayway.restassured.config.RestAssuredConfig;
import com.jayway.restassured.filter.log.LogDetail;
import com.jayway.restassured.specification.RequestSpecification;


/**
 * Created by aleksandr on 10/8/14.
 */
public abstract class AbstractServiceSupport {
    private RequestSpecification defaultRequestSpec;

    private String protocol = "http";
    private String host = "173.1.164.3";
    private Integer port = 80;
    private String basePath = "/";
   // private String contentType = "application/zip";

    /**
     * Implement this to control loading.
     */
    abstract protected void load();


    /**
     * Helper method to load a spec from a service name
     *
     */
    protected void load(String parameterSet) {

        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setBaseUri(String.format("%s://%s%s", protocol, host, basePath));
       // builder.setContentType(contentType);
        builder.setPort(port);
        RestAssuredConfig restAssuredConfig = RestAssuredConfig.newConfig();
        restAssuredConfig = restAssuredConfig.logConfig(LogConfig.logConfig().enableLoggingOfRequestAndResponseIfValidationFails(LogDetail.ALL));
        builder.setConfig(restAssuredConfig);

        defaultRequestSpec = builder.build();
    }

    public RequestSpecification spec(){
        return defaultRequestSpec;
    }

}
