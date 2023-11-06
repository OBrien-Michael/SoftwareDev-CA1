/*
MultipleChoice class inherits Exam and implements the Scorable interface.
The MultipleChoice object holds the details for its superclass Exam and its own Essay variables.
Correct answers should be 0 or greater.
Number of questions in a MultipleChoice exam must be between 10 and 50.
It will implement the calculateScore() method from the Scorable interface to return the score.
 */
public class MultipleChoice extends Exam implements Scorable {

    //MultipleChoice variables
    private int correctAnswers; //Used to store the number of correct answers
    private int noQuestions; //Used to store the number of questions on the exam

    //Get and set methods
    public int getCorrectAnswers() {
        return correctAnswers;
    }

    //Check to see if correct answers is 0 or greater, if not throw a new ExamException
    public void setCorrectAnswers(int correctAnswers) throws ExamException {
        if(correctAnswers >= 0){
            this.correctAnswers = correctAnswers;
        }
        else {
            throw new ExamException("Error: Correct answers should be 0 or greater.");
        }
    }

    public int getNoQuestions() {
        return noQuestions;
    }

    //Check to see if no of questions is between 10 and 50, if not throw a new ExamException
    public void setNoQuestions(int noQuestions) throws ExamException{
        if(noQuestions >= 10 && noQuestions <= 50){
            this.noQuestions = noQuestions;
        }
        else {
            throw new ExamException("Error: Multiple choice questions should be between 10 and 50.");
        }
    }

    //Essay Constructor that takes in the details for Exam and MultipleChoice
    public MultipleChoice(int examId, String subject, int duration, int correctAnswers, int noQuestions) throws ExamException{
        super(examId, subject, duration);
        this.setCorrectAnswers(correctAnswers);
        this.setNoQuestions(noQuestions);
    }

    //Display exam details prints all the details in the MultipleChoice object to the screen.
    public void displayExamDetails(){
        System.out.println("Exam id: "+this.getExamId());
        System.out.println("Subject name: "+this.getSubject());
        System.out.println("Exam duration: "+this.getDuration());
        System.out.println("Multiple choice total questions: "+this.getNoQuestions());
        System.out.println("Multiple choice correct answers: "+this.getCorrectAnswers()+"\n\n");
    };

    //Calculate the multiple choice exam score out of 100.
    //Multiply the number of questions correct by 100, then divide by the total answers to get the percentage.
    @Override
    public int calculateScore() {
        int multipleChoiceScore = this.getCorrectAnswers() * 100;
        multipleChoiceScore = multipleChoiceScore/this.getNoQuestions();

        return multipleChoiceScore;
    }

    @Override
    public String toString() {
        return "MultipleChoice{" +
                "correctAnswers=" + correctAnswers +
                ", noQuestions=" + noQuestions +
                "} " + super.toString();
    }
}
