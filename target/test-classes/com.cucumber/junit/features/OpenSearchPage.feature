@crossBrowser
Feature: User can navigate to different pages

@bookDepositorySearchPage
Scenario: Open Book Depository Search page
Given I am an anonymous customer with clear cookies
And I open the "https://www.bookdepository.com/search?searchTerm=&search=Find+book"
Then I am redirected to a "Search page"