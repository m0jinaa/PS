import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] doll = new int[n];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			doll[i] = Integer.parseInt(st.nextToken());
		}

		int s = 0;
		int e = 0;
		int cnt = 0;
		int answer = n + 1;

		while (e < n) {
			if (doll[e] == 1)
				cnt++;

			while (cnt >= k) {
				answer = Math.min(answer, e - s + 1);
				if (doll[s++] == 1) {
					cnt--;
				}
			}
			e++;
		}
		System.out.println(answer == n + 1 ? -1 : answer);
	}
}