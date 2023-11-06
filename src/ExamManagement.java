/*
ExamManagement App
This is a menu-driven application to add students, create exams and calculate the scores they receive.
It will allow a user to:
Add a new student.
Display a list of current students in the system.
Add exam results based on student id and which exam type it is to the system.
Display a list of all exams.
Print summary results to a file.
Print detailed results to a file.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class ExamManagement {
    public static void main(String[] args){

        System.out.println("Starting Exam Management App...");

        ArrayList<Student> studentArrayList = new ArrayList<>();
        ArrayList<Exam> examArrayList = new ArrayList<>();
        ArrayList<ExamResult> examResultArrayList = new ArrayList<>();

        //Create a new scanner to take in input from the console
        Scanner scanner = new Scanner(System.in);
        String userInput = "";


        System.out.println("Welcome to the Exam Management App.");

        //If the user enters 0 the application will exit
        while(!userInput.equals("0")){

            //Main menu
            System.out.println("\nWhat would you like to do today?\n");
            System.out.println("1. Add a new student.");
            System.out.println("2. Display list of current students.");
            System.out.println("3. Add exam results to the system.");
            System.out.println("4. Display list of all exams.");
            System.out.println("5. Print summary results to file.");
            System.out.println("6. Print detailed results to file.");
            System.out.println("7. Populate the app with test data.");
            System.out.println("0. Exit Exam Management App.\n");

            userInput = scanner.nextLine();

            if(userInput.equals("1")){ //Create a new student object and add them to the ArrayList

                int studentId;
                String studentName;
                Student newStudent;

                System.out.println("Please enter the new students details:");

                try{
                    System.out.println("Please enter student ID:");
                    studentId = Integer.parseInt(scanner.nextLine());

                    System.out.println("Please enter student name:");
                    studentName = scanner.nextLine();

                    //Create the new student and add them to the studentArrayList
                    newStudent = new Student(studentId,studentName);
                    studentArrayList.add(newStudent);

                    System.out.println("The new student has been added to the system.");
                }
                catch(NumberFormatException numberFormatException){
                    System.out.println("Error: Please enter only numbers for student ID.");
                }
                catch (StudentException studentException) {
                    System.out.println(studentException.toString());
                }

            }
            else if (userInput.equals("2")) { //Display current list of students
                //Display a list of the students in the system, if not just say no students have been added.
                if(studentArrayList.isEmpty()){
                    System.out.println("No students have been added to the system.");
                }
                else{
                    System.out.println("Displaying list of current students:");
                    for (Student student:studentArrayList) {
                        System.out.println("Student ID: "+student.getStudentId()+", "+"Student Name: "+student.getStudentName());
                    }
                }
            }
            /*
            Check to see if the student exists
            Add a new exam to the system and store the result of the results to the examResultArrayList
             */
            else if (userInput.equals("3")) {

                //Student variable
                int studentId;

                //Exam variables
                int examId;
                String subject;
                int duration;

                //Essay variables
                String essayAnswer;
                int grammar;
                int content;
                int wordLimit;

                //Multiple choice variables
                int correctAnswers;
                int noQuestions;


                System.out.println("Please enter the student id you wish to add results for:");
                System.out.println("Note: The student must already be entered in the system.");

                try{
                    studentId = Integer.parseInt(scanner.nextLine());

                    //Check to see if the student exists in the student array, if not return to the menu
                    for (Student student:studentArrayList){
                        if(student.getStudentId()==studentId){

                            System.out.println("Please enter the Exam Id:");
                            examId = Integer.parseInt(scanner.nextLine());

                            System.out.println("Please enter exam subject:");
                            subject = scanner.nextLine();

                            System.out.println("Please enter exam duration in minutes:");
                            duration = Integer.parseInt(scanner.nextLine());

                            System.out.println("Please enter the exam type you wish to add the results for:");
                            System.out.println("1. Essay");
                            System.out.println("2. Multiple Choice");

                            userInput = scanner.nextLine();

                            //Creating a new Essay exam
                            if (userInput.equals("1")){

                                System.out.println("Essay:");

                                System.out.println("Please enter essay answer written by student:");
                                essayAnswer = scanner.nextLine();

                                System.out.println("Please enter essay grammar score:");
                                grammar = Integer.parseInt(scanner.nextLine());

                                System.out.println("Please enter essay content mark:");
                                content = Integer.parseInt(scanner.nextLine());

                                System.out.println("Please enter the max word limit for the essay:");
                                wordLimit = Integer.parseInt(scanner.nextLine());

                                Essay newEssayObj = new Essay(examId,subject,duration,essayAnswer,grammar,content,wordLimit);
                                examArrayList.add(newEssayObj);

                                ExamResult newExamResult = new ExamResult(student,newEssayObj,newEssayObj.calculateScore());
                                examResultArrayList.add(newExamResult);

                                System.out.println("New Essay has been added for: "+student.getStudentName()+". The exam has been graded.\n");

                            }
                            //Creating a new MultipleChoice exam
                            else if (userInput.equals("2")){

                                System.out.println("Multiple Choice:");

                                System.out.println("Please enter number of questions in the multiple choice exam:");
                                noQuestions = Integer.parseInt(scanner.nextLine());

                                System.out.println("Please enter number of correct questions answered by student:");
                                correctAnswers = Integer.parseInt(scanner.nextLine());

                                //Create a newMultipleChoice
                                MultipleChoice newMultipleChoiceObj = new MultipleChoice(examId,subject,duration,correctAnswers,noQuestions);
                                examArrayList.add(newMultipleChoiceObj);

                                ExamResult newExamResult = new ExamResult(student,newMultipleChoiceObj,newMultipleChoiceObj.calculateScore());
                                examResultArrayList.add(newExamResult);

                                System.out.println("New Multiple Choice has been added for: "+student.getStudentName()+". The exam has been graded.\n");
                            }
                        }
                    }
                }
                catch(NumberFormatException numberFormatException){
                    System.out.println("Error: Please enter only numbers for student ID.");
                }
                catch(ExamException examException){
                    System.out.println(examException.toString());
                }
            }
            else if (userInput.equals("4")){//Display complete list of exams
                //Check for the correct displayExamDetails() to print to console
                for (Exam exam:examArrayList){
                    if(exam instanceof Essay){
                        ((Essay) exam).displayExamDetails();
                    }
                    else if(exam instanceof MultipleChoice){
                        ((MultipleChoice) exam).displayExamDetails();
                    }
                }
            }
            else if (userInput.equals("5")){//Print summary result to file
                System.out.println("Printing summary results to file");
                for (Student student:studentArrayList){
                    student.printSummaryResult(examResultArrayList);
                }
                System.out.println("File saved as Student Exam Summary Results.txt.");
            }
            else if (userInput.equals("6")) {//Print detailed results to file
                System.out.println("Printing detailed results to file");
                for (Student student:studentArrayList){
                    student.printDetailedResults(examResultArrayList);
                }
                System.out.println("File saved as Student Exam Detailed Results.txt.");
            }
            else if(userInput.equals("7")){//Enter test data into the system
                try {
                    System.out.println("Populating test data...");

                    Student testStudentOne = new Student(1,"John Johnson");
                    Student testStudentTwo = new Student(2,"Jack Jackson");

                    studentArrayList.add(testStudentOne);
                    studentArrayList.add(testStudentTwo);

                    //Lorem ipsum generated answer to 600 words
                    String essayTestAnswer = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur urna elit, facilisis vel vestibulum in, maximus non nibh. Nulla facilisi. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus semper rutrum velit, at dictum neque pharetra id. Proin suscipit consequat vestibulum. Quisque et felis ante. Quisque hendrerit diam vitae leo suscipit, vitae blandit purus varius.\n" +
                            "\n" +
                            "Nunc nisi nulla, dapibus ac tempor lacinia, commodo ut augue. Phasellus eget purus rhoncus, mollis tellus et, placerat augue. Integer in tincidunt metus, fringilla aliquet mi. In volutpat porta odio nec cursus. In pellentesque enim commodo justo placerat, in mattis mi condimentum. Fusce laoreet sem nisl, eu blandit lectus tristique sit amet. Proin in dui et nisi accumsan volutpat.\n" +
                            "\n" +
                            "Cras sit amet porttitor dolor. Phasellus sit amet eleifend tellus. Nunc eget sapien ut lorem dignissim dignissim in vel diam. Vestibulum non pellentesque sapien. Morbi turpis elit, semper vel metus et, interdum dictum neque. Sed iaculis, justo nec sollicitudin dignissim, leo leo bibendum nisi, vitae tempus urna orci ac tortor. Ut libero sapien, lacinia et velit at, porttitor rutrum erat. Duis ultrices velit vitae interdum mattis. Cras rutrum, urna id ultrices viverra, erat neque pulvinar leo, sit amet faucibus diam massa a neque. Nam rhoncus, metus a blandit rutrum, nulla urna dapibus lacus, sed convallis tortor ante malesuada est. Ut volutpat varius odio, consequat iaculis tellus viverra imperdiet. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque sed metus a lacus mattis vehicula.\n" +
                            "\n" +
                            "Nam tincidunt dictum est eu facilisis. Sed eget pretium elit. Donec luctus eleifend diam id venenatis. Praesent porta ipsum sed blandit fermentum. Fusce mattis vitae magna non malesuada. In ultricies pretium tellus eget iaculis. Nulla tincidunt leo eu risus feugiat, a sodales sem tempus. Suspendisse vel pretium tellus.\n" +
                            "\n" +
                            "Etiam finibus id augue congue vestibulum. Proin dui mauris, tempus eu posuere sed, tristique vitae velit. Maecenas a fringilla enim. Fusce orci lectus, tincidunt ut augue vitae, aliquet pellentesque elit. Ut at libero sed velit lobortis efficitur tempor in risus. Donec ultricies, enim tristique suscipit maximus, lacus turpis consectetur risus, at venenatis leo massa sed arcu. Morbi blandit ex at ligula ultrices ornare. Morbi efficitur cursus vulputate. Sed in mi sit amet tortor ultrices pharetra. Suspendisse aliquet, dolor id scelerisque dapibus, tortor neque sodales orci, scelerisque sodales sem dui at nunc. Ut dictum, nunc id congue venenatis, magna nibh pharetra tellus, non molestie dui tortor sed mi.\n" +
                            "\n" +
                            "Nulla id tempus tortor, id iaculis urna. Integer vel elit felis. Sed volutpat nec leo vitae varius. Nullam sed dui sem. In sollicitudin dui lacus, congue gravida dolor egestas a. Morbi dapibus sem a lobortis egestas. Nunc interdum quis dolor et dictum. Morbi interdum massa eget egestas lobortis. Donec eu dui nec libero eleifend congue id at justo. Suspendisse eget ante volutpat nisl suscipit bibendum vitae non augue. Duis eget odio nibh. Nullam congue dignissim cursus.\n" +
                            "\n" +
                            "Donec a lacus ut nibh semper porttitor. Nullam gravida euismod porttitor. Suspendisse potenti. Vivamus pulvinar nibh sit amet quam rutrum euismod. Aenean congue tempus tellus, sed sagittis orci tincidunt vel. Curabitur ac quam a tellus pharetra ornare. Donec in leo eu lorem eleifend ultrices vitae ac urna. Proin non condimentum ex. Nulla eu elit arcu. Ut eu hendrerit neque. Suspendisse condimentum semper diam facilisis lobortis.\n" +
                            "\n" +
                            "Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Mauris pretium ex at turpis porttitor varius. Aliquam erat volutpat. Etiam id condimentum ante, quis faucibus purus. Aliquam pharetra sed erat et condimentum. Pellentesque dapibus justo sed elit porttitor, at auctor sem rhoncus. Donec et libero eget neque commodo imperdiet. Integer ornare tortor vitae eleifend fermentum. Quisque blandit ligula sed sapien egestas, vitae aliquet arcu.";

                    //Create new Essay Exam objects
                    Essay testEssayOne = new Essay(1,"History",60,essayTestAnswer,100,100,1200);
                    Essay testEssayTwo = new Essay(2,"Geography",60,essayTestAnswer,75,100,600);

                    //Add the Essay Exams to the examArrayList
                    examArrayList.add(testEssayOne);
                    examArrayList.add(testEssayTwo);

                    //Create new MultipleChoice Exam objects
                    MultipleChoice testMultipleChoiceOne = new MultipleChoice(1,"History",120,20,30);
                    MultipleChoice testMultipleChoiceTwo = new MultipleChoice(3,"Math",60,25,50);

                    //Add the MultipleChoice Exams to the examArrayList
                    examArrayList.add(testMultipleChoiceOne);
                    examArrayList.add(testMultipleChoiceTwo);

                    //Create new ExamResult objects
                    ExamResult examResultOne = new ExamResult(testStudentOne,testEssayOne,testEssayOne.calculateScore());
                    ExamResult examResultTwo = new ExamResult(testStudentOne,testEssayTwo,testEssayTwo.calculateScore());
                    ExamResult examResultThree = new ExamResult(testStudentOne,testMultipleChoiceOne,testMultipleChoiceOne.calculateScore());
                    ExamResult examResultFour = new ExamResult(testStudentTwo,testMultipleChoiceTwo,testMultipleChoiceTwo.calculateScore());

                    //Add ExamResult objects to examResultArrayList
                    examResultArrayList.add(examResultOne);
                    examResultArrayList.add(examResultTwo);
                    examResultArrayList.add(examResultThree);
                    examResultArrayList.add(examResultFour);

                    System.out.println("Test data added to system\n");
                } catch (StudentException studentException) {
                    System.out.println(studentException.toString());
                } catch (ExamException examException) {
                    System.out.println(examException.toString());
                }
            }
        }
        System.out.println("Exam App Ending...");
    }
}
