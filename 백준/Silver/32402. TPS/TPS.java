import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		final int[] dx = new int[] { 0, 1, 0, -1 };
		final int[] dy = new int[] { 1, 0, -1, 0 };

		int d = 0;

		int xp = 0;
		int yp = 0;
		int xc = 0;
		int yc = -1;

		int n = Integer.parseInt(br.readLine());

		String order;

		while (n-- > 0) {
			order = br.readLine();

			switch (order) {
			case "W":
				xp += dx[d];
				yp += dy[d];
				xc += dx[d];
				yc += dy[d];
				break;
			case "A":
				xp += dx[(d + 3) % 4];
				yp += dy[(d + 3) % 4];
				xc += dx[(d + 3) % 4];
				yc += dy[(d + 3) % 4];
				break;
			case "S":
				xp += dx[(d + 2) % 4];
				yp += dy[(d + 2) % 4];
				xc += dx[(d + 2) % 4];
				yc += dy[(d + 2) % 4];
				break;
			case "D":
				xp += dx[(d + 1) % 4];
				yp += dy[(d + 1) % 4];
				xc += dx[(d + 1) % 4];
				yc += dy[(d + 1) % 4];
				break;
			case "MR":
				xc += dx[d];
				yc += dy[d];
				d = (d + 1) % 4;
				xc += dx[(d + 2) % 4];
				yc += dy[(d + 2) % 4];
				break;
			case "ML":
				xc += dx[d];
				yc += dy[d];
				d = (d + 3) % 4;
				xc += dx[(d + 2) % 4];
				yc += dy[(d + 2) % 4];
				break;
			}

			sb.append(xp).append(" ").append(yp).append(" ").append(xc).append(" ").append(yc).append("\n");
		}

		System.out.println(sb.toString());
	}
}