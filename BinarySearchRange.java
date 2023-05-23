//Author: Lewis Thomas
//Class: CSCD300
//Email: lthomas32@ewu.edu

import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;

public class BinarySearchRange {
    public static void main(String [] args) {
        if (args.length != 3)
            throw new IllegalArgumentException("Please enter the correct amount of command line arguments for the assignment was told 3");

        //pulling numbers from command line
        int low;
        int high;
        try {
            low = Integer.parseInt(args[1]);
            high = Integer.parseInt(args[2]);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("Invalid arguments from command line the second and third argument must be integers");
        }

        //open file and checking it creating array
        File inf = openFile(args[0]);
        Scanner fileScanner = openFileScanner(inf);
        int linesPer = countFile(fileScanner);

        //reset cursor java sucks!
        fileScanner.close();

        //fill array open and close file
        fileScanner = openFileScanner(inf);
        int [] arr = fillArray(fileScanner,linesPer);
        fileScanner.close();

        if (arr.length == 0 || low > high || low > arr[arr.length-1] || high < arr[0])
            System.out.println("null");

        else if (arr[0] >= low && arr[arr.length-1] <= high)
            System.out.println("A[0.." + (arr.length-1) + "]");

        else{ //Lets get to work
            int firstIndex = findFirstIndex(low,arr);
            int lastIndex = findLastIndex(high, arr);

            //edge cases in methods as well
            if (firstIndex <= lastIndex)
                System.out.println("A[" + firstIndex + ".." + lastIndex + "]");
            else
                System.out.println("null");

        }
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

    private static int countFile(final Scanner fin){
        if (fin == null)
            throw new IllegalArgumentException("Scanner is null in count file");

        int count = 0;
        while (fin.hasNext()) {
            count++;
            fin.nextLine();
        }
        return count;
    }

    private static int [] fillArray (final Scanner fin, final int linesPer){
        if (fin == null)
            throw new IllegalArgumentException("Bad scanner in fillArray");
        int [] arr = new int [linesPer];
        for (int i =0; i < linesPer; i++){
            arr[i] = Integer.parseInt(fin.nextLine());
        }
        return arr;
    }

    private static int findFirstIndex(final int target, final int[]  arr){
        if (arr == null)
            throw new IllegalArgumentException("Null array in find first Index");

        //edge case
        if (arr[0] >= target)
            return 0;

        int low = 0;
        int high = arr.length-1;
        int mid;
        while (low <= high) {
            mid = (high + low) / 2;
            if (arr[mid] == target) {
                //guaranteed a sorted array so if one spot lower is less than then I know I am at the lowest index
                if (target > arr[mid-1])
                    return mid;

                //keep going
                //I don't need an else return will cause it leave
                high = mid - 1;
            } else if (target < arr[mid]) {

                //if one spot over is less than the low then I am at the lowest index
                //I know arr[mid] is greater than target
                if (target > arr[mid-1])
                    return mid;

                //keep going
                high = mid - 1;
            } else
                low = mid + 1;

        }

        return -1;
    }

    private static int findLastIndex(final int target, final int[] arr){
        if (arr == null)
            throw new IllegalArgumentException("Null array in find Last Index");
        int low = 0;
        int high = arr.length-1;
        int mid;

        //edge case
        if (arr[high] <= target)
            return high;

        while (low <= high) {
            mid = (high + low) / 2;
            if (arr[mid] == target) {
                //guaranteed a sorted array so if one spot higher is greater than then I know I am at the lowest index
                if (target < arr[mid+1])
                    return mid;

                //keep going
                //I don't need an else return will cause it leave
                low = mid + 1;
            } else if (target < arr[mid]) {
                high = mid - 1;
            } else {
                if (target < arr[mid + 1])
                    return mid;

                low = mid + 1;
            }

        }

        return -1;
    }

}
