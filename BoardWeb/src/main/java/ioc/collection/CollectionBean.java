package ioc.collection;

import java.util.Properties;

// 컬렉션을 Setter Injection하는 방법
public class CollectionBean {
	
	// 1. List
	/*
	private List<String> list;

	public void setList(List<String> list) {
		this.list = list;
	}
	
	public List<String> getList() {
		return list;
	}
	*/
	
	// 2. Set
	/*
	private Set<String> set;
	
	public void setSet(Set<String> set) {
		this.set = set;
	}
	
	public Set<String> getSet() {
		return set;
	}
	*/
	
	// 3. Map
	/*
	private Map<String, Integer> map;
	
	public void setMap(Map<String, Integer> map) {
		this.map = map;
	}
	
	public Map<String, Integer> getMap() {
		return map;
	}
	*/
	
	// 4. Properties
	private Properties prop;
	
	public void setProp(Properties prop) {
		this.prop = prop;
	}

	public Properties getProp() {
		return prop;
	}
	


}
