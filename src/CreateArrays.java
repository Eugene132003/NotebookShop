import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CreateArrays {
    public static List<String> brendArrays(List<Notebook> notebookList){
        List<String> brendArray = new ArrayList<>();
        int count=0;
        brendArray.add(notebookList.get(0).getBrand());
        for (int i=1;i< notebookList.size();i++) {
                for (String item:brendArray) {
                    if(item.equalsIgnoreCase(notebookList.get(i).getBrand())){
                        count++;
                    }
                }
                if(count==0){
                    brendArray.add(notebookList.get(i).getBrand());
                }
                count=0;
            }
        return brendArray;
    }

    public static List<String> modelArrays(List<Notebook> notebookList){
        List<String> modelArray = new ArrayList<>();
        int count=0;
        modelArray.add(notebookList.get(0).getModel());
        for (int i=1;i< notebookList.size();i++) {
            for (String item:modelArray) {
                if(item.equalsIgnoreCase(notebookList.get(i).getModel())){
                    count++;
                }
            }
            if(count==0){
                modelArray.add(notebookList.get(i).getModel());
            }
            count=0;
        }
        return modelArray;
    }

    public static List<String> processorArrays(List<Notebook> notebookList){
        List<String> processorArray = new ArrayList<>();
        int count=0;
        processorArray.add(notebookList.get(0).getProcessor());
        for (int i=1;i< notebookList.size();i++) {
            for (String item:processorArray) {
                if(item.equalsIgnoreCase(notebookList.get(i).getProcessor())){
                    count++;
                }
            }
            if(count==0){
                processorArray.add(notebookList.get(i).getProcessor());
            }
            count=0;
        }
        return processorArray;
    }

    public static List<Double> screenSizeRange(List<Notebook> notebookList){
        List<Double> screenSizeRange = new ArrayList<>();

        int count=0;
        screenSizeRange.add(notebookList.get(0).getScreenSize());
        for (int i=1;i< notebookList.size();i++) {
            for (double item : screenSizeRange) {
                if (item == notebookList.get(i).getScreenSize()) {
                    count++;
                }
            }
            if (count == 0) {
                screenSizeRange.add(notebookList.get(i).getScreenSize());
            }
            count = 0;
        }
        Collections.sort(screenSizeRange);
        return screenSizeRange;
    }

    public static List<Integer> hddSizeRange(List<Notebook> notebookList){
        List<Integer> hddSizeRange = new ArrayList<>();

        int count=0;
        hddSizeRange.add(notebookList.get(0).getHddSize());
        for (int i=1;i< notebookList.size();i++) {
            for (double item : hddSizeRange) {
                if (item == notebookList.get(i).getHddSize()) {
                    count++;
                }
            }
            if (count == 0) {
                hddSizeRange.add(notebookList.get(i).getHddSize());
            }
            count = 0;
        }
        Collections.sort(hddSizeRange);
        return hddSizeRange;
    }

    public static List<Integer> romSizeRange(List<Notebook> notebookList){
        List<Integer> romSizeRange = new ArrayList<>();
        int count=0;
        romSizeRange.add(notebookList.get(0).getRom());
        for (int i=1;i< notebookList.size();i++) {
            for (double item : romSizeRange) {
                if (item == notebookList.get(i).getRom()) {
                    count++;
                }
            }
            if (count == 0) {
                romSizeRange.add(notebookList.get(i).getRom());
            }
            count = 0;
        }
        Collections.sort(romSizeRange);
        return romSizeRange;
    }
}
