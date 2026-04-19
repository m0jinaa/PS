import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int R = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		double r = R * 1.0 / 255;
		double g = G * 1.0 / 255;
		double b = B * 1.0 / 255;

		double k = 1 - Math.max(r, Math.max(g, b));

		double c, m, y;

		if (k == 1) {
			c = 0;
			m = 0;
			y = 0;
		} else {
			c = (1 - r - k) / (1 - k);
			m = (1 - g - k) / (1 - k);
			y = (1 - b - k) / (1 - k);
		}

		sb.append(c).append(" ").append(m).append(" ").append(y).append(" ").append(k).append("\n");

		System.out.print(sb.toString());
	}
}