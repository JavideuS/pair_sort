import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class pairSort {


    //Should not be called
    private pairSort() {}

    // is v > w ?
    private static boolean greater(int v, int w) {
        ;   // optimization when reference equals
        return v>w;
    }

    //mejorar
    private static void sort_greater(int[] pairs,int start,int finish) {

        //int offset = 2; Siempre es 2 porque es en pares
        int[] last_pair = {pairs[finish-1], pairs[finish]};
        for(int i = finish -2; i >= start ; i--){
            pairs[i+2] = pairs[i];
        }
        pairs[start] =last_pair[0];
        pairs[start+1] =last_pair[1];
    }



    // is v < w ?
    private static boolean less(int v, int w) {
        return v < w;
    }


    private static void sort_between(int[] pairs, int finish, int mid){
        //We exchange the second and third number
        exchange(pairs,mid+1,finish -1);
        //Then we exchange the third number and the fourth
        exchange(pairs,finish-1,finish);
        if((finish-1)!=(mid+2)){
            sort_greater(pairs,mid+2,finish);
        }
    }

    private static void check_between(int[] pairs,int start, int finish){

        //Punto medio - 1 (para ajusar el index cero)
        int mid = ((finish+start)/2)-1;
        //int mid = start + ((finish - start) / 2);
        //Reduce Derecha
        if(less(pairs[mid+1],pairs[finish-1])){
            checkPairs(pairs,mid+1,finish);
        }
        //Reduce Izquierda
        else if(greater(pairs[mid],pairs[finish])){
            //Primero lo encajamos hacia la mitad
            sort_greater(pairs,mid+1,finish);
            //Ya que siempre accedo al ultimo como finish-1
            checkPairs(pairs,0,mid+2);
        }
        else if(pairs[mid] < pairs[finish - 1] && pairs[mid+1] > pairs[finish])
        {
            sort_between(pairs,finish,mid);
        }
        //Peor escenario
        else{
            //check_big_between(pairs,finish,mid);
            insertion_sort(pairs,finish);
        }


    }

//    private static void check_big_between(int[] pairs,int finish,int mid) {
//        //Primer caso
//        //Un switch de mas
//        if(pairs[mid-1] > pairs[finish-1] && pairs[mid+2] < pairs[finish]){
//            //Primero los switch
//            exchange(pairs,mid,finish-1);
//            exchange(pairs,mid,finish);
//            //Luego llamo a la ordenacion
//            sort_greater(pairs,mid+1,finish);
//            //sort_between(pairs,finish,mid+1) -> cualquiera sirve
//        }
//        //Segundo caso
//        else if(pairs[mid] < pairs[finish-1] && pairs[mid+1] > pairs[finish]){
//            //Primero el switch
//            exchange(pairs,mid,finish-1);
//            sort_between(pairs,finish,mid);
//        }
//        //Tercer caso
//        else if (pairs[mid-1] < pairs[finish-1]){
//            //Primero el switch
//            exchange(pairs,mid,finish-1);
//            //Luego llamo la ordenacion
//            sort_greater(pairs,mid+1,finish);
//            //sort_between(pairs,finish,mid+1) -> Cualquiera sirve
//        }
//        //Super raro
//        else{
//
//        }
//
//    }

    // Binary search to find the correct position to insert the value
    static int binarySearch(int[] arr, int val, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == val) {
                return mid;
            } else if (arr[mid] < val) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }

    // Insertion sort using binary search
    static void insertion_sort(int[] arr,int finish) {
        for (int i = finish -2; i < finish; i++) {
            int key = arr[i];
            // Find the correct position to insert the key using binary search
            int j = binarySearch(arr, key, 0, i - 1);
            // Shift elements to the right to make room for the key
            System.arraycopy(arr, j, arr, j + 1, i - j);
            // Insert the key into the correct position
            arr[j] = key;
        }
    }

    private static void exchange(int[] data,int a, int b){
        int temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }

    private static void checkPairs(int[] data, int start, int finish){
        if(less(data[finish -2],data[finish-1])){
            return;
        }
        else if(greater(data[start],data[finish])){
            sort_greater(data,start,finish);
        }
        else{
            check_between(data,start,finish);
        }
    }

    //public
    public static void sort(int[] a){
        if(a.length == 0) return;
        if(a.length == 1) return;

        if(greater(a[0],a[1])){
            exchange( a,0, 1);
        }

        int start = 2;
        for(int i=start; i<a.length; i+=2){
            if(greater(a[i], a[i+1])){
                exchange(a,i,i+1);
            }
            int finish = start + i;
            checkPairs(a,0,finish-1);
        }
    }


    private static void show(int[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
    }


    public static void main(String[] args) {
        int[] a = {10,7,1,5,2,3,9,6,8,0,21,6};
        pairSort.sort(a);
        show(a);

    }
}




