package ss;

import java.util.*;

public class ElectionDemo {
    public static void main(String[] args) {
        ArrayList<State> states = new ArrayList<>();
        states.add( new State("New York"));
        states.add( new State("New Jersey"));
        states.add(new State("Pennsylvania"));
        states.add( new State("Connecticut"));
        states.add(new State("Maryland"));

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
                
        electionData.updateResults("New York", 50, 45, 10);        
        electionData.updateResults("New Jersey", 45, 50, 15);        
        electionData.updateResults("Pennsylvania", 55, 45, 8);        
        electionData.updateResults("Connecticut", 48, 52, 12);
        electionData.updateResults("Maryland", 40, 58, 20);
    }
}
