import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		int[] inBoundA = new int[m+1];
		int[] inBoundB = new int[n+1];
		
		int[] headingA = new int[m+1];
		int[] headingB = new int[n+1];
		
		int[] weaponA = new int[m+1];
		int[] weaponB = new int[n+1];
		Arrays.fill(weaponA, 2);
		Arrays.fill(weaponB, 2);
		Queue<int[]> q = new LinkedList<int[]>();
		
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 1;i<=m;i++) {
			headingA[i] = Integer.parseInt(st.nextToken());
			inBoundB[headingA[i]]++;
		}

		st = new StringTokenizer(br.readLine()," ");
		for(int i = 1;i<=n;i++) {
			headingB[i] = Integer.parseInt(st.nextToken());
			inBoundA[headingB[i]]++;
		}
		for(int i = 1;i<=m;i++) {
			if(inBoundA[i]==0) {
				q.add(new int[] {0,i});
				weaponA[i] = 1;
			}
		}
		
		for(int i = 1;i<=n;i++) {
			if(inBoundB[i]==0) {
				q.add(new int[] {1,i});
				weaponB[i] = 1;
			}
		}
		int[] now;
		int side,num,to;
		while(!q.isEmpty()) {
			now = q.poll();
			side = now[0];
			num = now[1];
//			System.out.println(side+ " "+num);
//			System.out.println(Arrays.toString(weaponA));
//			System.out.println(Arrays.toString(inBoundA));
//			System.out.println(Arrays.toString(inBoundB));
//			System.out.println(Arrays.toString(weaponB));
			if(side==0) {
				to = headingA[num];
				inBoundB[to]--;
				if(weaponA[num]==1) {//공격이면
					weaponB[to] = 0;
					inBoundB[to] = 0;
				}
				if(inBoundB[to]==0) {
					if(weaponB[to]==2)
						weaponB[to] = 1;
					q.add(new int[] {1,to});
				}
			}
			else{
				to = headingB[num];
				inBoundA[to]--;
				if(weaponB[num]==1) {//공격이면
					weaponA[to] = 0;
					inBoundA[to] = 0;
				}
				if(inBoundA[to]==0) {
					if(weaponA[to]==2)
						weaponA[to] = 1;
					q.add(new int[] {0,to});
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 1;i<=m;i++) {
			
			sb.append(weaponA[i]==2?1:weaponA[i]);
		}
		sb.append("\n");
		for(int i = 1;i<=n;i++) {
			sb.append(weaponB[i]==2?0:weaponB[i]);
		}
		sb.append("\n");
		
		System.out.print(sb);
	}
}