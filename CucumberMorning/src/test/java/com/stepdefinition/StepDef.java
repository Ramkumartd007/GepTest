package com.stepdefinition;


import io.cucumber.java.en.*;

public class StepDef {
	
	@Given("user launch the application")
	public void user_launch_the_application() {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("user launch the application");
	}
	@When("user enter the {string} in email field")
	public void user_enter_the_username_in_email_field(String Username) {
	    // Write code here that turns the phrase above into concrete actions
		 System.out.println("enter the username : " + Username);
	}
	@When("user enter the {string} in the password field")
	public void user_enter_the_password_in_the_password_field(String Password) {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("enter the password : " + Password);
	}
	@Then("user click the login button")
	public void user_click_the_login_button() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("click the login button");
	}

}
