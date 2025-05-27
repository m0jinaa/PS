import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int min = 1000001;
		int max = 0;

		int s, e;

		while (n-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());

			max = Math.max(max, s);
			min = Math.min(min, e);
		}

		int answer = Math.max(0, max - min);

		System.out.println(answer);
	}
}