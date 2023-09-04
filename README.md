# Java-Udemy-Masterclass-Collections-Comparator-and-Comparable-Lesson
In this lesson, showed us the differences between Comparator(custom) and Comparable(natural) for sorting and comparing objects.

The Comparable Interface may be utilised if the objects have a natural ordering, 
We must override the compareTo() method
We get access to the Comparable Interface methods for sorting our objects

Comparator Interface is used to define custom comparison logic for objects that may not have a natural ordering
It allows you to create multiple ways to compare objects of a class, depending on your needs, without modifying the class itself.
You create a separate class that implements Comparator<T> and overrides the compare method to specify the comparison logic.
Objects that implement Comparator can be used to sort collections of objects based on the custom comparison logic provided by the comparator.
This is particularly useful when you want to sort objects in different ways without altering their original class.
