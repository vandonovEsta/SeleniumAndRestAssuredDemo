Feature: Base Website functionality

#  Background:
#    Given We navigate to Endurosat website

  Scenario: Check satelite modules pricing
    Given We navigate to Endurosat website
    When We open the products list
    And Choose satellites
    Then Page should contain the right title
    And Pricing should be correct

  Scenario: Add product to cart and check cart content
    Given We navigate to Endurosat website
    When We open the products list
    And Choose satellites
    And From Satellites choose ENDURANCE product
    And Choose Add product to cart
    Then Review My List button should open the cart page
    And Cart should contain ENDURANCE product

  Scenario: Navigate to Space Service page
    Given We navigate to Endurosat website
    When We click on Space Service link
    Then The Space Service page should load

  Scenario: Navigate to Careers page
    Given We navigate to Endurosat website
    When We Click on Careers
    Then The Careers page should load
    And Open Positions Button Should be visible

  Scenario: Contact support
    Given We navigate to Endurosat website
    When We Click on Contact button
    And Select from topics Support
    And Fill the form
    And Click Send
    Then We should see confirmation that message was sent successfully
