Feature: Visit Canyon Ranch Website
@login
  Scenario Outline: User visits the staging site and landing of account site
    Given Hit the Canyon Ranch staging URL
    When Hit the login "<endpoint>" url
    Then user enter the registered mobile number "<mobile>"
    And user clicks get verification code CTA
#    Then user enter the registered mobile number
    Then user enter the verification code "<code>"
    And user lands on account landing page
    Examples:
      |endpoint|mobile|code|
      |/login|2111111111|111111|

  Scenario Outline: Login from service listing page and landing of account site
    Given Hit the Canyon Ranch staging URL
    When User hit the service listing of las-vegas location
    And user clicks the Account CTA
    Then user navigates to login page
    Then user enter the registered mobile number "<mobile>"
    And user clicks get verification code CTA
    Then user enter the verification code "<code>"
    And user lands on account landing page
    Examples:
      |mobile|code|
      |2111111111|111111|


  Scenario Outline: Landing on service listing page post successful login
    Given Hit the Canyon Ranch staging URL
    When User hit the service listing of las-vegas location
    When user select the one category from any pillar
    And user clicks the sign-in or register CTA
    Then user navigates to login page
    Then user enter the registered mobile number "<mobile>"
    And user clicks get verification code CTA
    Then user enter the verification code "<code>"
    And user redirects to service listing page
    Examples:
      |mobile|code|
      |2111111111|111111|


  Scenario Outline: Landing on service details page post successful login
    Given Hit the Canyon Ranch staging URL
    When User hit the service listing of las-vegas location
    When user select the one category from any pillar
    Then user select the service from selected category
    And user hover to Add to cart CTA
    And user clicks the sign-in or register CTA
    Then user navigates to login page
    Then user enter the registered mobile number "<mobile>"
    And user clicks get verification code CTA
    Then user enter the verification code "<code>"
    And user redirects to service listing page
    Examples:
      |mobile|code|
      |2111111111|111111|

  @l
  Scenario Outline: Landing on service details page post successful login
    Given Hit the Canyon Ranch staging URL
    When User hit the service listing of las-vegas location
    When user select the one category from any pillar
    Then user select the service from selected category
    And user hover to Add to cart CTA
    And user clicks the sign-in or register CTA
    Then user navigates to login page
    Then user enter the registered number "<mobileno>"
    And user clicks get verification code CTA
    Then user enter the verification code "<vcode>"
    And user redirects to service listing page
    Examples:
      |mobileno|vcode|
      |2111111111|111111|
  
  Scenario: User logs in with OTP
    Given the app is launched
    When the user opens the SMS and fetches the OTP
    Then the OTP should be entered into the app