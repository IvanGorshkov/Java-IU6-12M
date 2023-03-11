package com.java.lab;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.stream.Collectors;

// В следующих заданиях требуется ввести последовательность строк из текстового потока и выполнить указанные действия. При этом могут рассматриваться два варианта:
// • каждая строка состоит из одного слова;
// • каждая строка состоит из нескольких слов.
//Имена входного и выходного файлов, а также абсолютный путь к ним могут быть введены как параметры командной строки или храниться в файле.
// В каждом слове стихотворения Николая Заболоцкого заменить первую букву слова на прописную.

public class Main {

    public static void main(String[] args) throws IOException {

        File file_in = new File("/Users/ivangorshkov/Documents/BMSTU/BigDataJava/Java-IU6-12M/Lab5/Z6/in.txt");
        Path path = Paths.get("/Users/ivangorshkov/Documents/BMSTU/BigDataJava/Java-IU6-12M/Lab5/Z6/out.txt");
        Scanner in = new Scanner(file_in);
        int k = 1;
        while(in.hasNextLine()) {
            String line = in.nextLine();
            String[] words = line.split(" ");
            words[0] = capitalize(words[0]);
            if (k == 1) {
                Files.write(path, Collections.singleton(String.join(" ", words)), StandardCharsets.UTF_8);
            } else {
                Files.write(path, Collections.singleton(String.join(" ", words)), StandardCharsets.UTF_8, StandardOpenOption.APPEND);
            }
            k += 1;
        }
    }
    public static String capitalize(String str)
    {
        if (str == null || str.length() == 0) return str;
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}