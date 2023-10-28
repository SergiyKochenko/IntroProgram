# IntroProgram
 Software Development CA1

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

 

