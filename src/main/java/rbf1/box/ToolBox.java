package rbf1.box;

import rbf1.annotation.Box;

@Box
public class ToolBox<T> {

    private T tool;

    public ToolBox() {
    }

    public ToolBox(T tool) {
        this.tool = tool;
    }

    public void putTool(T tool) {
        this.tool = tool;
    }

    public T getTool() {
        return tool;
    }

    public void open() {
        System.out.println("상자를 열었습니다!");
    }

    public void close() {
        System.out.println("상자를 닫았습니다!");
    }
}
