
# SE320 Homework 0: Unit Testing & Java Brush-Up

- Assignment out: 9/30/2020
- Assignment due: 10/8/2020
- Late Policy: standard for the course, see the syllabus

### Overview
In this assignment you'll be getting acquainted with unit testing frameworks, which also serves as a
good opportunity to get familiar with the Java-based tools you'll be using this term during a
"lighter" assignment.

### Code To Test

The goal for this assignment is mostly establishing some basic familiarity with tools, so the code
you're implementing is not intended to be challenging.

Write a static method to compute the number of ways to select k elements of from a set of size n ---
i.e., n choose k.  If you'd like to read up on it, the Wikipedia article on [edu.drexel.se320.Combination](https://en.wikipedia.org/wiki/edu.drexel.se320.Combination) is adequate, all you really need to remember is that:

- For $k \le n$ and both non-negative, n choose k is $n!/(k!*(n-k)!).i
- If n exceeds k, the result is 0.
- If either input is negative, that is an invalid input: throw a
  java.lang.IllegalArgumentException in such cases, specifying which argument was bad.  Throw
  different exceptions depending on whether n, k, or both, are negative.

### Testing

Write some simple tests for your code.  The rest of the course focuses on being particularly
thorough, so take this as an opportunity to try out the various unit testing features discussed in
class.  You must cover each of the following:

- Two tests using basic assertion methods (e.g., assertEquals, etc.)
- Two tests using matchers (i.e., assertThat)
- Two tests using assertThrows to check that error signalling is done correctly: to verify that the IllegalArgumentException for a negative input
    correctly identifies the specific argument that was passed incorrectly (i.e., that if you pass
    negative k, the exception says k was negative rather than incorrectly claiming n was negative).
- Two tests using simple Jqwik @Property tests to check things that are true of multiple inputs

So you must write *at least* 8 test methods.  You are not required to write more, but it may be useful.

Each test must pass (for the right reason), including the exception tests.  Passing a test when the code fails might seem weird at first, but think of it this way: Tests pass when code does what it should.  There are certain times when code *should* throw exceptions!


Tip: While discouraged by some groups' coding standards (for good reason), Java's ```import
static``` support can often make test suites a bit less verbose.  ```import static``` imports a
static method of some class such that it can be used directly as a local method, without having to
repeat the class name.  For example, you'll see that many test suites contain

```import static org.junit.Assert.assertEquals```

and similar for other static methods of ```org.junit.Assert```.  You're welcome to do this as well.

The template code contains templates of *two* test classes with some imports already provided.  Note
that you must use at least two test classes, because they require different JUnit4 runners.

### Grading

- 20% Code
    + Your code must be what was requested, it must compile with ```gradlew compile```, and the tests
    must run to completion using ```gradlew test```.
- 80% Tests (10ts each)
    + Each test must be a unit test, checking a different piece of functionality from the other tests.
    + The exception-related tests may have overlap between the "expected" and Rule based approaches in what is checked. 


### Submitting

Please submit through Github Classroom by the deadline (or, following the late policy).

Make sure you have added any new files to git, and committed your changes.  Most IDEs will do a decent job making this clear.  On the command line, remember to both ```git add``` changed files and ```git commit``` to save a snapshot, and ```git push origin master``` to actually push the updates to Github!  If you're really stuck, let the course staff (TA or professor) know and we'll try to help.  If you're not sure whether it worked, you can look on Github to see if the latest changes there match what you just pushed.

### Scaffolding
To (possibly) simplify things for you, we're providing scaffolding for you to
use the gradle Java build tool for your project.  Gradle is similar to ant, but
requires a bit less work to get going.  We're providing a template project that
automatically downloads JUnit for you, and manages classpaths correctly when
running the test target.  For many projects, simply adding proper dependency
descriptions to the file build.gradle and placing a copy of your original
project's source code in src/edu.drexel.se320.Combination/java/ will be enough for gradle to compile
the project.  Extending or replacing the sample test files under src/test/java/
should make it easy to get started writing unit tests.

