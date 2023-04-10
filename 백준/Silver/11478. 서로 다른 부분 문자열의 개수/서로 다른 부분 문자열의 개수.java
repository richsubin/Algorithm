import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;


public class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		HashMap<String, Integer> map = new HashMap<>();
		
		String str = br.readLine();
		
		for(int i=0;i<str.length();i++) {
			String key = "";
			for(int j=i;j<str.length();j++) {
				key+=str.charAt(j);
				if(map.containsKey(key)) continue;
				else map.put(key, 1);
			}
		}
		
		bw.write(map.size()+"");
		bw.flush();
		bw.close();
		br.close();
	}
}