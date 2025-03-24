import java.util.Arrays;

public class Gaus {
    public static void gaussianElimination(double[][] A, double[] B) {
        int n = B.length;

        for (int i = 0; i < n; i++) {
            int max = i;
            for (int k = i + 1; k < n; k++) {
                if (Math.abs(A[k][i]) > Math.abs(A[max][i])) {
                    max = k;
                }
            }

            double[] temp = A[i];
            A[i] = A[max];
            A[max] = temp;

            double t = B[i];
            B[i] = B[max];
            B[max] = t;

            for (int k = i + 1; k < n; k++) {
                double factor = A[k][i] / A[i][i];
                for (int j = i; j < n; j++) {
                    A[k][j] -= factor * A[i][j];
                }
                B[k] -= factor * B[i];
            }
        }

        double[] X = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            double sum = 0.0;
            for (int j = i + 1; j < n; j++) {
                sum += A[i][j] * X[j];
            }
            X[i] = (B[i] - sum) / A[i][i];
        }

        System.out.println("Solução: " + Arrays.toString(X));
    }

    public static void main(String[] args) {
        double[][] A = {
                {5, 2, 1},
                {-1, 4, 2},
                {2, -3, 10}
        };
        double[] B = {-12, 20, 3};

        gaussianElimination(A, B);
    }
}
