import java.util.Random;
import java.text.DecimalFormat;

public class Example_4x6x16 {
    private static final int INPUT_NEURONS = 2;
    private static final int HIDDEN_NEURONS = 4;
    private static final int OUTPUT_NEURONS = 1;

    private static final double LEARN_RATE = 0.2;    // Rho.
    private static final double MAX_ERROR = 0.0001;
    private static final int TRAINING_REPS = 10000;

    // Input to Hidden Weights (with Biases).输入层与隐藏层的权值矩阵
    private static double wih[][] = new double[INPUT_NEURONS + 1][HIDDEN_NEURONS];

    // Hidden to Output Weights (with Biases).隐藏层和输出层的权值矩阵
    private static double who[][] = new double[HIDDEN_NEURONS + 1][OUTPUT_NEURONS];

    // Activations.
    private static double inputs[] = new double[INPUT_NEURONS];
    private static double hidden[] = new double[HIDDEN_NEURONS];
    private static double target[] = new double[OUTPUT_NEURONS];
    private static double actual[] = new double[OUTPUT_NEURONS];

    // Unit errors.
    private static double erro[] = new double[OUTPUT_NEURONS];
    private static double errh[] = new double[HIDDEN_NEURONS];


    private static double trainInputs[] = new double[]{0.05, 0.1};

    private static double trainOutput[] = new double[]{0.01, 0.99};


    private static void NeuralNetwork() {

        assignRandomWeights();  //权值矩阵初始化

        // Train the network.
        for (int epoch = 0; epoch < TRAINING_REPS; epoch++) {

            for (int i = 0; i < INPUT_NEURONS; i++) {
                inputs[i] = trainInputs[i];
            } // i

            for (int i = 0; i < OUTPUT_NEURONS; i++) {
                target[i] = trainOutput[i];
            } // i

            feedForward();

            backPropagate();

        } // epoch

        getTrainingStats();

        System.out.println("\nTest network against original input:");
        testNetworkTraining();

        return;
    }

    private static void getTrainingStats() {
        for (int j = 0; j < INPUT_NEURONS; j++) {
            inputs[j] = trainInputs[j];//{0.05,0.1}
        } // j

        for (int j = 0; j < OUTPUT_NEURONS; j++) {
            target[j] = trainOutput[j];//{0.01,0.99}
        } // j

        feedForward();

        if (maximum(actual) == maximum(target)) {
            System.out.println("It has finished, and successed in 100%");
        } else {
            System.out.println(inputs[0] + "\t" + inputs[1] + "\t" + inputs[2] + "\t" + inputs[3]);
            System.out.println(maximum(actual) + "\t" + maximum(target));
        } // i

        return;
    }


    private static void testNetworkTraining() {
        // This function simply tests the training vectors against network.
        for (int j = 0; j < INPUT_NEURONS; j++) {
            inputs[j] = trainInputs[j];
        } // j

        feedForward();

        for (int j = 0; j < INPUT_NEURONS; j++) {
            System.out.print(inputs[j] + "\t");
        } // j

        System.out.print("Output: ");
        for (int j = 0; j < OUTPUT_NEURONS; j++) {
            System.out.print(actual[j] + "\t");
        }

        // i
        return;
    }

    private static int maximum(final double[] vector) {
        // This function returns the index of the maximum of vector().
        int sel = 0;
        double max = vector[sel];

        for (int index = 0; index < OUTPUT_NEURONS; index++) {
            if (vector[index] > max) {
                max = vector[index];
                sel = index;
            }
        }
        return sel;
    }
    //正向传播函数
    private static void feedForward() {
        double sum = 0.0;

        // Calculate input to hidden layer.
        for (int hid = 0; hid < HIDDEN_NEURONS; hid++) {
            sum = 0.0;
            for (int inp = 0; inp < INPUT_NEURONS; inp++) {
                sum += inputs[inp] * wih[inp][hid];
            } // inp

            sum += wih[INPUT_NEURONS][hid]; // Add in bias.
            hidden[hid] = sigmoid(sum);
        } // hid

        // Calculate the hidden to output layer.
        for (int out = 0; out < OUTPUT_NEURONS; out++) {
            sum = 0.0;
            for (int hid = 0; hid < HIDDEN_NEURONS; hid++) {
                sum += hidden[hid] * who[hid][out];
            } // hid

            sum += who[HIDDEN_NEURONS][out]; // Add in bias.
            actual[out] = sigmoid(sum);
        } // out
        return;
    }
    //反向传播函数
    private static void backPropagate() {
        // Calculate the output layer error (step 3 for output cell).
        for (int out = 0; out < OUTPUT_NEURONS; out++) {
            erro[out] = (target[out] - actual[out]) * sigmoidDerivative(actual[out]);
        }

        // Calculate the hidden layer error (step 3 for hidden cell).
        for (int hid = 0; hid < HIDDEN_NEURONS; hid++) {
            errh[hid] = 0.0;
            for (int out = 0; out < OUTPUT_NEURONS; out++) {
                errh[hid] += erro[out] * who[hid][out];
            }
            errh[hid] *= sigmoidDerivative(hidden[hid]);
        }

        // Update the weights for the output layer (step 4).
        for (int out = 0; out < OUTPUT_NEURONS; out++) {
            for (int hid = 0; hid < HIDDEN_NEURONS; hid++) {
                who[hid][out] += (LEARN_RATE * erro[out] * hidden[hid]);
            } // hid
            who[HIDDEN_NEURONS][out] += (LEARN_RATE * erro[out]); // Update the bias.
        } // out

        // Update the weights for the hidden layer (step 4).
        for (int hid = 0; hid < HIDDEN_NEURONS; hid++) {
            for (int inp = 0; inp < INPUT_NEURONS; inp++) {
                wih[inp][hid] += (LEARN_RATE * errh[hid] * inputs[inp]);
            } // inp
            wih[INPUT_NEURONS][hid] += (LEARN_RATE * errh[hid]); // Update the bias.
        } // hid
        return;
    }

    private static void assignRandomWeights() {
        for (int inp = 0; inp <= INPUT_NEURONS; inp++) // Do not subtract 1 here.
        {
            for (int hid = 0; hid < HIDDEN_NEURONS; hid++) {
                // Assign a random weight value between -0.5 and 0.5
                wih[inp][hid] = new Random().nextDouble() - 0.5;
            } // hid
        } // inp

        for (int hid = 0; hid <= HIDDEN_NEURONS; hid++) // Do not subtract 1 here.
        {
            for (int out = 0; out < OUTPUT_NEURONS; out++) {
                // Assign a random weight value between -0.5 and 0.5
                who[hid][out] = new Random().nextDouble() - 0.5;
            } // out
        } // hid
        return;
    }

    private static double sigmoid(final double val) {
        return (1.0 / (1.0 + Math.exp(-val)));
    }  //神经网络激活函数

    //sigmoid函数求导
    private static double sigmoidDerivative(final double val) {
        return (val * (1.0 - val));
    }
    public static void main(String[] args) {
        NeuralNetwork();
        return;
    }
}
