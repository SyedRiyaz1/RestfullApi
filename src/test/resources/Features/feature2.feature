Feature:Cucumber: javaLogin
Scenario Outline: validate  user Id
Given Launch Gmailsite
When I Open Gmail Website
When Enter User id "<u>" Value
And click uid next
Then validate user Output for "<c1>"Criteria
When Enter Password id "<p>" Value
And  click pwd next
Then validate Password Output for "<c2>"Criteria
And Close site

Examples:
| u                     | c1           |    p                | c2            |
| riyaz.selenium        |  valid       |        94815380     | invalid       | 
|                       |   blank      |           N/A       |   N/A         |
| riyaz.selenium        | valid        |    9481538032       | valid         | 