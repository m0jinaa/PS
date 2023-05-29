import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main{
	static char[][] stars;
	
	static void fill(int x, int y, int stage) {
		int d = 4*stage-3;
		
		for(int i = 0;i<d;i++) {
			stars[x][y+i] = stars[x+i][y] = stars[x+d-1][y+i] = stars[x+i][y+d-1] = '*';
		}
		if(stage!=1)
			fill(x+2,y+2, stage-1);
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		int w = 4*n-3;
		
		stars = new char[w][w];
		
		for(int i = 0;i<w;i++) {
			Arrays.fill(stars[i], ' ');
		}
		
		fill(0,0,n);
		
		for(int i=0 ;i<w;i++) {
			for(int j = 0;j<w;j++) {
				sb.append(stars[i][j]);
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}