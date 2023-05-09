import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static char[] animal;
	static long[] amount;
	static LinkedList<Integer>[] child;
	static long answer;
	static long postOrder(int now) {
		long cnt = 0;
		for(int c:child[now]) {
			cnt+=postOrder(c);
		}
		switch(animal[now]) {
		case'S':
			cnt+=amount[now];
			break;
		case'W':
			if(amount[now]<=cnt) {
				cnt-=amount[now];
			}
			else
				cnt = 0;
			break;
		}
		return cnt;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		animal = new char[n+1];
		animal[1] = 'S';
		amount = new long[n+1];
		child = new LinkedList[n+1];
		for(int i = 0;i<=n;i++)
			child[i] = new LinkedList<Integer>();
		
		for(int i = 2;i<=n;i++) {
			st = new StringTokenizer(br.readLine()," ");
			animal[i] = st.nextToken().charAt(0);
			amount[i] = Long.parseLong(st.nextToken());
			int parent = Integer.parseInt(st.nextToken());
			child[parent].add(i);
		}
		answer = postOrder(1);
		System.out.println(answer);	
	}
}
