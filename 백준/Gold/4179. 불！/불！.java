import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int R, C, time;
	static char[][] map;
	static int dr[] = { -1,  0,  1,  0 };
	static int dc[] = {  0,  1,  0, -1 };
	static boolean[][] visitedJ;
	static boolean[][] visitedF;
	static Queue<Pos> jihun = new LinkedList<Pos>();
	static Queue<Pos> fire  = new LinkedList<Pos>();
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visitedJ = new boolean[R][C];
		visitedF = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		} // 입력 끝
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] == 'F') {
					visitedF[i][j] = true;
					fire.offer(new Pos(i, j));
				}
				else if(map[i][j] == 'J') {
					visitedJ[i][j] = true;
					jihun.offer(new Pos(i, j));
				}
			}
		}
		
		bfs();
		
	}
	
	static void bfs() {
		
		while(true) {
			
			time++;
			
			int sizeJ = jihun.size();
			
			if(sizeJ == 0) {
				
				System.out.println("IMPOSSIBLE");
				return;
				
			}
			
			while(sizeJ-- > 0) {
				
				Pos now = jihun.poll();
				
				if(map[now.row][now.col] == 'F') continue;
				if(now.row == 0 || now.row == R - 1 || now.col == 0 || now.col == C - 1) {
					System.out.println(time);
					return;		
				}
				
				for (int i = 0; i < 4; i++) {
					
					int nr = now.row + dr[i];
					int nc = now.col + dc[i];
					
					if(0 <= nr && nr < R && 0 <= nc && nc < C && !visitedJ[nr][nc] && map[nr][nc] == '.') {
						
						
						visitedJ[nr][nc] = true;
						jihun.offer(new Pos(nr, nc));
						
					}
					
				}
				
			}
			
			int sizeF = fire.size();
			
			while(sizeF-- > 0) {
				
				Pos now = fire.poll();
				
				for (int i = 0; i < 4; i++) {
					
					int nr = now.row + dr[i];
					int nc = now.col + dc[i];
					
					if(0 <= nr && nr < R && 0 <= nc && nc < C && !visitedF[nr][nc] && map[nr][nc] != '#') {
						
						visitedF[nr][nc] = true;
						map[nr][nc] = 'F';
						fire.offer(new Pos(nr, nc));
						
					}
					
				}
				
			}
			
		}
		
	}
	
	static class Pos {
		
		int row, col;
		
		public Pos(int row, int col) {

			this.row = row;
			this.col = col;
			
		}
		
	}
	
}