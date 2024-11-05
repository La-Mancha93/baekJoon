import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int count = 0;
        for(int i =1; i<=N;i++){
            if(N % i ==0) count++;
            if(count == K){
                bw.write(String.valueOf(i));
                break;
            }
        }
        if(count < K) bw.write(String.valueOf(0));
        bw.flush();
    }
}