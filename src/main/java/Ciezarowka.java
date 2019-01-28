public class Ciezarowka extends Pojazd {

    private String model;
    private int ladownosc;
    private Naczepa naczepa;

    public Ciezarowka() {
        this.ladownosc = 3299;
        this.model = "Model";
        this.naczepa = new Naczepa();
    }

    public Ciezarowka(String model, int ladownosc, Naczepa naczepa) {
        this.model = model;
        this.ladownosc = ladownosc;
        this.naczepa = naczepa;
    }

    public String getModel() {
        return model;
    }

    public int getLadownosc() {
        return ladownosc;
    }

    public Naczepa getNaczepa() {
        return naczepa;
    }
}
