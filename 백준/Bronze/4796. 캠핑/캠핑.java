import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int L, P, V;
		int answer;
		int t = 0;

		while (true) {
			st = new StringTokenizer(br.readLine(), " ");

			L = Integer.parseInt(st.nextToken());
			P = Integer.parseInt(st.nextToken());
			V = Integer.parseInt(st.nextToken());

			if (L == 0 && P == 0 && V == 0)
				break;

			t++;

			answer = (V / P) * L;

			if (V % P <= L) {
				answer += V % P;
			} else {
				answer += L;
			}

			sb.append("Case ").append(t).append(": ").append(answer).append("\n");
		}

		System.out.print(sb.toString());
	}
}