import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine(), " ");

		int answer = 0;

		int[] cnt = new int[50001];

		int x;

		while (n-- > 0) {
			x = Integer.parseInt(st.nextToken());

			cnt[x]++;

			answer = Math.max(answer, cnt[x]);
		}

		System.out.println(answer);
	}
}