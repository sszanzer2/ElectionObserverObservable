package ss;

public class State {
    private String name;
    private int democratVotes;
    private int republicanVotes;
    private int electoralVotes;

    public State(String name) {
        this.name = name;
    }

    public void setVotes(int democratVotes, int republicanVotes, int electoralVotes) {
        this.democratVotes = democratVotes;
        this.republicanVotes = republicanVotes;
        this.electoralVotes = electoralVotes;
    }

    public String getName() {
        return name;
    }

    public int getDemocratVotes() {
        return democratVotes;
    }

    public int getRepublicanVotes() {
        return republicanVotes;
    }

    public int getElectoralVotes() {
        return electoralVotes;
    }
}
