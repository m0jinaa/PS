import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		char[] S = br.readLine().toCharArray();

		// B[i] = i번째 동전까지 중에 벚꽃그림이 위로 가있는 동전의 개수
		int[] B = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			B[i] = B[i - 1] + (S[i - 1] == 'B' ? 1 : 0);
		}

		int answer = n;

		int c;

		for (int i = 0; i <= n; i++) {
			// i번째 동전까지 벚꽃그림으로 놓으려면 뒤집어야하는 동전의 개수
			c = (i - B[i]) + (B[n] - B[i]);
			answer = Math.min(answer, c);
		}

		System.out.println(answer);
	}
}