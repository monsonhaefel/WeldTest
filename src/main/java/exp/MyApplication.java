package exp;

import javax.inject.Inject;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class MyApplication {

	@Inject
	public int myValue;
	
	public static void main(String [] args) {
		//MyApplication comp = (MyApplication) CdiContainer.get(MyApplication.class);
		
		
		Weld weld = new Weld();
		WeldContainer container = weld.initialize();
		MyApplication myApp = container.select(MyApplication.class).get();
		
		System.out.println("MyValue = "+myApp.myValue);
		
		weld.shutdown();
	}
}
