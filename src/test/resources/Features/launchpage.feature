Feature: Launch Application form page


@Smoke1
  Scenario Outline: Verify user is place the phone order
    Given User is able to open the browser
    And user select mobilephone "<Brand>"
    And user add the order to cart
  And Check order in cart
    And user Enter the details
    And Completes the order placing
  Examples:
    | Brand |
   # | Samsung galaxy s6 |
    | Nokia lumia 1520  |
  #  | Nexus 6           |
    #| Samsung galaxy s7 |
  #  | Iphone 6 32gb     |

  @Smoke2
  Scenario Outline: Verify user is place the phone order
    Given User is able to open the browser
    And user select mobilephone "<Brand>"
    And user add the order to cart
    And Check order in cart
    And user Enter the custmer details from Excel "<SheetName>" and <Rownumber>
    Examples:
      | Brand            |  | SheetName       | Rownumber |
      | Nokia lumia 1520 |  | CustomerDetails | 0         |
      |Samsung galaxy s6 |  | CustomerDetails | 1         |
      | Nexus 6           |  | CustomerDetails | 2         |
      | Samsung galaxy s7 |  | CustomerDetails | 3         |
      | Iphone 6 32gb     |  | CustomerDetails | 4         |


  @Smoke3
  Scenario: Verify links
    Given User is able to open the browser
    And Verify Links













