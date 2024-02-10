import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		double s = 0;
		double e = Double.parseDouble(br.readLine());

		double[][] dots = new double[3][2];

		double a, b, t;
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			a = Double.parseDouble(st.nextToken());
			b = Double.parseDouble(st.nextToken());

			if (a > b) {
				t = a;
				a = b;
				b = t;
			}
			dots[i][0] = a;
			dots[i][1] = b;
		}

		double m;

		for (int i = 0; i < 3; i++) {
			if (dots[i][0] == dots[i][1])
				continue;
			m = (dots[i][0] + dots[i][1]) / 2;

			for (int j = i + 1; j < 3; j++) {
				dots[j][0] = m + Math.abs(m - dots[j][0]);
				dots[j][1] = m + Math.abs(m - dots[j][1]);
			}

			s = m + Math.abs(m - s);

			if (s > e) {
				t = s;
				s = e;
				e = t;
			}

			s = m;
		}

		double length = e - s;

		System.out.println(Math.floor(length * 10) / 10);

	}
}