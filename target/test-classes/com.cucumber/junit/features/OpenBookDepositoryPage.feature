@crossBrowser
Feature: User can navigate to different pages

  @bookDepositoryHomePage
  Scenario: Open Book Depository Home page for guest user
    Given I am an anonymous customer with clear cookies
    And I open the "https://www.bookdepository.com/"
    Then I am redirected to a "Home page"
