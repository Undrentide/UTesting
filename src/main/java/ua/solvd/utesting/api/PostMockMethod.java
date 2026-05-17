package ua.solvd.utesting.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.http.HttpMethodType;

@Endpoint(url = "${config.url}/post", methodType = HttpMethodType.POST)
public class PostMockMethod extends AbstractApiMethodV2 {
    public PostMockMethod(String jsonBody) {
        if (jsonBody != null && !jsonBody.isEmpty()) {
            setBodyContent(jsonBody);
            request.header("Content-Type", "application/json");
        }
    }
}