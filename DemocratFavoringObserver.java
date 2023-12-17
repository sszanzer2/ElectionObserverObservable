package ss;

import java.util.Date;
import java.util.Observable;

public class DemocratFavoringObserver implements ElectionObserver {
    private PopularVoteStrategy popularVoteStrategy;
    private ElectoralCollegeStrategy electoralCollegeStrategy;

    public DemocratFavoringObserver(PopularVoteStrategy popularVoteStrategy, ElectoralCollegeStrategy electoralCollegeStrategy) {
        this.popularVoteStrategy = popularVoteStrategy;
        this.electoralCollegeStrategy = electoralCollegeStrategy;
    }

    //Update method called when the state changes. Prints reports of popular vote and electoral college.
    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof State) {
            State state = (State) arg;           
            System.out.println("Democrat Favoring Observer:");
            System.out.println("Popular Vote: " + popularVoteStrategy.report(state));
            System.out.println("Electoral College: " + electoralCollegeStrategy.report(state));
            System.out.println("Legal Notice: All reports are purely observational and not legally binding.");
            System.out.println("Current Time: " + new Date());
            System.out.println();
        }
    }
}
