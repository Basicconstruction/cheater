package file.text_picker;

import java.util.ArrayList;

/**
 *
 * */
public class EasySplit {
    String split;
    public EasySplit(String split){
        this.split = split;
    }
    public String[] getSplits(String text){
        text = SpaceFilter.getFilterText(text);
        ArrayList<String> al = new ArrayList<>();
        for(String s:text.split(split)){
            /*
             * 过滤掉无实际信息的文本(" "和"")
             */
            if(!(s.equals(" ")||s.equals(""))){
                al.add(s.trim());
            }
        }
        String[] res = new String[al.size()];
        int count = 0;
        for(String s: al){
            res[count++] = s;
        }
        return res;
    }
}
