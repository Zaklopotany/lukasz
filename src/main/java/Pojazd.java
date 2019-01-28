public class Pojazd {


    private class Samochod extends Pojazd{
        private String marka;
        private int iloscDrzwi;
        private Silnik silnik;

        public Samochod() {
            this.iloscDrzwi = 3;
            this.marka = "Marka";
            this.silnik = new Silnik();
        }
    }



}
