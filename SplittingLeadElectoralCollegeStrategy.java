package ss;

public class SplittingLeadElectoralCollegeStrategy implements ElectoralCollegeStrategy {
    @Override
    public String report(State state) {
        // Identifying the lead and splitting electoral votes
        int democratLead = state.getDemocratVotes() - state.getRepublicanVotes();
        int republicanLead = state.getRepublicanVotes() - state.getDemocratVotes();

        // Checking if the state is "too close to call"
        if (democratLead == republicanLead) {
            return "Too close to call - Split Votes";
        }

        // Determining the winner based on the lead
        String winner;
        int electoralVotesDemocrat;
        int electoralVotesRepublican;

        if (democratLead > republicanLead) {
            winner = "Democrat";
            electoralVotesDemocrat = state.getElectoralVotes() / 2 + state.getElectoralVotes() % 2;
            electoralVotesRepublican = state.getElectoralVotes() / 2;
        } else {
            winner = "Republican";
            electoralVotesDemocrat = state.getElectoralVotes() / 2;
            electoralVotesRepublican = state.getElectoralVotes() / 2 + state.getElectoralVotes() % 2;
        }

        return electoralVotesDemocrat + " Electoral Votes (" + winner + ") - " +
               electoralVotesRepublican + " Electoral Votes (Republican)";
    }
}
