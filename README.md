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

## 8. ExamResult Class
This class stores the result of an exam for a specific student with attributes:
- `student` (a Student object) representing the student who took the exam.
- `exam` (an Exam object) representing the exam taken by the student.
- `score` (integer) representing the score achieved by the student in the exam.
It implements the `Comparable` interface for result comparison based on scores.

## 9. ExamManagement Main Class
A main class named `ExamManagement` that demonstrates the use of the above classes. It uses ArrayLists to create instances of Student, Exam, and ExamResult. The program allows for the entry of exam results for multiple students, sorting and displaying them, and provides an option to print results to a text file.

Please refer to the respective class files for detailed implementation and functionality.
