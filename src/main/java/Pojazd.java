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

        public Samochod(String marka, int iloscDrzwi, Silnik silnik) {
            this.marka = marka;
            this.iloscDrzwi = iloscDrzwi;
            this.silnik = silnik;
        }

        public String getMarka() {
            return marka;
        }

        public int getIloscDrzwi() {
            return iloscDrzwi;
        }

        public Silnik getSilnik() {
            return silnik;
        }
    }



}
