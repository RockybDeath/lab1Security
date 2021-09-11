import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import sun.awt.windows.WBufferStrategy;

import java.io.*;

public class FileOperations {
    public String getContentOfFile(String path) throws FileNotFoundException, IOException {
            File file = new File(path);
            if(!file.exists()) throw new FileNotFoundException();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line ="";
            StringBuilder stringBuilder = new StringBuilder();
            while((line = bufferedReader.readLine()) != null){
                stringBuilder.append(line+"\n");
            }
            bufferedReader.close();
            return stringBuilder.toString();
    }
    public String setContentToFile(String path, String content) throws IOException {
            File file = new File(path);
            if(!file.exists()) file.createNewFile();
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            bufferedWriter.write(content);
            bufferedWriter.flush();
            bufferedWriter.close();
            return "Успешно записано";
    }
    public boolean checkFile(String path) throws IOException {
        File file = new File(path);
        if(!file.exists()) file.createNewFile();
        return file.canWrite();
    }
}
