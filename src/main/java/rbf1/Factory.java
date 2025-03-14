package rbf1;

import rbf1.box.ToolBox;
import rbf1.component.Packager;
import rbf1.tools.Apple;
import rbf1.tools.Brick;
import rbf1.tools.installable.HugeCrowbar;
import rbf1.tools.installable.HugeGrinder;
import rbf1.tools.portable.Wrench;

public class Factory {

    public static void main(String[] args) {
        test1();
        System.out.println();
        test2();
        System.out.println();
        test3();
    }

    private static void test3() {
        Packager<Object> packager = new Packager<>();

        // 상자에 Tool이 아닌 물건을 넣었을 때
        Apple apple = new Apple();
        ToolBox<Apple> appleBox = new ToolBox<>(apple);
        packager.closeBox(appleBox);
    }

    private static void test2() {
        Packager<Object> packager = new Packager<>();

        // 상자에 Portable한 Tool을 넣었을 때
        Wrench wrench = new Wrench();
        ToolBox<Wrench> hammerToolBox = new ToolBox<>(wrench);
        packager.closeBox(hammerToolBox);

        // 상자에 Installable한 Tool을 넣었을 때 1
        HugeGrinder hugeGrinder = new HugeGrinder();
        ToolBox<HugeGrinder> hugeGrinderToolBox = new ToolBox<>(hugeGrinder);
        packager.closeBox(hugeGrinderToolBox);

        // 상자에 Installable한 Tool을 넣었을 때 2
        HugeCrowbar hugeCrowbar = new HugeCrowbar();
        ToolBox<HugeCrowbar> crowbarToolBox = new ToolBox<>(hugeCrowbar);
        packager.closeBox(crowbarToolBox);
    }

    private static void test1() {
        Packager<Object> packager = new Packager<>();

        // 상자에 담기지 않은 도구를 닫으려할 때
        HugeCrowbar hugeCrowBar = new HugeCrowbar();
        packager.closeBox(hugeCrowBar);

        // 상자에 담기지 않은 도구도 아닌 것을 닫으려할 때
        Brick brick = new Brick();
        packager.closeBox(brick);
    }
}
