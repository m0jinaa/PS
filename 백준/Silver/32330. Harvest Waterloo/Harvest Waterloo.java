import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
	static int n, m;
	static char[][] map;
	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };

	static boolean inRange(int x, int y) {
		return !(x < 0 || x >= n || y < 0 || y >= m);
	}

	static class Node {
		int x, y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	static int getPumpkin(int x, int y) {
		LinkedList<Node> q = new LinkedList<>();
		q.add(new Node(x, y));
        
        // 시작 위치는 호박 위
		int pumpkin = (map[x][y] == 'S') ? 1 : (map[x][y] == 'M' ? 5 : 10);
		
        //방문 체크
        map[x][y] = '*';

		Node now;
		int nx, ny;

		while (!q.isEmpty()) {
			now = q.poll();

			for (int i = 0; i < 4; i++) {
				nx = now.x + dx[i];
				ny = now.y + dy[i];

				if (!inRange(nx, ny) || map[nx][ny] == '*')
					continue;

				pumpkin += (map[nx][ny] == 'S') ? 1 : (map[nx][ny] == 'M' ? 5 : 10);

				map[nx][ny] = '*';
				q.add(new Node(nx, ny));
			}
		}

		return pumpkin;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        // 지도 크기
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());

        // 지도
		map = new char[n][];

		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
		}
    
        // 농부 위치
		int sx = Integer.parseInt(br.readLine());
		int sy = Integer.parseInt(br.readLine());
        
        //수확가능한 호박의 가치 
		int answer = getPumpkin(sx, sy);

		System.out.println(answer);
	}
}