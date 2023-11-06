/*
The ExamException class allows classes that extend this to throw an ExamException
It contains a message that can be set to be thrown to the console.
 */

public class ExamException extends Exception{

    //Exception message to be shown on console
    private String examExceptionMessage;

    //Set and get methods
    public String getExamExceptionMessage() {
        return examExceptionMessage;
    }

    public void setExamExceptionMessage(String examExceptionMessage) {
        this.examExceptionMessage = examExceptionMessage;
    }

    //Default constructor for ExamException
    public ExamException() {
        this.setExamExceptionMessage("Error: Exam Exception");
    }

    //Constructor for the ExamException that takes in a message to be shown to the console
    public ExamException(String examExceptionMessage){
        setExamExceptionMessage(examExceptionMessage);
    }

    @Override
    public String toString() {
        return this.getExamExceptionMessage();
    }
}
