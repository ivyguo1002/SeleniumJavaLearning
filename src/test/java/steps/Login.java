package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login {
    @When("I log in as user")
    public void iLogInAsUser() {
        System.out.println("log in as user");
    }

    @Given("I have signed in as a user")
    public void iHaveSignedInAsAUser() {
        System.out.println("I have signed in as a user");
    }

    @Then("I should be logged in to the system")
    public void iShouldBeLoggedInToTheSystem() {
        System.out.println("I should be logged into the system");
    }

    @When("I log in with username {string} password {string}")
    public void iLogInWithUsernamePassword(String arg0, String arg1) {
        System.out.println(arg0);
        System.out.println(arg1);
    }
}
