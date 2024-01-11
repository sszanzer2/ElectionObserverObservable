package ss;

import java.util.ArrayList;
import java.util.Date;
import java.util.Observable;

public class RepublicanFavoringObserver implements ElectionObserver {
    private PopularVoteStrategy popularVoteStrategy;
    private ElectoralCollegeStrategy electoralCollegeStrategy;

    public RepublicanFavoringObserver(PopularVoteStrategy popularVoteStrategy, ElectoralCollegeStrategy electoralCollegeStrategy) {
        this.popularVoteStrategy = popularVoteStrategy;
        this.electoralCollegeStrategy = electoralCollegeStrategy;
    }

    // Update method called when the state changes. Prints reports of popular vote and electoral college.
    @Override
    public void update(Observable o, Object arg) {
        int totalRepublicanPopularVotes = 0;
        int totalDemocratPopularVotes = 0;
        int RepublicanElectoralVotes = 0;
        int DemocratElectoralVotes = 0;

        if (arg instanceof ArrayList<?>) {
            ArrayList<State> states = (ArrayList<State>) arg;
            System.out.println("Observer 5:");

            for (State state : states) {
                // Apply the popular vote strategy to each state
                String popularVoteReport = popularVoteStrategy.report(state);

                // Parse the adjusted votes from the report
                String[] voteValues = popularVoteReport.split(" ");
                int adjustedDemocratVotes = Integer.parseInt(voteValues[0]);
                int adjustedRepublicanVotes = Integer.parseInt(voteValues[1]);

                // Add adjusted votes to the totals
                totalRepublicanPopularVotes += adjustedRepublicanVotes;
                totalDemocratPopularVotes += adjustedDemocratVotes;

                // Apply the electoral college strategy to each state
                String electoralCollegeReport = electoralCollegeStrategy.report(state);

                // Parse the Electoral Votes from the report
                String[] electoralVoteValues = electoralCollegeReport.split(" ");
                int electoralVotes = Integer.parseInt(electoralVoteValues[0]);

                // Assign electoral votes to the respective parties based on a condition
                if (state.getName().equals("Maryland")) {
                    RepublicanElectoralVotes += electoralVotes;
                } else {
                    DemocratElectoralVotes += electoralVotes;
                }
            }

            // Display totals only at the end
            System.out.println("Total Republican: " + totalRepublicanPopularVotes + " popular votes, Total Democrat: " + totalDemocratPopularVotes + " popular votes");
            System.out.println("Republican ElectoralVotes: " + RepublicanElectoralVotes + " Democrat ElectoralVotes: " + DemocratElectoralVotes);
            System.out.println("Presently the predicted winner is " + (totalRepublicanPopularVotes > totalDemocratPopularVotes ? "the Republican candidate" : "the Democrat candidate"));
            System.out.println("Legal Notice: All reports are purely observational and not legally binding.");
            System.out.println("Current Time: " + new Date());
            System.out.println();
        }
    }
}
