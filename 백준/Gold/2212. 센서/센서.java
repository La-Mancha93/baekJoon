import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        String[] split = br.readLine().split(" ");
        Integer[] sensor = new Integer[N];
        for (int i = 0; i < split.length; i++) {
            sensor[i] = Integer.parseInt(split[i]);
        }
        Arrays.sort(sensor,Comparator.reverseOrder());
        Integer[] dif = new Integer[N - 1];
        for(int i =0; i<dif.length;i++){
            dif[i] = sensor[i] - sensor[i+1];
        }
        Arrays.sort(dif,Comparator.reverseOrder());
        int result = 0;
        for(int i =K-1;i<N-1;i++){
            result+=dif[i];
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}