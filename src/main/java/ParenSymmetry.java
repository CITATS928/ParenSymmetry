import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ParenSymmetry {


    private Boolean isBalanced(String s) {
        // implement this method
        int counterL=0;
        int counterR=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                counterL++;
            } else if (s.charAt(i)==')') {
                counterR++;
            }
        }

        if(counterR==counterL){
            //System.out.println("L is "+counterL+"\nR is "+counterR);
            return true;
        }else{
            //System.out.println("L is "+counterL+"\nR is "+counterR);
            return false;
        }

    }

    private void checkFile(String filename) throws FileNotFoundException {
        // open file named filename
        Scanner fileIn = new Scanner(new File(filename));

        while(fileIn.hasNext()){
            String lineIn = fileIn.nextLine();
            System.out.println(isBalanced(lineIn));//isBalanced(lineIn);
        }

        fileIn.close();
        // for each line in the file
            // read the line
            // print whether or not the line's parenthesis are balanced

        // CLOSE the file
    }

    public static void main(String[] args) throws FileNotFoundException {
        ParenSymmetry ps = new ParenSymmetry();

        ps.checkFile("/Users/qian/Desktop/ZipCode/Java/ParenSymmetry/TestStrings0.txt");
        System.out.println("==============");


        Boolean b0 = ps.isBalanced("()");
        printResult(b0, true);

        String[] falseStrings = {"(", "((", ")", "", "(()())((())))"};
        Boolean falses = true;
        for (String strToTest : falseStrings) {
            falses = ps.isBalanced(strToTest);
        }
        printResult(falses, false);

        String[] trueStrings = {"()", "(())", "(((())))", "", "(()())((()))", "(   )", "( () ( ) )"};
        Boolean trues = false;
        for (String strToTest : trueStrings) {
            trues = ps.isBalanced(strToTest);
        }
        printResult(trues, true);

    }

    private static void printResult(Boolean b0, boolean b) {
        if (b0 == null) {
            System.out.println("Null Failure");
            return;
        }
        if (b0 == b) {
            System.out.println("Success");
        } else {
            System.out.println("Failure");
        }
    }
}
