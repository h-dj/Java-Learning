package cn.hdj.annotations;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 注解处理器
 */
public class UseCaseTracker {
    public static void trackUserCases(List<Integer> useCase, Class<?> clazz) {
        for (Method m : clazz.getDeclaredMethods()) {
            UseCase uc = m.getAnnotation(UseCase.class);
            if (uc != null) {
                System.out.println("found use case :" + uc.id() + " " + uc.description());
                useCase.remove(new Integer(uc.id()));
            }
        }

        for (int i : useCase) {
            System.out.println("warning :messing use case " + i);
        }
    }

    public static void main(String[] args) {
        List<Integer> useCases = new ArrayList<>();
        Collections.addAll(useCases, 47, 48, 49, 50);
        trackUserCases(useCases, PasswordUtils.class);

    }
}
