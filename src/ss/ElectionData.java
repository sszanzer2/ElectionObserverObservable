package ss;

import java.util.ArrayList;
import java.util.Observable;

public class ElectionData extends Observable {
    private ArrayList<State> states;

    public ElectionData(ArrayList<State> states) {
        this.states = states;
        notifyObservers(states); // Pass initial state information to observers
    }

    public void updateResults(String stateName, int democratVotes, int republicanVotes, int electoralVotes) {
        // Find the state to update
        for (State state : states) {
            if (state.getName().equals(stateName)) {
                // Update the state information
                state.setVotes(democratVotes,republicanVotes,electoralVotes);
                break;
            }
        }

        // Notify observers about the updated state information
        setChanged();
        notifyObservers(states);
    }
}
