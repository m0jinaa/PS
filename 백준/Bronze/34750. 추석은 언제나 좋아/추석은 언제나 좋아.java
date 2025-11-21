import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		int parent, mine;

		if (n >= 1000000) {
			parent = (n * 2) / 10;
			mine = (n * 8) / 10;
		} else if (n >= 500000) {
			parent = (n * 15) / 100;
			mine = (n * 85) / 100;
		} else if (n >= 100000) {
			parent = n / 10;
			mine = (n * 9) / 10;
		} else {
			parent = (n * 5) / 100;
			mine = (n * 95) / 100;
		}

		sb.append(parent).append(" ").append(mine).append("\n");

		System.out.print(sb.toString());
	}
}