import java.lang.reflect.Array;

//idk


public class Sort {
    public static <T extends Comparable<? super T>> void selectionSort(T [] arr){
        int inner, outer, min;

        for(inner = 0; inner < arr.length -1; inner++){
            min = inner;
            for(outer = inner + 1; outer < arr.length; outer++){
                if(arr[min].compareTo(arr[outer]) > 0)
                    min = outer;
            }

            if(min != inner)
                swap(arr,min, inner);
        }

    }

    public static <T extends Comparable<? super T>> void bubbleSort(T [] arr) {
        int right = arr.length - 1;
        while (right > 0) {
            int new_right = -1;
            for (int i = 0; i < right; i++) {
                if (arr[i].compareTo(arr[i + 1]) > 0) {
                    swap(arr,i, i+1 );
                    new_right = i;
                }
            }
            right = new_right;
        }
    }


    private static <T extends Comparable<? super T>> void insertionSort(T [] arr) {
        for (int i = 1; i < arr.length; i++){
            T key = arr[i];
            int j;
            for(j = i -1; j >= 0 && arr[j].compareTo(key) > 0; i--)
                arr[j+1] = arr[j];

            arr[j+1] = key;
        }
    }

    public static void mergeSort(int [] arr,int start, int end){
        if (start < end){


            int middle = (end + start)/2;
            mergeSort(arr,start,middle);
            mergeSort(arr,middle+1, end);

            merge(arr,start,middle,end);
        }
    }

    private static void merge(int[] arr, int start, int middle, int end){
        int [] leftArr = new int[middle-start+1];
        int [] rightArr = new int[end-middle];


        for (int i = 0; i < leftArr.length; i++) {
            leftArr[i] = arr[start+i];

        }
        for (int i = 0; i < rightArr.length; i++) {
            rightArr[i] = arr[middle+1+i];

        }

        int i = 0; int j = 0;
        for (int k = start; k <= end; k++) {
            if (i == leftArr.length) {
                arr[k] = rightArr[j];
                j++;
            }
            else if (j == rightArr.length) {
                arr[k] = leftArr[i];
                i++;
            }
            else if (leftArr[i] < rightArr[j]){
                arr[k] = leftArr[i];
                i++;
            }
            else {
                arr[k] = rightArr[j];
                j++;
            }
        }

    }


    private static <T extends Comparable<? super T>> void swap (T [] arr,int i, int j){

        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
