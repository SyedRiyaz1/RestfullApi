Feature: Cucumber TestjavaLogin
Scenario: validate page titlePage
Given Launch Gmailsite
When  I Open Gmail Website
Then Page Title is "Gmail"
And Close site
