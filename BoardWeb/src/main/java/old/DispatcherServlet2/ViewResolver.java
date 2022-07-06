package old.DispatcherServlet2;

public class ViewResolver {
	private String prefix; // 접두어 -> 경로
	private String suffix; // 접미어 -> 확장자
	
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	
	// 완성된 경로를 생성해서 리턴하는 메소드
	public String getView(String viewName) {
		return prefix + viewName + suffix;
	}
}
