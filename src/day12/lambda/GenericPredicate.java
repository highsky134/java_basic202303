package day12.lambda;


@FunctionalInterface
public interface GenericPredicate<T> {
    // <T> 제네릭 표시

     // 지정된 타입에 대한 검사를 수행
    boolean test(T t);

}
