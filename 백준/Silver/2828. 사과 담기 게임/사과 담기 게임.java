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

		int s = 1;
		int e = m;

		int k = Integer.parseInt(br.readLine());

		int x;

		int answer = 0;

		while (k-- > 0) {
			x = Integer.parseInt(br.readLine());

			if (s <= x && x <= e)
				continue;
			if (x < s) {
				answer += (s - x);
				e -= (s - x);
				s = x;
			} else {
				answer += (x - e);
				s += (x - e);
				e = x;
			}
		}

		System.out.println(answer);
	}
}