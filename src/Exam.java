/*

 */

public abstract class Exam {
    private int examId; //Used to uniquely identify each exam.
    private String subject; //Used to represent the subject of the exam.
    private int duration; //Used to store the duration of the exam in minutes.

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

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Exam() {
        this.examId = 0;
        this.subject = "Unknown";
        this.duration = 0;
    }

    public Exam(int examId, String subject, int duration) {
        this.examId = examId;
        this.subject = subject;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Exam{" + "examId=" + examId + ", subject='" + subject + '\'' + ", duration=" + duration + '}';
    }




}
