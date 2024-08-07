import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		boolean[][] instruments = new boolean[n][1001];

		int k;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			k = Integer.parseInt(st.nextToken());

			for (int j = 0; j < k; j++) {
				instruments[i][Integer.parseInt(st.nextToken())] = true;
			}
		}

		int[] notes = new int[m];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < m; i++) {
			notes[i] = Integer.parseInt(st.nextToken());
		}

		int now;
		int max;

		int answer = 0;

		for (int i = 0; i < m;) {
			max = i;
			for (int j = 0; j < n; j++) {
				now = i;
				while (now < m && instruments[j][notes[now]]) {
					now++;
				}
				max = Math.max(max, now);
			}
			i = max;

			if (i < m)
				answer++;
		}

		System.out.println(answer);
	}
}