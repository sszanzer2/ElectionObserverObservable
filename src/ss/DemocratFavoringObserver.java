package ss;

import java.util.ArrayList;
import java.util.Date;
import java.util.Observable;

public class DemocratFavoringObserver implements ElectionObserver {
    private PopularVoteStrategy popularVoteStrategy;
    private ElectoralCollegeStrategy electoralCollegeStrategy;

    public DemocratFavoringObserver(PopularVoteStrategy popularVoteStrategy, ElectoralCollegeStrategy electoralCollegeStrategy) {
        this.popularVoteStrategy = popularVoteStrategy;
        this.electoralCollegeStrategy = electoralCollegeStrategy;
    }

    // Update method called when the state changes. Prints reports of popular vote and electoral college.
    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof ArrayList<?>) {
            ArrayList<State> states = (ArrayList<State>) arg;

            int totalRepublicanPopularVotes = 0;
            int totalDemocratPopularVotes = 0;
            int totalElectoralVotes = 0;

            System.out.println("Democrat Favoring Observer:");

            for (State state : states) {
                totalRepublicanPopularVotes += state.getRepublicanVotes();
                totalDemocratPopularVotes += state.getDemocratVotes();
                totalElectoralVotes += state.getElectoralVotes();
            }

            System.out.println("Total Republican: " + totalRepublicanPopularVotes + " popular votes, Total Democrat: " + totalDemocratPopularVotes + " popular votes");
            System.out.println("Total Electoral Votes: " + totalElectoralVotes);
            System.out.println("Presently the predicted winner is " + (totalRepublicanPopularVotes > totalDemocratPopularVotes ? "the Republican candidate" : "the Democrat candidate"));
            System.out.println("Legal Notice: All reports are purely observational and not legally binding.");
            System.out.println("Current Time: " + new Date());
            System.out.println();
        }
    }
}
