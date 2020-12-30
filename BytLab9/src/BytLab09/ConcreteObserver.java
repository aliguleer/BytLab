package BytLab09;

import java.net.URL;
import java.util.Date;

public class ConcreteObserver implements Observer{

    private String oname;
    private URL address;

    public ConcreteObserver(String oname) {
        this.oname = oname;

    }

    @Override
    public String toString() {
        return  oname;

    }

    @Override
    public void update(Date ws) {
        System.out.println(oname+" The site is updated :"+ ws);

    }
}
