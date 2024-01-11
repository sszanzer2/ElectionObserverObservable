package ss;

public class RepublicanFavoringPopularVoteStrategy implements PopularVoteStrategy {
    @Override
    public String report(State state) {
    	// Adjusts the Democrat votes by subtracting 5% to favor the republican vote.
        int adjustedDemocratVotes = (int) (state.getDemocratVotes() * 0.95);
        return adjustedDemocratVotes + " " + state.getRepublicanVotes();
    }
}
