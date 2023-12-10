import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        int N = Integer.parseInt(temp[0]);
        int K = Integer.parseInt(temp[1]);
        int[] arr = new int[N];
        int answer = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine()); 
        }

        Arrays.sort(arr);

        int left = 0;
        int right = arr.length-1;
        int sum = 0;

        while (left < right) {
            sum = arr[left] + arr[right];
            // 합이 목표보다 크다면, 합을 줄일 필요가 있음
            if (sum > K) {
                sum -= arr[right--];
            }
            // 합이 목표보다 같거나 작다면, 합을 늘릴 필요가 있음
            else if (sum < K) {
                answer++;
                sum -= arr[left++];
            } 
            // 합이 목표와 같다면, 합을 줄일 필요가 있음
            else {
                answer++;
                sum -= arr[right--];
            }
        }
        System.out.println(answer);
    }
}