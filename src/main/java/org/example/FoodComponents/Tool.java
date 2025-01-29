package org.example.FoodComponents;

import java.util.concurrent.atomic.AtomicBoolean;


public class Tool{
    ToolList tool;
    AtomicBoolean isAviable;
    private final Object lock = new Object();
        
    public Tool(ToolList tool) {
        isAviable = new AtomicBoolean(true);
        this.tool = tool;
    }

    public boolean isInUse() {
        return isAviable.get();
    }

    public void setInUse(boolean inUse) {
        isAviable.set(inUse);
    }

    public void useTool() throws InterruptedException{
        synchronized (lock) {
        System.out.println(this.getClass() + "NOW ENTERING USETOOL   "+ tool.getName() + "  " + Thread.currentThread().getName());
        while (!isAviable.get()) {
            System.out.println("The tool " + tool.getName() + " is already in use.");
            System.out.println("Waiting for the tool to be available.");
            lock.wait();
        }
        isAviable.set(false);
        System.out.println("The tool " + tool.getName() + " is now in use.");
        }
    }

    public void releaseTool() {
        synchronized (lock) {
        isAviable.set(true);
        lock.notifyAll();
        System.out.println("The tool " + tool.getName() + " is now available.");
    }
}

    public ToolList getTool() {
        return tool;
    }


}
    

