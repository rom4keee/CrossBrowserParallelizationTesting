@crossBrowser
Feature: User can navigate to different pages

@facebookLoginPage
Scenario: Open Facebook Login page
Given I am an anonymous customer with clear cookies
And I open the "https://www.facebook.com/"
Then I am redirected to a "Login page"
