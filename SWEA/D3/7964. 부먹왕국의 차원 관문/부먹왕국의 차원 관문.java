import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int tc = Integer.parseInt(br.readLine());
		for(int t = 1;t<=tc;t++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int answer = 0;
			st = new StringTokenizer(br.readLine());
			
			int[] city = new int[n];
			for(int i = 0;i<n;i++) {
				city[i] = Integer.parseInt(st.nextToken());
			}
			int cnt = 0;
			
			for(int c:city) {
				if(c==0) {
					cnt++;
					if(cnt==d) {
						cnt = 0;
						answer++;
					}
				}
				else
					cnt = 0;
			}
			System.out.printf("#%d %d\n",t,answer);
		}
	}
}
