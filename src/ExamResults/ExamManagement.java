package ExamResults;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

class ExamManagement {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        List<ExamResult> examResults = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Student");
            System.out.println("2. Add Multiple Choice Exam Result");
            System.out.println("3. Add Essay Exam Result");
            System.out.println("4. Print Summary Result");
            System.out.println("5. Print Detailed Results");
            System.out.println("6. Quit");
            System.out.print("Enter your choice(only numbers allowed): ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                if (choice < 1 || choice > 6) {
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
                    continue;  // Ask for input again
                }

                switch (choice) {
                    case 1:
                        while (true) {
                            System.out.print("Enter Student ID: ");
                            String studentIdString = scanner.nextLine();
                            if (!Student.isValidStudentId(studentIdString)) {
                                System.out.println("Invalid student ID. Please enter only numeric characters.");
                            } else {
                                int studentIdInt = Integer.parseInt(studentIdString);

                                System.out.print("Enter Student Name: ");
                                String studentName = scanner.nextLine();

                                if (!Student.isValidStudentName(studentName)) {
                                    System.out.println("Invalid student name. Please enter only alphabetic characters.");
                                } else {
                                    try {
                                        Student student = new Student(studentIdInt, studentName);
                                        students.add(student);
                                        System.out.println("Student added successfully.");
                                        break;  // Break out of the loop if everything is valid
                                    } catch (StudentException e) {
                                        System.out.println(e.getMessage());
                                        break;  // Break out of the loop if there's an exception
                                    }
                                }
                            }
                        }
                        break;

                    case 2:
                        while (true) {
                            try {
                                System.out.print("Enter Student ID: ");
                                int studentId = scanner.nextInt();
                                scanner.nextLine();

                                Student student = findStudentById(students, studentId);
                                if (student == null) {
                                    System.out.println("Student not found.");
                                    break;
                                }

                                System.out.print("Enter Exam ID: ");
                                int examId = scanner.nextInt();
                                scanner.nextLine();

                                System.out.print("Enter Subject: ");
                                String subject = scanner.nextLine();

                                System.out.print("Enter Duration (in minutes): ");
                                int duration = scanner.nextInt();
                                scanner.nextLine();

                                System.out.print("Enter Total Questions: ");
                                int noQuestions = scanner.nextInt();
                                scanner.nextLine();

                                System.out.print("Enter Correct Answers: ");
                                int correctAnswers = scanner.nextInt();
                                scanner.nextLine();

                                try {
                                    Exam exam = new MultipleChoice(examId, subject, duration, correctAnswers, noQuestions);
                                    student.addExam(exam);
                                    double score = ((MultipleChoice) exam).calculateScore();
                                    ExamResult result = new ExamResult(student, exam, (int) score);
                                    examResults.add(result);
                                    System.out.println("Multiple Choice Exam result added successfully.");
                                    break;  // Break out of the loop if everything is valid
                                } catch (ExamException e) {
                                    System.out.println(e.getMessage());
                                    break;  // Break out of the loop if there's an exception
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid input. Please enter only numeric characters and try again.");
                                scanner.nextLine();
                            }
                        }
                        break;

                    case 3:
                        while (true) {
                            try {
                                System.out.print("Enter Student ID: ");
                                int studentId = scanner.nextInt();
                                scanner.nextLine();

                                Student student = findStudentById(students, studentId);
                                if (student == null) {
                                    System.out.println("Student not found.");
                                    break;
                                }

                                System.out.print("Enter Exam ID: ");
                                int examId = scanner.nextInt();
                                scanner.nextLine();

                                System.out.print("Enter Subject: ");
                                String subject = scanner.nextLine();

                                System.out.print("Enter Duration (in minutes): ");
                                int duration = scanner.nextInt();
                                scanner.nextLine();

                                System.out.print("Enter Essay Answer: ");
                                String essayAnswer = scanner.nextLine();

                                System.out.print("Enter Grammar Marks: ");
                                int grammar = scanner.nextInt();
                                scanner.nextLine();

                                System.out.print("Enter Content Marks: ");
                                int content = scanner.nextInt();
                                scanner.nextLine();

                                System.out.print("Enter Word Limit: ");
                                int wordLimit = scanner.nextInt();
                                scanner.nextLine();

                                try {
                                    Exam exam = new Essay(examId, subject, duration, essayAnswer, grammar, content, wordLimit);
                                    student.addExam(exam);
                                    double score = ((Essay) exam).calculateScore();
                                    ExamResult result = new ExamResult(student, exam, (int) score);
                                    examResults.add(result);
                                    System.out.println("Essay Exam result added successfully.");
                                    break;  // Break out of the loop if everything is valid
                                } catch (ExamException e) {
                                    System.out.println(e.getMessage());
                                    break;  // Break out of the loop if there's an exception
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid input. Please try again.");
                                scanner.nextLine();
                            }
                        }
                        break;

                    case 4:
                        try {
                            printSummaryResult(examResults);
                        } catch (IOException e) {
                            System.out.println("Error writing to file: " + e.getMessage());
                        }
                        break;

                    case 5:
                        try {
                            printDetailedResults(examResults);
                        } catch (IOException e) {
                            System.out.println("Error writing to file: " + e.getMessage());
                        }
                        break;

                    case 6:
                        scanner.close();
                        return;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter only numeric characters.");
                scanner.nextLine();  // Consume invalid input
            }
        }
    }

    private static Student findStudentById(List<Student> students, int studentId) {
        for (Student student : students) {
            if (student.getStudentId() == studentId) {
                return student;
            }
        }
        return null;
    }

    private static void printSummaryResult(List<ExamResult> examResults) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("summary_result.txt"));
        writer.write("-------------------------------------------------------\n");
        writer.write(String.format("%-22s%-30s%-25s%-25s\n", "Student ID", "Name", "Exam ID", "Subject"));
        writer.write("-------------------------------------------------------\n");

        for (ExamResult result : examResults) {
            Student student = result.getStudent();
            Exam exam = result.getExam();
            writer.write(String.format("%-22d%-30s%-25d%-25s\n",
                    student.getStudentId(), student.getStudentName(),
                    exam.getExamId(), exam.getSubject()));
        }

        writer.close();
        System.out.println("Summary result written to summary_result.txt");
    }

    private static void printDetailedResults(List<ExamResult> examResults) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("detailed_results.txt"));
        writer.write("-------------------------------------------------------\n");
        writer.write(String.format("%-22s%-30s%-25s%-25s%-25s%-25s\n",
                "Student ID", "Name", "Exam ID", "Subject", "Exam Type", "Score"));
        writer.write("-------------------------------------------------------\n");

        for (ExamResult result : examResults) {
            Student student = result.getStudent();
            Exam exam = result.getExam();
            String examType = (exam instanceof MultipleChoice) ? "Mult Choice" : "Essay";
            writer.write(String.format("%-22d%-30s%-25d%-25s%-25s%-25d\n",
                    student.getStudentId(), student.getStudentName(),
                    exam.getExamId(), exam.getSubject(), examType, result.getScore()));
        }

        writer.close();
        System.out.println("Detailed results written to detailed_results.txt");
    }
}
