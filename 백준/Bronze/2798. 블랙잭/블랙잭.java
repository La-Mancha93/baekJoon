import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] E1 = br.readLine().split(" ");
        String[] E2 = br.readLine().split(" ");

        int N = Integer.parseInt(E1[0]);
        int M = Integer.parseInt(E1[1]);

        int[] num = new int[E2.length];
        for (int i = 0; i < num.length; i++) {
            num[i] = Integer.parseInt(E2[i]);
        }
        int max = 0;
        // 3개의 숫자를 선택해 M의 숫자를 넘기지 않는다.같거나 작다
        // FOR문 3개를 돌리는데 k는 j보다값이 커야하고 j는 i보다 커야한다.
        a: for (int i = 0; i < num.length; i++) {
            for (int j = i+1; j < num.length; j++) {
                for (int k = j+1; k < num.length; k++) {
                    if(num[i]+num[j]+num[k] <= M){
                        //배열에 값을 전부 넣어둔다
                        //만약 M과 동일한 값이 나오면 break;
                        if(num[i] + num[j] + num[k] > max ) {
                            max = num[i] + num[j] + num[k];
                        }
                        if (M == num[i] + num[j] + num[k]) {
                            max = num[i] + num[j] + num[k];
                            break a;
                        }
                    }
                }
            }
        }
        //배열을 돌면서 max 값을 저장한다.
        //1. 배열 for문으로 값을 꺼낸다
        //2. 해당 값이 이전의 max값보다 클경우
        //3. 해당 값으로 max 값을 변경한다.
        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }
}
