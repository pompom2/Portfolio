package polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {
	
	public static void main(String[] args) {
		/* 
		< SamsungTV에서 LgTV로 바꾸는 과정 >
		- 1, 2번: Java로 할 수 있는 방법
		1. 각각의 클래스 
		- 문제점: 고치는 내용이 많아서 유지보수가 어렵다.
		2. 개선 - 인터페이스를 만들어 구현하는 관계로 변경
		- 문제점: 소스 코드를 고쳐야 한다.
		----------
		
		Spring으로 할 수 있는 방법
		3. 개선 - Factory 디자인 패턴 사용
		- 소스코드를 고치지 않고 TV를 변경할 수 있음
		- Spring에 내포되어 있는 방법
		
		*/
		
		/* 1, 2번 방법 - Java의 문법으로 처리
		TV tv = new LgTV();
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		*/
		
		// 3. 아래의 소스코드를 고치지 않음. (직접 만든 Factory 클래스를 활용)
		/*
		BeanFactory factory = new BeanFactory();
		TV tv = (TV)factory.getBean(args[0]);
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		*/
		
		// 4. 아래의 소스 코드는 고치지 않음. (스프링에서 제공하는 Factory 클래스를 활용)
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
		TV tv = (TV)factory.getBean("tv");
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
		// 객체 여러번 호출 -> 한번만 실행되고 있음. (스프링은 싱글톤 패턴이 적용되어 있음)
		//TV tv1 = (TV)factory.getBean("tv");
		//TV tv2 = (TV)factory.getBean("tv");
		//TV tv3 = (TV)factory.getBean("tv");
		
		factory.close();
		
	}

}
