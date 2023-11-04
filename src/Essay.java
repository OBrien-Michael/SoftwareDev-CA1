/*
The Essay class inherits Exam and implements the Scorable interface
 */
public class Essay extends Exam implements Scorable{

    private String essayAnswer; //Used to store the answer written by the student.
    private int grammar; //Used to store the mark attained by the student for grammar.
    private int content; //Used to store the mark attained by the student for essay content.
    private int wordLimit; //Used to store the upper word limit for the essay.

    public int gradeEssay(){
        return 0;
    }

    public void displayExamDetails(){

    }

    @Override
    public void calculateScore() {

    }
}
