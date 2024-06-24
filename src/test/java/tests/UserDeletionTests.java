package tests;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static specs.Specifications.requestSpec;
import static specs.Specifications.responseSpecification;

@DisplayName("User Deletion Tests")
public class UserDeletionTests extends TestBase {
    @Feature("User tests")
    @Test
    @DisplayName("Verify 204 status code when user was deleted")
    void userSuccessfulDeletionTest() {
        String response =
                step("Make Request", () ->
                        given(requestSpec())
                                .when()
                                .delete("/{id}", 2)
                                .then()
                                .spec(responseSpecification(204)).extract().asString()
                );

        step("Check Response", () -> assertThat(response).isEmpty());
    }

}
