import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		char[] skill = br.readLine().toCharArray();
		
		int answer = 0;
		int s = 0;
		int l = 0;
		for(char c : skill) {
			if(49<=c && c<=57) {
				answer++;
			}
			else if(c=='L') {
				l++;
			}
			else if( c == 'S') {
				s++;
			}
			else if(c=='R') {
				if(l>0) {
					answer++;
					l--;
				}
				else {
					break;
				}
			}
			else if(c=='K') {
				if(s>0) {
					answer++;
					s--;
				}
				else {
					break;
				}
			}
		}
		
		System.out.println(answer);
	}
}