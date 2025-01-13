package adapters;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.*;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import lombok.extern.log4j.Log4j2;

import static io.restassured.RestAssured.given;

@Log4j2
public class TestPlanAPI {
    private final static String TOKEN= "cc2b40db03abcaadd07ce02c0abb8dcc7749a1aff5cf0491baa622a67cc52b91";


    public static Gson gson = new GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create();

    public static RequestSpecification spec =
            given()
                    .log().all()
                    .header("Token", TOKEN)
                    .header("accept", "application/json")
                    .contentType(ContentType.JSON);

    public static CreatePlanRs createPlan(CreatePlanRq createPlanRq) {
        log.info("Creating test plan");
        return
                given()
                        .spec(spec)
                        .body(gson.toJson(createPlanRq))
                        .when()
                        .post("https://api.qase.io/v1/plan/MYPROJECT")
                        .then()
                        .log().all()
                        .statusCode(200)
                        .extract()
                        .as(CreatePlanRs.class);
    }

    public static UpdatePlanRs updatePlan(UpdatePlanRq updatePlanRq, int id) {
        log.info("Updating test plan");
        return
                given()
                        .spec(spec)
                        .body(gson.toJson(updatePlanRq))
                        .when()
                        .patch("https://api.qase.io/v1/plan/MYPROJECT/" + id)
                        .then()
                        .log().all()
                        .statusCode(200)
                        .extract()
                        .as(UpdatePlanRs.class);
    }

    public static void deletePlan(int id) {
        log.info("Deleting test plan");
        given()
                .spec(spec)
                .when()
                .delete("https://api.qase.io/v1/plan/MYPROJECT/" + id)
                .then()
                .log().all()
                .statusCode(200);
    }
}
