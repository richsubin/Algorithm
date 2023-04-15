import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Docu{
	int index, weight;
	
	public Docu(int index, int weight) {
		super();
		this.index = index; //현 위치
		this.weight = weight;
	}
}

public class Main {
	
	static Queue<Docu> queue;
	static int N, M;
	static int result; // 그래서 M 문서가 몇번째에 출력되는데
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine()); //테스트케이스
		for(int i=0;i<T;i++) {
			queue = new LinkedList<>();
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); //문서 수
			M = Integer.parseInt(st.nextToken()); //찾아야하는 문서 현위치
			
			Integer[] wOrder = new Integer[N];
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				int weight = Integer.parseInt(st.nextToken()); //중요도
				queue.offer(new Docu(j, weight)); //큐에 일단 넣어줌
				wOrder[j] = weight;
			}
			Arrays.sort(wOrder, Collections.reverseOrder());
			queDocu(wOrder);
			sb.append(result+"\n");
		}
		bw.write(sb+"");
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void queDocu(Integer[] wOrder) {
		int count = 0; //M이랑 같을 때까지 올려줄거임
		int i=0;
		while(!queue.isEmpty()) {
			//해야할 것 : 일단 맨앞에 있는거 뺴고 중요도가 낮으면 다시 offer 해줘야함
			Docu d = queue.poll();
			if(d.weight < wOrder[i]) {
				queue.offer(d);
			}
			else {
				count++;
				i++;
				if(d.index == M) {
					result = count;
					return;
				}
			}
		}
	}
}