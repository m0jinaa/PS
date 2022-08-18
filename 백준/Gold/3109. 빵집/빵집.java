import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static char[][] map;
	static int r,c;
	public static boolean getPath(int a,int b) {
		map[a][b] = '-';
		
		if(b==c-1)
			return true;
		
		if(a>0 && map[a-1][b+1]=='.'&&getPath(a-1,b+1))
			return true;
		
		if(map[a][b+1]=='.'&&getPath(a,b+1))
			return true;
		
		if(a<r-1&&map[a+1][b+1]=='.'&&getPath(a+1,b+1))
			return true;
		
		return false;
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		map = new char[r][];
		for(int i = 0;i<r;i++) {
			map[i] = br.readLine().toCharArray();
		}

		int answer = 0;
		for(int i = 0;i<r;i++) {
			if(getPath(i,0))
				answer++;
		}
		System.out.println(answer);
	}
}
