package ua.solvd.utesting.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.http.HttpMethodType;

@Endpoint(url = "${config.url}/put", methodType = HttpMethodType.PUT)
public class PutMockMethod extends AbstractApiMethodV2 {
    public PutMockMethod(String jsonBody) {
        if (jsonBody != null && !jsonBody.isEmpty()) {
            setBodyContent(jsonBody);
            request.header("Content-Type", "application/json");
        }
    }
}