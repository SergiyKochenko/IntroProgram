package ExamResults;



class MultipleChoice extends Exam implements Scorable {
    private int correctAnswers;
    private int noQuestions;

    public MultipleChoice(int examId, String subject, int duration, int correctAnswers, int noQuestions) throws ExamException {
        super(examId, subject, duration);
        if (noQuestions < 10 || noQuestions > 50) {
            throw new ExamException("Number of questions should be between 10 and 50");
        }
        if (correctAnswers < 0) {
            throw new ExamException("Correct answers should be greater than or equal to zero");
        }
        this.correctAnswers = correctAnswers;
        this.noQuestions = noQuestions;
    }

    public double calculateScore() {
        return ((double) correctAnswers / noQuestions) * 100;
    }

    public void displayExamDetails() {
        System.out.println("Exam Type: Multiple Choice");
        System.out.println("Exam ID: " + getExamId());
        System.out.println("Subject: " + getSubject());
        System.out.println("Duration: " + getDuration() + " minutes");
        System.out.println("Correct Answers: " + correctAnswers);
        System.out.println("Total Questions: " + noQuestions);
    }
}