//Lewis Thomas
//CSCD_300

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ListQuickSort {
    public static void main(String[] args) {
        if (args.length != 1)
            throw new IllegalArgumentException("Please enter command line argument with the proper parameters");

        File listFile = openFile(args[0]);
        Scanner fileScanner = openFileScanner(listFile);
        DLinkedList list = fillList(fileScanner);
        fileScanner.close();
        list.quickSort();

        //I made you a pretty enhanced for loop in my class I hope you like it :P
        for(Integer data: list)
            System.out.println(data);

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
    private static DLinkedList fillList (final Scanner fin){
        if (fin == null)
            throw new IllegalArgumentException("Bad scanner in fillArray");

        DLinkedList list = new DLinkedList();
        while (fin.hasNext()) {
            list.addFirst(Integer.parseInt(fin.nextLine()));
        }
        return list;

    }

}

