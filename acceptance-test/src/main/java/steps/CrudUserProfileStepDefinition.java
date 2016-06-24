package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import domain.CrudApi;
import domain.DataMinerServiceUrls;
import domain.ParentStepDefinition;
import domain.ResponseHelper;
import domain.UserProfileStepResource;

import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CrudUserProfileStepDefinition extends ParentStepDefinition {
    @Given("^I create a user profile with the follow details$")
    public void iCreateAUserProfileWithTheFollowDetails(Map<String, String> data) throws Throwable {
        UserProfileStepResource userProfileStepResource = UserProfileStepResource.createFrom(data);
        response = CrudApi.create(DataMinerServiceUrls.createUserProfile, userProfileStepResource);
        assertThat(response.getStatusCode(), is(201));
    }

    @Then("^I see user profile with details$")
    public void iSeeUserProfileWithDetails(Map<String, String> data) throws Throwable {
        UserProfileStepResource returnUserProfileResource = ResponseHelper.getUserProfileResource(response);

        assertThat(returnUserProfileResource.getUsername(), is(data.get("username")));
        assertThat(returnUserProfileResource.getAge(), is(Integer.parseInt(data.get("age"))));
        assertThat(returnUserProfileResource.getInterest(), is(UserProfileStepResource.extractInterest(data.get("interest"))));
    }
}
