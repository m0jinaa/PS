import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution{

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t = 1;t<=tc;t++) {
			int n = Integer.parseInt(br.readLine());
			boolean[] alp = new boolean[26];
			for(int i = 0;i<n;i++) {
				String s = br.readLine();
				alp[s.charAt(0)-'A'] = true;
			}
			int answer = 0;
			for(answer = 0;answer<26;answer++) {
				if(alp[answer] == false)
					break;
			}
			System.out.printf("#%d %d\n",t,answer);
		}
	}

}
