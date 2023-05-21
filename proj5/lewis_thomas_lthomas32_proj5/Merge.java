//Lewis Thomas
//cscd 300

public class Merge {
    public static void main(String[] args) {
        if (args.length < 1)
            throw new IllegalArgumentException("No arguments provided");

        ArrayQueue [] queue = new ArrayQueue[args.length];
        ListQueue listQueue = new ListQueue();


        for (int i = 0; i < args.length; i++) {
            queue[i] = new ArrayQueue(10, args[i]);
        }


        for (ArrayQueue arrayQueue : queue) {
            while (arrayQueue.fin.hasNext() && arrayQueue.size() < 10) {
                String item = arrayQueue.fin.nextLine();
                arrayQueue.enqueue(item);
            }
        }


        while (notEmpty(queue)) {
            //theoretically it should be impossible to have a negative index
            int index = -1;
            //The list is not empty at least one number will be smaller
            Double smallest = Double.POSITIVE_INFINITY;

            for (int i = 0; i < queue.length; i++) {
                //abusing short circuit logic if the size == 0 it will just stop.
                //the list is not empty, so I will least have one index
                //The second part of the boolean is parsing the string and comparing it to smallest
                if(queue[i].size() != 0 && Double.compare(Double.parseDouble(queue[i].front()),smallest) < 0) {
                    index = i;
                    smallest = Double.parseDouble(queue[i].front());
                }
            }

            // this has to be something. It is impossible for it to be negative one or empty.
            listQueue.enqueue(queue[index].dequeue());

            //the file may have no more lines
            if (queue[index].fin.hasNext()) {
                String item = queue[index].fin.nextLine();
                queue[index].enqueue(item);
            }
            //if the queue is empty close the scanner
            if (queue[index].size() == 0) {
                queue[index].close();
            }
        }
        // just populate the list queue first in first out.
        while(listQueue.size() != 0)
            System.out.println(listQueue.dequeue());


    }

    private static boolean notEmpty(final ArrayQueue[] queue) {
        for (ArrayQueue arrayQueue : queue) {
            if (arrayQueue.size() != 0)
                return true;
        }
        return false;
    }

}
