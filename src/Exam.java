/*
The Exam class is an abstract class to be extended by other classes to give them the type of Exam.
The Exam object will hold the examId, the subject and the duration of an exam.
Duration must be between 30 and 180 minutes
 */

public abstract class Exam{

    //Object variables
    private int examId; //Used to uniquely identify each exam.
    private String subject; //Used to represent the subject of the exam.
    private int duration; //Used to store the duration of the exam in minutes.

    //Set and Get methods
    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getDuration() {
        return duration;
    }

    //Try to set the duration of the exam to be more than 30 minutes but less than 180 minutes.
    //If outside these parameters throw ExamException.
    public void setDuration(int duration) throws ExamException{

        if(duration >= 30 && duration <= 180){
            this.duration = duration;
        }
        else {
            throw new ExamException("Error: Exam duration must be greater than 30 minutes and less than 180 minutes.");
        }
    }

    //Exam Constructor
    public Exam(int examId, String subject, int duration) throws ExamException{
        this.setExamId(examId);
        this.setSubject(subject);
        this.setDuration(duration);
    }

    @Override
    public String toString() {
        return "Exam{" + "examId=" + examId + ", subject='" + subject + ", duration=" + duration + '}';
    }

}
