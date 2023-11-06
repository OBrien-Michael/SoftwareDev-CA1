/*
Any class that implements the Printable interface must implement its methods.
printSummaryResult and printDetailedResults take in an ExamResult ArrayList.
 */
import java.util.ArrayList;

public interface Printable {

    public void printSummaryResult(ArrayList<ExamResult> examResultArrayList);
    public void printDetailedResults(ArrayList<ExamResult> examResultArrayList);

}
