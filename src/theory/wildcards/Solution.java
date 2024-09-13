package theory.wildcards;

public class Solution {
    public static void main(String[] args) {
        Gen<A> a = new Gen<>(new A());
        Gen<B> b = new Gen<>(new B());
        Gen<C> c = new Gen<>(new C());

        Gen.setA(a);
        Gen.setA(b);
        Gen.setA(c);
        Gen.setB(a);
        Gen.setB(b);
    }
}

class A {}
class B extends A {}
class C extends A {}
class Gen<T> {
    T obj;
    Gen(T o) {
        obj = o;
    }

    static void setA(Gen<? extends A> a) {
        System.out.println("setA");
    }

    static void setB(Gen<? super B> b) {
        System.out.println("setB");
    }
}