package com.metanit;

import java.io.*;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\USER\\IdeaProjects\\task48\\data\\input_task48.txt");
        FileWriter fileWriter = new FileWriter(file);
        FileReader fileReader = new FileReader(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(" Yesterday was the 9th   of January 2013  ");
        bufferedWriter.flush();

        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String s = bufferedReader.readLine();
        System.out.println(s);


        Pattern pattern = Pattern.compile(("(\\d+)"));
        Matcher matcher = pattern.matcher(s);
        int sum = 0;
        HashSet<Integer> set = new HashSet<Integer>();

        String string = "";
        while (matcher.find()) {
            System.out.print(string + matcher.group(1));

            int a = Integer.parseInt(matcher.group(1));
            if (!set.contains(a)) {
                set.add(a);
            }
            sum = sum + Integer.parseInt(matcher.group(1));

        }

        System.out.println(sum);
        System.out.println(set);
        System.out.println(set.stream().mapToInt(Integer::intValue).sum());
        bufferedWriter.newLine();
        bufferedWriter.write(String.valueOf(sum));
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}