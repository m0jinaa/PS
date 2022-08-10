import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st;
		int answer = 0;
		boolean[][] map = new boolean[100][100];
		int n = Integer.parseInt(br.readLine());
		for(int i = 0;i<n;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			for(int j = a;j<a+10;j++) {
				for(int k = b;k<b+10;k++) {
					if(!map[j][k]) {
						map[j][k] = true;
						answer++;
					}
				}
			}
		}
		System.out.println(answer);
	}
}
