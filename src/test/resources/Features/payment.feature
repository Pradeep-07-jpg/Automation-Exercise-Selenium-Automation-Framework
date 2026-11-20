Feature: Payment and Order Confirmation

  Scenario: Verify successful payment and order confirmation
    Given the user is on the payment page
    When the user enters valid card details
    And the user confirms the order
    Then the successful order confirmation message should be displayed

  Scenario: Verify invoice download and continue navigation
    Given the user is on the order confirmation page
    When the user downloads the invoice
    And the invoice should be downloaded successfully
    Then the user clicks Continue