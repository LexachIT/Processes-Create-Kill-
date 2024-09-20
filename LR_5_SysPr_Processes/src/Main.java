import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        for (int i = 0; i<3; i++) {
            try{
                ProcessBuilder Builder = new ProcessBuilder();
                Builder.command("notepad.exe");
                Process process = Builder.start();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                }
                process.destroy();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }


        }
    }
}
