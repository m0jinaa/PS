import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int g = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		char[] w = br.readLine().toCharArray();
		char[] S = br.readLine().toCharArray();
		
		int answer = 0;
		int[] expect = new int[123];
		int[] count = new int[123];
		for(char c:w) {
			expect[c]++;
		}
		boolean equal=false;
		for(int i = 0;i<l;i++) {
			
			equal = true;
			count[S[i]]++;
			if(i>=g) {
				count[S[i-g]]--;
			}
			for(int j = 65;j<123;j++) {//A부터 확인
				if(expect[j]!=count[j]) {
					equal = false;
					break;
				}
			}
			if(equal)
				answer++;
		}
		System.out.println(answer);	
	}
}
