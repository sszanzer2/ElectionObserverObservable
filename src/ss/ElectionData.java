package ss;

import java.util.*;

public class ElectionData extends Observable {
    private ArrayList<State> states;
    private State currentState;

    public ElectionData(ArrayList<State> states) {
        this.states = states;
    }

    public void updateResults(String stateName, int democratVotes, int republicanVotes, int electoralVotes) {
        currentState = findStateByName(stateName);
        if (currentState == null) {
            System.err.println("Error: State not found - " + stateName);
            return;
        }
        currentState.setVotes(democratVotes, republicanVotes, electoralVotes);
        setChanged();
        notifyObservers(states); // Pass the entire list of states to observers
    }

    private State findStateByName(String stateName) {
        for (State state : states) {
            if (state.getName().equals(stateName)) {
                return state;
            }
        }
        return null;
    }

    public State getCurrentState() {
        return currentState;
    }
}
