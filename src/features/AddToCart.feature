@AddToCartFeature
Feature: Add products to the shopping-cart
Description: to test adding products in the shopping cart on Swag Lab App

@AddOneProduct
Scenario Outline: Verify user is able to add a product in the shopping-cart
 	Given User in products page
 	When User select a "<product>"
 	And User clicks on Add To The Cart button
 	Then Product added successfully in the shopping-cart
 	
 	Examples:
 	| product  		    |
 	|Sauce Labs Backpack|
 	
@AddMultipleProducts 
Scenario: Verify user is able to add multiple products in the shopping-cart
 	Given User in products page
 	When User select multiple products
 	| Field   | Value                    |
 	|product1 | Sauce Labs Bolt T-Shirt  |
 	|product2 | Sauce Labs Fleece Jacket |
 	|product3 |Sauce Labs Bike Light     |
 	And User clicks on Add To The Cart button
 	Then Product added successfully in the shopping-cart

 	
 	
