import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int[] parent;
	static int[] height;

	static int getHeight(int x) {
		if (parent[x] == -1)
			return height[x] = 0;
		else if (height[x] != -1)
			return height[x];
		else {
			return height[x] = getHeight(parent[x]) + 1;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		parent = new int[n + 1];
		height = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			parent[i] = Integer.parseInt(br.readLine());
			height[i] = -1;
		}

		for (int i = 1; i <= n; i++) {
			getHeight(i);
		}

		for (int i = 1; i <= n; i++) {
			sb.append(height[i]).append("\n");
		}

		System.out.println(sb.toString());
	}
}