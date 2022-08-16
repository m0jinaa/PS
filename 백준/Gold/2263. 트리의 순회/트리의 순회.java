import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] inOrder;
	static int[] postOrder;
	static int[] index;
	static StringBuilder sb = new StringBuilder();
	static void preOrder(int i_start,int i_end,int p_start,int p_end) {
		//System.out.println(i_start+ " "+i_end+ " "+p_start+ " "+p_end);
		if(p_end<p_start)
			return;
		
		int p = postOrder[p_end];
		sb.append(p).append(" ");
		int ind = index[p];

		preOrder(i_start,ind-1,p_start,p_start+(ind-1-i_start));
		preOrder(ind+1,i_end,p_start+(ind-i_start),p_end-1);
	
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		inOrder = new int[n];
		postOrder = new int[n];
		index = new int[n+1];
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0;i<n;i++) {
			inOrder[i] = Integer.parseInt(st.nextToken());
			index[inOrder[i]] = i;
		}

		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0;i<n;i++) {
			postOrder[i] = Integer.parseInt(st.nextToken());
		}
		preOrder(0,n-1,0,n-1);
		
		System.out.println(sb);
	}
}
