import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int[] h = new int[1000001];

		int answer = 0;

		int x;

		st = new StringTokenizer(br.readLine(), " ");

		while (n-- > 0) {
			x = Integer.parseInt(st.nextToken());
			if (h[x] > 0) {
				h[x]--;
				h[--x]++;
			} else {
				answer++;
				h[x - 1]++;
			}
		}

		System.out.println(answer);
	}
}