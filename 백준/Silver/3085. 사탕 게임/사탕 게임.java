import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int n;
	static char[][] candy;
	static int answer;

	public static void check(int type, int i) {
		// row
		int max = 1;
		if (type == 0) {
			int row = 1;
			for (int j = 1; j < n; j++) {
				if (candy[i][j] != candy[i][j - 1]) {
					row = 1;
				} else {
					row++;
					max = Math.max(max, row);
				}
			}

		} else {
			int col = 1;
			for (int j = 1; j < n; j++) {

				if (candy[j][i] != candy[j - 1][i]) {
					col = 1;
				} else {
					col++;
					max = Math.max(max, col);
				}
			}
		}

		answer = Math.max(answer, max);
	}

	public static void swap(int x1, int y1, int x2, int y2) {
		char temp = candy[x1][y1];
		candy[x1][y1] = candy[x2][y2];
		candy[x2][y2] = temp;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		candy = new char[n][];

		for (int i = 0; i < n; i++) {
			candy[i] = br.readLine().toCharArray();
		}

		answer = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < n; j++) {
				check(0, i);
				check(1, i);
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				// 오른쪽
				if (j + 1 < n && candy[i][j] != candy[i][j + 1]) {
					swap(i, j, i, j + 1);

					check(0, i);
					check(1, j);
					check(1, j+1);

					swap(i, j, i, j + 1);
				}
				// 오른쪽
				if (j + 1 < n && candy[j][i] != candy[j + 1][i]) {
					swap(j, i, j + 1, i);

					check(0, j);
					check(0, j+1);
					check(1, i);

					swap(j, i, j + 1, i);
				}
			}
		}

		System.out.println(answer);
	}
}