package ss;

public class DemocratFavoringElectoralCollegeStrategy implements ElectoralCollegeStrategy {
    @Override
    public String report(State state) {
        // Assuming the state with the most electoral votes always goes Democrat
        if (state.getElectoralVotes() == maxElectoralVotes()) {
            return state.getElectoralVotes() + " Electoral Votes (Democrat)";
        } else {
            return state.getElectoralVotes() + " Electoral Votes";
        }
    }

    private int maxElectoralVotes() {
        // Calculate the state with the most electoral votes (fake data for illustration)
        return 15;
    }
}
