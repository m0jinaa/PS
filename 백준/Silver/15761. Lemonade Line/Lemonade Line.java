import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine(), " ");

		int[] time = new int[n];

		for (int i = 0; i < n; i++) {
			time[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(time);

		int answer = 0;

		for (int i = n - 1; i >= 0; i--) {
			if (time[i] < n - 1 - i)
				break;
			answer++;
		}

		System.out.println(answer);
	}
}