import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int n;

	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };

	static boolean inRange(int x, int y) {
		return !(x < 0 || x >= n || y < 0 || y >= n);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(br.readLine());

		char[][] map = new char[n][];

		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
		}

		// 심장 찾기

		int x, y;

		int heartX = -1;
		int heartY = -1;

		boolean found = true;

		for (int i = 0; i < n && heartX == -1; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == '_')
					continue;

				found = true;
				for (int k = 0; k < 4; k++) {
					x = i + dx[k];
					y = j + dy[k];

					if (!inRange(x, y) || map[x][y] == '_') {
						found = false;
						break;
					}
				}
				if (found) {
					heartX = i;
					heartY = j;
					break;
				}
			}
		}

		// 왼쪽 팔 길이 구하기
		x = heartX;
		y = heartY - 1;

		int leftArm = 0;
		while (inRange(x, y) && map[x][y] == '*') {
			leftArm++;
			y--;
		}

		// 오른쪽 팔 길이 구하기
		x = heartX;
		y = heartY + 1;

		int rightArm = 0;

		while (inRange(x, y) && map[x][y] == '*') {
			rightArm++;
			y++;
		}

		// 몸통 길이 구하기
		x = heartX + 1;
		y = heartY;

		int torso = 0;

		while (inRange(x, y) && map[x][y] == '*') {
			torso++;
			x++;
		}

		// 왼쪽 다리 길이 구하기
		int leftLegX = x;
		int leftLegY = y - 1;

		int leftLeg = 0;

		while (inRange(leftLegX, leftLegY) && map[leftLegX][leftLegY] == '*') {
			leftLeg++;
			leftLegX++;
		}

		// 오른쪽 다리 길이 구하기
		int rightLegX = x;
		int rightLegY = y + 1;

		int rightLeg = 0;

		while (inRange(rightLegX, rightLegY) && map[rightLegX][rightLegY] == '*') {
			rightLeg++;
			rightLegX++;
		}

		// 출력
		sb.append(heartX + 1).append(" ").append(heartY + 1).append("\n");
		sb.append(leftArm).append(" ").append(rightArm).append(" ").append(torso).append(" ").append(leftLeg)
				.append(" ").append(rightLeg).append("\n");

		System.out.print(sb.toString());
	}
}