import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());


		int[] height = new int[n];

		for (int i = 0; i < n; i++) {
			height[i] = Integer.parseInt(br.readLine());
		}

		int i = 1;

		while (i <= n) {
			// 높은곳 찾기
			while (i < n && height[i - 1] < height[i]) {
				i++;
			}

			sb.append(i).append("\n");


			while (i < n && height[i - 1] > height[i]) {
				i++;
			}
			i++;
		}

		System.out.println(sb.toString());
	}
}