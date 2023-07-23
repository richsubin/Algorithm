import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int cnt=0;
		int N = Integer.parseInt(br.readLine());
		int arr[] =new int[N];
		Map<String, Integer> car = new HashMap<>();
		for(int i=0;i<N;i++) {
			car.put(br.readLine(), i);
		}
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			arr[i] = car.get(str);
		}
		for(int i=0;i<N-1;i++) {
			for(int j=i+1;j<N;j++) {
				if(arr[i]>arr[j]) {
					cnt++; break;
				}
			}
		}
		
		bw.write(cnt+"");
		bw.flush();
		bw.close();
	}
}