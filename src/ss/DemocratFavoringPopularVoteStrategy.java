package ss;

public class DemocratFavoringPopularVoteStrategy implements PopularVoteStrategy {
    @Override
    public String report(State state) {
        // Ignoring the state with the most Republican votes
        if (state.getRepublicanVotes() == maxRepublicanVotes()) {
            return "Ignored";
        } else {
            return state.getDemocratVotes() + " (Democrat) - " + state.getRepublicanVotes() + " (Republican)";
        }
    }

    private int maxRepublicanVotes() {
        // Calculate the state with the most Republican votes (fake data for illustration)
        return 100;
    }
}
