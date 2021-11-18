package dev.danvega;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
//        List<String> languages = List.of("java","python","c++","c#","javascript");
//
//        // find all languages that start with java
//        List<String> javaLanguages = new ArrayList<>();
//        for(String language : languages) {
//            if(language.startsWith("java")) {
//                // java is to javascript as car is to carpet
//                javaLanguages.add(language);
//            }
//        }
//        System.out.println(javaLanguages);

//        List<String> languages = List.of("java","python","c++","c#","javascript");
//
//        List<String> javaLanguages = languages.stream().filter(language -> language.startsWith("java")).toList();
//
//        System.out.println(javaLanguages);

        List<Developer> developers = List.of(
                new Developer("Dan", List.of("Java","JavaScript","TypeScript","C#")),
                new Developer("Joe", List.of("Java","TypeScript","C#")),
                new Developer("Andrew", List.of("TypeScript","C#"))
        );

        List<Developer> java = developers.stream().filter(developer -> developer.languages().contains("Java")).toList();
        System.out.println(java);
    }
}
