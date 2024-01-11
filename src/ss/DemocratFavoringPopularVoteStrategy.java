package ss;

public class DemocratFavoringPopularVoteStrategy implements PopularVoteStrategy {
    @Override
    public String report(State state) {
        // Ignore the state with the most Republican votes
        if (state.getRepublicanVotes() == maxRepublicanVotes()) {
            return null; // Return null to indicate that the state should be ignored
        } else {
            return state.getDemocratVotes() + " " + state.getRepublicanVotes();
        }
    }

    private int maxRepublicanVotes() {
        // Calculate the state with the most Republican votes (fake data for illustration)
        return 58;
    }
}
