package ua.solvd.utesting.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.http.HttpMethodType;

@Endpoint(url = "${config.url}/${path}", methodType = HttpMethodType.GET)
public class GetMockMethod extends AbstractApiMethodV2 {
    public GetMockMethod(String path) {
        replaceUrlPlaceholder("path", path);
    }
}