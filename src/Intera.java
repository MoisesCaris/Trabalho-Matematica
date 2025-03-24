import java.util.Arrays;

public class Intera {
    public static void gaussSeidel(double[][] A, double[] B, double tol, int maxIter) {
        int n = B.length;
        double[] X = new double[n]; // Vetor de solução inicializado com zeros
        Arrays.fill(X, 0);

        for (int iter = 0; iter < maxIter; iter++) {
            double[] X_old = Arrays.copyOf(X, n);

            for (int i = 0; i < n; i++) {
                double sum = 0.0;
                for (int j = 0; j < n; j++) {
                    if (j != i) {
                        sum += A[i][j] * X[j];
                    }
                }
                X[i] = (B[i] - sum) / A[i][i];
            }

            // Verifica a convergência
            double error = 0.0;
            for (int i = 0; i < n; i++) {
                error += Math.abs(X[i] - X_old[i]);
            }
            if (error < tol) {
                break;
            }
        }

        System.out.println("Solução: " + Arrays.toString(X));
    }

    public static void main(String[] args) {
        double[][] A = {
                {3, 0, 1},
                {1, -1, 0},
                {1, 1, -2}
        };
        double[] B = {3, 1, 9};
        double tol = 1e-6;
        int maxIter = 1;

        gaussSeidel(A, B, tol, maxIter);
    }
}
