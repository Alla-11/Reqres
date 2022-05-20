package tests;

import com.google.gson.Gson;
import objects.reqres.*;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.digest;
import static io.restassured.RestAssured.given;


public class ReqresTest {

    //https://reqres.in/

    @Test(description = "get list users")
    public void getListUsersTest(){
        String body = given()
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200)
                .extract().body().asString();
        UsersList usersList = new Gson().fromJson(body, UsersList.class);
        System.out.println(usersList);
    }

    @Test (description = "get single user")
    public void getSingleUserTest(){
        String body = given()
                .when()
                .get("https://reqres.in/api/users/2")
                .then()
                .statusCode(200)
                .extract().body().asString();
        SingleUser singleUser = new Gson().fromJson(body, SingleUser.class);
        System.out.println(singleUser);

    }

    @Test(description = "single user not found")
    public void getSingleUserNotFoundTest(){
        String body = given()
                .when()
                .get("https://reqres.in/api/users/23")
                .then()
                .statusCode(404)
                .extract().body().asString();
        SingleUser newSingleUser = new Gson().fromJson(body,SingleUser.class);
        System.out.println(newSingleUser);
    }

    @Test(description = "List <RESOURCE>")
    public void getListResourceTest(){
        String body = given()
                .when()
                .get("https://reqres.in/api/unknown")
                .then()
                .statusCode(200)
                .extract().body().asString();
        ListResource listResource = new Gson().fromJson(body,ListResource.class);
        System.out.println(listResource);

    }

    @Test(description = "get single resource")
    public void getSingleResourceTest(){
        String body = given()
                .when()
                .get("https://reqres.in/api/unknown/2")
                .then()
                .statusCode(200)
                .extract().body().asString();
        SingleResource singleResource = new Gson().fromJson(body,SingleResource.class);
        System.out.println(singleResource);
    }

    @Test(description = "single resourse not found")
    public void getSingleResourseNotFoundTest(){
        String body = given()
                .when()
                .get("https://reqres.in/api/unknown/23")
                .then()
                .statusCode(404)
                .extract().body().asString();
        SingleResource singleResource = new Gson().fromJson(body,SingleResource.class);
        System.out.println(singleResource);
    }

    @Test (description = " post from create")
    public void postCreateUserTest(){
        User user = User.builder()
                .name("morpheus")
                .job("leader")
                .build();
        given()
                .body(user)
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .log().all()
                .statusCode(201);
    }

    @Test(description = "put update")
    public void putUpdateTest(){
        User user = User.builder()
                .name("morpheus")
                .job("zion resident")
                .build();
        given()
                .body(user)
                .when()
                .put("https://reqres.in/api/users/2")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test(description = "patch update")
    public void dateTest(){
        User user = User.builder()
                .name("morpheus")
                .job("zion resident")
                .build();
        given()
                .body(user)
                .when()
                .patch("https://reqres.in/api/users/2")
                .then()
                .log().all()
                .statusCode(200);

    }

    @Test(description = "delete")
    public void deleteUserTest(){
        given()
                .when()
                .delete("https://reqres.in/api/users/2")
                .then()
                .log().all()
                .statusCode(204);
    }

    @Test(description = "post register successfull")
    public void postRegisterSuccessfullTest(){
        RegisterUser person = RegisterUser.builder()
                .email("eve.holt@reqres.in")
                .password("pistol")
                .build();
        given()
                .header("Content-Type","application/json")
                .body(person)
                .when()
                .post("https://reqres.in/api/register")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test(description = "register unsuccessful")
    public void postRegisterUnsuccessfulTest(){
        RegisterUser person = RegisterUser.builder()
                .email("sydney@fife")
                .build();
        given()
                .header("Content-Type", "application/json")
                .body(person)
                .when()
                .post("https://reqres.in/api/register")
                .then()
                .log().all()
                .statusCode(400);
    }

    @Test(description = "logon successful")
    public void postLoginSuccessfulTest(){
        RegisterUser person = RegisterUser.builder()
                .email("eve.holt@reqres.in")
                .password("cityslicka")
                .build();
        given()
                .header("Content-Type", "application/json")
                .body(person)
                .when()
                .post("https://reqres.in/api/login")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test(description = "login unsuccessful")
    public void postLOginUnsuccessfullTest(){
        RegisterUser person = RegisterUser.builder()
                .email("peter@klaven")
                .build();
        given()
                .header("Content-Type", "application/json")
                .body(person)
                .when()
                .post("https://reqres.in/api/login")
                .then()
                .log().all()
                .statusCode(400);
    }

    @Test (description = "get delayed response")
    public void getDelayedResponseTest(){
        String body = given()
                .when()
                .get("https://reqres.in/api/users?delay=3")
                .then()
                .statusCode(200)
                .extract().body().asString();
        DelayedList list = new Gson().fromJson(body,DelayedList.class);
        System.out.println(list);
    }



}
