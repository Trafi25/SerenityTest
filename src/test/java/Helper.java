import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Helper {

    private static final String API_KEY=  "x-api-key";
    private static final String OBJ_KEY=  "DEMO-API-KEY";

    public static Response GetResourse(String Response){
        return    given()
        .header(API_KEY, OBJ_KEY)
        .when()
        .get(Response)
        .then()
        .extract()
        .response();
    }

}
