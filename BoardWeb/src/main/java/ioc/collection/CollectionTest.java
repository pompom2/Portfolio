package ioc.collection;

import java.util.Properties;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionTest {
		
	public static void main(String[] args) {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("collectionContext.xml");
		
		// 1. List
		/*
		CollectionBean bean = (CollectionBean) factory.getBean("listBean");
		List<String> list = bean.getList();
		System.out.println(list);
		*/
		
		// 2. Set
		/*
		CollectionBean bean = (CollectionBean) factory.getBean("setBean");
		Set<String> set = bean.getSet();
		System.out.println(set);
		*/
		
		// 3. Map
		/*
		CollectionBean bean = (CollectionBean) factory.getBean("mapBean");
		Map<String, Integer> map = bean.getMap();
		System.out.println(map);
		*/
		
		// 4. Prop
		CollectionBean bean = (CollectionBean) factory.getBean("propBean");
		Properties prop = bean.getProp();
		System.out.println(prop);
		
		
		factory.close();
	}

}
