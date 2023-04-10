package day11.io.rw;

import day11.io.Path;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileReaderExample {

    public static void main(String[] args) {

        try (FileReader fr = new FileReader(Path.ROOT_PATH + "/member.txt")) {

            // 버퍼 스트림
            BufferedReader br = new BufferedReader(fr);

            String s = br.readLine();
            System.out.println("s = " + s);

            String[] split = s.split(",");
            System.out.println(Arrays.toString(split));


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