Gradle has the additional advantage of auto-generating scripts that relieve you of globally installing the correct gradle version on your computer.  The skeleton code contains scripts in the same directory as the edu.drexel.se320.Combination build file (```build.gradle```) that will download and run the appropriate version of gradle for you, from within your project directory.  These are also the scripts that many IDEs assume are present when importing Gradle projects, so don't delete them.

To run your tests from the command line / shell / command prompt / Powershell, change directory to the folder containing ```build.gradle``` and the ```gradlew``` scripts, and type

    ./gradlew test

on Mac OS or Linux systems, or

    .\gradlew.bat test

on Windows.

To make grading easier *we will be running your code via gradle*.  This means your code and test
suite need to work when we run your tests as just described.
This means your program source code must be in files under ```src/edu.drexel.se320.Combination/java/```, and your test code
must be somewhere under ```src/test/java/```.  Beyond that we don't have a preference for how you
organize your code into packages.  The template code already respects this directory layout, so if
you just put code in the same directories as the examples, it should work without issue.

That said, you don't need to use ```gradle``` yourself as you work through the project.  Eclipse,
NetBeans, and other Java IDEs should be able to work with the directory structure just fine, and
are capable of locating and running JUnit tests, though the details vary across IDEs.  You're
welcome to do development that way, and then make sure it still works via ```gradle``` shortly
before submitting.  Many Java IDEs have support for importing a gradle project and doing all building and testing via gradle.  In the case of Eclipse, you'll need to install the [Eclipse Buildship](https://projects.eclipse.org/projects/tools.buildship) plugin for this.


### Source Control
At this point, you should all know what version control / source control is, and be comfortable
with some form of it.  "My machine crashed and my code is gone" is not an acceptable reason for an extension in this course; you should be keeping all of your code under version control with a version stored somewhere other than your personal computer, from the moment you start work on an assignment.

I strongly recommend getting an account on a site like Github, Gitlab, or Bitbucket (there are others, these are only the most well-known), and using that to host git repositories to store your homework.  (Some also support mercurial if that's your preference.)

While these sites are best known for their role in open source collaboration, most let you keep private repositories as well (the details keep changing, mostly whether or not you need to register for a special academic discount or not; some simply give anyone unlimited private repositories).  I've been using this for pretty much all code I've written since... 2009.

If you're uncomfortable with placing your code on some company's servers, it's also possible to set up git or mercurial repositories on tux, stored in a (private) directory (this is *slightly* more complicated, but I just look it up online whenever I need to create a new such repository).

Keeping your code under version control with a non-local repository (any of the options above) has a number of advantages over normal folders on your hard drive:

- You get version control.
- If you're good about checking in code regularly when things are in good states, if you try out something that really backfires, you can reset to the last version of your code that at least mostly worked, without stressing about it or manually managing backups.
- In the process, you get backups (assuming you remember to not only commit, but push).
- Both git and mercurial can be used locally without any servers, but if you consistently push your latest commits to a server, you'll still have it even if your machine dies (for me, this has saved multiple homeworks and research projects from disaster over the years).
- You get into good habits for when you eventually go off and are expected to make regular checkins.
- After you finish courses, if you remember you've done some particular thing before but can't remember how, it's often easier to look back at the project where you did that thing than it is to search for the solution online.

*Do make sure, whichever route you choose, to ensure your repositories are private,* though, for obvious reasons.  On Github/Gitlab/Mercurial this is a setting you can choose when you create a new repository, and you can change it later if you realize you made a mistake.  On tux, using UNIX permissions to make some parent directory of the directory containing your code unreadable to group or other would suffice.  I have one directory (once "courses" but now called "research") that contains a subfolder for each project, each of which is a git repository.  Fixing permissions on that top directory is enough (chmod go-rwx courses).

If you'd like more information on any of this, I'm happy to send or post some references.  The
course syllabus has a link to a fully open & free book on using git.

