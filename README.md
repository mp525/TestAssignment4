# Test assignment 4

## Mockito questions
In this section I will answer the questions about Mockito using examples.

### Question 1 - *How do you verify that a mock was called?*
You can verify that certain mocks have been called during a test with a simple “verify” static function on Mockito. The following example shows its use, marked with yellow.
(img)
This example also verifies that a certain method “getBookingsForEmployee(id)” was called with a certain argument.

### Question 2 - *How do you verify that a mock was NOT called?*
Mockito has a simple method called “verifyNoInteractions” to which you can pass a mocked object. Following code shows an example implementation, with the method in yellow.
(img)

### Question 3 - *How do you verify how many times a mock should have been called?*
Again, Mockito provides a simple solution to this problem. You can simply pass a parameter to the verify method, that specifies how many times a mock should have been called. Below example shows an implementation.
(img)

### Question 4 - *How do you verify that a mock was called with specific arguments?*
The following code shows how to verify certain arguments given to a mock.
(img)

### Question 5 - *How do you predicate to verify the properties of the arguments given to a call to the mock?*
To verify arguments’ properties with Mockito, there is a way to do that by using a specific method. The yellowed out part of the following example, shows one implementation.
(img)
