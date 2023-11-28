import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);
        int ans = 999_999;

        int[] arr = Arrays.stream(br.readLine().split(" "))
          .mapToInt(Integer::parseInt)
          .toArray();

        int sum = 0;
        int j = 0;
        for (int i = 0; i < N; i++) {
            while (j < N && sum + arr[j] < M) {
                sum += arr[j];
                j++;
            }
            // System.out.println("" + i + " " + j + " " +(j-i+1));
            ans = Math.min(ans, j-i+1);
            sum -= arr[i];
        }

        ans = (ans == 999_999) ? -1 : ans;
        System.out.println(ans);
    }
}