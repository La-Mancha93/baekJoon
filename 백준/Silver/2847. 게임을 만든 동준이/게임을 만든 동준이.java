import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] ints = new int[N];
        for (int i = 0; i < N; i++) {
            ints[i] = Integer.parseInt(br.readLine());
        }
        int count = 0;
        a: while(true){
            for (int i = 0; i < ints.length-1; i++) {
                if(ints[i] >= ints[i+1]){
                    ints[i]--;
                    count++;
                    continue a;
                }
            }
            break;
        }
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}
