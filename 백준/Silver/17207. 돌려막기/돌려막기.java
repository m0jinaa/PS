import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = 5;

		int[][] A = new int[n][n];
		int[][] B = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < n; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < n; j++) {
				B[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] C = new int[n][n];

		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					C[i][j] += A[i][k] * B[k][j];
				}
			}
		}

		int min = 1_000_000_007;

		String[] name = new String[] { "Inseo", "Junsuk", "Jungwoo", "Jinwoo", "Youngki" };

		int sum;
		int answer = -1;

		for (int i = 0; i < n; i++) {
			sum = 0;
			for (int j = 0; j < n; j++) {
				sum += C[i][j];
			}

			if (sum <= min) {
				answer = i;
				min = sum;
			}
		}

		System.out.println(name[answer]);
	}
}