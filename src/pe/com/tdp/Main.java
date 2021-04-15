package pe.com.tdp;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        String pwd = ReadFile.getValueFromLine("data2.txt", "pwd");
        System.out.println("pwd encontrada:" + pwd);
        pwd = ReadFile.getValueFromLineBySeparator("data2.txt", "pwd", ":");
        System.out.println("pwd encontrada:" + pwd);

    }

}
