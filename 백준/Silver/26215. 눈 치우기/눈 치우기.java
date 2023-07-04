import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine(), " ");

		int sum = 0;
		int max = 0;

		int x;

		while (n-- > 0) {
			x = Integer.parseInt(st.nextToken());
			sum += x;
			max = Math.max(max, x);
		}
		int answer = 0;

		if (max * 2 >= sum) {
			answer = max;
		} else {
			answer = sum / 2 + (sum - max * 2) % 2;
		}

		if (answer > 1440)
			answer = -1;

		System.out.println(answer);
	}
}