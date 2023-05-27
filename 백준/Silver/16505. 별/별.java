import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static char[][] stars;
	
	static void fill(int x, int y,int w) {
		if(w==1) {
			stars[x][y] = '*';
		}
		else if(w==2) {
			stars[x][y] = stars[x][y+1] = stars[x+1][y] = '*';
		}
		else {
			fill(x,y,w/2);
			fill(x+w/2,y,w/2);
			fill(x,y+w/2,w/2);
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		//너비 = 2^n
		int w = (int)Math.pow(2, n);
		
		stars = new char[w][w];
		for(int i = 0;i<w;i++) {
			Arrays.fill(stars[i], ' ');
		}
		fill(0,0,w);

		for(int i = 0;i<w;i++) {
			for(int j = 0;j<w-i;j++) {
				sb.append(stars[i][j]);
			}
			sb.append("\n");
		}
		
		System.out.print(sb.toString());
	}
}