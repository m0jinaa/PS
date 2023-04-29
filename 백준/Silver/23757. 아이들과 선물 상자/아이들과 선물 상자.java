import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> presents = new PriorityQueue<>(Collections.reverseOrder());

        st = new StringTokenizer(br.readLine()," ");

        for(int i = 0;i<n;i++){
            presents.add(Integer.parseInt(st.nextToken()));
        }
        
        int answer = 1;
        int x,y;
        
        st = new StringTokenizer(br.readLine()," ");
        
        for(int i = 0;i<m;i++){
        	
            x = Integer.parseInt(st.nextToken());
            
            if(presents.peek()<x){
                answer = 0;
                break;
            }
            else{
                y = presents.poll();
                if(y-x>0){
                    presents.add(y-x);
                }
            }
        }

        System.out.println(answer);

	}
}
