# Assignment description
Create a class called **Course**.

The class has two fields:

- **name** of type **String**, represents the name of the course.
- **enrolments** of type **int**, represents the number of enrolled students in a course.

Implement the constructor **Course(String name, int enrolments)**, that initializes the fields to the value of the parameters.
Create two methods **String getName()** and **int getEnrolments()** to retrieve the name of the course and the number of enrolled students in the course.

Create the method **String toString()**, which returns a string that is a textual representation of a course object. A course should be represented by the following text: "The name of the course is <name> and there are <enrolments> students enrolled in the course", where <name> means the value of the field **name** and <enrolments> means the value of the field **enrolments**. For example, if the value of the fields **name** and **enrolments** are "Introductory Programming" and 150, respectively, then the method should return: "The name of the course is Introductory Programming and there are 150 students enrolled in the course"

To set the value of **name** and **enrolments** fields for a course, implement two methods **void setName(String name)** and **void setEnrolments(int enrolments)**. The **setName** method sets the value of the field **name** with its parameter. In the **setEnrolments** method, the number of enrolled students can be between 0 and 300 (including 0 and 300). Any other value outside this range is not valid. Implement the method such that, if the value of the parameter is smaller than 0, it prints the string "The number of enrolled students cannot be negative!". If the value is greater than 300, it prints the string "The number of enrolled students cannot be greater than 300!". Only set the **enrolments** field, if the value is within the valid range.

In your implementation make sure to use the correct access modifiers (public/private), for the class and all fields and methods.

**File to submit:** Course.java