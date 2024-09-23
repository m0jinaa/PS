import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		long a = Long.parseLong(st.nextToken());

		long p = a;

		long answer = 0;

		while (p <= n) {
			answer += n / p;
			p *= a;
		}
		System.out.println(answer);
	}
}