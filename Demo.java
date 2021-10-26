import java.util.*;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

public class Demo extends Thread{
static CopyOnWriteArraySet<String> al = new CopyOnWriteArraySet<>();
	
	public void run() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			System.out.println("Child Thread going to update list");			
		}
		System.out.println("Child thread updating list");
		al.add("Swift");
		
	}

	public static void main(String[] args) throws Exception{
		
			al.add("Java");
			al.add("Python");
			al.add("JDBC");
			
			Demo d = new Demo();
			d.start();
			
			
			Iterator<String> itr = al.iterator();
			while(itr.hasNext()) {
				String s = itr.next();
				System.out.println("Main thread itearating list and current object  "+s);
			Thread.sleep(6000);
			
			}
			System.out.println(al);

	}
	}


