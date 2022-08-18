import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int R,C;
	static int[][] map;
	static boolean[] visited;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static int answer;

	static boolean inRange(int a, int b) {
		if(a<0||a>=R||b<0||b>=C)
			return false;
		return true;
	}
	
	static void move(int a, int b, int c) {
		boolean flag = true;
		int x,y;
		for(int i = 0;i<4;i++) {
			x = a+dx[i];
			y = b+dy[i];
			if(!inRange(x,y) || visited[map[x][y]])
				continue;
			visited[map[x][y]] = true;
			move(x,y,c+1);
			visited[map[x][y]] = false;
			flag = false;
		}
		if(flag)//갈 곳이 없음
			answer = answer<c?c:answer;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		visited = new boolean[26];
		
		for(int i = 0;i<R;i++) {
			char[] carr = br.readLine().toCharArray();
			for(int j = 0;j<C;j++) {
				map[i][j] = carr[j]-'A';
			}
		}
		visited[map[0][0]] = true;
		
		move(0,0,1);
		
		System.out.println(answer);		
	}
}
