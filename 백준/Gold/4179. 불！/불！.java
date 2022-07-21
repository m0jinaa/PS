import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Pair{
	int a;
	int b;
	int cnt;
	public Pair(int a, int b, int cnt) {
		this.a = a;
		this.b = b;
		this.cnt = cnt;
	}	
}
public class Main {
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	
	static void fireExtend(LinkedList<Point> f, char[][] g,Point p) {
		int a = p.x;
		int b = p.y;
		for(int i = 0;i<4;i++) {
			int x = a+dx[i];
			int y = b+dy[i];
			if(0<=x&&x<g.length&&0<=y&&y<g[0].length) {
				if(g[x][y] == '.' ||g[x][y] == 'J') {
					g[x][y] = 'F';
					f.add(new Point(x,y));
				}				
			}
		}
		
	}
	static int wayOut(LinkedList<Pair> q, char[][] g,Pair p) {
		int a = p.a;
		int b = p.b;
		int c = p.cnt;
		for(int i = 0;i<4;i++) {
			int x = a+dx[i];
			int y = b+dy[i];
			if(0<=x&&x<g.length&&0<=y&&y<g[0].length) {
				if(g[x][y]=='.') {
					g[x][y] = 'J';
					q.add(new Pair(x,y,c+1));
				}
			}
			else {
				return c+1;
			}
		}
		return -1;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[r][c];
		LinkedList<Pair> person = new LinkedList<Pair>();
		LinkedList<Point> fire = new LinkedList<Point>();
		
		for(int i = 0;i<r;i++) {
			String s = br.readLine();
			for(int j = 0;j<c;j++) {
				char chr = s.charAt(j);
				switch(chr) {
				case 'J':
					person.add(new Pair(i,j,0));
					break;
				case 'F':
					fire.add(new Point(i,j));
					break;
				}
				map[i][j] = chr;
			}
		}
		
		int answer = -1;
		
		out:while(true) {
			int fsize = fire.size();
			for(int i = 0;i<fsize;i++) {
				fireExtend(fire,map,fire.pollFirst());				
			}
			int psize = person.size();
			for(int i = 0;i<psize;i++) {
				answer = wayOut(person,map,person.pollFirst());
				if(answer!=-1) {
					break out;
				}
			}
			if(person.isEmpty())
				break;
		}
		if(answer!=-1){
			System.out.println(answer);
		}
		else
			System.out.println("IMPOSSIBLE");	
	}
}
