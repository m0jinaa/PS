import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine()," ");

        int[] max = new int[n];
        int[] min = new int[n];
        int[] num = new int[n];

        int x;
        for(int i = 0;i<n;i++) {
            x = Integer.parseInt(st.nextToken());
            num[i] = x==1?x:-1;
        }
        min[0] = max[0] = num[0];
        int minx = num[0],maxx=num[0];

        for(int i = 1;i<n;i++) {
            min[i] = Math.min(0, min[i-1])+num[i];
            max[i] = Math.max(0, max[i-1])+num[i];
            minx = Math.min(min[i], minx);
            maxx = Math.max(max[i], maxx);
        }

        System.out.println(Math.max(maxx, -minx));
    }
}