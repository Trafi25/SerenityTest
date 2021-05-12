import io.restassured.RestAssured;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Title;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static io.restassured.RestAssured.when;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SerenityRunner.class)
public class Crud_test {

    private static final int STATUS_CODE_OK = 200;
    private static final int STATUS_NOT_FOUND = 404;
    private static final String BASE_URI = "https://api.thecatapi.com";
    private static final int STATUS_CODE = 401;



    @Test
    @Title("Verification of delete request")
    public void tetstdeleteoneofbettercats(){


        when().
                delete("https://api.thecatapi.com/v1/favourites/1").
                then().statusCode(STATUS_CODE).
                log().all();
    }

    @Before
    public void setUp() {
        RestAssured.baseURI = BASE_URI;
    }

    @Test
    @Title("Test get user")
    public void testgetcatigorieslist(){

        Helper.GetResourse("/v1/categories")
                .then()
                .statusCode(STATUS_CODE_OK)
                .log().body();
        assertThat(STATUS_CODE_OK, equalTo(STATUS_CODE_OK));
    }


    @Test
    public void testfakegetcatigorieslist(){

        Helper.GetResourse("/v2/categories")
                .then()
                .statusCode(STATUS_NOT_FOUND)
                .log().body();

    }

    @Test
    public void testketegorieslistbuid(){

        Helper.GetResourse("/v1/images/search")

                .then()
                .statusCode(STATUS_CODE_OK)
                .body(Matchers.notNullValue())
                .log().body();

    }
}
