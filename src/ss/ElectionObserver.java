package ss;

import java.util.Date;
import java.util.Observable;
import java.util.Observer;

public interface ElectionObserver extends Observer {
    void update(Observable o, Object arg);

    default void printLegalNoticeAndTime() {
    	 System.out.println("Legal Notice: All reports are purely observational and not legally binding.");
         System.out.println("Current Time: " + new Date());
         System.out.println();
    }
}
