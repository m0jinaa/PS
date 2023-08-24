import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int[][][][][] possible;
	static String[][][][][] dp;

	static int dfs(int a, int b, int x, int y, int z) {
		if (possible[a][b][x][y][z] != -1)
			return possible[a][b][x][y][z];
		else if (x == 0 && y == 0 && z == 0) {
			dp[a][b][x][y][z] = "";
			return possible[a][b][x][y][z] = 1;
		}

		if (x > 0 && dfs(b, 1, x - 1, y, z) == 1) {
			dp[a][b][x][y][z] = "A" + dp[b][1][x - 1][y][z];
			return possible[a][b][x][y][z] = 1;
		} else if (y > 0 && b != 2 && dfs(b, 2, x, y - 1, z) == 1) {
			dp[a][b][x][y][z] = "B" + dp[b][2][x][y - 1][z];
			return possible[a][b][x][y][z] = 1;
		} else if (z > 0 && a != 3 && b != 3 && dfs(b, 3, x, y, z - 1) == 1) {
			dp[a][b][x][y][z] = "C" + dp[b][3][x][y][z - 1];
			return possible[a][b][x][y][z] = 1;
		}

		return possible[a][b][x][y][z] = 0;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] row = br.readLine().toCharArray();

		int a = 0, b = 0, c = 0;

		for (char r : row) {
			switch (r) {
			case 'A':
				a++;
				break;
			case 'B':
				b++;
				break;
			case 'C':
				c++;
				break;
			}
		}

		possible = new int[4][4][a + 1][b + 1][c + 1];
		dp = new String[4][4][a + 1][b + 1][c + 1];
		for (int w = 0; w < 4; w++) {
			for (int h = 0; h < 4; h++) {
				for (int i = 0; i <= a; i++) {
					for (int j = 0; j <= b; j++) {
						for (int k = 0; k <= c; k++) {
							possible[w][h][i][j][k] = -1;
						}
					}
				}
			}
		}
		String answer = "-1";
		if (dfs(0, 0, a, b, c) == 1) {
			answer = dp[0][0][a][b][c];
		}
		System.out.println(answer);
	}
}