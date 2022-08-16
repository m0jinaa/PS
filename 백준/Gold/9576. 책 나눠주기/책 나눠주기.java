import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		for(int t = 0;t<tc;t++) {
			st = new StringTokenizer(br.readLine()," ");
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			ArrayList<int[]> list = new ArrayList<int[]>();
			boolean[] done = new boolean[n+1];
			int a,b;
			for(int i = 0;i<m;i++) {
				st = new StringTokenizer(br.readLine()," ");
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				list.add(new int[] {a,b});
			}
			list.sort((l1,l2)->{
				if(l1[1]==l2[1])
					return l1[0]<l2[0]?-1:1;
				else
					return l1[1]<l2[1]?-1:1;
			});
			int answer = 0;
			for(int[] l:list) {
				for(int i = l[0];i<=l[1];i++) {
					if(done[i])
						continue;
					done[i] = true;
					answer++;
					break;
				}
			}
			System.out.println(answer);			
		}
	}
}
