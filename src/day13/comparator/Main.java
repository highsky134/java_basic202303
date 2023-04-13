package day13.comparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Student> studentList = new ArrayList<>(
                List.of(
                    new Student("홍철수", 15, 79),
                    new Student("박영희", 17, 41),
                    new Student("손흥민", 11, 11),
                    new Student("디아블로", 25, 44)
                )
        );
        studentList.add(new Student("김씨",1,1));
        // 나이 순으로 오름차 정렬(나이 적은순)
        studentList.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getScore() - o2.getScore();
                // o2 - o1 하면 내림차 정렬
            }
        });

        // 이름 가나다순으로 오름차 정렬
        studentList.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));

        studentList.forEach(s -> System.out.println(s));



    }
}
