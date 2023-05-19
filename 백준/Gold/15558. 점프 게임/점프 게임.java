import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main{
	static int n, k;
	static int[][] map;

	static class Loc {
		int x, y, t;

		public Loc(int x, int y, int t) {
			super();
			this.x = x;
			this.y = y;
			this.t = t;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		map = new int[2][n];
		char[] row;
		for (int i = 0; i < 2; i++) {
			row = br.readLine().toCharArray();
			for (int j = 0; j < n; j++) {
				map[i][j] = row[j]-'0';
			}
		}

		System.out.println(check() ? 1 : 0);
	}

	private static boolean check() {
		
		LinkedList<Loc> q = new LinkedList<>();
		
		boolean[][] visited = new boolean[2][n];
		
		q.add(new Loc(0,0,0));
		visited[0][0] = true;
		Loc now;
		
		while(!q.isEmpty()) {
			now = q.poll();
			//앞으로 한 칸
			if(now.y+1<n) {
				if(map[now.x][now.y+1]==1 && !visited[now.x][now.y+1]) {
					visited[now.x][now.y+1] = true;
					q.add(new Loc(now.x,now.y+1,now.t+1));
				}
			}
			else {
				return true;
			}
			
			//뒤로 한 칸
			if(now.y-1>=0) {
				if(now.t+1<=now.y-1 && map[now.x][now.y-1]==1 && !visited[now.x][now.y-1]) {
					visited[now.x][now.y-1] = true;
					q.add(new Loc(now.x,now.y-1,now.t+1));
				}
			}

			//옆줄 앞으로 k 칸
			if(now.y+k<n) {
				if(map[1-now.x][now.y+k]==1 && !visited[1-now.x][now.y+k]) {
					visited[1-now.x][now.y+k] = true;
					q.add(new Loc(1-now.x,now.y+k,now.t+1));
				}
			}
			else {
				return true;
			}			
		}
		
		return false;
	}
}