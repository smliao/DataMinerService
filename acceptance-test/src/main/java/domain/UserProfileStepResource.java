package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserProfileStepResource {
    private String id;

    private String username;

    private int age;

    private List<String> interest;

    public static ArrayList<String> extractInterest(String interest) {
        if (interest == null || interest.isEmpty()) {
            return new ArrayList<>();
        }
        return new ArrayList<>(Arrays.asList(interest.split(",\\s*")));
    }

    public static UserProfileStepResource createFrom(Map<String, String> data) {
        String username = data.get("username");
        int age = Integer.parseInt(data.get("age"));
        List<String> interest = extractInterest(data.get("interest"));
        return new UserProfileStepResource(UUID.randomUUID().toString(), username, age, interest);
    }
}
