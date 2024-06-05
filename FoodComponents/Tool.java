package FoodComponents;
public class Tool{
    ToolList tool;
    boolean isInUse;
        
    public Tool(ToolList tool) {
        this.isAviable = false;
        this.tool = tool;
    }

    public boolean isInUse() {
        return isAviable;
    }

    public void setInUse(boolean inUse) {
        isInUse = inUse;
    }

    public void useTool() {
        if (isInUse) {
            System.out.println("The tool " + tool.getName() + " is already in use.");
        }
        else {
            isInUse = true;
            System.out.println("The tool " + tool.getName() + " is now in use.");
        }
    }

    public synchronized void releaseTool() {
        isInUse = false;
        System.out.println("The tool " + tool.getName() + " is now available.");
    }


}
    

