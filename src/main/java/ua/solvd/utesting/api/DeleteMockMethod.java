package ua.solvd.utesting.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.http.HttpMethodType;

@Endpoint(url = "${config.url}/delete", methodType = HttpMethodType.DELETE)
public class DeleteMockMethod extends AbstractApiMethodV2 {
    public DeleteMockMethod() {
    }
}