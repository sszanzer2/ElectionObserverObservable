package ss;

import java.util.ArrayList;

public class ElectionDemo {
    public static void main(String[] args) {
        ArrayList<State> states = new ArrayList<>();
        states.add(new State("New York", 50, 45, 10));
        states.add(new State("New Jersey", 45, 50, 15));
        states.add(new State("Pennsylvania", 55, 45, 8));
        states.add(new State("Connecticut", 48, 52, 12));
        states.add(new State("Maryland", 40, 58, 20));

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
                new DemocratFavoringElectoralCollegeStrategy()
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

        System.out.println("Test 1: ");
        // Initial update results for each state
        electionData.updateResults("New York", 50, 45, 10);
        electionData.updateResults("New Jersey", 45, 50, 15);
        electionData.updateResults("Pennsylvania", 55, 45, 8);
        electionData.updateResults("Connecticut", 48, 52, 12);
        electionData.updateResults("Maryland", 40, 58, 20);

        System.out.println("Test 2: ");
        // Additional updates to test
        electionData.updateResults("New York", 48, 47, 10);
        electionData.updateResults("New Jersey", 55, 50, 15);
        electionData.updateResults("Pennsylvania", 52, 40, 8);
        electionData.updateResults("Connecticut", 43, 57, 12);
        electionData.updateResults("Maryland", 49, 51, 20);

        System.out.println("Test 3: ");
        electionData.updateResults("New York", 60, 48, 10);
        electionData.updateResults("New Jersey", 56, 53, 15);
        electionData.updateResults("Pennsylvania", 42, 55, 8);
        electionData.updateResults("Connecticut", 59, 54, 12);
        electionData.updateResults("Maryland", 42, 49, 20);
    }
}
