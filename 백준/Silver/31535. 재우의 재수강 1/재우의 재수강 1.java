import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());

		int[] a = new int[n];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}

		int[] p = new int[n + 1];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			p[i] = Integer.parseInt(st.nextToken());
		}
		p[n] = p[n - 1];

		// y까지 도달하기
		int i;
		int cost = 0;
		int j = 0;
		int now = 0;

		for (i = 0; i < n; i++) {
			if (now >= y)
				break;
			cost += (Math.min(y, a[i]) - now) * p[i];
			j = i;
			now = a[i];
		}

		int answer = cost + p[j] * w;

		int s = y;
		int upCost = 0;
		int c;
		for (; j < n; j++) {
			upCost += ((a[j] - s) * p[j]);
			c = cost + upCost * 2 + p[j + 1] * w;
			answer = Math.min(answer, c);
		}

		System.out.println(answer);
	}
}