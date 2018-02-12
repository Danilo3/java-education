package decorator.io;


import java.io.*;

public class InputTest {
    public static void main(String[] args) {
        int c;
        try{
            InputStream inputStream =
                    new LowerCaseInputStream(
                            new BufferedInputStream(
                                    new FileInputStream("src/decorator/io/test.txt")));

            while((c=inputStream.read())>=0){
                System.out.print((char)c);
            }
            inputStream.close();
        }catch (IOException exception){
            exception.printStackTrace();
        }
    }
}
