import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Scanner;

public class Main {
    public static void main(String []args){
        String keyboard = "";
        String fileContent = null;
        String targetFileContent = null;
        FileOperations fileOperations = new FileOperations();
        CaesarMethod caesarMethod = null;
        Scanner in = new Scanner(System.in);
        System.out.println("Type help, please");
        while(!keyboard.equals("exit")){
            keyboard = in.nextLine().trim();
            switch (keyboard) {
                case "start":
                    if (fileContent != null && targetFileContent != null && caesarMethod != null) {
                        System.out.println("Write decrypt or encrypt: ");
                        keyboard = in.nextLine().trim();
                        try {
                            switch (keyboard) {
                                case "decrypt":
                                    System.out.println(fileOperations.setContentToFile(targetFileContent, caesarMethod.decrypt(fileContent)));
                                    break;
                                case "encrypt":
                                    System.out.println(fileOperations.setContentToFile(targetFileContent, caesarMethod.encrypt(fileContent)));
                                    break;
                            }
                        } catch (Exception e){
                            System.out.println("File not found or cant to write");
                        }
                    } else {
                        if(fileContent == null) System.out.println("You don't set filename");
                        if(targetFileContent == null) System.out.println("You don't set target file");
                        if(caesarMethod == null) System.out.println("You don't set keyword and key");
                    }
                    break;
                case "set-filename":
                    try {
                        System.out.println("Write filename for your file: ");
                        keyboard = in.nextLine().trim();
                        fileContent = fileOperations.getContentOfFile(keyboard);
                        System.out.println("Successfully");
                    } catch (Exception e){
                        fileContent = null;
                        System.out.println("File not found or cant read");
                    }
                    break;
                case "set-key":
                    try {
                        System.out.println("Write keyword, please: ");
                        keyboard = in.nextLine().trim();
                        System.out.println("Write key, please: ");
                        caesarMethod = new CaesarMethod(Integer.parseInt(in.nextLine().trim()), keyboard);
                        System.out.println("Successfully");
                    } catch (NumberFormatException e){
                        System.out.println("You wrong type number");
                    }catch (IllegalArgumentException e){
                        System.out.println("Keyword must be less than 26 symbols");
                    }
                    break;
                case "set-target file":
                    try {
                        System.out.println("Write filename for your target file: ");
                        targetFileContent = in.nextLine().trim();
                        if (fileOperations.checkFile(targetFileContent)) {
                            System.out.println("Successfully");
                        } else {
                            System.out.println("Can't write to file. Error.");
                            targetFileContent = null;
                        }
                    }catch (Exception e){
                        targetFileContent = null;
                        System.out.println("Can't create file");
                    }
                    break;
                case "help":
                    System.out.println("start - start the program\n" +
                            "set-filename - set name of the source file\n" +
                            "set-key - set parameters for new alphabet, where key is offset\n" +
                            "set-target file - set name of the file where you can see result\n" +
                            "encrypt - encrypt the file with the given parameters\n"+
                            "decrypt - decrypt the file with the given parameters\n"+
                            "exit - exit the program");
                    break;
                default:
                    System.out.println("Type help, please");
                    break;
            }
        }
        in.close();
        System.out.println("Bye, good luck!");
    }
}
//        while(!keyboard.equals("exit")){
//                keyboard = in.nextLine().trim();
//                if(keyboard.equals("start")){
//                changeKey:while(!keyboard.equals("exit")) {
//                System.out.println("Write keyword, please: ");
//                keyboard = in.nextLine().trim();
//                System.out.println("Write key, please: ");
//                caesarMethod = new CaesarMethod(Integer.parseInt(in.nextLine().trim()), keyboard);
//                System.out.println("Write filename for your file or exit to change key: ");
//                changeFile:
//                while (!keyboard.equals("exit")) {
//                keyboard = in.nextLine().trim();
//                if(keyboard.equals("exit")){
//                System.out.println("Write keyword or exit, please: ");
//                keyboard = "file";
//                continue changeKey;
//                }
//                String fileContent = fileOperations.getContentOfFile(keyboard);
//                System.out.println("Write decrypt or encrypt or exit to write another filename: ");
//                keyboard = in.nextLine().trim();
//                if(keyboard.equals("exit")){
//                System.out.println("Write filename for your file or exit to change key: ");
//                keyboard = "file";
//                continue changeFile;
//                }
//                changeMode:
//                while (!keyboard.equals("exit")) {
//                switch (keyboard) {
//                case "decrypt":
//                System.out.println("Write filename for your decrypt file or exit to change mode:  ");
//                keyboard = in.nextLine().trim();
//                if (keyboard.equals("exit")) {
//                System.out.println("Write decrypt or encrypt or exit to write another filename: ");
//                keyboard = in.nextLine().trim();
//                continue changeMode;
//                }
//                System.out.println(fileOperations.setContentToFile(keyboard, caesarMethod.decrypt(fileContent)));
//                break;
//                case "encrypt":
//                System.out.println("Write filename for your encrypt file or exit to change mode: ");
//                keyboard = in.nextLine().trim();
//                if (keyboard.equals("exit")) {
//                System.out.println("Write decrypt or encrypt or exit to write another filename: ");
//                keyboard = in.nextLine().trim();
//                continue changeMode;
//                }
//                System.out.println(fileOperations.setContentToFile(keyboard, caesarMethod.encrypt(fileContent)));
//                break;
//                case "exit":
//                System.out.println("Write filename for your file or exit to change key: ");
//                keyboard = "file";
//                continue changeFile;
//default:
//        System.out.println("Write filename for your decrypt file or exit to change mode:  ");
//        keyboard = in.nextLine().trim();
//        if(keyboard.equals("exit")) keyboard = "file";
//        continue changeMode;
//        }
//        }
//        }
//        }
//        } else if(keyboard.equals("exit")) break;
//        else System.out.println("When u want to start, type - start\nIf you want to exit type - exit");
//        }
