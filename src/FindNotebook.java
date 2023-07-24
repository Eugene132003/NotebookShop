import java.util.*;

public class FindNotebook {

    public static List<Notebook> filterAll(List filter, Scanner sc, List<Notebook> filterNotebook, int selector){
        for (int i=0; i<filter.size();i++) {
            System.out.println((i+1) + " - "+filter.get(i));
        }
        String menuBrend=sc.nextLine();
        List<Notebook> temp=new ArrayList<>();
        switch (selector){
            case 1:
                for (int i = 0; i < filterNotebook.size(); i++) {
                    if (filterNotebook.get(i).getBrand().equalsIgnoreCase((String) filter.get(Integer.parseInt(menuBrend)-1))){
                        temp.add(filterNotebook.get(i));
                    }
                }
                break;
            case 2:
                for (int i = 0; i < filterNotebook.size(); i++) {
                    if (filterNotebook.get(i).getModel().equalsIgnoreCase((String) filter.get(Integer.parseInt(menuBrend)-1))){
                        temp.add(filterNotebook.get(i));
                    }
                }
                break;
            case 3:
                for (int i = 0; i < filterNotebook.size(); i++) {
                    if (filterNotebook.get(i).getProcessor().equalsIgnoreCase((String) filter.get(Integer.parseInt(menuBrend)-1))){
                        temp.add(filterNotebook.get(i));
                    }
                }
                break;
            case 4:
                for (int i = 0; i < filterNotebook.size(); i++) {
                    if (filterNotebook.get(i).getScreenSize()==(Double) filter.get(Integer.parseInt(menuBrend)-1)){
                        temp.add(filterNotebook.get(i));
                    }
                }
                break;
            case 5:
                for (int i = 0; i < filterNotebook.size(); i++) {
                    if (filterNotebook.get(i).getHddSize()==(Integer) filter.get(Integer.parseInt(menuBrend)-1)){
                        temp.add(filterNotebook.get(i));
                    }
                }
                break;
            case 6:
                for (int i = 0; i < filterNotebook.size(); i++) {
                    if (filterNotebook.get(i).getRom()==(Integer) filter.get(Integer.parseInt(menuBrend)-1)){
                        temp.add(filterNotebook.get(i));
                    }
                }
                break;
        }
        filterNotebook.clear();
        filterNotebook.addAll(temp);
        temp.clear();
        return filterNotebook;
    }

    public static void findNotebook(List<Notebook> notebookList, Scanner sc,List<Notebook> filterNotebook){

        System.out.println("Введите номер необходимого параметра (можно перечислить несколько через запятую): \n" +
                "1 - Бренд ноутубка \n2 - Модель ноутубка \n3 - Процессор ноутубка \n4 - Размер экрана ноутубка \n" +
                "5 - Размер жесткого диска ноутубка \n6 - Размер оперативной памяти ноутубка \n");

        String paramMenu = sc.nextLine();
        String stringArray[] = paramMenu.split("\\D+");
        filterNotebook.addAll(notebookList);

        for (String item: stringArray) {
            switch (Integer.parseInt(item)){
                case 1:
                    System.out.println("Выбираем бренд: ");
                    filterAll(CreateArrays.brendArrays(filterNotebook), sc, filterNotebook, 1);
                    break;
                case 2:
                    System.out.println("Выбираем модель: ");
                    filterAll(CreateArrays.modelArrays(filterNotebook), sc, filterNotebook,2);
                    break;
                case 3:
                    System.out.println("Выбираем процессор: ");
                    filterAll(CreateArrays.processorArrays(filterNotebook), sc, filterNotebook,3);
                    break;
                case 4:
                    System.out.println("Выбираем размер экрана: ");
                    filterAll(CreateArrays.screenSizeRange(filterNotebook), sc, filterNotebook,4);
                    break;
                case 5:
                    System.out.println("Выбираем размер жесткого диска: ");
                    filterAll(CreateArrays.hddSizeRange(filterNotebook), sc, filterNotebook,5);
                    break;
                case 6:
                    System.out.println("Выбираем размер оперативной памяти: ");
                    filterAll(CreateArrays.romSizeRange(filterNotebook), sc, filterNotebook,6);
                    break;
                default:
                    System.out.println("Введите правильное число!!!");
                    break;
            }
        }
    }
}

