Feature: Zoho Feature One
Scenario Outline: signup
Given zoho Site Launch
When go To Zoho Homepage Send "<usernames>" "<passwords>" "<mobileNumber>"
And click Submit Takescreenshot


Examples: 
|usernames|passwords|mobileNumber|
|username11|password11|111111|

