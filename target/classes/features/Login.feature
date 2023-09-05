@priority2
Feature: User Login

#background will be executed before every Scenario
Background: 
Given User navigates to Login page

@login @validcredentials @all @smoke @regression
Scenario Outline: Login with valid credentials
When User enters valid username <username>
And Enter Valid password <password>
And clicks on Login button
Then User should get navigated to overview page
Examples:
|username      |password |
|"shankhwarsumit"|"123456"   |
|"nehakhurana"   |"12345"    |

@login @invalid @all @regression
Scenario: Login with invalid credentials
When User enters invalid username "shankjh"
And Enter invalid password "1234567890"
And clicks on Login button
Then User should get a proper warning message


@login @validusernameandinvalidpasswprd @all @regression
Scenario: Login with valid username and invalid password
When User enters valid username "shankhwarsumit"
And Enter invalid password "1234567890"
And clicks on Login button
Then User should get a proper warning message

@login @invalidusernameandvalidpasswprd @all  @regression
Scenario: Login with invalid username and valid password
When User enters invalid username "shankhwarsu"
And Enter Valid password "123456"
And clicks on Login button
Then User should get a proper warning message

@login @noncredentials @all @regression
Scenario: Login without providing any credentials
When User dont enter username into username field
And User dont enter password into password field
Then User should get a proper warning message

