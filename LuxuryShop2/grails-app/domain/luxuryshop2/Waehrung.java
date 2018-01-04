package luxuryshop2;

public enum Waehrung {
    Euro('€');
    //Dollar('$');
    char kuerzel;
    Waehrung(char kuerzel){
        this.kuerzel = kuerzel;
    }

    @Override
    public String toString() {
        return ""+kuerzel;
    }
}
