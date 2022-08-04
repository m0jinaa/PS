import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int tc = 10;
		int n = 8;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t = 1;t<=tc;t++) {
			int k = Integer.parseInt(br.readLine());
			char[][] map = new char[n][];
			for(int i = 0;i<n;i++) {
				map[i] = br.readLine().toCharArray();
			}
			int answer = 0;
			boolean possible = true;
			//horizontal
			for(int i = 0;i<n;i++) {
				for(int j = 0;j<=n-k;j++) {//start location:(i,j)
					possible = true;
					for(int m = 0;m<k/2;m++) {
						if(map[i][j+m]!=map[i][j+k-1-m]) {
							possible = false;
							break;
						}
					}
					if(possible) {
						answer++;
					}
				}
			}		
			//vertical
			for(int j = 0;j<n;j++) {
				for(int i = 0;i<=n-k;i++) {//start location:(i,j)
					possible = true;
					for(int m = 0;m<k/2;m++) {
						if(map[i+m][j]!=map[i+k-1-m][j]) {
							possible = false;
							break;
						}
					}
					if(possible) {
						answer++;
					}
					
				}
			}			
			System.out.printf("#%d %d\n",t,answer);
		}
	}
}
