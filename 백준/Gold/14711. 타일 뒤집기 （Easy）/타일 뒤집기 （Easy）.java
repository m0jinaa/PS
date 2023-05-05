import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		int[][] tiles = new int[2][n];
		char[] arr = br.readLine().toCharArray();
		for(int i = 0;i<n;i++) {
			tiles[0][i] = arr[i]=='#'?1:0;
		}
		sb.append(arr).append("\n");
		int cnt;
		for(int i = 1;i<n;i++) {
			for(int j = 0;j<n;j++) {
				cnt = 0;
				cnt+=tiles[i%2][j];
				if(j>=1)
					cnt+=tiles[1-(i%2)][j-1];
				cnt+=tiles[1-(i%2)][j];
				if(j<n-1)
					cnt+=tiles[1-(i%2)][j+1];
				
				if(cnt%2==0) {
					tiles[i%2][j] = tiles[1-(i%2)][j];
					if(tiles[i%2][j]==1) {
						sb.append("#");
					}
					else {
						sb.append(".");
					}
				}
				else {
					tiles[i%2][j] = 1-tiles[1-(i%2)][j];
					if(tiles[i%2][j]==1) {
						sb.append("#");
					}
					else {
						sb.append(".");
					}
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
    }
}