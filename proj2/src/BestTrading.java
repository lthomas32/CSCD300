import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;

public class BestTrading{

    public static void main(String[] args) {
        if (args.length != 1)
            throw new IllegalArgumentException("Please enter command line argument");
        //open close file
        File arrayFile = openFile(args[0]);
        Scanner fileScanner = openFileScanner(arrayFile);
        int linesPer = countFile(fileScanner);
        fileScanner.close();

        if (linesPer == 0)
            throw new IllegalArgumentException("You have no data in the file, we wasn't told to write null this time");

        //fill array
        fileScanner = openFileScanner(arrayFile);
        int [] arr = fillArray(fileScanner,linesPer);
        fileScanner.close();

        //call recursive function
        int [] bestTradingDays = bestTrading(arr,0,arr.length-1);

        //I had the toString but his example had explicitly no spaces
        System.out.printf("[%d,%d,%d]\n", bestTradingDays[0],bestTradingDays[1],bestTradingDays[2]);


    }
    private static int[] bestTrading(int[] a, int low, int high) {
        //this is impossible unless you changed my code
        if (low > high)
            throw new IllegalArgumentException("low > high");
        //this is the easiest way
        int[] arr = new int[3];
        if (low == high) {
            arr[0] = low;
            arr[1] = high;
            arr[2] = 0;
            return arr;
        }
        //set a mid for the O(logN) recursive calls
        int mid = (low+high)/2;
        //check left half for best day
        int [] leftarr = bestTrading(a, low, mid);
        //check right half for best day
        int[] rightarr = bestTrading(a, mid+1, high);
        //the recursive call will actually do this on the way back for each one
        int[] accross = bestTradingAcross(a, low, high);

        // this determines what the best one only have 3 options
        if (leftarr[2] >= rightarr[2] && leftarr[2] > accross[2])
            return leftarr;
        else if (rightarr[2] >= leftarr[2] && rightarr[2] > accross[2])
            return rightarr;
        else
            return accross;



    }
    private static int [] bestTradingAcross(int [] a, int low, int high){
        if (low >= high)
            throw new IllegalArgumentException("low > high");
        int mid = (low+high)/2;
        //x and z are holding the index of low and high
        //I normally use i and j, but I messed up when making this and don't feel like changing it
        //technically all 4 are index variables

        int x = low;
        int z = high;
        int i,y;
        for (i = 0; i <= mid; i++){
            if (a[x] > a[i])
                x = i;
        }
        for (y = mid+1; y <= high; y++){
            if (a[z] < a[y])
                z = y;
        }

        int [] arr = {x,z,(a[z]-a[x])};
        return arr;
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
}


