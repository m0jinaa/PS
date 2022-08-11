import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static char[][] floor;
	static boolean[][] v;
	
	public static boolean inRange(int a, int b) {
		if(a<0||a>=n||b<0||b>=m)
			return false;
		return true;
	}
	public static void count(int a, int b) {
		int x = a;
		int y = b;
	
		if(floor[a][b]=='-') {
			while(inRange(x,y+1)) {
				y+=1;
				if(floor[x][y] == floor[a][b])
					v[x][y]=true;
				else
					break;
			}
		}
		else {
			while(inRange(x+1,y)) {
				x+=1;
				if(floor[x][y] == floor[a][b])
					v[x][y]=true;
				else
					break;
			}
		}		
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		floor = new char[n][];
		for(int i = 0;i<n;i++) {
			floor[i] = br.readLine().toCharArray();
		}
		v = new boolean[n][m];
		int answer = 0;
		for(int i = 0;i<n;i++) {
			for(int j = 0;j<m;j++) {
				if(!v[i][j]){
					v[i][j] = true;
					answer++;
					count(i,j);
				}					
			}
		}
		System.out.println(answer);		
	}
}
