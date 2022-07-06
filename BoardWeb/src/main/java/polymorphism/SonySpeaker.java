package polymorphism;

import org.springframework.stereotype.Component;

//@Component("sony")
public class SonySpeaker implements Speaker {
	
	public SonySpeaker() {
		System.out.println("=> SonySpeaker --- 생성자");
	}
	
	@Override
	public void volumeUp() {
		System.out.println("SonySpeaker --- 소리를 올린다.");
	}
	
	@Override
	public void volumeDown() {
		System.out.println("SonySpeaker --- 소리를 내린다.");
	}

}
