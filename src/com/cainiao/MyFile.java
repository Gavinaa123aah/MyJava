package com.cainiao;

import java.io.*;

public class MyFile {
    /**
     *写文件，方法1
     * 按字节流写入
     */
    static void write_file(){
        try {
            String[] data = {"aa","bb","ccc"};
            OutputStream outputStream =new FileOutputStream("out.txt",true);
            for(int i =0;i<data.length;i++){
                outputStream.write(data[1].getBytes());
            }
            outputStream.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    /**
     * 按字符流写入
     */
    static void write_file2(){
        try {
            FileWriter fileWriter = new FileWriter("text2.txt",true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.append("aaaaa\r\n");
            bufferedWriter.append("bbbbb\r\n");
            bufferedWriter.append("ccccc\r\n");
            bufferedWriter.close();
            fileWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 使用FileReader
     * 每次读一个字符
     */
    static void read_file(){
        try {
            FileReader fileReader = new FileReader("text.txt");
            int ch = 0;
            while ((ch=fileReader.read())!=-1){
                System.out.print((char) ch);
            }
            fileReader.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    /**
     * InputStreamReader+BufferedReader读取字符串  ， InputStreamReader类是从字节流到字符流的桥梁
     * 按行读取效果最好
     */
    static void read_file2(){
        try {
            FileInputStream fileInputStream = new FileInputStream("text.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line = null;
            while ((line=bufferedReader.readLine())!=null){
                System.out.println(line);
            }
        }catch (Exception e){
            e.printStackTrace();
        }


    }

    /**
     * 按字节读取后转码
     */
    static void read_file3(){
        String str="";
        try {
            InputStream inputStream = new FileInputStream("text.txt");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            str = new String(buffer,"UTF-8");

            System.out.println(str);

        }catch (Exception E){
            E.printStackTrace();
        }



    }
    /**
     *
     * @param args
     * @throws FileNotFoundException
     * @throws IOException
     */

    public static void main(String args[]) throws FileNotFoundException, IOException {

       read_file3();
    }
}
