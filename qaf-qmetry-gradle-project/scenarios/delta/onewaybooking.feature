Feature: Booking Page Validation

Scenario Outline: Validate One Way Booking

Given User is on Delta Booking Page 
	When User clicks on Trip type dropdown
#		And User selects trip type '<trip>'
#	When User clicks on From Link
#And User enters departure airport 'LAX'
#And User selects departure airport from search results
#And User clicks on To link
#And User enters destination airport 'DCA'
#And User selects destination airport from search results
#And User selects trip type 'oneway'
#And User selects departure date '02/05/2022'
#And User selects number of passenger '2'
#And User clicks on search button
#Then list of flights should generate

Examples: {'dataFile':'resources/uat/delta/data/onewaybooking.json'}
