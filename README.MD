# API tests for [Reqres.in](https://reqres.in/)

---

Test your front-end against a real API

<a href="https://reqres.in/"><img src="./media/reqres_logo.png"/></a>

---


## Content:

- <a href="#tools">Tools and technologies</a>
- <a href="#facts">Project features</a>
- <a href="#scenarios">Test scenarios</a>
- <a href="#cli">Launch from the CLI</a>
- <a href="#jenkins">CI/CD with Jenkins</a>
- <a href="#allure">Allure reporting</a>
- <a href="#allure-testops">Integration with Allure TestOps</a>
- <a href="#jira">Integration with JIRA</a>
- <a href="#telegram">Bot notifications in Telegram</a>


<a id="tools"></a>
## Tools and technologies
<p align="center">
<a href="https://www.jetbrains.com/idea/"><img src="./media/logo/Idea.svg" width="50" height="50"  alt="IDEA"/></a>  
<a href="https://www.java.com/"><img src="./media/logo/java.svg" width="50" height="50"  alt="Java"/></a>  
<a href="https://rest-assured.io/"><img src="media/logo/Restassured.png" width="50" height="50"  alt="Java"/></a>  
<a href="https://projectlombok.org/"><img src="media/logo/Lombok.png" width="50" height="50"  alt="Java"/></a>  
<a href="https://github.com/"><img src="./media/logo/github.svg" width="50" height="50"  alt="Github"/></a>  
<a href="https://junit.org/junit5/"><img src="./media/logo/JUnit5.svg" width="50" height="50"  alt="JUnit 5"/></a>  
<a href="https://gradle.org/"><img src="./media/logo/Gradle.svg" width="50" height="50"  alt="Gradle"/></a>
<a href="https://github.com/allure-framework/allure2"><img src="./media/logo/Allure.svg" width="50" height="50"  alt="Allure"/></a>
<a href="https://qameta.io/"><img src="./media/logo/AllureTestOps.svg" width="50" height="50"  alt="Allure TestOps"/></a>   
<a href="https://www.jenkins.io/"><img src="./media/logo/Jenkins.svg" width="50" height="50"  alt="Jenkins"/></a>  
<a href="https://www.atlassian.com/ru/software/jira/"><img src="./media/logo/JIRA.svg" width="50" height="50"  alt="Jira"/></a>
</p>

<a id="facts"></a>
## Project features
* `Lombok` for models 
* Request/response specifications 
* Custom `tpl` templates for `Allure` report logging
* Test cases as a documentation with `Allure TestOps`
* Launch all or separate tests from TMS directly
* `JIRA` integration
* Telegram notifications

<a id="scenarios"></a>
## Test Scenarios
* [x] Verify specific colour is a color of 2005 by Pantone
* [x] Verify only predefined users can pass the registration
* [x] Verify user found by ID has data as expected
* [x] Verify 404 status code error and empty response when user is not found by ID
* [x] Verify user with valid data can be successfully created
* [x] Verify 400 status code error when patch data is corrupted
* [x] Verify 204 status code when user was deleted



<a id="cli"></a>
## <img alt="cli" height="25" src="./media/logo/run.png" width="25"> Launch from the CLI

All tests can be executed by command:
```bash  
./gradlew clean test
```


<a id="jenkins"></a>
## <img alt="Jenkins" height="25" src="./media/logo/Jenkins.svg" width="25"/></a><a name="CI/CD with Jenkins"></a>CI/CD with [Jenkins](https://jenkins.autotests.cloud/job/26-asolqa-reqres-api/)</a>
<img alt="Jenkins" src="./media/reports/Jenkins.png"> 

### Jenkins job

- `COMMENT` parameter (by default @asolqa is tagged)

After the build is done the test results are available in `Allure`, `Allure TestOps` and `JIRA`

<a id="allure"></a>
## <img alt="Allure" height="25" src="./media/logo/Allure.svg" width="25"/></a> <a name="Allure"></a>Allure [reporting](https://jenkins.autotests.cloud/job/26-asolqa-reqres-api/allure/)</a>
<img alt="Allure" src="./media/reports/AllureReportExample.png"> 

`Allure` report includes request and response logging beautified with `tpl` templates:
<img alt="Allure2" src="./media/reports/AllureReportExample2.png">


<a id="allure-testops"></a>
## <img alt="Allure" height="25" src="./media/logo/AllureTestOps.svg" width="25"/></a> Integration with <a target="_blank" href="https://allure.autotests.cloud/project/4305/dashboards">Allure TestOps</a>

`Allure TestOps` processes tests as a documentation and allows to launch them directly from TMS. 
Here all test cases execution results are available. 

Dashboard contains test runs statistics:
<img alt="Dashboard" src="./media/reports/Dashboard.png">

All test cases:
<img alt="Cases1" src="./media/reports/TestOpsAutomated.png">

To execute tests from TestOps move to Jobs:
<img alt="Launch" src="./media/reports/LaunchJob1.png">

Click to run Job, select needed/all items and submit launch:
<img alt="Launch" src="./media/reports/LaunchJob.png">

Launches:
<img alt="Launch" src="./media/reports/Launches.png">



<a id="jira"></a>
## <img alt="Allure" height="25" src="./media/logo/JIRA.svg" width="25"/></a> Integration with <a target="_blank" href="https://jira.autotests.cloud/browse/HOMEWORK-1272">Jira</a>

`Jira` has information about all related test cases, their statuses and launches results from `Allure TestOps`:

<img alt="JIRA" src="./media/reports/JIRA.png">

<a id="telegram"></a>
## <img alt="Allure" height="25" src="./media/logo/Telegram.svg" width="25"/></a> Bot notifications in Telegram
After every build Telegram bot sends notification with `Allure` report:
<img alt="Bot" src="./media/reports/Telegram_screen.png"> 









