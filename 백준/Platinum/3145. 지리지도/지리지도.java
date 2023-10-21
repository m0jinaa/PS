import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static HashMap<Integer, String> name;
	static int[] connected;
	static boolean[] used;
	static int[][] index;
	static ArrayList<Integer>[] canConnect;

	static char[][] map;
	static int n, m;

	static class Village {
		int x, y;

		public Village(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	static boolean inRange(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= m)
			return false;
		return true;
	}

	static boolean connect(int x) {
		used[x] = true;

		for (int y : canConnect[x]) {
			if (connected[y] == 0 || (!used[connected[y]] && connect(connected[y]))) {
				connected[y] = x;
				return true;
			}
		}

		return false;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		index = new int[n][m];
		map = new char[n][];
		name = new HashMap<>();

		int ind = 1;

		String temp;

		int cnt = 0;

		// 이름에 인덱스 부여하기
		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();

			for (int j = 0; j < m;) {
				if (map[i][j] == '.' || map[i][j] == 'x') {
					if (map[i][j] == 'x')
						cnt++;
					j++;
					continue;
				}
				temp = "";
				while (j < m && map[i][j] != '.' && map[i][j] != 'x') {
					temp += map[i][j];
					index[i][j] = ind;
					j++;
				}

				name.put(ind, temp);
				ind++;
			}
		}

		connected = new int[ind];

		// 마을마다 주변 살펴보면서 연결관계 만들기

		canConnect = new ArrayList[cnt + 1];

		for (int i = 1; i <= cnt; i++) {
			canConnect[i] = new ArrayList<>();
		}

		used = new boolean[cnt + 1];
		Village[] village = new Village[cnt + 1];

		int[] dx = new int[] { -1, -1, -1, 0, 1, 1, 1, 0 };
		int[] dy = new int[] { -1, 0, 1, 1, 1, 0, -1, -1 };

		int nx, ny;

		int v = 1;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] != 'x')
					continue;
				village[v] = new Village(i + 1, j + 1);
				for (int k = 0; k < 8; k++) {
					nx = i + dx[k];
					ny = j + dy[k];
					if (!inRange(nx, ny) || index[nx][ny] == 0)
						continue;
					canConnect[v].add(index[nx][ny]);
				}

				v++;
			}
		}

		for (int i = 1; i < v; i++) {
			Arrays.fill(used, false);
			connect(i);
		}

		for (int i = 1; i < ind; i++) {
			sb.append(village[connected[i]].x).append(" ").append(village[connected[i]].y).append(" ")
					.append(name.get(i)).append("\n");
		}

		System.out.print(sb.toString());
	}
}