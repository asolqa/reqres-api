package tests;

import io.qameta.allure.Feature;
import models.lombok.RegistrationData;
import models.lombok.RegistrationError;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static specs.Specifications.requestSpec;
import static specs.Specifications.responseSpecification;

@DisplayName("Registration Tests")
public class RegistrationTests extends TestBase {

    @Feature("Registration errors")
    @Test
    @DisplayName("Verify only predefined users can pass the registration")
    void unsuccessfulRegistrationTest() {
        RegistrationData registrationData = new RegistrationData("test.test@reqres.in", "testpswd");

        RegistrationError response =
                step("Make Request", () ->
                        given(requestSpec())
                                .when()
                                .body(registrationData)
                                .post("/register")
                                .then()
                                .spec(responseSpecification(400))
                                .and().extract().as(RegistrationError.class)
                );

        step("Check Response",
                () -> assertThat(response.getError()).contains("Note: Only defined users succeed registration")
        );
    }
}
