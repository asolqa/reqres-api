package tests;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static specs.Specifications.requestSpec;
import static specs.Specifications.responseSpecification;

@DisplayName("User Update Tests")
public class UserUpdateTests extends TestBase {

    @Feature("User tests")
    @Test
    @DisplayName("Verify 400 status code error when patch data is corrupted")
    void userCorruptedDataPatchTest() {
        String response =
                step("Make Request", () ->
                        given(requestSpec())
                                .when()
                                .body("fff")
                                .patch("/{id}", 2)
                                .then()
                                .spec(responseSpecification(400)).extract().asString()
                );

        step("Check Response", () -> assertThat(response).contains("<title>Error</title>"));
    }
}
