import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int L = Integer.parseInt(br.readLine());
		long result = 0;
		String str = br.readLine();
		int r = 1;
		for(int i=0;i<L;i++) {
			result += (str.charAt(i)-96) * r;
			r = (r * 31) % 1234567891;
		}
		
		bw.write(result+"");
		bw.flush();
		bw.close();
	}
}