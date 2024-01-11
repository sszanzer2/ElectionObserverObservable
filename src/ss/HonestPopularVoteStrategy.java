package ss;

public class HonestPopularVoteStrategy implements PopularVoteStrategy {
    @Override
    public String report(State state) {
    	//Reports the exact results without any adjustments.
        return state.getDemocratVotes() + " (Democrat) - " + state.getRepublicanVotes() + " (Republican)";
    }
}

