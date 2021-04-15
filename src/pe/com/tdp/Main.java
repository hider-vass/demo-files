package pe.com.tdp;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        String pwd = getValueFromLine("data2.txt", "pwd");
        System.out.println("pwd encontrada:" + pwd);
        pwd = getValueFromLineBySeparator("data2.txt", "pwd", ":");
        System.out.println("pwd encontrada:" + pwd);

    }

    public static String getValueFromLine(String fileName, String keyToValueInLine) throws IOException {
        String line;
        String filePath = fileName;
        File file = new File(fileName);
        int startIndexPwdValue = keyToValueInLine.length() + 1;
        try (FileReader reader = new FileReader(file); BufferedReader buffer = new BufferedReader(reader)) {
            filePath = file.getAbsolutePath();
            while ((line = buffer.readLine()) != null) {
                if (line.startsWith(keyToValueInLine)) {
                    if (startIndexPwdValue >= line.length()) {
                        String errorMsg = "Error la leer el valor en la linea=%s";
                        throw new IndexOutOfBoundsException(String.format(errorMsg, keyToValueInLine, line));
                    }
                    return line.substring(startIndexPwdValue);
                }
            }
        } catch (FileNotFoundException e) {
            throw new IOException(String.format("El archivo %s no existe, error:%s", filePath, e.getMessage()));
        } catch (IOException e) {
            throw new IOException(String.format("Error al procesar el archivo %s,error:%s", filePath, e.getMessage()));
        }
        return null;
    }

    public static String getValueFromLineBySeparator(String fileName, String key, String separator) throws IOException {
        String line;
        String filePath = fileName;
        File file = new File(fileName);
        try (FileReader reader = new FileReader(file); BufferedReader buffer = new BufferedReader(reader)) {
            filePath = file.getAbsolutePath();
            while ((line = buffer.readLine()) != null) {
                if (line.startsWith(key)) {
                    String[] split = line.split(separator);
                    if (split.length < 2) {
                        String errorMsg = "Error la leer el valor en la linea=%s";
                        throw new IndexOutOfBoundsException(String.format(errorMsg, line));
                    }
                    return split[1];
                }
            }
        } catch (FileNotFoundException e) {
            throw new IOException(String.format("El archivo %s no existe, error:%s", filePath, e.getMessage()));
        } catch (IOException e) {
            throw new IOException(String.format("Error al procesar el archivo %s,error:%s", filePath, e.getMessage()));
        }
        return null;
    }
}
