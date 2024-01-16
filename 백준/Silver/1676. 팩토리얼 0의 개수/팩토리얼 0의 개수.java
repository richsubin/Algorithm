import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		int result = 0;
		
		while(num >= 5) {
			result += num/5;
			num /= 5;
		}
		
		bw.write(result+"");
		bw.flush();
		bw.close();
	}
}