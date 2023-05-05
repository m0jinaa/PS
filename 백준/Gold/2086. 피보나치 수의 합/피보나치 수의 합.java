import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int MOD = 1_000_000_000;
    static final long[][] E = new long[][] {{1,0},{0,1}};
    static final long[][] V = new long[][] {{1,1},{1,0}};

    static long[][] mult(long[][] a, long[][] b){
        long[][] c = new long[2][2];

        for(int k = 0;k<2;k++) {
            for(int i = 0;i<2;i++) {
                for(int j = 0;j<2;j++) {
                    c[i][j] = (c[i][j]+a[i][k]*b[k][j])%MOD;
                }
            }
        }

        return c;
    }

    static long[][] fibo(long x){
        long[][] c = E;
        long[][] v = V;
        long i = 1L;
        while(i<=x && i>0) {
            if((x&i)>0) {
                c = mult(c,v);
            }
            v = mult(v,v);
            i<<=1;
        }

        return c;
    }
    public static long sum(long x) {
        long answer = (fibo(x+2)[0][1]-1+MOD)%MOD;

        return answer;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        long answer = (sum(b)-sum(a-1)+MOD)%MOD;

        System.out.println(answer);
    }

}