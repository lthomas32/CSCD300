import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RoundRobin {
    public static void main(String[] args) {
        if (args.length != 2)
            throw new IllegalArgumentException("Please enter command line argument with the proper parameters");

        File listFile = openFile(args[0]);
        Scanner fileScanner = openFileScanner(listFile);
        LinkedList roundRobin = fillList(fileScanner);
        fileScanner.close();



        int allottedTime;
        try {
            allottedTime = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Your second command line argument was not a number.");
        }

        if (allottedTime <= 0)
            throw new IllegalArgumentException("If the time is <= 0 I will be in an infinite loop, this is bad!");

        if (roundRobin.size() == 0)
            throw new IllegalArgumentException("No data was given please input a file with information");

        if (roundRobin.size() == 1)
            System.out.println(roundRobin.getCursor().getId());
        else {


            int[] remove = runOS(roundRobin, allottedTime);

            for (int i = 0; i < remove.length - 1; i++)
                System.out.print(remove[i] + ",");

            System.out.println(remove[remove.length-1]);
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

    private static LinkedList fillList (final Scanner fin){
        if (fin == null)
            throw new IllegalArgumentException("Bad scanner in fillArray");
        LinkedList roundRobin = new LinkedList();

        while(fin.hasNext()){
            roundRobin.addSorted(new Node(fin.nextLine()));
        }
        return roundRobin;
    }

    private static int[] runOS(LinkedList roundRobin, int allottedTime){
        Node curr = roundRobin.getCursor();
        int index = 0;
        int [] remove = new int[roundRobin.size()];

        while(roundRobin.size > 0){
            curr.setProcessingTime(curr.getProcessingTime()-allottedTime);
            if(curr.getProcessingTime() <= 0){
                remove[index] = curr.getId();
                index++;
                roundRobin.remove(curr);
            }
            //I chose not to clean up curr allowing this to happen. It has been stated it optional lots of time
            //If I wanted to I could make this an else and do it inside the if statement with temp holders
            // after I leave this spot garbage collection will remove the node completely.
            curr = curr.getNext();

        }
        return remove;

    }

}
