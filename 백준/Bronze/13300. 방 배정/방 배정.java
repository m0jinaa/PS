import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int[][]children = new int[2][6];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		for(int i = 0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int sex = Integer.parseInt(st.nextToken());
			int grade = Integer.parseInt(st.nextToken());
			children[sex][grade-1]++;
		}
		int answer = 0;
		for(int[] sex:children) {
			for(int c:sex) {
				answer+=c/k;
				if(c%k!=0)
					answer++;
			}
		}
		System.out.println(answer);
	}

}
