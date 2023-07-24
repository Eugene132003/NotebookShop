import java.io.*;
import java.util.List;
import java.util.Scanner;

public class DeleteNotebook {
    public static List<Notebook> deleteNotebook(List<Notebook> notebookList, Scanner sc, File file){

        if (notebookList.isEmpty()) {
            System.out.println("Список ноутбуков пуст, удалять нечего.");
        } else {
            System.out.println("Введите номер удаяемого ноутбука из списка:");
            int i=1;
            for (Notebook item: notebookList) {
                System.out.println(i + " - "+"Ноутбук "+ item.getBrand()+ " модель: " + item.getModel()
                        +" с процессором "+ item.getProcessor()
                        +" размером экрана " + item.getScreenSize()
                        +"\" жестким диском на "+ item.getHddSize()
                        +"Гб и оперативной памятью на "+ item.getRom()+"Гб");
                i++;
            }
            int numberDelete = Integer.parseInt(sc.nextLine());

            String lineToRemove = notebookList.get(numberDelete-1).getBrand()+" "+notebookList.get(numberDelete-1).getModel()+" "
                    +notebookList.get(numberDelete-1).getProcessor()+" "+notebookList.get(numberDelete-1).getScreenSize()+" "
                    +notebookList.get(numberDelete-1).getHddSize()+" "+notebookList.get(numberDelete-1).getRom();
            notebookList.remove(numberDelete-1);
            try {
                File tempFile = new File("src/temp.txt");
                BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String currentLine;

                while ((currentLine = reader.readLine()) != null) {

                    if (!currentLine.equals(lineToRemove)) {
                        writer.write(currentLine + System.getProperty("line.separator"));
                    }
                }
                reader.close();
                writer.close();

                File oldFile = new File(file.toString());
                oldFile.delete();

                tempFile.renameTo(oldFile);
            } catch (IOException ex) {
                System.out.println("Ошибка при удалении строки из файла " + file);
                ex.printStackTrace();
            }

        }
        return notebookList;
    }
}
