package com.habit.custom.knowledges;

import java.util.List;

/**
 * OLTS on 29.11.2016.
 */
public class Knowledge {

    // FULL SCAN
    public static void main(String[] args) {
        Knowledge knowledge = new Knowledge();
        System.out.println(knowledge.find());
    }

    public String find() {
        List<Class<?>> classes = ClassFinder.find("com.habit");
        StringBuilder s = new StringBuilder("");
        for (Class<?> c : classes) {
            Pattern[] patterns = c.getAnnotationsByType(Pattern.class);
            for (Pattern p : patterns) {
                s.append(p.type()).append(" ").append(p.value());
            }
            AntiPattern[] antiPatterns = c.getAnnotationsByType(AntiPattern.class);
            for (AntiPattern p : antiPatterns) {
                s.append(p.value());
            }
        }
        return s.toString();
    }
}
