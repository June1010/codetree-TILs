import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        int N = Integer.parseInt(temp[0]);
        int M = Integer.parseInt(temp[1]);
        int[] arr = Arrays.stream(br.readLine().split(" "))
                          .mapToInt(Integer::parseInt)
                          .toArray();

        int j = -1;
        int sum = 0;
        int answer = 0;
        for (int i = 0; i < N; i++) {
            while (j+1 < N && sum < M) {
                j++;
                sum += arr[j];
            }

            if (sum == M) {
                answer++;
            }

            sum -= arr[i];
        }

        System.out.println(answer);
    }
}