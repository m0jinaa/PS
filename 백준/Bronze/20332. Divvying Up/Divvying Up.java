import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine(), " ");

		int sum = 0;

		int w;

		for (int i = 0; i < n; i++) {
			w = Integer.parseInt(st.nextToken());
			sum += w;
		}

		sb.append(sum % 3 == 0 ? "yes" : "no");

		System.out.println(sb.toString());
	}
}