import java.io.*;
import java.util.*;

public class Main {

    public static int N, M;
    public static int[] arrA, arrB;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        N = Integer.parseInt(temp[0]);
        M = Integer.parseInt(temp[1]);
        arrA = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        arrB = Arrays.stream(br.readLine().split(" "))
                     .mapToInt(Integer::parseInt)
                     .toArray();
        
        if (check()) {
            System.out.println("Yes");
            return;
        }
        System.out.println("No");
        return;
    }

    public static boolean check() {
        int i = 0;
        for (int j = 0; j < M; j++) {
            while (i < N && arrA[i] != arrB[j]) {
                i++;
            }

            if (i == N) {
                return false;
            } else {
                i++;
            }
        }
        return true;
    }
}