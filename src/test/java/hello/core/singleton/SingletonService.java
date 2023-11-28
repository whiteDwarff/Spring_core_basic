package hello.core.singleton;

public class SingletonService {

    // 자기 자신을 static으로 생성 (하나만 생성)
    // static memory에 저장
    // SingletonService를 사용하려면 getInstance()를 통해서만 사용가능하며 new 키워드로 생성 불가
    // getInstance()를 호출하면 항상 같은 인스턴스를 반환한다.
    // 딱 하나의 객체 인스턴스만 존재해야 하므로, 생성자를 private으로 막아서 혹시라도 외부에서 new 키워드로 객체 인스턴스가 생성되는 것을 막는다. ***
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

    // 생성자를 private으로 선언하여 외부에서 new 키워드를 사용한 객체 생성을 못하게 막는다.
    private  SingletonService() {}

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
