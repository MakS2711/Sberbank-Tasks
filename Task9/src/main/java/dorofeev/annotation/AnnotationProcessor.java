package dorofeev.annotation;

import dorofeev.exception.AnnotationException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AnnotationProcessor {

    public static List<Object> runningCustomTest(Class<?> clazz) throws Exception {
        var currentInstanceClass = clazz.getDeclaredConstructor().newInstance();

        return getTestMethods(clazz).stream().map(x -> {
            try {
                return x.invoke(currentInstanceClass);
            } catch (IllegalAccessException | InvocationTargetException e) {
                return null;
            }
        }).collect(Collectors.toList());
    }

    private static List<Method> getTestMethods(Class<?> clazz) throws AnnotationException {
        List<Method> methodList = new ArrayList<>();
        Method doBeforeAll = null;
        Method doAfterAll = null;

        for (var m : List.of(clazz.getMethods())) {
            if (m.isAnnotationPresent(DoTest.class)) {
                if (m.getAnnotation(DoTest.class).order() < 1) {
                    throw new AnnotationException("Номер вызова должен быть положительный и больше 0");
                }
                methodList.add(m);
            } else if (m.isAnnotationPresent(DoBeforeAll.class)) {
                if (doBeforeAll == null) {
                    doBeforeAll = m;
                } else {
                    throw new AnnotationException("Количество аннотаций DoBeforeAll > 1");
                }
            } else if (m.isAnnotationPresent(DoAfterAll.class)) {
                if (doAfterAll == null) {
                    doAfterAll = m;
                } else {
                    throw new AnnotationException("Количество аннотаций DoAfterAll > 1");
                }
            }
        }

        if (methodList.isEmpty()) {
            throw new AnnotationException("Количество аннотаций DoTest < 1");
        }

        methodList.sort(Comparator.comparingInt(o -> o.getAnnotation(DoTest.class).order()));

        if (doBeforeAll != null) {
            methodList.add(0, doBeforeAll);
        }

        if (doAfterAll != null) {
            methodList.add(methodList.size(), doAfterAll);
        }

        return methodList;
    }
}