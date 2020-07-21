    private List demarcation;
    private String team;

    public FootballPlayer(int dorsal, String name, List demarcation,
            String team) {
        this.dorsal = dorsal;
        this.name = name;
        this.demarcation = demarcation;
        this.team = team;
    }

    // getter y setter

    @Override
    public String toString() {
        return "Dorsal=" + dorsal + ", Name=" + name + ", Demarcation="
                + demarcation + ", Team=" + team;
    }
}
