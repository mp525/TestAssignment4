# Test assignment 4

## Mockito questions
In this section I will answer the questions about Mockito using examples.

### Question 1 - *How do you verify that a mock was called?*
You can verify that certain mocks have been called during a test with a simple “verify” static function on Mockito. The following example shows its use, marked with yellow.

![image 1](https://github.com/mp525/TestAssignment4/blob/master/images/1.JPG)

This example also verifies that a certain method “getBookingsForEmployee(id)” was called with a certain argument.

### Question 2 - *How do you verify that a mock was NOT called?*
Mockito has a simple method called “verifyNoInteractions” to which you can pass a mocked object. Following code shows an example implementation, with the method in yellow.

![image 2](https://github.com/mp525/TestAssignment4/blob/master/images/2.JPG)

### Question 3 - *How do you verify how many times a mock should have been called?*
Again, Mockito provides a simple solution to this problem. You can simply pass a parameter to the verify method, that specifies how many times a mock should have been called. Below example shows an implementation.

![image 3](https://github.com/mp525/TestAssignment4/blob/master/images/3.JPG)

### Question 4 - *How do you verify that a mock was called with specific arguments?*
The following code shows how to verify certain arguments given to a mock.

![image 4](https://github.com/mp525/TestAssignment4/blob/master/images/4.JPG)

### Question 5 - *How do you predicate to verify the properties of the arguments given to a call to the mock?*
To verify arguments’ properties with Mockito, there is a way to do that by using a specific method. The yellowed out part of the following example, shows one implementation.

![image 5](https://github.com/mp525/TestAssignment4/blob/master/images/5.JPG)

## Coverage report, mutation testing and static analysis
The coverage report was generated using jacoco and the following in a terminal: *mvn clean test*. The report front page is as follows:

![image 6](https://github.com/mp525/TestAssignment4/blob/master/images/jacoco.JPG)

The result is a html document showing the test coverage of the code. The document can be found in the *test_sites* folder. 

Mutation testing was done using PiTest and the following command: *mvn test-compile org.pitest:pitest-maven:mutationCoverage*. The results of the test are shown in the terminal as follows:

![image 7](https://github.com/mp525/TestAssignment4/blob/master/images/pitest_nonKilled.JPG)

Due to some unexplained error in implementation, the number of mutations "killed" is 0.

For the static analysis of the code I've used PMD. PMD generates an html document after running the following command in a terminal: *mvn pmd:pmd pmd:cpd*. This document shows any failure to follow a certain code standard, in the project. The resulting html page shows one error in my case:

