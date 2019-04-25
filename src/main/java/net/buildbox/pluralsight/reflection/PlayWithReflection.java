package net.buildbox.pluralsight.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 * Hello world!
 */
public class PlayWithReflection {
    public static void main(String[] args) throws Exception {
        String personClassName = "net.buildbox.pluralsight.reflection.model.Person";
        Class<?> personClass = Class.forName(personClassName);
        System.out.println("Person class = " + personClass);

        Field[] fields = personClass.getFields();
        System.out.println("Fields:");
        System.out.println(Arrays.toString(fields));

        Field[] declaredFields = personClass.getDeclaredFields();
        System.out.println("Declared Fields:");
        System.out.println(Arrays.toString(declaredFields));

        Method[] methods = personClass.getMethods();
        System.out.println("Methods:");
        for (Method method : methods) {
            System.out.println(method);
        }

        Method[] declaredMethods = personClass.getDeclaredMethods();
        System.out.println("Declared Methods:");
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }

        System.out.println("Static Declared Methods:");
        Arrays.stream(declaredMethods)
                .filter(m -> Modifier.isStatic(m.getModifiers()))
                .forEach(System.out::println);
    }
}
