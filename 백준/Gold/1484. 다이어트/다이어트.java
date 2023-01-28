import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int g = Integer.parseInt(br.readLine());
        long a = 50000;
        long b = 50001;

        long v;
        Stack<Long> stack = new Stack<Long>();

        while(a>0 && a<=b) {
            v = b*b-a*a;
            if(v==g) {
                stack.add(b);
                b-=1;
                a-=1;
            }
            else if(v>g)
                b-=1;
            else
                a-=1;
        }

        StringBuilder sb = new StringBuilder();

        if(stack.size()==0)
            sb.append("-1\n");

        while(!stack.isEmpty()) {
            sb.append(stack.pop()).append("\n");
        }

        System.out.print(sb.toString());

    }
}