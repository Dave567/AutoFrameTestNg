Feature: Adopt an animal from the zoo site1

@Functional
Scenario: Adopt  an animal
Given I am on the home page of Zoo site
When I goto Adoption page and check foravailability
And I adopt an animal
Then I should see the success message "your adoption has been set up"

@Functional
Scenario: Adopt an animal copy
Given I am on the home page of Zoo site
When I goto Adoption page and check for unavailability
Then I should see the error message "sorry, animal not available"
