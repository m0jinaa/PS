import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());

		long answer;
		long h, l;
		int max;

		for (int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine(), " ");

			h = Long.parseLong(st.nextToken());
			l = Long.parseLong(st.nextToken());

			max = (int) (Math.log10(l) / Math.log10(2));

			answer = (long) Math.pow(2, max + 1) - 1 + (h - max) * l;

			sb.append("Case ").append(t).append(": ").append(answer).append("\n");
		}

		System.out.println(sb.toString());
	}
}