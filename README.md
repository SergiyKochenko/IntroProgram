# Software Development CA1

You are tasked with designing a Java program for managing exam results for multiple students in a university.  The system should include the following:

1.	An interface called Scorable containing the following method:

a.	calculateScore(): This method should be implemented by classes that represent exams and calculates the score of the exam


2.	An abstract class called Exam containing the following attributes:

a.	examId (integer) to uniquely identify each exam
b.	subject (string) to represent the subject of the exam
c.	duration (integer) to store the duration of the exam in minutes


3.	Two classes, MultipleChoice and Essay, that inherit the Exam class and implement the Scorable interface

a.	For MultipleChoice, include the following additional attributes:
i.	correctAnswers (integer) to store the number of correct answers
ii.	noQuestions (integer) to store the number of questions on the exam
b.	For Essay, include the following attributes:
i.	essayAnswer (string) to store the essay answer written by the student
ii.	grammar (integer) to store the mark attained by the student for grammar
iii.	content (integer) to store the mark attained by the student for essay content
iv.	wordLimit (integer) to store the upper word limit for the essay
c.	Essay should also contain a method gradeEssay() that calculates the essay score (there is no set method, you decide, but it should be based on grammar, content and word count, eg, you could allocate x marks for each, weighting them as you see fit, and penalise if the word count goes a certain percentage above or below the number of words allowed.  Use a string method to work out the number of words in the essay answer supplied for this!)
d.	Implement a method displayExamDetails() in both MultipleChoice and Essay classes to display the exam details and results on screen
e.	When implementing the calculateScore() method from the Scorable interface for both classes, assume the mark being returned is out of 100, eg, if you have 25 questions and 15 correct answers, the score is 60%.

 

4.	Create an ExamException class and use it to add the following validation to the Exam, Essay and MultipleChoice classes:

a.	duration should be between 30 and 180 minutes (Exam)
b.	wordCount should be greater than or equal to 0 (Essay)
c.	wordLimit should be between 500 and 10000 (Essay)
d.	noQuestions should be between 10 and 50 (MultipleChoice)
e.	correctAnswers should be greater than or equal to zero (MultipleChoice)


5.	Create a class Student with the following attributes:

a.	studentId (integer) to uniquely identify each student
b.	studentName (string) to store the name of the student
c.	examsTaken (a list of Exam objects) to store the exams taken by the student


6.	Create a StudentException class and use it in the Student class to ensure that studentName is between 2 and 30 characters in length


7.	Create a Printable interface with methods printSummaryResult() and printDetailedResults().

