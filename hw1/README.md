
# SE320 Homework 1: Closed-box Testing
## Fall 2020

- Assignment out: 10/07/2020
- Assignment due: 10/22/2020 by 11:59pm
- Late Policy: standard for the course, see the syllabus

### Overview
In this assignment you'll be writing a bit of code, and testing it using closed-box testing
techniques (we'll cover whitebox techniques in a later assignment).

### Code To Test
For this assignment, please implement a single static method that performs a binary search on a
sorted array.  We will work under the assumption that the array represents some kind of
multiset/bag structure, and that searches are only expected for elements that should be in the
array.

- Valid inputs to the search operation are non-null, non-empty arrays (i.e., length >= 0), and a non-null element to search for.
- Your search operation should tolerate bad input --- i.e., it should produce an exception (perhaps
  an
  [```IllegalArgumentException```](https://docs.oracle.com/javase/8/docs/api/index.html?java/lang/IllegalArgumentException.html))
  with an informative error message rather than crashing.  You don't need to check that the array
  is sorted, though --- you're free to produce any output if the input is otherwise valid but the
  array is unsorted.
    + (Why? This is a trade-off between correctness and performance; checking sortedness is linear in the size of the array, while binary search is logarithmic; checking sortedness would defeat the point of doing binary search.)
- If the sought-after element is present, the return value should be the index into the array where that element is found.
    + Arrays with duplicate entries are considered valid. If the element being searched for has duplicates, you may return the index of any copy of that element.
- If the sought-after element is not present in the array, you should raise an informative
  exception with an informative error message (perhaps a [```NoSuchElementException```](https://docs.oracle.com/javase/8/docs/api/index.html?java/util/NoSuchElementException.html)).

For your convenience, you may consider the ```Find``` specification from the
lecture slides, but note that your code is expected to work for more than just integers. 

The ```edu.drexel.se320.BinarySearch``` class in the template code (see below)
has the signature we expect you to implement; do not modify it.  If you are
inclined to change the signature of that method, you are probably on the wrong
track.  Note that this requires you to use Java generics with bounds to ensure
the implementation (should) work with any array that can have elements
compared.  For testing, you don't need to test for every conceivable type that
could be put in the array (this is impossible to do anyways).  You can stick to
one choice of array element type for all of your tests (e.g., Integer or
String).  Make use of the [```Comparable``` interface](https://docs.oracle.com/javase/8/docs/api/java/lang/Comparable.html). 

### Testing
Test your code!  Please write appropriate automated tests for your search functionality, by
*applying the closed-box testing techniques discussed in lecture and the text*.  (Note you'll be
expected to explain the approach you took; see below).

Note that the test cases discussed in class are *far* from adequate.

Tip: While discouraged by some groups' coding standards (for good reason), Java's ```import
static``` support can often make test suites a bit less verbose.  ```import static``` imports a
static method of some class such that it can be used directly as a local method, without having to
repeat the class name.  For example, you'll see that many test suites contain

```import static org.junit.jupiter.api.Assertions.assertEquals```

and similar for other static methods of ```org.junit.jupiter.api.Assertions```.  You're welcome to do this with
your search method as well.

The template code contains several trivial tests already as a reminder for how to write certain tests. 
Remember that the other class examples are on Github: https://github.com/Drexel-se320/examples


### Grading

- 20% Search Routine
    + If your code compiles, genuinely attempts to implement binary search, and passes all of your
      tests, you get 20/20 here.
    + If your code fails to compile, fails some of your tests, or if you implement something other than binary search (i.e.,
      something less error-prone), you'll get 0/20.
- 60% Test suite
- 20% Testing Approach
    + See below for description of what is expected
    + We *strongly* recommend writing this up in a file within the project directory. That way when you submit the .zip file containing the code, you'll automatically get the write-up too (otherwise people sometimes forget it)

Note that the 20% credit for your code is all-or-nothing, and doesn't depend on the code being bug-free!
Though if you get full credit for the testing portion and your tests all pass, then you've probably
caught most of your bugs.

Note: Yes, Java's standard library includes binary search implementations on arrays.  No, you may *not* simply call that --- you should implement the algorithm yourself; if you just call Java's, you'll get a 0 for the assignment.

### Submitting

Please submit through Learn by the deadline (or, following the late policy).

Please submit an archive file (.zip, .tar, or .tgz/.tar.gz) containing your work for the
assignment, including all scaffolding code (below), and a write-up of your testing approach.
We suggest putting your writeup file in the same directory as the build.gradle file, and
packing that one directory (this makes it hard to forget to submit the write-up).

For your write-up, you must explain the approach you took to testing your search routine.
Tell us if you used equivalence partitions, boundary value analysis, decision tables, etc.,
including what order you did these things and what process (if any) you used for each.  We are not
looking for a particular combination of techniques; we're interested in your record of how you
applied the chosen techniques.  For example, if you applied the Category-Partition method, what
categories did you end up with?  If you worked out decision tables, include them.  Any closed-box
technique you apply generates intermediate results that are not literally represented as test
methods written in Java.  If you're unsure what information to include here, you could of course err
on the side of more information, but really you should just ask.

Please *do not submit .rar* files!  Please submit your write-up as a .txt, .md, or .pdf file.

### Scaffolding and Source Control

As in the previous homework, you are provided with skeleton code that uses Gradle for building and running tests.  You're welcome to use whatever IDE/editor and test running approach you prefer, as long as those grading your work are still able to run the tests via Gradle.  A good way to ensure this is the case is to either run the tests yourself via Gradle prior to submission, or to ensure you're using your IDE's support for Gradle projects (most Java IDEs, including Eclipse and IntelliJ, include a plugin for this by default).

As in the previous homework, you are expected to be using version control to ensure you don't lose all of your progress.
