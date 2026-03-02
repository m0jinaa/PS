import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static StringBuilder sb = new StringBuilder();

	static void makeScene(int x) {
		if (x == 0)
			return;
		makeScene(x - 1);
		sb.append(x).append("\n");
		makeScene(x - 1);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int k = (1 << n) - 1;

		sb.append(k).append("\n");
		makeScene(n);
		sb.append(n).append("\n");

		System.out.print(sb.toString());
	}
}