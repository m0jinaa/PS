import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static char[][] map;
	static boolean[][] v;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static LinkedList<Point>[] door = new LinkedList[26];
	static boolean[] key;
	static boolean inRange(int a, int b) {
		if(a<0||a>=n||b<0||b>=m)
			return false;
		return true;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		for(int t = 0;t<tc;t++) {
			st = new StringTokenizer(br.readLine()," ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			map = new char[n][];
			key = new boolean[26];
			for(int i = 0;i<26;i++) {
				door[i] = new LinkedList<Point>();
			}
			v = new boolean[n][m];
			Queue<Point> q = new LinkedList<Point>();
			for(int i = 0;i<n;i++) {
				map[i] = br.readLine().toCharArray();
			}
			char[] carr = br.readLine().toCharArray();
			for(char c:carr) {
				if(c == '0')
					break;
				key[c-'a'] = true;
			}
			int answer = 0;
			for(int i = 0;i<n;i++) {
				for(int j = 0;j<m;j++) {
					if(i == 0||i==n-1||j==0||j==m-1) {
						char c = map[i][j];
						if(c == '.') {
							v[i][j] = true;
							q.offer(new Point(i,j));
						}
						else if(65<=c&&c<=90) {
							if(key[c-65]) {
								v[i][j] = true;
								q.offer(new Point(i,j));
							}
							else {
								door[c-65].add(new Point(i,j));
							}
						}
						else if(97<=c&&c<=122) {
							v[i][j] = true;
							key[c-97] = true;
							q.offer(new Point(i,j));
							while(!door[c-97].isEmpty()) {
								q.offer(door[c-97].poll());
							}
						}
						else if(c == '$') {
							answer++;
							v[i][j] = true;
							q.add(new Point(i,j));
						}
						
					}
				}			
			}

			int x,y,nx,ny;
			while(!q.isEmpty()) {
				Point p = q.poll();
				x = p.x;
				y = p.y;

				for(int i = 0;i<4;i++) {
					nx = x+dx[i];
					ny = y+dy[i];
					if(!inRange(nx,ny)||v[nx][ny])
						continue;
					char c = map[nx][ny];
					if(65<=c&&c<=90) {//대문자 ->문					
						if(key[c-'A']) {
							v[nx][ny] = true;
						}
						else {
							door[c-'A'].add(p);
						}
					}
					else if(97<=c&&c<=122) {
						v[nx][ny] = true;
						key[c-'a'] = true;
						for(Point pp : door[c-'a']) {
							q.offer(pp);
						}
					}
					else if(c=='.') {
						v[nx][ny] = true;
					}
					else if(c=='$') {
						v[nx][ny] = true;
						answer++;
					}
					if(v[nx][ny])
						q.offer(new Point(nx,ny));
				}
			}
			System.out.println(answer);
		}
	}
}
