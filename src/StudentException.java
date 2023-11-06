/*
The StudentException class allows classes that extend this to throw a StudentException
It contains a message that can be set to be thrown to the console.
 */
public class StudentException extends Exception{

    //Exception message to be shown on console
    private String studentExceptionMessage;

    //Set and get methods for the StudentException object
    public String getsStudentExceptionMessage() {
        return studentExceptionMessage;
    }

    public void setStudentExceptionMessage(String studentExceptionMessage) {
        this.studentExceptionMessage = studentExceptionMessage;
    }

    //Default constructor for StudentException
    public StudentException() {
        this.studentExceptionMessage = "Error: Student Exception";
    }

    //Constructor for StudentException that takes in a message to be shown to the console
    public StudentException(String studentExceptionMessage){
        setStudentExceptionMessage(studentExceptionMessage);
    }

    @Override
    public String toString() {
        return this.getsStudentExceptionMessage();
    }

}
