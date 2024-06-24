package tests;

import io.qameta.allure.Feature;
import models.lombok.ColorInformation;
import models.lombok.UnknownResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static specs.Specifications.requestSpec;
import static specs.Specifications.responseSpecification;

@DisplayName("Catalog Tests")
public class CatalogTests extends TestBase {

    @Feature("Color tests")
    @Test
    @DisplayName("Verify \"blue turquoise\" is a color of 2005 by Pantone")
    void pantoneDataTest() {
        UnknownResponse response =
                step("Make Request", () ->
                        given(requestSpec())
                                .when()
                                .get("/uknown")
                                .then()
                                .spec(responseSpecification(200))
                                .and().extract().as(UnknownResponse.class)
                );


        step("Check Response", () -> {
                    assertThat(response.getData()).hasSize(6);

                    ColorInformation lastItem = response.getData().get(5);
                    assertThat(lastItem.getName()).isEqualTo("blue turquoise");
                    assertThat(lastItem.getYear()).isEqualTo(2005);
                }
        );
    }


}
