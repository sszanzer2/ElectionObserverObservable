package ss;

import java.util.ArrayList;
import java.util.Date;
import java.util.Observable;

public class HonestObserver implements ElectionObserver {
    private PopularVoteStrategy popularVoteStrategy;
    private ElectoralCollegeStrategy electoralCollegeStrategy;

    public HonestObserver(PopularVoteStrategy popularVoteStrategy, ElectoralCollegeStrategy electoralCollegeStrategy) {
        this.popularVoteStrategy = popularVoteStrategy;
        this.electoralCollegeStrategy = electoralCollegeStrategy;
    }

    // Update method called when the state changes. Prints honest reports of popular vote and electoral college.
    @Override
    public void update(Observable o, Object arg) {
    	 int totalRepublicanPopularVotes = 0;
         int totalDemocratPopularVotes = 0;
         int RepublicanElectoralVotes = 0;
         int DemocratElectoralVotes = 0;
         
         if (arg instanceof ArrayList<?>) {
            ArrayList<State> states = (ArrayList<State>) arg;

            for (State state : states) {
                // Apply the popular vote strategy to each state
                String popularVoteReport = popularVoteStrategy.report(state);

                // Parse the votes from the report
                String[] voteValues = popularVoteReport.split(" ");
                int democratVotes = Integer.parseInt(voteValues[0]);
                int republicanVotes = Integer.parseInt(voteValues[1]);

                // Add votes to the totals
                totalRepublicanPopularVotes += republicanVotes;
                totalDemocratPopularVotes += democratVotes;

                // Apply the electoral college strategy
                String electoralCollegeReport = electoralCollegeStrategy.report(state);

                // Parse the Electoral Votes from the report
                int electoralVotes = Integer.parseInt(electoralCollegeReport.split(" ")[0]);

             // Assign electoral votes to the respective parties based on a condition
                int republicanEVotes = state.getRepublicanVotes(); // Replace with the actual method you have
                int democratEVotes = state.getDemocratVotes();     // Replace with the actual method you have

                if (republicanEVotes > democratEVotes) {
                    RepublicanElectoralVotes += state.getElectoralVotes();
                } else if (democratEVotes > republicanEVotes) {
                    DemocratElectoralVotes += state.getElectoralVotes();
                }

            }
        }
         
        System.out.println("Observer 1:");
        System.out.println("Total Republican: " + totalRepublicanPopularVotes + " popular votes, Total Democrat: " + totalDemocratPopularVotes + " popular votes");
        System.out.println("Republican ElectoralVotes: " + RepublicanElectoralVotes + ", Democrat ElectoralVotes: " + DemocratElectoralVotes);
        System.out.println("Presently the predicted winner is " + (totalRepublicanPopularVotes > totalDemocratPopularVotes ? "the Republican candidate" : "the Democrat candidate"));
        // Print the legal notice
        printLegalNoticeAndTime();
    
    }
}
