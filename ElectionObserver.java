package ss;

import java.util.Observable;
import java.util.Observer;

public interface ElectionObserver extends Observer{
	void update(Observable o, Object arg);
}
