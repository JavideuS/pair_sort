
public class pairSort {

    //private
    private int[] data;

    private class checkPairs(int[] pairs){

    }

    private class int greater(int[] pairs){

        //[1][4] + [7][10]
        //-> [1][4][7][10]

        if(pair[1] < pair[2]){
            return 1;
        }
        else{
            return 0;
        }
    }

    private class int less(int[] pairs){

        //[1][4] + [7][10]
        //-> [1][4][7][10]

        if(pair[0] > pair[3]){
            //Save a copy of first number
            int temp = pair[0];
            //We changed with the start of the second pair
            pair[0] = pair[2];
            pair[2] = temp;

            //Now we save the second nu,ber
            temp = pair[1];
            //We changed it with the last of the second pair
            pair[1] = pair[3];
            pair[3] = temp;

            return 1;
        }
        else{
            return 0;
        }
    }

    private class int between(int[] pairs){

        //[1][8] + [5][7]
        //-> [1][5][7][8]
        if(pairs[0] < pairs[2] || pairs[1] > pairs[3]){

            //We exhange the second and third number
            exchange(pair[1],pair[2]);
            //Then we exhange the third number and the fourth
            exchange(pair[2],pair[3]);

            return 1;
        }
        else {
            return 0;
        }
    }

    private void exchange(int a, int b){
        int temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }


    //public

    //constructor
    public pairSort(int[] pairs) {
        //We save the array as a copy
        data = new int[pairs.length];
        for (int i = 0; i < pairs.length; i++) {
            data[i] = pairs[i];
        }
    }




    public static void main(String[] args) {


    }


}