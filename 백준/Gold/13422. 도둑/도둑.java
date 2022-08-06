import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for(int i = 0;i<t;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			int[] house = new int[n*2];
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0;j<n;j++) {
				house[j] = house[j+n] = Integer.parseInt(st.nextToken());
			}
			int amount = 0;
			int answer = 0;
			for(int j = 0;j<m;j++) {
				amount+=house[j];
			}
			if(amount<k)
				answer++;
			if(n!=m) {
				for(int j = m;j<n+m-1;j++) {
					amount+=house[j];
					amount-=house[j-m];					
					if(amount<k)
						answer++;			
				}
			}
			System.out.println(answer);
		}
	}

}
