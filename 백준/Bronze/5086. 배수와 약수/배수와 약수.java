import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            if(A == 0 && B == 0) break;
            if (factorCheck(A, B)) bw.write("factor\n");
            else if (multipleCheck(A, B)) bw.write("multiple\n");
            else bw.write("neither\n");
        }
        bw.flush();
        bw.close();
    }

    private static boolean factorCheck(int a, int b) {
        return b % a == 0;
    }

    private static boolean multipleCheck(int a, int b) {
        return a % b == 0;
    }
}