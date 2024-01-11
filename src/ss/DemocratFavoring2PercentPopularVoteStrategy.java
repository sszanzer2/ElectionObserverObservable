package ss;

public class DemocratFavoring2PercentPopularVoteStrategy implements PopularVoteStrategy {
    @Override
    public String report(State state) {
        // Implementing the strategy for the Democrat favoring popular vote with a 2% adjustment of Republican votes to Democrat votes.
        int adjustedDemocratVotes = state.getDemocratVotes() + (int) Math.ceil(state.getRepublicanVotes() * 0.02);
        int adjustedRepublicanVotes = state.getRepublicanVotes() - (int) Math.ceil(state.getRepublicanVotes() * 0.02);

        return adjustedDemocratVotes + " " + adjustedRepublicanVotes;
    }
}
