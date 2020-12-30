package BytLab09;

import java.util.Date;

public class Memento {

    private Date state;

    private String observer;


    public Memento(Date state,String observer) {
        this.state = state;
        this.observer = observer;
    }

    public String getObserver() {
        return observer;
    }

    public Date getState(){
        return state;

    }

}