8.	Implement the Printable interface in the Student class to allow printing of student results to a text file (Loads of info available of the internet but you could start here https://www.homeandlearn.co.uk/java/write_to_textfile.html).  Output should be formatted appropriately.  It does not have to look exactly like the example below but it should be clearly laid out in tabular format. 

![Picture1](https://github.com/SergiyKochenko/IntroProgram/assets/119933936/0be0c49d-a3ad-457d-b4c8-941c983180f0)



	
	Both print methods should be fully implemented.
 
9.	Create a class ExamResult that stores the result of an exam for a specific student. It should have the following attributes:

d.	student (a Student object) representing the student who took the exam
e.	exam (an Exam object) representing the exam taken by the student
f.	score (integer) representing the score achieved by the student in the exam
g.	Implement the Comparable interface in the ExamResult class to allow for comparison of results based on scores


10.	Create a main tester class ExamManagement that demonstrates the use of these classes. It should use ArrayLists and create instances of Student, Exam, and ExamResult.  It should also contain a menu driven system to allow exam results for multiple students to be entered from the keyboard and stored.  These results should then be displayed (offer several options here, eg, by exam type, sorted by score, etc) and a print to file option offered if required.

<hr>

# Exam Results Management System

This Java program is designed to manage exam results for multiple students in a university. It includes the following components:

## 1. Scorable Interface
An interface named `Scorable` containing the method `calculateScore()`.

## 2. Exam Abstract Class
An abstract class named `Exam` with the following attributes:
- `examId` (integer) to uniquely identify each exam.
- `subject` (string) to represent the subject of the exam.
- `duration` (integer) to store the duration of the exam in minutes.
It also includes a method `displayExamDetails()`.

## 3. MultipleChoice and Essay Classes
- `MultipleChoice` and `Essay` inherit from the `Exam` class and implement the `Scorable` interface.
- Additional attributes for `MultipleChoice`:
  - `correctAnswers` (integer) to store the number of correct answers.
  - `noQuestions` (integer) to store the number of questions on the exam.
- Additional attributes for `Essay`:
  - `essayAnswer` (string) to store the essay answer written by the student.
  - `grammar` (integer) to store the mark attained by the student for grammar.
  - `content` (integer) to store the mark attained by the student for essay content.
  - `wordLimit` (integer) to store the upper word limit for the essay.
- `Essay` also contains a method `gradeEssay()` that calculates the essay score.

## 4. ExamException Class
This class handles validation for attributes of `Exam`, `Essay`, and `MultipleChoice` classes:
- `duration` should be between 30 and 180 minutes (Exam).
- `wordCount` should be greater than or equal to 0 (Essay).
- `wordLimit` should be between 500 and 10000 (Essay).
- `noQuestions` should be between 10 and 50 (MultipleChoice).
- `correctAnswers` should be greater than or equal to zero (MultipleChoice).

## 5. Student Class
A class named `Student` with the following attributes:
- `studentId` (integer) to uniquely identify each student.
- `studentName` (string) to store the name of the student.
- `examsTaken` (a list of Exam objects) to store the exams taken by the student.

## 6. StudentException Class
This class ensures that `studentName` is between 2 and 30 characters in length.

## 7. Printable Interface
An interface named `Printable` with methods `printSummaryResult()` and `printDetailedResults()`.

![Screenshot_22](https://github.com/SergiyKochenko/IntroProgram/assets/119933936/b752032e-0f84-4f9b-8bde-80e66fca5a34)


![Screenshot_24](https://github.com/SergiyKochenko/IntroProgram/assets/119933936/b2766b1e-abbd-4723-9feb-eda796b08a33)




## 8. ExamResult Class
This class stores the result of an exam for a specific student with attributes:
- `student` (a Student object) representing the student who took the exam.
- `exam` (an Exam object) representing the exam taken by the student.
- `score` (integer) representing the score achieved by the student in the exam.
It implements the `Comparable` interface for result comparison based on scores.

## 9. ExamManagement Main Class
A main class named `ExamManagement` that demonstrates the use of the above classes. It uses ArrayLists to create instances of Student, Exam, and ExamResult. The program allows for the entry of exam results for multiple students, sorting and displaying them, and provides an option to print results to a text file.

Please refer to the respective class files for detailed implementation and functionality.

## Output menu

![Screenshot_29](https://github.com/SergiyKochenko/IntroProgram/assets/119933936/2fc8e401-295f-4088-a6b1-2d678d607a76)

![Screenshot_30](https://github.com/SergiyKochenko/IntroProgram/assets/119933936/f95abb08-cc43-4cae-82c7-34f49679eafd)

![Screenshot_33](https://github.com/SergiyKochenko/IntroProgram/assets/119933936/d1395b16-dd9f-41c5-9b50-430a838b5660)

![Screenshot_34](https://github.com/SergiyKochenko/IntroProgram/assets/119933936/ecef2c3a-5635-4d52-b705-32e87ed08305)




<hr>

## Credits

### Code

The structure and the code of the project were based on Software Development CA1 by ATU Atlantic Technological University (Donegal).

Stack Overflow, Google, YouTube, and Slack were used intensively for research into code functionalities and problem-solving.

### Contributing

This project is a personal portfolio project and is not open for contributions. However, you're welcome to explore the source code and use it as a reference or inspiration for your own projects.

### Inspiration

This project was inspired by the IntelliJ IDEA 2023.2.2 Java project and the Software Development CA1.

### Acknowledgment
Thanks to:
- The BSc Hons in Contemporary Software Development course at ATU Donegal program.
- Teresa Deeney  INSTRUCTOR MANAGER at ATU Atlantic Technological University (Donegal).
- The tutor support team at ATU Atlantic Technological University for their support.
- To my family and my friends who supported me in the project.
- Classmates for helping me.


