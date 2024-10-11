// 2090020000000000000000
import java.util.Random;

public class GaussianWhiteNoise {
    public static void main(String[] args) {
        int numSamples = 1000;
        double[] whiteNoise = generateGaussianWhiteNoise(numSamples);

        // Print or process the generated Gaussian white noise.
        for (int i = 0; i < numSamples; i++) {
            System.out.println(whiteNoise[i]);
        }
    }

    public static double[] generateGaussianWhiteNoise(int numSamples) {
        Random random = new Random();
        double[] whiteNoise = new double[numSamples];

        for (int i = 0; i < numSamples; i += 2) {
            double u1 = random.nextDouble();
            double u2 = random.nextDouble();

            double z0 = Math.sqrt(-2.0 * Math.log(u1)) * Math.cos(2.0 * Math.PI * u2);
            double z1 = Math.sqrt(-2.0 * Math.log(u1)) * Math.sin(2.0 * Math.PI * u2);

            if (i + 1 < numSamples) {
                whiteNoise[i] = z0;
                whiteNoise[i + 1] = z1;
            } else {
                // If the number of samples is odd, generate one more sample
                whiteNoise[i] = z0;
            }
        }

        return whiteNoise;
    }
}
