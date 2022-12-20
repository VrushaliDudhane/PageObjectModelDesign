# PageObjectModelDesign
Page Object model Test automation Design using Selenium with Java, TestNG framework and Maven AUT-tripadvisor

Page Object model Test automation Design using Selenium with Java, TestNG framework and Maven-

The given project demonstrate the way of creating Page Object Model(POM) design pattern and running the test cases in parallel on two different browsers.
Application Under Test: Tripadvisor.com (You can find manual Test cases under folder /ManualTestCases

Technologies Used:
1)	Selenium WebDriver 4.4 (opensource)
2)	JDK 1.8 (Java Development Kit)
3)	Eclipse (Java Editor)
4)	TestNG (Test Unit Framework)
5)	Maven (Build Automation Tool)
6)	Log4j (logging API)
7)	Apache POI API (Read-Write utilities for Excel - Test Data Handling) 
8)	Browser - Google Chrome/ Microsoft Edge

Automation Framework Architecture: 
1)	 POM (Page Object Model) 
2)	 Maven (Build Automation Tool) 
3)	 Test Libraries for different UI Pages 
4)	 Test Utilities for different generic functions 
5)	 Report - Dashboard (Pass/Fail Test) by using TestNG report
6)	 GITHub Repository (Code Versioning Tool)
The best Practices used to design:
1)	Every Test method has single responsibility , no test case dependency
2)	Each page has separate page class and Page Test class
3)	A page object represents meaningful elements of a page and not necessarily a complete page
4)	 When navigate to another page, the initial page object should return another page object for the new page 
5)	A page object is not have any assertions
6)	Test class I not having any WebDriver Methods
7)	Followed Object Oriented Programming Concepts
i)	Encapsulation:  In every page class made all the locators private and  action methods as public
ii)	Abstraction: created Page class as a abstract class which has abstract methods like getPageTitle(), getWebElement(By locator)
iii)	Inheritance: BaseTest class which creates the reference of WebDriver which is been extended by all Test classes
iv)	Polymorphism:  used method overloading and logged in to the application with different set of parameters  
v)	Reduced code duplicacy
8)	Increased code reusability
9)	Left no hardcoded data in source code
10)	Used Extensive logging- everything which is part of source code get analyzed from logs without looking at the source code
11)	Generated and saved failure proofs outside the src code screenshots/
12)	Used as many assertions as possible
13)	Used explicite wait on each webelement to get loaded
14)	Handeled Exceptions with try catch block.
15)	Used TestNG listeners to trace the execution of Test cases



