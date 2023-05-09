import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> que = new LinkedList<>();

        for(int i=1;i<=N;i++){
            que.add(i);
        }

        while(que.size()>1){
            for(int i=0;i<K-1;i++){
                int temp = que.poll();
                que.offer(temp);
            }
            sb.append(que.poll()+", ");
        }
        sb.append(que.poll());
        bw.write("<"+sb+">");
        bw.flush();
        bw.close();
        br.close();
    }
}