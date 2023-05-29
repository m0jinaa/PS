import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args)  throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int w = 2*n-1;
		char[][] stars = new char[n][w];
		
		for(int i = 0;i<n;i++) {
			Arrays.fill(stars[i], ' ');
			stars[i][n-1-i] = stars[i][n-1+i] = '*';
		}
		Arrays.fill(stars[n-1], '*');
		
		for(int i = 0;i<n;i++) {
			for(int j = 0;j<n+i;j++) {
				sb.append(stars[i][j]);
			}
			sb.append("\n");
		}
		
		System.out.print(sb.toString());
	}	
}