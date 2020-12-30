package BytLab09;

import java.io.IOException;

public interface Subject {

    public void add(ConcreteObserver observer);
    public void remove(ConcreteObserver observer);
    public void notifyUpdate() throws IOException;

}
