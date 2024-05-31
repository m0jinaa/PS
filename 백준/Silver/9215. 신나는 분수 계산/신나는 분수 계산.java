import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

	static BigInteger gcd(BigInteger a, BigInteger b) {
		BigInteger t;

		while (!b.equals(BigInteger.ZERO)) {
			t = a.mod(b);
			a = b;
			b = t;
		}

		return a;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st, stt;
		
		int n, t = 0;
		BigInteger p, q, r, s, a, b;

		while ((n = Integer.parseInt(br.readLine())) != 0) {
			t++;

			p = BigInteger.ZERO;
			q = BigInteger.ONE;
			r = BigInteger.ZERO;

			while (n-- > 0) {

				// 소수부 확인
				st = new StringTokenizer(br.readLine(), "/");

				if (st.countTokens() != 1) { // 소수부 있음
					stt = new StringTokenizer(st.nextToken(), ",");

					if (stt.countTokens() != 1) {
						r = r.add(new BigInteger(stt.nextToken()));
					}

					// a/b
					a = new BigInteger(stt.nextToken());
					b = new BigInteger(st.nextToken());

					// 두 분모의 최대공약수
					s = gcd(q, b);

					p = p.multiply(b).add(a.multiply(q)).divide(s);
					q = q.multiply(b).divide(s);

					r = r.add(p.divide(q));
					p = p.mod(q);

				} else {// 소수부 없음 -> 정수부 있음
					r = r.add(new BigInteger(st.nextToken()));
				}
			}

			s = gcd(p, q);

			p = p.divide(s);
			q = q.divide(s);

			sb.append("Test ").append(t).append(": ");

			if (p.equals(BigInteger.ZERO)) {
				sb.append(r).append("\n");
			} else if (r.equals(BigInteger.ZERO)) {
				sb.append(p).append("/").append(q).append("\n");
			} else {
				sb.append(r).append(",").append(p).append("/").append(q).append("\n");
			}
		}

		System.out.println(sb.toString());
	}
}