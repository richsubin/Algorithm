import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] arr = new int[10];
		int num =1;
		for(int i=0;i<3;i++) {
			num *= Integer.parseInt(br.readLine());
		}
		String str = Integer.toString(num);
		
		for(int i=0;i<str.length();i++) {
			arr[str.charAt(i)-'0']++;
		}
		for(int a: arr) {
			bw.write(a+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}