/*
The Essay class inherits Exam and implements the Scorable interface
The Essay object holds the details for its superclass Exam and its own Essay variables
The essayAnswer cannot have less than 0 words.
The wordLimit of an Essay must be between 500 and 10000
It will have a gradeEssay() method used to calculate the score.
It will implement the calculateScore() method from the Scorable interface to return the score.
 */
public class Essay extends Exam implements Scorable{

    //Essay object variables
    private String essayAnswer; //Used to store the answer written by the student.
    private int grammar; //Used to store the mark attained by the student for grammar.
    private int content; //Used to store the mark attained by the student for essay content.
    private int wordLimit; //Used to store the upper word limit for the essay.

    //Get and Set Methods
    public String getEssayAnswer() {
        return essayAnswer;
    }

    //If the wordCount in the essayAnswer is less than 0 throw a new ExamException
    public void setEssayAnswer(String essayAnswer) throws ExamException{

        //Split the answer into words separated by a space then return the length of the array to get the word count.
        int wordCount = essayAnswer.split("\\s+").length;

        //If word count is greater than 0 and is not empty then set essayAnswer, if not throw exception.
        if(wordCount >= 0 && !essayAnswer.isEmpty()){
            this.essayAnswer = essayAnswer;
        }
        else{
            throw new ExamException("Error: Number of words in Essay Answer should be 0 or greater.");
        }
    }

    public int getGrammar() {
        return grammar;
    }

    public void setGrammar(int grammar) {
        this.grammar = grammar;
    }

    public int getContent() {
        return content;
    }

    public void setContent(int content) {
        this.content = content;
    }

    public int getWordLimit() {
        return wordLimit;
    }

    //If the wordLimit is less than 500 or greater than 10000 throw a new ExamException
    public void setWordLimit(int wordLimit) throws ExamException {
        if(wordLimit >= 500 && wordLimit <= 10000){
            this.wordLimit = wordLimit;
        }
        else {
            throw new ExamException("Error: Essay word limit should be between 500 and 10000 words.");
        }
    }

    //Essay Constructor that takes in the details for exam and essay
    public Essay(int examId, String subject, int duration, String essayAnswer, int grammar, int content, int wordLimit) throws ExamException{
        super(examId, subject, duration);
        this.setEssayAnswer(essayAnswer);
        this.setGrammar(grammar);
        this.setContent(content);
        this.setWordLimit(wordLimit);
    }

    //Display exam details prints all the details in the Essay object to the screen.
    public void displayExamDetails(){
        System.out.println("Exam id: "+this.getExamId());
        System.out.println("Subject name: "+this.getSubject());
        System.out.println("Exam duration: "+this.getDuration());
        System.out.println("Essay answer: "+this.getEssayAnswer());
        System.out.println("Grammar score: "+this.getGrammar());
        System.out.println("Content score: "+this.getContent());
        System.out.println("Essay word limit: "+this.getWordLimit()+"\n\n");
    }

    //This method grade the essay object using:
    //Grammar worth 25%
    //Content worth 75%
    //Penalise if word count is below and above in 10% increments
    //Return the total score
    public int gradeEssay(){

        int wordCount = essayAnswer.split("\\s+").length;//Find word count
        double grammarScore;
        double contentScore;
        double totalScore;
        
        //Calculate the score out of 100% based on grammar and content
        //Find 25% of grammar score.
        //Find 75% of content score.
        grammarScore = grammar/4.0;
        contentScore = (content/4.0)*3.0;

        //Total score of the essay before any penalty
        totalScore = grammarScore + contentScore;

        //Find the percentage difference between the word limit and word count
        double wordDifferenceAmount = this.getWordLimit()-wordCount;

        //If word difference is negative make it positive
        if(wordDifferenceAmount<0){
            wordDifferenceAmount = Math.abs(wordDifferenceAmount);
        }

        double percentageDifference = ((double)wordDifferenceAmount/this.getWordLimit())*100;

        //If the difference in percentage is great then set the word count penalty higher
        //If there is a low difference then set a lower penalty
        //Allow for up to 20% of a word difference
        if (percentageDifference >= 80.0) {
            totalScore = totalScore*0.2;
        } else if (percentageDifference >= 70.0) {
            totalScore = totalScore*0.3;
        } else if (percentageDifference >= 60.0) {
            totalScore = totalScore*0.4;
        } else if (percentageDifference >= 50.0) {
            totalScore = totalScore*0.5;
        } else if (percentageDifference >= 40.0) {
            totalScore = totalScore*0.6;
        } else if (percentageDifference >= 30.0) {
            totalScore = totalScore*0.7;
        } else if (percentageDifference >= 20.0) {
            totalScore = totalScore*0.8;
        } else if (percentageDifference > 10.0) {
            totalScore = totalScore*0.9;
        }

        return (int)totalScore;
    }

    //Calculate the total score using the gradeEssay method
    @Override
    public int calculateScore() {
        return this.gradeEssay();
    }

    @Override
    public String toString() {
        return "Essay{" +
                "essayAnswer='" + essayAnswer + '\'' +
                ", grammar=" + grammar +
                ", content=" + content +
                ", wordLimit=" + wordLimit +
                "} " + super.toString();
    }
}
