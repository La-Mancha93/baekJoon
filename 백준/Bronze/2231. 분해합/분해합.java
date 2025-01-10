import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        //분해합: N과 N을 이루는 각 자리수의 합
        for (int i = 1; i < N; i++) {
            int num = i;
            String s = String.valueOf(i);
            String[] split = s.split("");
            for (int j = 0; j < split.length; j++) {
                int A = Integer.parseInt(split[j]);
                num += A;
            }
            if(num == N) {
                answer = i;
                break;
            }
        }
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }

    private static int siba(int c) {
        if(c == 0) return 1;
        int answer = 1;
        for (int i = 0; i< c;i++){
            answer *= 10;
        }
        return answer;
    }
}