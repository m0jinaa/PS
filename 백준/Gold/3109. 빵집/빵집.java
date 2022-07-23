import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static boolean getPath(char[][] g, int a,int b,int[][] v) {
		if(0>a ||a>=g.length||v[a][b] == 1||v[a][b] == -1)
			return false;
		else if(0<=a && a<g.length&&0<=b&&b<g[0].length&&g[a][b] == '.') {
			if(b==g[0].length-1) {
				v[a][b] = 1;
				return true;
			}
			else{
				if(getPath(g,a-1,b+1,v) ||getPath(g,a,b+1,v) ||getPath(g,a+1,b+1,v)) {
					v[a][b] = 1;
					return true;
				}
				else
					v[a][b] = -1;
			}
		}
		
		return false;
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[r][c];
		for(int i = 0;i<r;i++) {
			map[i] = br.readLine().toCharArray();
		}
		int[][] v = new int[r][c];
		int answer = 0;
		for(int i = 0;i<r;i++) {
			if(getPath(map,i,0,v))
				answer++;
		}
		System.out.println(answer);
	}
}
