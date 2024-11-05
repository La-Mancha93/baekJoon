import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true){
            int n = Integer.parseInt(br.readLine());
            if(n == -1) break;
            checkPerfect(n);
        }

    }

    private static void checkPerfect(int n) {
        int sum = 0;
        int[] array = new int[0];
        for(int i =1;i < n;i++){
            if(n % i == 0) {
                array = inputArray(array,i);
                sum += i;
            }
        }
        if(sum == n) {
            makePerfectLang(n, array);
        } else{
            System.out.println(n+" is NOT perfect.");
        }
    }

    private static void makePerfectLang(int n, int[] array) {
        StringBuilder output = new StringBuilder(n + " = ");
        for (int i = 0; i < array.length-1; i++) {
            int i1 = array[i];
            output.append(i1).append(" + ");
        }
        output.append(array[array.length-1]);
        System.out.println(output);
    }

    private static int[] inputArray(int[] array, int i) {
        int[] newArray = new int[array.length + 1];
        for(int j = 0; j< array.length; j++){
            newArray[j] = array[j];
        }
        newArray[array.length] = i;
        return newArray;
    }
}