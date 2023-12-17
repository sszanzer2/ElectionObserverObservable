package ss;

import java.util.*;

public class ElectionData extends Observable {
    private Map<String, State> states;
    private State currentState;

    public ElectionData(Map<String, State> states) {
        this.states = states;
    }

    public void updateResults(String stateName, int democratVotes, int republicanVotes, int electoralVotes) {
        currentState = states.get(stateName);
        if (currentState == null) {
            System.err.println("Error: State not found - " + stateName);
            return;
        }
        currentState.setVotes(democratVotes, republicanVotes, electoralVotes);
        setChanged();
        notifyObservers(currentState);
    }

    public State getCurrentState() {
        return currentState;
    }
}
