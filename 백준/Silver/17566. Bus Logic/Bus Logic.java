import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int m = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());

		long start = 1L << (s - m);

		long spot;

		boolean[] canReach = new boolean[s];
		int ind;

		int answer = 0;

		while (b-- > 0) {
			spot = Long.parseLong(br.readLine(), 2);

			if ((spot & start) == 0)
				continue;
			ind = s - 1;

			while (spot != 0 && ind >= 0) {
				if (spot % 2 != 0 && !canReach[ind]) {
					canReach[ind] = true;
					answer++;
				}
				spot /= 2;
				ind--;
			}
		}

		System.out.println(answer != 0 ? answer - 1 : answer);
	}
}