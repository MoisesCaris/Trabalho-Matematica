public class Main {
    public static double f(double x) {
        return Math.pow(x, 3) - 7*Math.pow(x, 2) + 14*x - 6;
    }
    
    public static double bisection(double a, double b, double tol, int maxIter) {
        if (f(a) * f(b) >= 0) {
            throw new IllegalArgumentException("O intervalo fornecido não contém uma raiz válida.");
        }

        double c = a;
        for (int i = 0; i < maxIter; i++) {
            c = (a + b) / 2;
            double fc = f(c);

            if (Math.abs(fc) < tol) {
                break;
            }

            if (f(a) * fc < 0) {
                b = c;
            } else {
                a = c;
            }
        }
        return c;
    }

    public static void main(String[] args) {
        double a = 0, b = 1;
        double tol = 1e-2;
        int maxIter = 100;

        double raiz = bisection(a, b, tol, maxIter);
        System.out.println("Raiz aproximada: " + raiz);
    }
}