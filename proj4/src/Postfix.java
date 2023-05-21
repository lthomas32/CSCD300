// Authors: Lewis Thomas
// CSCD 300
// Assignment 4

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Scanner;


public class Postfix {

    public static void main(String[] args) {
        if (args.length != 1)
            throw new IllegalArgumentException("Please enter command line argument with the proper parameters");

        File listFile = openFile(args[0]);
        Scanner fileScanner = openFileScanner(listFile);
        ListStack stack = new ListStack();
        postfix(stack,fileScanner);
        fileScanner.close();

        DecimalFormat fmt = new DecimalFormat("###.######");

        if (stack.size() != 1)
            throw new IllegalArgumentException("Something went wrong not the right number of numbers/operands for a proper formula");
        System.out.println(fmt.format(Double.parseDouble(stack.top())));





    }

    private static File openFile(final String newFile) {
        //checking to arguments are valid
        if (newFile == null || newFile.isBlank())
            throw new IllegalArgumentException("Your file name was invalid");
        File inf = new File(newFile);

        //I was guaranteed a file. You did not insert the correct path.
        if(!(inf.exists()))
            throw new IllegalArgumentException("Your file does not exist");

        return inf;
    }
    private static Scanner openFileScanner(final File inf){
        if (inf == null)
            throw new IllegalArgumentException("File object is null in openFileScanner");

        try{
            return new Scanner(inf);
        }
        catch(FileNotFoundException e){
            throw new IllegalArgumentException("Invalid file path");
        }

    }
    private static void postfix(ListStack stack, Scanner fin ){
        double a, b;
        while(fin.hasNext()){
            String item = fin.nextLine();
            switch (item){
                case "+" -> {
                    a = Double.parseDouble(stack.pop());
                    b = Double.parseDouble(stack.pop());
                    stack.push(String.valueOf(b + a));
                }
                case"-" -> {
                    a = Double.parseDouble(stack.pop());
                    b = Double.parseDouble(stack.pop());
                    stack.push(String.valueOf(b - a));
                }
                case "*" -> {
                    a = Double.parseDouble(stack.pop());
                    b = Double.parseDouble(stack.pop());
                    stack.push(String.valueOf(b * a));
                }
                case "/" -> {
                    a = Double.parseDouble(stack.pop());
                    b = Double.parseDouble(stack.pop());
                    stack.push(String.valueOf(b / a));
                }
                default -> { stack.push(item);}

            }
        }

    }
}
