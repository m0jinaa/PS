import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] arr = br.readLine().toCharArray();
        boolean[][] cards = new boolean[4][14];
        int[] cnt = new int[4];

        Arrays.fill(cnt,13);

        int n = arr.length;
        char t;
        int num;
        int ind=0;
        boolean wrong = false;
        for(int i = 0;i<n;i+=3){
            t = arr[i];
            num = (arr[i+1]-'0')*10+(arr[i+2]-'0');
            switch(t){
                case 'P':
                    ind = 0;
                    break;
                case 'K':
                    ind = 1;
                    break;
                case 'H':
                    ind = 2;
                    break;
                case 'T':
                    ind = 3;
                    break;
            }

            if(cards[ind][num]){
                wrong = true;
                break;
            }
            else{
                cards[ind][num] = true;
                cnt[ind]--;
            }
        }

        StringBuilder sb = new StringBuilder();

        if(wrong){
            sb.append("GRESKA");
        }
        else{
            for(int x : cnt){
                sb.append(x).append(" ");
            }
        }

        System.out.println(sb.toString());
	}

}
