import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 현금
		int money = Integer.parseInt(br.readLine());

		int sMoney = money;
		int jMoney = money;

		// 14일간의 주가
		int duration = 14;

		int[] price = new int[duration];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < duration; i++) {
			price[i] = Integer.parseInt(st.nextToken());
		}

		// 주식 보유 수
		int sStock = 0;
		int jStock = 0;

		int increase = 0;
		int decrease = 0;

		int c;

		for (int i = 0; i < duration; i++) {
			// 준현 주식 변동
			c = jMoney / price[i];

			jStock += c;
			jMoney -= c * price[i];

			// 성민 주식 변동

			if (i == 0)
				continue;
			else if (price[i - 1] < price[i]) {
				increase++;
				decrease = 0;
			} else if (price[i - 1] > price[i]) {
				decrease++;
				increase = 0;
			} else {
				increase = 0;
				decrease = 0;
			}

			if (increase >= 3) { // 3일 연속 상승
				sMoney += price[i] * sStock;
				sStock = 0;
			} else if (decrease >= 3) { // 3일 연속 하락
				c = sMoney / price[i];
				sStock += c;
				sMoney -= c * price[i];
			}
		}

		int sAsset = sMoney + sStock * price[duration - 1];
		int jAsset = jMoney + jStock * price[duration - 1];

		String answer = sAsset < jAsset ? "BNP\n" : (sAsset > jAsset ? "TIMING\n" : "SAMESAME\n");

		System.out.println(answer);
	}
}