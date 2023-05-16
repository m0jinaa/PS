import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int space = 0;

		space += 2 * n * m;// 윗면, 아랫면

		int[][] blocks = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				blocks[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (i == 0) {//위쪽 벽면
					space += blocks[i][j];
				}
				if (i == n - 1) {//아래쪽 벽면
					space += blocks[i][j];
				}
				if (j == 0) {//왼쪽 벽면
					space += blocks[i][j];
				}
				if (j == m - 1) {//오른쪽 벽면
					space += blocks[i][j];
				}
				
				//주위블럭과의 차이만큼 겉넓이 추가
				if (i != n - 1) {
					space += Math.abs(blocks[i][j] - blocks[i + 1][j]);
				}

				if (j != m - 1) {
					space += Math.abs(blocks[i][j] - blocks[i][j + 1]);
				}
			}
		}

		System.out.println(space);
	}
}