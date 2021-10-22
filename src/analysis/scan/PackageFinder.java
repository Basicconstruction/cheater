package analysis.scan;

import file.text_picker.SpaceFilter;
import file.text_picker.TextCollector;
import file.text_picker.TextIterator;

import java.io.File;

public class PackageFinder {
    public String packageName;
    public PackageFinder(File file){
        TextIterator ti = new TextCollector(file).getAsTextIterator();
        while(ti.hasNext){
            String s = ti.getLine();
            if(packageNameFinder(s)){
                break;
            }
        }
    }
    /**
     * 合理性假设以 减小代码数量，加快速度。
     * 该方法认为 package pname;应该在同一行，分号可以在下一行
     * */
    public boolean packageNameFinder(String s){

        if(s.contains("package")){
            String str = SpaceFilter.getFilterText(s.substring(s.indexOf("package")+8)).trim();
            if(str.endsWith(";")){
                packageName = str.substring(0,str.indexOf(";")).trim();
            }
            return true;
        }
        return false;
    }
}
