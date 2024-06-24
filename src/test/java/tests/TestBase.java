package tests;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

import static io.qameta.allure.Allure.step;

public class TestBase {
    @BeforeAll
    static void setUpConfig() {
        step("Set Base URI", () -> RestAssured.baseURI = "https://reqres.in");
        step("Set Base Path", () -> RestAssured.basePath = "/api");
    }
}
