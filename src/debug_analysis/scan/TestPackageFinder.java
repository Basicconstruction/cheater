package debug_analysis.scan;

import analysis.scan.PackageFinder;

import java.io.File;

public class TestPackageFinder {
    public static void main(String[] args) {
        PackageFinder pf = new PackageFinder(new File("H:\\Desktop\\temporary\\SpaceFilter.java"));
        System.out.println(pf.packageName);
    }
}
