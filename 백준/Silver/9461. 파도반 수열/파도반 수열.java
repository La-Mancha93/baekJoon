import java.io.*;
import java.util.*;

public class Main {

    public static long[] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        memo = new long[500];
        for (int i = 0; i < T; i++) {
            Long answer = makeAnswer(Integer.parseInt(br.readLine()));
            bw.write(answer + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static Long makeAnswer(int i) {
        if(i <= 3 && i >0) {
            if(memo[i] != 0) return memo[i];
            memo[i] = 1;
            return memo[i];
        }
        if(i <= 5) {
            if(memo[i] != 0) return memo[i];
            memo[i] = 2;
            return memo[i];
        }
        if(memo[i] == 0) {
            memo[i] = makeAnswer(i - 1) + makeAnswer(i - 5);
        }
        return memo[i];
    }
}