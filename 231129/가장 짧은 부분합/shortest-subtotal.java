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
        int right = -1;

        for (int left = 0; left < N; left++) {
            while (right+1 < N && sum < M) {
                right++;
                sum += arr[right];
            }

            if (sum >= M) {
                ans = Math.min(ans, right-left+1);
            }
            
            sum -= arr[left];
        }

        ans = (ans == 999_999) ? -1 : ans;
        System.out.println(ans);
    }
}