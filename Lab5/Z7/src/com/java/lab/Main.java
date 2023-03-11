package com.java.lab;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

// При выполнении следующих заданий для вывода результатов создавать новую директорию и файл средствами класса File
// 6.	Из файла удалить все слова, содержащие от трех до пяти символов, но при этом из каждой строки должно быть удалено только максимальное четное количество таких слов.
public class Main {

    public static void main(String[] args) throws IOException {

        File file_in = new File("/Users/ivangorshkov/Documents/BMSTU/BigDataJava/Java-IU6-12M/Lab5/Z7/in.txt");
        Path path = Paths.get("/Users/ivangorshkov/Documents/BMSTU/BigDataJava/Java-IU6-12M/Lab5/Z7/directory/out.txt");
        File theDir = new File("/Users/ivangorshkov/Documents/BMSTU/BigDataJava/Java-IU6-12M/Lab5/Z7/directory");
        if (!theDir.exists()){
            theDir.mkdir();
        }

        Scanner in = new Scanner(file_in);
        int k = 1;

        while(in.hasNextLine()) {
            String line = in.nextLine();
            String[] words = line.split(" ");
            var list = new ArrayList<String>();
            var buf = new StringBuilder(line);

            for (String s : words) {
                if ((s.length() >= 3) && (s.length() <= 5)) {
                    list.add(s);
                }
            }

            if ((list.size() % 2) == 1) {
                list.remove(list.size() - 1);
            }

            int index = 0;
            for (String s : list) {
                index = buf.indexOf(s, index);
                buf.delete(index, index + s.length());
            }
            if (k == 1) {
                Files.write(path, Collections.singleton(buf.toString()), StandardCharsets.UTF_8);
            } else {
                Files.write(path, Collections.singleton(buf.toString()), StandardCharsets.UTF_8, StandardOpenOption.APPEND);
            }
            k += 1;
        }
    }
}
