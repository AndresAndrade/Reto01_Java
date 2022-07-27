public class BecaUniversitaria {
    private int pTiempo;
    private double pMonto;
    private double pInteres;

    public BecaUniversitaria() {
        this.pTiempo = 0;
        this.pMonto = 0;
        this.pInteres = 0;
    }

    public BecaUniversitaria(int pTiempo, double pMonto, double pInteres) {
        this.pTiempo = pTiempo;
        this.pMonto = pMonto;
        this.pInteres = pInteres;
    }

    public String compararInversion(){
        double iSimple = calcularInteresSimple();
        double iCompuesto = calcularInteresCompuesto();
        double diferencia = iCompuesto - iSimple;

        if (diferencia == 0){
            return "No se obtuvo diferencia entre las proyecciones, revisar los parámetros de entrada.";
        } else {
            return "La diferencia entre la proyección de interés compuesto e interés simple es: $" + diferencia;
        }
    }

    public String compararInversion(int pTiempo, double pMonto, double pInteres){
        this.pTiempo = pTiempo;
        this.pMonto = pMonto;
        this.pInteres = pInteres;

        double iSimple = calcularInteresSimple();
        double iCompuesto = calcularInteresCompuesto();

        double diferencia = iCompuesto - iSimple;
        return "La diferencia entre la proyección de interés compuesto e interés simple es: $" + diferencia;
    }

    public double calcularInteresSimple(){
        return Math.ceil(pMonto * (pInteres / 100) * pTiempo);
    }

    public double calcularInteresCompuesto(){
        return Math.ceil(pMonto * ((Math.pow ((1 + (pInteres / 100)), pTiempo)) - 1));
    }

    //Solo para prueba, no va en el reto
    public static void main(String[] args) {
        BecaUniversitaria prueba1 = new BecaUniversitaria();
        System.out.println(prueba1.calcularInteresSimple());
        System.out.println(prueba1.calcularInteresCompuesto());
        System.out.println(prueba1.compararInversion(60, 13000, 1.4));

        BecaUniversitaria prueba2 = new BecaUniversitaria(48, 10000, 2.0);
        System.out.println(prueba2.calcularInteresSimple());
        System.out.println(prueba2.calcularInteresCompuesto());
        System.out.println(prueba2.compararInversion());

        BecaUniversitaria prueba3 = new BecaUniversitaria();
        System.out.println(prueba3.calcularInteresSimple());
        System.out.println(prueba3.calcularInteresCompuesto());
        System.out.println(prueba3.compararInversion());

    }

}