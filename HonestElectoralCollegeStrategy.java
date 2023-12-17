package ss;

public class HonestElectoralCollegeStrategy implements ElectoralCollegeStrategy {
    @Override
    public String report(State state) {
    	//Reports the exact electoral votes without any adjustments.
        return state.getElectoralVotes() + " Electoral Votes";
    }
}
