package cn.swjtu.Interface_071303;

public interface MyInterfaceA {
    public abstract void methodA();

    public abstract void methodCommon();

    public default void methodDefault() {
        System.out.println("AAA");
    }

    public default void methodDefaultA() {
        System.out.println("AAA");
    }
}
