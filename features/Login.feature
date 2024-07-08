Feature: Login feature

  @Smoke
  Scenario: Login to bescome as a single user with valid credential
    Given Login to bescom app
    When enter 'jakkulababu@gmail.com' and 'Babu1234' and click on ok button
    Then I validate home link is 'BESCOM'

  @Smoke
  Scenario: Login to bescome with valid credential using datatable
    Given Login to bescom app
    When i enter user id and password and click on login button
      | userid                | password |
      | jakkulababu@gmail.com | Babu1234 |
    Then I validate home link is 'BESCOM'

  @Smoke
  Scenario Outline: Login to bescome with different user role with valid credential
    Given Login to bescom app
    When i enter '<userid>' and '<password>' and click on login button
    Then I validate home link shoule be '<homeText>'

    Examples: 
      | userid                | password | homeText |
      | jakkulababu@gmail.com | Babu1234 | BESCOM   |
      | jakkulababu@gmail.com | Babu1234 | BESCOM   |
      | jakkulababu@gmail.com | Babu1234 | BESCOM   |
      | jakkulababu@gmail.com | Babu1234 | BESCOM   |
      | jakkulababu@gmail.com | Babu1234 | BESCOM   |
      | jakkulababu@gmail.com | Babu1234 | BESCOM   |


  @Smoke
  Scenario: Login to bescome with valid credential using datatable
    Given Login to bescom app
    When i enter user id and password and click on login button
      | userid                | password |
      | jakkulababu@gmail.com | Babu1234 |
    Then I validate home link is 'BESCOM'

    
    
  #@Smoke @P23
  #Scenario Outline: Login to bescome with invalid credential
    #Given Login to bescom app
    #When i enter invalid '<uid>' and '<pws>' and click on login button
    #Then I validate error message shoule be '<error>'
#
    #Examples: 
      #| uid                   | pws     | error                    |
      #|                       | Bau1234 | Please enter UserName.   |
      #| jakkulababu@gmail.com |         | Please enter Password.   |
      #| jakks@gmail.com       | Bau1234 | Credentials are invalid. |
