package cn.hdj.java8.repeatAnnotation;

import java.lang.reflect.Method;
import java.util.stream.Stream;

/**
 * @author h_dj
 * @version V1.0
 * @Title: RepeatableAnnotationTest
 * @Package cn.hdj.java8.repeatAnnotation
 * @Description: TODO
 * @date 2018/4/1 11:30
 */
public class RepeatableAnnotationTest {


    @Schedule(dayOfMonth = "last")
    @Schedule(dayOfWeek = "Fri", hour = 25)
    public void doPeriodicCleanup() {
    }


    public static void main(String[] args) throws NoSuchMethodException {
        Method method = RepeatableAnnotationTest.class.getDeclaredMethod("doPeriodicCleanup");

        Schedules schedule1 = method.getAnnotation(Schedules.class);

        Stream.of(schedule1.value()).forEach(System.out::println);

        Schedule[] schedules2 = method.getAnnotationsByType(Schedule.class);
        Stream.of(schedules2).forEach(System.out::println);



    }

}
