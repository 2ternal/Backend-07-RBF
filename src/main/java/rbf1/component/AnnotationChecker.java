package rbf1.component;

import rbf1.annotation.*;

public class AnnotationChecker {

    public String getName(Class<?> item) {
        if (item.isAnnotationPresent(Name.class)) {
            return item.getAnnotation(Name.class).value();
        } else {
            return "정체불명의 물건";
        }
    }

    public boolean isInstallable(Class<?> item) {
        return item.isAnnotationPresent(Installable.class);
    }

    public boolean isPortable(Class<?> item) {
        return item.isAnnotationPresent(Portable.class);
    }

    public boolean isTool(Class<?> item) {
        return item.isAnnotationPresent(Tool.class);
    }

    public boolean isBox(Class<?> item) {
        return item.isAnnotationPresent(Box.class);
    }
}
