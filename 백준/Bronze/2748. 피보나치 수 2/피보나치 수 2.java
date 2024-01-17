import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		long[] arr = new long[n+1];
		arr[0] = 0;
		arr[1] = 1;
		
		for(int i = 0;i<n-1;i++) {
			arr[i+2] = arr[i+1] + arr[i];
		}
		
		bw.write(arr[n]+"");
		bw.flush();
		bw.close();

	}
}