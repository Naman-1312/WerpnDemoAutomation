@SanityTest1
Feature: To Plan Purchase Functionality

  Scenario Outline: To verify the functionality of Plan Purchasing
    Given User is on Membership Plan Page
    When User select a plan and click on ApplyNow button
    And User select a payment option and click on Add to cart button
    And User click on Proceed to checkout button
    And User fill all the personal informations "<firstName>","<lastName>","<personalEmail>","<homePhone>","<mobilePhone>" and "<DOB>"
    And User fill all the mailing details "<streetAddress>","<Apartment>","<city>","<province>","<country>" and "<postalCode>"
    And User fill all the Employement Information "<graduationDate>", "<cnoNumber>", "<work>", "<union>" and "<sector>"
    And User click on Placeorder button
    And I fill all the Payment details
    Then I validate the payment success message

    Examples: 
      | firstName | lastName   | personalEmail              | homePhone  | mobilePhone | DOB        | streetAddress | Apartment | city      | province | country | postalCode | graduationDate | cnoNumber | work      | union | sector       |
      | Demo      | automation | demoautomation@yopmail.com | 9838181818 |  9181811818 | 20-12-2001 | automation    |       290 | ghaziabad | Ontario  | Canada  | L6A        | 17-12-2024     | DG6261    | Part Time | CUPE  | Primary Care |
