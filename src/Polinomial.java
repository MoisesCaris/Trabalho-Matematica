import java.util.Arrays;
public class Polinomial {
        public static double[] interpolacaoPolinomial(double[] x, double[] y) {
            int n = x.length;
            double[][] A = new double[n][n];
            double[] coeficientes = new double[n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    A[i][j] = Math.pow(x[i], j);
                }
            }

            double[] b = Arrays.copyOf(y, n);
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    double fator = A[j][i] / A[i][i];
                    for (int k = i; k < n; k++) {
                        A[j][k] -= fator * A[i][k];
                    }
                    b[j] -= fator * b[i];
                }
            }

            for (int i = n - 1; i >= 0; i--) {
                double soma = 0;
                for (int j = i + 1; j < n; j++) {
                    soma += A[i][j] * coeficientes[j];
                }
                coeficientes[i] = (b[i] - soma) / A[i][i];
            }

            return coeficientes;
        }

        public static void main(String[] args) {
            double[] x = {1, 2, 3};
            double[] y = {2, 3, 5};
            double[] coef = interpolacaoPolinomial(x, y);

            System.out.println("Coeficientes do polinômio: " + Arrays.toString(coef));
        }
}
