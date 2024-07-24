Feature: Login functionality
		In order to do internet banking
		As a valid Para Bank customer
		I want to login successfully
		
#Scenario: Login_Sucessful
#Given I am in the login page of the Sauce Demo Application
#When I enter valid credentials
#Then I should be taken to the Product Page
#Scenario: Login_Sucessful
#Given I am in the login page
#When I enter valid credentials
#Then I should be taken to the Product Page

  Scenario Outline: Login_Sucessful
    Given I am in the login page of Sauce Demo Application
    When I enter valid <username> and <password> 
    Then I should be taken to the Product Page

    Examples: 
    |username|password|
    |"standard_user"|"secret_sauce"|
    

  #Scenario: Login_Sucessful
    #Given I am in the login page of Sauce Demo Application
    #When I enter valid credentials
    #|standard_user|secret_sauce|
    #Then I should be taken to the Product Page
