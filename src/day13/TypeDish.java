package day13;

import static day13.Dish.*;

// 음식의 이름과 타입만 관리하는 객체
public class TypeDish {

    private final String name;
    private final Type type;

    public TypeDish(Dish dish) {
        this.name = dish.getName();
        this.type = dish.getType();
    }

    public TypeDish(String name, Type type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return "TypeDish{" +
                "name='" + name + '\'' +
                ", type=" + type +
                '}';
    }
}
