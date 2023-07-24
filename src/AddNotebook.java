import java.io.*;
import java.util.List;
import java.util.Scanner;

public class AddNotebook { public static List<Notebook> addNotebook(List<Notebook> notebookList, Scanner sc, File file) {
    System.out.println("Введите бренд ноутубка:");
    String brand = sc.nextLine();

    System.out.println("Введите модель ноутубка:");
    String model = sc.nextLine();

    System.out.println("Введите процессор ноутубка:");
    String processor = sc.nextLine();

    System.out.println("Введите размер экрана ноутубка:");
    double screenSize = Double.parseDouble(sc.nextLine());

    System.out.println("Введите размер жесткого диска ноутубка:");
    int hddSize = Integer.parseInt(sc.nextLine());

    System.out.println("Введите размер оперативной памяти ноутубка:");
    int rom = Integer.parseInt(sc.nextLine());
    Notebook notebook = new Notebook(brand, model, processor, screenSize, hddSize, rom);

    if(file.length()==0){
        notebookList.add(notebook);
        try (FileWriter writer=new FileWriter("src/notebook.txt")){
            writer.write(notebook.getBrand()+" "+notebook.getModel()+" "+notebook.getProcessor()+" "+notebook.getScreenSize()+" "+notebook.getHddSize()+" "+notebook.getRom());
            writer.write("\n");
        }catch (Exception e){
            e.printStackTrace();
        }
    }else{
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            String temp =notebook.getBrand()+" "+notebook.getModel()+" "+notebook.getProcessor()+" "+notebook.getScreenSize()+" "+notebook.getHddSize()+" "+notebook.getRom();
            boolean find=true;
            while (line != null) {
                if (line.equalsIgnoreCase(temp)) {
                    find = false;
                }
                line = reader.readLine();
            }
            if (find==true){
                String stringArray[] = temp.split(" ");
                notebookList.add(notebook);
                try (FileWriter writer=new FileWriter("src/notebook.txt",true)){
                    writer.write("\n");
                    writer.write(temp);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            reader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    return notebookList;
}
}
