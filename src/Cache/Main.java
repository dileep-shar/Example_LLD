package Cache;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cache<String> cache = new LFUCache<String>(2);

        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t-->0){
            int v = s.nextInt();
            int key = s.nextInt();
            if(v==1) {
                s.nextLine();
                String val = s.nextLine();
                cache.put(key,val);
            }else {
                System.out.println(cache.get(key));
            }
        }
    }
}
