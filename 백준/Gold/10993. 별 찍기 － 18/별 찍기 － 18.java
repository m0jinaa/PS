import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main{
	static char[][] stars;
	
	static void fill(int x, int y,int stage) {
		int w = (int)Math.pow(2, stage+1)-3;
		int h = (int)Math.pow(2, stage)-1;
		if(stage%2==0) {//뒤집어진 삼각형
			Arrays.fill(stars[x], y,y+w,'*');
			int s = y;
			int e = y+w-1;
			int l = x;
			while(s<=e) {
				stars[l][s] = stars[l][e] = '*';
				l++;
				s++;
				e--;
			}
			int next = (int)Math.pow(2, stage-1);
			fill(x+1,y+next,stage-1);
		}
		else {//올바른 삼각형
			int s = y;
			int e = y+w-1;
			int l = x+h-1;
			Arrays.fill(stars[l], y,y+w,'*');
			while(s<=e) {
				stars[l][s] = stars[l][e] = '*';
				l--;
				s++;
				e--;
			}
			if(stage!=1) {
				int next = (int)Math.pow(2, stage-1)-1;
				fill(x+next,y+next+1,stage-1);
			}			
		}
		

	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		//높이 = 2^n-1
		int h = (int)Math.pow(2, n)-1;
		//너비 = 2^(n+1)-3
		int w = (int)Math.pow(2, n+1)-3;
		
		stars = new char[h][w];
		
		for(int i = 0;i<h;i++) {
			Arrays.fill(stars[i], ' ');
		}
		
		fill(0,0,n);
		
		int diff = 0;
		if(n%2==0) {
			diff = -1;
		}
		else {
			w = h;
			diff = 1;
		}
		
		for(int i = 0;i<h;i++) {
			for(int j = 0;j<w+i*diff;j++) {
				sb.append(stars[i][j]);
			}
			sb.append("\n");
		}
		
		System.out.print(sb.toString());
	}
}