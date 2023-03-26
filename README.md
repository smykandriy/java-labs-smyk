I Level

Modify the code of the first laboratory as follows: create an abstract class AerialVehicle and add two descendants: the Helicopter class from the first laboratory work and the Drone class.

The AerialVehicle class should contain the following fields:

manufacturer - a string that contains the name of the manufacturer of the aircraft.
maxSpeed - a numerical value that corresponds to the maximum speed that the vehicle can develop in the air.
Create two abstract methods: getMaxFlyingDistance() and getMaxDeliveryWeight() in the parent class.

To simplify the task, it should be assumed that your drone is powered by a battery. Accordingly, the drone class should contain information about the battery capacity, maximum drone speed, and battery consumption per minute of flight. Implement abstract methods in the child classes, if necessary, add attributes to the child classes that will be used in calculations.

For all classes, implement conversion of the object to a string representation (preference is given to using the @ToString annotation from the Lombok library).

Also, create an AerialVehicleManager class to demonstrate the created classes. In the main() method, create objects of the classes, adding them to a list (List) parameterized by the AerialVehicle type, and output them to the console using a for-each loop.

II Level

To the task described in Level I, the following should be added:

A method that allows adding a new object to the Manager class, which is a descendant of the abstract class add (for example, the method addReptile(final Reptile reptile), if the abstract class is named Reptile).
Two methods for searching objects in the *Manager class (for example, ReptileManager). For instance, this could be a method for finding all reptiles that weigh more than a specified number of kilograms - findAllWithWeightGreaterThan(int weight), or a method for finding all reptiles that have legs - findWithLegs().
The search methods should use stream operations and lambda expressions.

Additionally, two more descendant classes should be added to your abstract class. The choice of classes should be made independently, and you should explain your choice during the defense.

When completing Level 2 task, the implemented main method should:

Create 2 objects of each of the created classes
Add them to an object of the *Manager class
Call the created search methods and output the search results to the console.
