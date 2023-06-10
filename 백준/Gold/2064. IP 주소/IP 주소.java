import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		// ip address
		int[] ip_address = new int[4];

		// network mask
		int[] network_mask = new int[4];

		int[][] ips = new int[n][4];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), ".");
			for (int j = 0; j < 4; j++) {
				ips[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		boolean same;
		int bit;
		int check;

		end: for (int i = 0; i < 4; i++) {

			for (int j = 7; j >= 0; j--) {
				bit = (1 << j);
				same = true;
				check = bit & ips[0][i];
				for (int k = 1; k < n; k++) {
					if (check != (ips[k][i] & (1 << j))) {
						same = false;
						break;
					}
				}

				if (same) {
					ip_address[i] |= check;
					network_mask[i] |= bit;
				} else {
					break end;
				}
			}
		}

		for (int i = 0; i < 4; i++) {
			sb.append(ip_address[i]).append(i == 3 ? "\n" : ".");
		}

		for (int i = 0; i < 4; i++) {
			sb.append(network_mask[i]).append(i == 3 ? "\n" : ".");
		}

		System.out.print(sb.toString());
	}
}