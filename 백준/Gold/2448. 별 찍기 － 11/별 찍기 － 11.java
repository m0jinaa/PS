import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main{
    static char[][] map;
    static void fill(int t,int b,int l, int r) {
        if(b-t==2) {
            map[t][(l+r)/2] = map[t+1][(3*l+r)/4] = map[t+1][(l+3*r)/4] =  '*';
            Arrays.fill(map[b], l, r, '*');
        }
        else {
            fill(t,(t+b)/2,(3*l+r)/4+1,(l+3*r)/4);
            fill((t+b)/2+1,b,l,(l+r)/2);
            fill((t+b)/2+1,b,(l+r)/2+1,r);
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        map = new char[n][n*2];

        for(int i = 0;i<n;i++) {
            Arrays.fill(map[i], ' ');
        }

        fill(0,n-1,0,n*2-1);

        for(char [] row: map) {
            for(char c: row) {
                sb.append(c);
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}
