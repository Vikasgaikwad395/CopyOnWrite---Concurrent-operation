import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class HashMapDemo extends  Thread{
		
	static ConcurrentHashMap<Integer,String> hm = new ConcurrentHashMap<>();
	
	public void run() {
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println("Child thread updating elements");
		}
		System.out.println("Child Thread updating Map");
		hm.put(105, "Angular");
		
	}
	public static void main(String[] args) throws Exception{
		
		hm.put(101, "Java");
		hm.put(103, "Python");
		hm.put(106, "ReactJS");
		hm.put(104, "Android");
		hm.put(102,"JavaScript" );
		
		
		HashMapDemo t = new HashMapDemo();
		t.start();
		
		
		Set<Integer> s = hm.keySet();
		Iterator<Integer> itr = s.iterator();
		while(itr.hasNext()) {
			Integer i = itr.next();
			System.out.println("Main thread iterating and current Entry is  " +i+"....."+hm.get(i));
		Thread.sleep(6000);
		}
		System.out.println(hm);
		

	}

}
