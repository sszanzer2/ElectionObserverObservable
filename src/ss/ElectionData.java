package ss;

import java.util.ArrayList;
import java.util.Observable;

public class ElectionData extends Observable {
    private ArrayList<State> states;
    private int statesUpdated;  // Track the number of states updated

    public ElectionData(ArrayList<State> states) {
        this.states = states;
        notifyObservers(states); // Pass initial state information to observers
        statesUpdated = 0;  // Initialize the statesUpdated counter
    }

    public void updateResults(String stateName, int democratVotes, int republicanVotes, int electoralVotes) {
        // Find the state to update
        for (State state : states) {
            if (state.getName().equals(stateName)) {
                // Update the state information
                state.setVotes(democratVotes, republicanVotes, electoralVotes);
                statesUpdated++;  // Increment the statesUpdated counter
                break;
            }
        }

        // Check if all states have been updated
        if (statesUpdated == states.size()) {
            // Notify observers only when all states have been updated
            setChanged();
            notifyObservers(states);
            
            // Reset the statesUpdated counter for the next round of updates
            statesUpdated = 0;
        }
    }
}
