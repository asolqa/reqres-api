package tests;

import io.qameta.allure.Feature;
import models.lombok.UserCreationRequest;
import models.lombok.UserCreationResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static specs.Specifications.*;

@DisplayName("User Creation Tests")
public class UserCreationTests extends TestBase {
    @Feature("User tests")
    @Test
    @DisplayName("Verify user with valid data can be successfully created")
    void userSuccessfulCreationTest() {
        UserCreationRequest postData = new UserCreationRequest("morpheus", "leader");

        UserCreationResponse response =
                step("Make Request", () ->
                        given(requestSpec())
                                .when()
                                .body(postData)
                                .post("/users")
                                .then()
                                .spec(responseSpecification(201))
                                .and().extract().as(UserCreationResponse.class));


        step("Check Response", () -> {
                    assertThat(response.getName()).isEqualTo("morpheus");
                    assertThat(response.getJob()).isEqualTo("leader");
                    assertThat(response.getId()).isNotNull();
                    assertThat(response.getCreatedAt()).isNotNull();
                }
        );
    }
}
