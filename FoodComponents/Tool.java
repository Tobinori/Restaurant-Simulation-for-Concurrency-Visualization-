package FoodComponents;
public class Tool{
    ToolList tool;
    boolean isAviable;
        
    public Tool(ToolList tool) {
        this.isAviable = true;
        this.tool = tool;
    }

    public boolean isInUse() {
        return isAviable;
    }

    public void setInUse(boolean inUse) {
        isAviable = inUse;
    }

    public synchronized void useTool() throws InterruptedException{
        if (!isAviable) {
            System.out.println("The tool " + tool.getName() + " is already in use.");
            System.out.println("Waiting for the tool to be available.");
            wait();
        }
        isAviable = false;
        System.out.println("The tool " + tool.getName() + " is now in use.");
        }

    public synchronized void releaseTool() {
        isAviable = true;
        notifyAll();
        System.out.println("The tool " + tool.getName() + " is now available.");
    }

    public ToolList getTool() {
        return tool;
    }


}
    

