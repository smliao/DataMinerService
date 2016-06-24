package domain;

import com.jayway.restassured.response.Response;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.jayway.restassured.mapper.factory.Jackson2ObjectMapperFactory;

public class ResponseHelper {

    private static final ObjectMapper objectMapper = new ObjectMapper()
            .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
            .enable(SerializationFeature.INDENT_OUTPUT)
            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
            .disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);

    public static final Jackson2ObjectMapperFactory JACKSON_WITH_JODA = new Jackson2ObjectMapperFactory() {
        @Override
        public ObjectMapper create(Class cls, String charset) {
            return objectMapper;
        }
    };

    public static UserProfileStepResource getUserProfileResource(Response response) {
        return response.getBody().jsonPath().using(JACKSON_WITH_JODA).getObject("", UserProfileStepResource.class);
    }
}
