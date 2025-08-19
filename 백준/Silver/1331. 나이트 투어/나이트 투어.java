import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int sx = -1;
		int sy = -1;

		char[] loc;
		boolean[][] v = new boolean[6][6];
		boolean valid = true;
		int x = -1, y = -1, nx, ny;

		for (int i = 0; i < 36; i++) {
			loc = br.readLine().toCharArray();
			nx = loc[0] - 'A';
			ny = loc[1] - '1';

			// 시작점인 경우 시작점 체크
			if (i == 0) {
				sx = nx;
				sy = ny;

				x = nx;
				y = ny;
				v[nx][ny] = true;

				continue;
			}

			// 이미 방문한 칸이거나 나이트가 이동할 수 없는 경로인 경우
			if (v[nx][ny] || Math.abs(x - nx) * Math.abs(y - ny) != 2) {
				valid = false;
				break;
			} else {
				v[nx][ny] = true;
				x = nx;
				y = ny;
			}

			// 마지막 지점일 때 시작점으로 돌아갈 수 있는지 체크
			if (i == 35 && Math.abs(x - sx) * Math.abs(y - sy) != 2) {
				valid = false;
				break;
			}
		}

		System.out.println(valid ? "Valid" : "Invalid");
	}
}