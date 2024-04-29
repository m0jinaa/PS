import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Main {
	static int r, c;
	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };
	static char[][] map;
	static boolean[][] v;
	static LinkedList<Node> q;

	static class Node {
		int x, y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	static boolean inRange(int x, int y) {
		if (x < 0 || x >= r || y < 0 || y >= c)
			return false;
		return true;
	}

	static int bfs(int x, int y) {
		q.clear();

		q.add(new Node(x, y));
		v[x][y] = true;

		Node now;
		int nx, ny;

		int cnt = 1;

		while (!q.isEmpty()) {
			now = q.poll();

			for (int i = 0; i < 4; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];

				if (!inRange(nx, ny) || map[nx][ny] == 'I' || v[nx][ny])
					continue;
				v[nx][ny] = true;
				q.add(new Node(nx, ny));
				cnt++;
			}
		}

		return cnt;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int floor = Integer.parseInt(br.readLine());

		r = Integer.parseInt(br.readLine());
		c = Integer.parseInt(br.readLine());

		map = new char[r][];
		v = new boolean[r][c];
		q = new LinkedList<>();

		for (int i = 0; i < r; i++) {
			map[i] = br.readLine().toCharArray();
		}

		ArrayList<Integer> rooms = new ArrayList<>();

		int space;

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (map[i][j] == 'I' || v[i][j])
					continue;
				space = bfs(i, j);
				rooms.add(space);
			}
		}

		Collections.sort(rooms, Collections.reverseOrder());

		int answer = 0;

		for (int s : rooms) {
			if (s > floor)
				break;
			answer++;
			floor -= s;
		}
		sb.append(answer).append(answer == 1 ? " room, " : " rooms, ").append(floor)
				.append(" square metre(s) left over");

		System.out.println(sb.toString());
	}
}