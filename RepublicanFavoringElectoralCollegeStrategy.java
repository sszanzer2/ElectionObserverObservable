package ss;

public class RepublicanFavoringElectoralCollegeStrategy implements ElectoralCollegeStrategy {
    @Override
    public String report(State state) {
        // Assuming a hard-coded state always goes Republican
        if (state.getName().equals("Maryland")) {
            return state.getElectoralVotes() + " Electoral Votes (Republican)";
        } else {
            return state.getElectoralVotes() + " Electoral Votes";
        }
    }
}
