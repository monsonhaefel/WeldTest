package exp;

import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Inject;

import org.apache.webbeans.config.WebBeansContext;
import org.apache.webbeans.spi.ContainerLifecycle;

public class MyApplication {

	private static ContainerLifecycle lifecycle = null;

	@Inject
	public int myValue;
	
	public static void main(String [] args) {
		lifecycle = WebBeansContext.currentInstance().getService(ContainerLifecycle.class);
		lifecycle.startApplication(null);

		final BeanManager beanManager = lifecycle.getBeanManager();
		final Bean<?> bean = beanManager.getBeans(MyApplication.class).iterator().next();

		final MyApplication myApp = (MyApplication) beanManager.getReference(bean, MyApplication.class, beanManager.createCreationalContext(bean));
		System.out.println("MyValue = "+myApp.myValue);

		lifecycle.stopApplication(null);
	}
}
