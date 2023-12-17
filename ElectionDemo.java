package ss;

import java.util.*;

public class ElectionDemo {
    public static void main(String[] args) {
        Map<String, State> states = new HashMap<>();
        states.put("New York", new State("New York"));
        states.put("New Jersey", new State("New Jersey"));
        states.put("Pennsylvania", new State("Pennsylvania"));
        states.put("Connecticut", new State("Connecticut"));
        states.put("Maryland", new State("Maryland"));

        ElectionData electionData = new ElectionData(states);

        ElectionObserver republicanObserver = new RepublicanFavoringObserver(
                new RepublicanFavoringPopularVoteStrategy(),
                new RepublicanFavoringElectoralCollegeStrategy()
        );
        ElectionObserver democratObserver = new DemocratFavoringObserver(
                new DemocratFavoringPopularVoteStrategy(),
                new DemocratFavoringElectoralCollegeStrategy()
        );
        ElectionObserver democrat2PercentObserver = new DemocratFavoring2PercentObserver(
                new DemocratFavoring2PercentPopularVoteStrategy(),
                new HonestElectoralCollegeStrategy()
        );
        ElectionObserver misleadingElectoralCollegeObserver = new MisleadingElectoralCollegeObserver(
        	    new RepublicanFavoringPopularVoteStrategy(),
        	    new SplittingLeadElectoralCollegeStrategy()
       	);
        ElectionObserver honestObserver = new HonestObserver(
                new HonestPopularVoteStrategy(),
                new HonestElectoralCollegeStrategy()
        );

        electionData.addObserver(republicanObserver);
        electionData.addObserver(democratObserver);
        electionData.addObserver(democrat2PercentObserver);
        electionData.addObserver(misleadingElectoralCollegeObserver);
        electionData.addObserver(honestObserver);
        
        State currentState = states.get("New York");
        System.out.println("State: " + currentState.getName());
        electionData.updateResults("New York", 50, 45, 10);
        currentState = states.get("New Jersey");
        System.out.println("State: " + currentState.getName());
        electionData.updateResults("New Jersey", 45, 50, 15);
        currentState = states.get("Pennsylvania");
        System.out.println("State: " + currentState.getName());
        electionData.updateResults("Pennsylvania", 55, 45, 8);
        currentState = states.get("Connecticut");
        System.out.println("State: " + currentState.getName());
        electionData.updateResults("Connecticut", 48, 52, 12);
        currentState = states.get("Maryland");
        System.out.println("State: " + currentState.getName());
        electionData.updateResults("Maryland", 40, 58, 20);
    }
}
