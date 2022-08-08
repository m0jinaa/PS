import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	static int[] numbers;
	static ArrayList<Integer> answer;
	static boolean[] visited;
	static void dfs(int now,int end) {
		if(visited[numbers[now]]== false) {
			visited[numbers[now]] = true;
			dfs(numbers[now],end);
			visited[numbers[now]] = false;
		}
		if(numbers[now]==end)
			answer.add(end);
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		 numbers = new int[n+1];
		for(int i = 1;i<=n;i++) {
			numbers[i] = Integer.parseInt(br.readLine());
		}
		answer = new ArrayList<Integer>();
		visited = new boolean[n+1];
		for(int i = 1;i<=n;i++) {
			visited[i] = true;
			dfs(i,i);
			visited[i] = false;
		}
		
		System.out.println(answer.size());
		for(int i = 0;i<answer.size();i++)
			System.out.println(answer.get(i));	
	}
}
