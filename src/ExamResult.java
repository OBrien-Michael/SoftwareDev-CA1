/*
The ExamResult class will store the score received for a student on an exam
 */

public class ExamResult implements Comparable<ExamResult>{

    //ExamResult variables
    private Student studentObj; //Used to store the student object
    private Exam examObj; //Used to store an exam object
    private int studentExamScore; //Used to store the students score for the exam

    //Set and get methods
    public Student getStudentObj() {
        return studentObj;
    }

    public void setStudentObj(Student studentObj) {
        this.studentObj = studentObj;
    }

    public Exam getExamObj() {
        return examObj;
    }

    public void setExamObj(Exam examObj) {
        this.examObj = examObj;
    }

    public int getStudentExamScore() {
        return studentExamScore;
    }

    public void setStudentExamScore(int studentExamScore) {
        this.studentExamScore = studentExamScore;
    }

    //ExamResult object which takes in the students object, the exam object and the score achieved for the student
    public ExamResult(Student studentObj, Exam examObj, int studentExamScore) {
        this.setStudentObj(studentObj);
        this.setExamObj(examObj);
        this.setStudentExamScore(studentExamScore);
    }

    //The compareTo method compares the score of the current students object to another student results object
    //Will return -1 if it is less, 0 if it is the same and 1 if it is greater.
    @Override
    public int compareTo(ExamResult comparedExamResultObj) {
        return Integer.compare(this.getStudentExamScore(), comparedExamResultObj.getStudentExamScore());
    }

    @Override
    public String toString() {
        return "ExamResult{" +
                "studentObj=" + studentObj +
                ", examObj=" + examObj +
                ", studentExamScore=" + studentExamScore +
                '}';
    }
}
