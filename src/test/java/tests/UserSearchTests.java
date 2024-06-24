package tests;

import io.qameta.allure.Feature;
import models.lombok.UsersResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static specs.Specifications.requestSpec;
import static specs.Specifications.responseSpecification;

@DisplayName("User Search Tests")
public class UserSearchTests extends TestBase {
    @Feature("User tests")
    @Test
    @DisplayName("Verify user found by ID has data as expected")
    void userSuccessfullyFoundByIDTest() {
        UsersResponse response =
                step("Make Request", () ->
                        given(requestSpec())
                                .when()
                                .get("/users/{id}", 3)
                                .then()
                                .spec(responseSpecification(200))
                                .and().extract().as(UsersResponse.class)
                );


        step("Check Response", () -> {
                    assertThat(response.getData().getId()).isEqualTo(3);
                    assertThat(response.getData().getEmail()).isEqualTo("emma.wong@reqres.in");
                }
        );
    }

    @Feature("User tests")
    @Test
    @DisplayName("Verify 404 status code error and empty response when user is not found by ID")
    void userNotFoundByIDTest() {
        UsersResponse response =
                step("Make Request", () ->
                        given(requestSpec())
                                .when()
                                .get("/users/{id}", 25)
                                .then()
                                .spec(responseSpecification(404))
                                .and().extract().as(UsersResponse.class)
                );

        step("Check Response", () -> {
                    assertThat(response.getData()).isNull();
                    assertThat(response.getSupport()).isNull();
                }
        );
    }
}
