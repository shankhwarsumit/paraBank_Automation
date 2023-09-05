@priority1
Feature: User Registration

Background: 
Given User navigated to Register Account page

@register @mandatoryfields @smoke @regression
Scenario: Register with all fields
When User enters firstname "Ramn" into the First Name field
And Enters lastname "Narayann" into the lastname field
And Enters Address "gomtinagarn" into Address field
And Enters city "Lucknown" into city field
And Enters State "Uttar pradesh" into the State field
And Enters Zipcode "225002" into the Zipcode field
And Enters phone number "9090909090" into the Phone field
And Enters SSN "123" into the SSN field
And Enters Username "Narayann" into Username field
And Enters Password "1010" into Password field
And Enters Confirm "1010" into Confirm field
And Clicks on Register button 
Then Account should get successfully created

@register @nodetails @regression
Scenario: Register without providing any fields
When User dont enter details into any fields
And Clicks on Register button 
Then Warning messages should be displayed for all the fields

@register @duplicatephonenumber @regression
Scenario: Register with duplicate phone number
When User enters firstname "shyam" into the First Name field
And Enters lastname "Nara" into the lastname field
And Enters Address "bbk" into Address field
And Enters city "Lucknow" into city field
And Enters State "Uttar pradesh" into the State field
And Enters Zipcode "225002" into the Zipcode field
And Enters phone number "7355467233" into the Phone field
And Enters SSN "321" into the SSN field
And Enters Username "shyamnarayann" into Username field
And Enters Password "5555" into Password field
And Enters Confirm "5555" into Confirm field
And Clicks on Register button 
Then Account should get successfully created

@register @duplicateusername @reg
Scenario: Register with duplicate username
Given User navigated to Register Account page
When User enters firstname "pyyam" into the First Name field
And Enters lastname "Naara" into the lastname field
And Enters Address "bbk" into Address field
And Enters city "Lucknow" into city field
And Enters State "Uttar pradesh" into the State field
And Enters Zipcode "225002" into the Zipcode field
And Enters phone number "73554672333" into the Phone field
And Enters SSN "321" into the SSN field
And Enters Username "shankhwarsumit" into Username field
And Enters Password "5555" into Password field
And Enters Confirm "5555" into Confirm field
And Clicks on Register button 
Then warning message should be displayed 




