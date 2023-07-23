import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		Map<String, Integer> map = new HashMap<>();
		
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			int index = str.indexOf(".")+1;
			String ext = str.substring(index,str.length());
			if(map.containsKey(ext)) 
				map.put(ext,map.get(ext)+1);
			else
				map.put(ext, 1);
		}
		ArrayList<String> keySet =new ArrayList<>(map.keySet());
		Collections.sort(keySet);
		for(String key : keySet) {
			bw.write(key+" "+map.get(key)+"\n");
		}
		bw.flush();
		bw.close();
	}

}
