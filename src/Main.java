import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //лист ноутбуков
        List<Notebook> notebookList = new ArrayList<>();
        List<Notebook> filterNotebook = new ArrayList<>();
        //Проверка наличия файла списка ноутбуков
        File file = new File("src/notebook.txt");
        if(file.exists() && !file.isDirectory()&&file.length()!=0) {
            readFile(notebookList, file);
        }else{
            try {
                file.createNewFile();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        //Главное меню
        Scanner sc=new Scanner(System.in);
        while (true) {
            System.out.println("Выберите вариант:\n 1 - Добавить ноутбук \n 2 - Удалить ноутбук \n 3 - Найти ноутбук по параметрам \n 4 - Вывести все ноутбуки");
            try {
            int mainMenu = sc.nextInt();
            sc.nextLine();
            switch (mainMenu){
                case 1:
                    AddNotebook.addNotebook(notebookList, sc, file);
                    break;
                case 2:
                    DeleteNotebook.deleteNotebook(notebookList, sc, file);
                    break;
                case 3:
                    FindNotebook.findNotebook(notebookList, sc, filterNotebook);
                    //Вывод фильтрованных ноутов
                    for (Notebook item1 : filterNotebook) {
                        if (!notebookList.isEmpty()) {
                            System.out.println("Ноутбук " + item1.getBrand() + " модель: " + item1.getModel() + " с процессором " + item1.getProcessor() + " размером экрана " + item1.getScreenSize() + "\" жестким диском на " + item1.getHddSize() + "Гб и оперативнй памятью на " + item1.getRom() + "Гб");
                        }
                    }
                    break;
                case 4:
                    printAll(notebookList);
                    break;
                default:
                    System.out.println("Введите правильное число!!!");
                    break;
            }

            }catch (Exception e){
                System.out.println("Введите правильное число!!!");
                break;
            }
        }
        sc.close();
    }

    //Вывод в консоль ноутбуков
    public static void printAll(List<Notebook> notebookList) {
        for (Notebook item: notebookList) {
            if(!notebookList.isEmpty()) {
                System.out.println("Ноутбук "+ item.getBrand()+ " модель: " + item.getModel()+" с процессором "+ item.getProcessor()+" размером экрана " + item.getScreenSize()+"\" жестким диском на "+ item.getHddSize()+"Гб и оперативнй памятью на "+ item.getRom()+"Гб");
            }
        }
    }

    //Чтение списка ноутбуков из файла
    public static List<Notebook> readFile(List<Notebook> notebookList, File file){
        try {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line = reader.readLine();

                while (line != null) {
                    String stringArray[] = line.split(" ");
                    Notebook notebook = new Notebook(stringArray[0], stringArray[1], stringArray[2], Double.parseDouble(stringArray[3]), Integer.parseInt(stringArray[4]), Integer.parseInt(stringArray[5]));
                    notebookList.add(notebook);
                    line = reader.readLine();
                }

                reader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return notebookList;
    }
}
