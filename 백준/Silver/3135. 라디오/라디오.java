import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		int n = Integer.parseInt(br.readLine());

		int answer = Math.abs(A - B);

		int x;

		for (int i = 0; i < n; i++) {
			x = Integer.parseInt(br.readLine());

			answer = Math.min(answer, 1 + Math.abs(x - B));
		}

		System.out.println(answer);
	}
}