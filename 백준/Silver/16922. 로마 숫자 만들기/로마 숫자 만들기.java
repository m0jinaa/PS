import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int n;
	static boolean[] num = new boolean[1001];
	static int[] roma = new int[] {1,5,10,50};
	static int answer;
	
	static void combi(int i,int k, int sum) {
		if(i==n) {
			if(!num[sum]) {
				num[sum] = true;
				answer++;
			}
		}
		else {
			for(int j = k;j<4;j++) {
				combi(i+1,j,sum+roma[j]);
			}
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		combi(0,0,0);
		
		System.out.println(answer);	
	}
}
