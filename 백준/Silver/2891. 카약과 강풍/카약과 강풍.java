import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());

		boolean[] broken = new boolean[n + 1];
		boolean[] spare = new boolean[n + 1];

		int b;

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < s; i++) {
			b = Integer.parseInt(st.nextToken());
			broken[b] = true;
		}

		int a;

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < r; i++) {
			a = Integer.parseInt(st.nextToken());
			if (broken[a])
				broken[a] = false;
			else
				spare[a] = true;
		}

		for (int i = 1; i <= n; i++) {
			if (!spare[i])
				continue;
			else if (broken[i]) {
				broken[i] = false;
			} else if (broken[i - 1]) {
				broken[i - 1] = false;
			} else if (i < n && broken[i + 1]) {
				broken[i + 1] = false;
			}
		}

		int answer = 0;

		for (int i = 1; i <= n; i++) {
			if (broken[i])
				answer++;
		}

		System.out.println(answer);
	}
}