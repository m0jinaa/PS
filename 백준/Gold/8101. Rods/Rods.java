import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());
		double l, ld;
		double target;
		double s, e, theta = 0;
		double r, answer;

		// sinx/x 그래프는 0 ~ pi 구간에서 감소그래프
		while (tc-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			l = Double.parseDouble(st.nextToken());
			ld = Double.parseDouble(st.nextToken());
			ld += l;

			target = l / ld;

			s = 0;
			e = Math.PI;

			for (int i = 0; i < 60; i++) {
				theta = (s + e) / 2;

				if (Math.sin(theta) / theta < target) {
					e = theta;
				} else {
					s = theta;
				}
			}

			r = ld / 2 / theta;
			answer = r * (1 - Math.cos(theta));

			sb.append(Math.round(answer)).append("\n");
		}

		System.out.print(sb.toString());
	}
}