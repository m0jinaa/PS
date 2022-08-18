import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] v;
	static char[][] map;
	public static boolean getPath(int a,int b) {
		if(0>a ||a>=map.length||v[a][b] == 1||v[a][b] == -1)
			return false;
		else if(0<=a && a<map.length&&0<=b&&b<map[0].length&&map[a][b] == '.') {
			if(b==map[0].length-1) {
				v[a][b] = 1;
				return true;
			}
			else{
				if(getPath(a-1,b+1) ||getPath(a,b+1) ||getPath(a+1,b+1)) {
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
		
		map = new char[r][];
		for(int i = 0;i<r;i++) {
			map[i] = br.readLine().toCharArray();
		}
		v = new int[r][c];
		int answer = 0;
		for(int i = 0;i<r;i++) {
			if(getPath(i,0))
				answer++;
		}
		System.out.println(answer);
	}
}
