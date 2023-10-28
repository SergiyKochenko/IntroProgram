package ExamResults;

class Essay extends Exam implements Scorable {
    private String essayAnswer;
    private int grammar;
    private int content;
    private int wordLimit;

    public Essay(int examId, String subject, int duration, String essayAnswer, int grammar, int content, int wordLimit) throws ExamException {
        super(examId, subject, duration);
        if (essayAnswer.split("\\s+").length < 0) {
            throw new ExamException("Word count should be greater than or equal to zero");
        }
        if (wordLimit < 500 || wordLimit > 10000) {
            throw new ExamException("Word limit should be between 500 and 10000");
        }
        this.essayAnswer = essayAnswer;
        this.grammar = grammar;
        this.content = content;
        this.wordLimit = wordLimit;
    }

    public double calculateScore() {
        return gradeEssay();
    }

    public void displayExamDetails() {
        System.out.println("Exam Type: Essay");
        System.out.println("Exam ID: " + getExamId());
        System.out.println("Subject: " + getSubject());
        System.out.println("Duration: " + getDuration() + " minutes");
        System.out.println("Word Limit: " + wordLimit);
        System.out.println("Grammar Marks: " + grammar);
        System.out.println("Content Marks: " + content);
        System.out.println("Word Count: " + essayAnswer.split("\\s+").length);
    }

    public double gradeEssay() {
        int wordCount = essayAnswer.split("\\s+").length;
        if (wordCount > wordLimit * 1.1 || wordCount < wordLimit * 0.9) {
            return 0; // Penalize the score if word count is outside the specified range
        }
        return ((grammar + content) / 2.0);
    }
}
