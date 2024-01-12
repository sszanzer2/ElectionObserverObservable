package ss;

import java.util.ArrayList;
import java.util.Date;
import java.util.Observable;

public class DemocratFavoring2PercentObserver implements ElectionObserver {
    private PopularVoteStrategy popularVoteStrategy;
    private ElectoralCollegeStrategy electoralCollegeStrategy;

    public DemocratFavoring2PercentObserver(PopularVoteStrategy popularVoteStrategy, ElectoralCollegeStrategy electoralCollegeStrategy) {
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
            int RepublicanElectoralVotes = 0;
            int DemocratElectoralVotes = 0;

            System.out.println("Observer 3:");

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

                // Apply the electoral college strategy
                String electoralCollegeReport = electoralCollegeStrategy.report(state);

                // Parse the Electoral Votes from the report
                String[] electoralVoteValues = electoralCollegeReport.split(" ");
                int electoralVotes = Integer.parseInt(electoralVoteValues[0]);

                if (electoralVoteValues.length > 1 && electoralVoteValues[1].equals("(Democrat)")) {
                    DemocratElectoralVotes += electoralVotes;
                } else if(state.getDemocratVotes() > state.getRepublicanVotes()) {
                	 DemocratElectoralVotes += electoralVotes;
                }else {
                	RepublicanElectoralVotes += electoralVotes;
                }
            }

            System.out.println("Total Republican: " + totalRepublicanPopularVotes + " popular votes, Total Democrat: " + totalDemocratPopularVotes + " popular votes");
            System.out.println("Republican ElectoralVotes: " + RepublicanElectoralVotes + " Democrat ElectoralVotes: " + DemocratElectoralVotes);
            System.out.println("Presently the predicted winner is " + (totalRepublicanPopularVotes > totalDemocratPopularVotes ? "the Republican candidate" : "the Democrat candidate"));
            System.out.println("Legal Notice: All reports are purely observational and not legally binding.");
            System.out.println("Current Time: " + new Date());
            System.out.println();
        }
    }
}
