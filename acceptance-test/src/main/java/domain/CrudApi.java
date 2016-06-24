package domain;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

import static com.jayway.restassured.RestAssured.with;

public abstract class CrudApi {

    public static Response create(ResourceUrl url, Object object) {
        return preparePostWith(object).post(url.value());
    }

    public static RequestSpecification preparePostWith(Object object) {
        return with().body(object).and().contentType(ContentType.JSON);
    }
}
