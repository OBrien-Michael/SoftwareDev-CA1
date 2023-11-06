/*
The Student class implements the Printable interface
The Student object will hold a students details and an ArrayList of the exams they have taken
A students name must be at least 2 and at max 30 characters in length
printSummaryResults() will print to a file containing a students, id, name, exam id, exam subject, exam type and the exams score
printDetailedResults() will print to a file containing a students, id, name, exam id, exam subject, exam duration, exam type,
if the exam is a multiple choice print the no questions and correct answers and exam score.
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Student implements Printable{

    //Student variables
    private int studentId; //Used to store the id of a student.
    private String studentName; //Used to store the students name.
    private ArrayList<Exam> examsTaken; //Used to store an array of the exams the student has taken.

    //Get and set methods
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    //Check to see if student name is at least 2 characters and at most 30, if it is outside these, throw a new StudentException
    public void setStudentName(String studentName) throws StudentException {
        if(studentName.length() >= 2 && studentName.length() <= 30){
            this.studentName = studentName;
        }
        else {
            throw new StudentException("Error: Student name must be greater than 2 characters and less than 30 characters in length.");
        }
    }

    public ArrayList<Exam> getExamsTaken() {
        return examsTaken;
    }

    public void setExamArrayList(ArrayList<Exam> examsTaken) {
        this.examsTaken = examsTaken;
    }

    //Student constructor that takes in the studentId and studentName
    public Student(int studentId, String studentName) throws StudentException{
        this.setStudentId(studentId);
        this.setStudentName(studentName);
    }

    //Student constructor that takes in the studentId, the student name and an ArrayList of exams that the student has taken.
    public Student(int studentId, String studentName, ArrayList<Exam> examsTaken) throws StudentException{
        this.setStudentId(studentId);
        this.setStudentName(studentName);
        this.setExamArrayList(examsTaken);
    }

    //printSummaryResult will print the students, id, name, exam id, exam subject, exam type and the exams score to a file
    @Override
    public void printSummaryResult(ArrayList<ExamResult> examResultsArrayList) {

        try{
            //Create a new file and use a BufferedWriter to hold information to be written to the file
            FileWriter fileWriter = new FileWriter("Student Exam Summary Results.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);


            //If the examResultsArrayList is not empty iterate through and write the students details to the file
            if(!examResultsArrayList.isEmpty()) {
                for (ExamResult examResult:examResultsArrayList){

                    bufferedWriter.write("--------------------------------------------------");
                    bufferedWriter.newLine();
                    bufferedWriter.write("Student ID: "+examResult.getStudentObj().getStudentId()+"\t\t");
                    bufferedWriter.write("Student Name: "+examResult.getStudentObj().getStudentName());
                    bufferedWriter.newLine();
                    bufferedWriter.write("--------------------------------------------------");

                    bufferedWriter.newLine();
                    bufferedWriter.newLine();

                    bufferedWriter.write("Exam Id\t\t\t");
                    bufferedWriter.write("Subject\t\t\t");
                    bufferedWriter.write("Exam Type\t\t\t");
                    bufferedWriter.write("Exam Score");

                    bufferedWriter.newLine();
                    bufferedWriter.write("\t"+examResult.getExamObj().getExamId()+"\t\t\t");
                    bufferedWriter.write(examResult.getExamObj().getSubject()+"\t\t\t");

                    //If the exam type is an Essay or MultipleChoice print what exam type it is
                    if (examResult.getExamObj() instanceof Essay){
                        bufferedWriter.write("Essay\t\t\t\t");
                    } else if (examResult.getExamObj() instanceof MultipleChoice) {
                        bufferedWriter.write("Multiple Choice\t\t\t\t");
                    }
                    else{
                        bufferedWriter.write("No Exam Type\t\t\t\t");
                    }

                    bufferedWriter.write(""+examResult.getStudentExamScore());

                    bufferedWriter.newLine();
                    bufferedWriter.newLine();


                }
            } else{
                System.out.println("No exam results found.");
            }

            //Flush and close the writer.
            bufferedWriter.flush();
            bufferedWriter.close();
        }
        catch(IOException ioException){
            System.out.println(ioException.toString());
        }
    }

    //printDetailedResults will print a students id, name, exam id, exam subject, exam duration, exam type and exam score.
    //if the exam is a multiple choice print the no questions and correct answers
    @Override
    public void printDetailedResults(ArrayList<ExamResult> examResultsArrayList) {
        try{
            //Create a new file and use a BufferedWriter to hold information to be written to the file
            FileWriter fileWriter = new FileWriter("Student Exam Detailed Results.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);


            //If the examResultsArrayList is not empty iterate through and write the students details to the file
            if(!examResultsArrayList.isEmpty()) {
                for (ExamResult examResult:examResultsArrayList){

                    bufferedWriter.write("--------------------------------------------------");
                    bufferedWriter.newLine();
                    bufferedWriter.write("Student ID: "+examResult.getStudentObj().getStudentId()+"\t\t");
                    bufferedWriter.write("Student Name: "+examResult.getStudentObj().getStudentName());
                    bufferedWriter.newLine();
                    bufferedWriter.write("--------------------------------------------------");

                    bufferedWriter.newLine();
                    bufferedWriter.newLine();

                    bufferedWriter.write("Exam Id\t\t\t");
                    bufferedWriter.write("Subject\t\t\t");
                    bufferedWriter.write("Duration\t\t\t");
                    bufferedWriter.write("Exam Type\t\t\t");

                    //If the exam type is a MultipleChoice write the No.Questions and Answers
                    if(examResult.getExamObj() instanceof MultipleChoice){
                        bufferedWriter.write("No. Questions\t\t\t");
                        bufferedWriter.write("Answers\t\t\t");
                    }
                    bufferedWriter.write("Exam Score");

                    bufferedWriter.newLine();
                    bufferedWriter.write("\t"+examResult.getExamObj().getExamId()+"\t\t\t");
                    bufferedWriter.write(examResult.getExamObj().getSubject()+"\t\t\t");
                    bufferedWriter.write(examResult.getExamObj().getDuration()+"\t\t\t\t");

                    //If the exam type is an Essay or MultipleChoice print what exam type it is
                    if (examResult.getExamObj() instanceof Essay){
                        bufferedWriter.write("Essay\t\t\t\t");
                    } else if (examResult.getExamObj() instanceof MultipleChoice) {
                        bufferedWriter.write("Multiple Choice\t\t\t\t");
                    }
                    else{
                        bufferedWriter.write("No Exam Type\t\t\t\t");
                    }

                    //If the exam type is a MultipleChoice write the No.Questions and Answers
                    if(examResult.getExamObj() instanceof MultipleChoice){
                        bufferedWriter.write(((MultipleChoice) examResult.getExamObj()).getNoQuestions()+"\t\t\t\t\t");
                        bufferedWriter.write(((MultipleChoice) examResult.getExamObj()).getCorrectAnswers()+"\t\t\t\t");
                    }

                    bufferedWriter.write(""+examResult.getStudentExamScore());

                    bufferedWriter.newLine();
                    bufferedWriter.newLine();

                }
            } else{
                System.out.println("No exam results found.");
            }

            //Flush and close the writer.
            bufferedWriter.flush();
            bufferedWriter.close();
        }
        catch(IOException ioException){
            System.out.println(ioException.toString());
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", examsTaken=" + examsTaken +
                '}';
    }
}
