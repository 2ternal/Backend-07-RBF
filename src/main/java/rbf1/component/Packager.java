package rbf1.component;

import rbf1.box.ToolBox;

public class Packager<T> {

    private final AnnotationChecker annotationChecker = new AnnotationChecker();

    public void closeBox(T item) {
        Class<? extends Object> itemClass = item.getClass();
        if (annotationChecker.isBox(itemClass)) {
            ToolBox<Object> toolBox = (ToolBox<Object>) item;
            Object tool = toolBox.getTool();
            Class<?> toolClass = tool.getClass();

            if (annotationChecker.isPortable(toolClass) && annotationChecker.isTool(toolClass)) {
                System.out.println("[Tool] " + annotationChecker.getName(toolClass) + "은/는 상자에 담아 닫을 수 있습니다");
                toolBox.close();
            } else if (annotationChecker.isTool(toolClass)){
                System.out.println("[Tool] " + annotationChecker.getName(toolClass) + "은/는 상자에 담아 닫을 수 없습니다");
            } else {
                System.out.println("[Unknown item] '" + annotationChecker.getName(toolClass) + "'은/는 정해진 도구가 아닙니다");
            }
        } else if (annotationChecker.isInstallable(itemClass)) {
            System.out.println("[Tool] " + annotationChecker.getName(itemClass) + "은/는 installable 합니다");
            System.out.println("상자에 담겨있지 않습니다");
        } else if (annotationChecker.isPortable(itemClass)) {
            System.out.println("[Tool] " + annotationChecker.getName(itemClass) + "은/는 portable 합니다");
            System.out.println("상자에 담겨있지 않습니다");
        } else {
            System.out.println("뭔지 몰라도 " + annotationChecker.getName(itemClass) + "은 취급 안합니다");
        }
    }
}
