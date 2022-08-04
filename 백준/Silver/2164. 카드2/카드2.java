import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		Queue<Integer> q = new ArrayDeque<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		for(int i = 1;i<=n;i++) {
			q.add(i);
		}
		while(q.size()>1) {
			q.poll();
			q.add(q.poll());
		}
		System.out.println(q.poll());
	}

}
