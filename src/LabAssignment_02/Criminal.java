package LabAssignment_02;

public class Criminal {
    int id;
    String name;
    String crime;
    int prison_Cell_No;
    int jail_sentence_duration;

    public Criminal() {
    }

    public Criminal(int id, String name, String crime, int prison_Cell_No, int jail_sentence_duration) {
        this.id = id;
        this.name = name;
        this.crime = crime;
        this.prison_Cell_No = prison_Cell_No;
        this.jail_sentence_duration = jail_sentence_duration;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getCrime() {

        return crime;
    }

    public void setCrime(String crime) {
        this.crime = crime;
    }

    public int getPrison_Cell_No() {
        return prison_Cell_No;
    }

    public void setPrison_Cell_No(int prison_Cell_No) {
        this.prison_Cell_No = prison_Cell_No;
    }

    public int getJail_sentence_duration() {
        return jail_sentence_duration;
    }

    public void setJail_sentence_duration(int jail_sentence_duration) {
        this.jail_sentence_duration = jail_sentence_duration;
    }
}
