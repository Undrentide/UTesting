package ua.solvd.utesting;

import ua.solvd.utesting.api.GetMockMethod;
import ua.solvd.utesting.api.PostMockMethod;
import ua.solvd.utesting.api.PutMockMethod;
import ua.solvd.utesting.api.DeleteMockMethod;

import com.zebrunner.carina.core.IAbstractTest;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MockApiTest implements IAbstractTest {

    @Test(description = "Test 1: status code 200 OK...")
    public void testStatusCode200() {
        GetMockMethod api = new GetMockMethod("status/200");
        Response response = api.callAPI();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(description = "Test 2: status code 404 Not Found...")
    public void testStatusCode404() {
        GetMockMethod api = new GetMockMethod("status/404");
        Response response = api.callAPI();
        Assert.assertEquals(response.getStatusCode(), 404);
    }

    @Test(description = "Test 3: status code 500 Internal Server Error...")
    public void testStatusCode500() {
        GetMockMethod api = new GetMockMethod("status/500");
        Response response = api.callAPI();
        Assert.assertEquals(response.getStatusCode(), 500);
    }

    @Test(description = "Test 4: validate GET response body structure...")
    public void testGetMethodResponse() {
        GetMockMethod api = new GetMockMethod("get");
        Response response = api.callAPI();
        response.then().body("url", Matchers.equalTo("https://httpbin.org/get"));
    }

    @Test(description = "Test 5: POST request with payload validation...")
    public void testPostWithBody() {
        String jsonBody = "{\"name\": \"Alice\", \"role\": \"user\"}";
        PostMockMethod api = new PostMockMethod(jsonBody);
        Response response = api.callAPI();
        Assert.assertEquals(response.getStatusCode(), 200);
        String returnedName = response.jsonPath().getString("json.name");
        Assert.assertEquals(returnedName, "Alice");
    }

    @Test(description = "Test 6: PUT request updating resource state...")
    public void testPutMethod() {
        String jsonBody = "{\"status\": \"active\"}";
        PutMockMethod api = new PutMockMethod(jsonBody);
        Response response = api.callAPI();
        Assert.assertEquals(response.getStatusCode(), 200);
        response.then().body("json.status", Matchers.equalTo("active"));
    }

    @Test(description = "Test 7: DELETE request execution...")
    public void testDeleteMethod() {
        DeleteMockMethod api = new DeleteMockMethod();
        Response response = api.callAPI();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(description = "Test 8: URL query parameters processing...")
    public void testQueryParams() {
        GetMockMethod api = new GetMockMethod("get");
        api.getRequest().queryParam("tier", "Some tier...");
        api.getRequest().queryParam("region", "Some region...");
        Response response = api.callAPI();
        String tierValue = response.jsonPath().getString("args.tier");
        Assert.assertEquals(tierValue, "Some tier...");
    }

    @Test(description = "Test 9: custom HTTP headers verification...")
    public void testCustomHeaders() {
        GetMockMethod api = new GetMockMethod("headers");
        api.getRequest().header("X-Auth-Token", "SomeToken123");
        Response response = api.callAPI();
        String token = response.jsonPath().getString("headers.X-Auth-Token");
        Assert.assertEquals(token, "SomeToken123");
    }

    @Test(description = "Test 10: server response latency validation...")
    public void testResponseDelay() {
        GetMockMethod api = new GetMockMethod("delay/2");
        long startTime = System.currentTimeMillis();
        Response response = api.callAPI();
        long duration = (System.currentTimeMillis() - startTime) / 1000;
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertTrue(duration >= 2);
    }
}