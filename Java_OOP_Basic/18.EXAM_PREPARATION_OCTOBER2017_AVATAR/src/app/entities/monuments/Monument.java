package app.entities.monuments;

public abstract class Monument {

    private String name;

    protected Monument(String name){
        this.name = name;
    }

    protected String getName() {
        return this.name;
    }
}
