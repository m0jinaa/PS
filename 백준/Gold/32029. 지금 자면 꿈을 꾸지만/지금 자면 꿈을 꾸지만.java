import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, a, b;
	static int[] expire;

	static int howManyHomeworkCanIDo(int start, int duration, int sleep) {
		int cnt = 0;
		int time = 0;

		for (int i = 1; i < start; i++) {
			if (time + a <= expire[i]) {
				time += a;
				cnt++;
			}
		}

		time += sleep;

		for (int i = start; i <= n; i++) {
			if (time + duration <= expire[i]) {
				time += duration;
				cnt++;
			}
		}

		return cnt;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());

		expire = new int[n + 1];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			expire[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(expire);

		int answer = 0;

		for (int x = 0; x < a; x++) {
			for (int j = 1; j <= n; j++) {
				answer = Math.max(answer, howManyHomeworkCanIDo(j, a - x, b * x));
			}
		}

		System.out.println(answer);
	}
}