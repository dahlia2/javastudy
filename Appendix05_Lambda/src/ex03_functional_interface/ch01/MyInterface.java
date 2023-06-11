package ex03_functional_interface.ch01;

@FunctionalInterface  // 함수형 인터페이스(추상 메소드를 1개만 가지는 인터페이스) - 람다식의 사용이 가능한 인터페이스
public interface MyInterface {
	public void method();  // 매개변수와 반환값이 모두 없는 형태
}
