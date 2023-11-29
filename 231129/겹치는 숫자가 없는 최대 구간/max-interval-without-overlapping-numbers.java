import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Set<Integer> visited = new HashSet();
        int answer = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" "))
                          .mapToInt(Integer::parseInt)
                          .toArray();

        int right = -1;
        for (int left = 0; left < N; left++) {
            while (right+1 < N && !visited.contains(arr[right+1])) {
                right++;
                visited.add(arr[right]);
            }

            answer = Math.max(answer, right-left+1);
            visited.remove(arr[left]);
        }

        System.out.println(answer);
    }
}