// Some parts were copied from
// https://github.com/xharaken/step2015/blob/master/Matrix.java

import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;


import java.lang.Exception;



class MatrixImpl {

    double[][] a, b, c; // Matrix A, B, C

    private void initMatrix(int n) {
        a = new double[n][n]; // Matrix A
        b = new double[n][n]; // Matrix B
        c = new double[n][n]; // Matrix C

        // Initialize the matrices to some values.
        int i, j;
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                a[i][j] = i * n + j;
                b[i][j] = j * n + i;
                c[i][j] = 0;
            }
        }
    }

    public void test(int n) {
        initMatrix(n);

        // calculation and time measuring
        double time = getTime(n);
        printTime(time);

        printSum(n);
    }


    // Calculate 100 size * 10 times and write down each execution time to a file.
    public void run() {

        try {
            // You have to prepare void file with this name in advance.
            File file = new File("data_.txt");

            if (checkBeforeWriteFile(file)) {
                BufferedWriter bw = new BufferedWriter(new FileWriter(file));

                // Change N from 100 to 1000 with step 10.
                for (int n = 100; n <= 1000; n += 10) {
                    System.out.println("N = " + n);
                    initMatrix(n);

                    // Calculate 10 times for each N.
                    for (int loop = 0; loop < 10; loop++) {

                        // calculation and time measuring
                        double time = getTime(n);

                        // Write down into the file.
                        bw.write(n + " " + time);
                        bw.newLine();

                        printTime(time);
                    }
                }
                bw.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Perform matrix multiplication once and return the execution time.
    private double getTime(int n) {
        long begin = System.currentTimeMillis();

        // Calculation part
        int i, j, k;
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                for (k = 0; k < n; k++) {
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }

        long end = System.currentTimeMillis();

        double time = (end - begin) / 1000.0;

        return time;
    }


    private boolean checkBeforeWriteFile(File file) {
        if (file.exists()) {
            if (file.isFile() && file.canWrite()) {
                return true;
            }
        }
        return false;
    }

    private void printSum(int n) {

        // Print C for debugging. Comment out the print before measuring the execution time.
        double sum = 0;
        int i, j;
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                sum += c[i][j];
                // System.out.printf("c[%d][%d]=%f\n", i, j, c[i][j]);
            }
        }
        // Print out the sum of all values in C.
        // This should be 450 for N=3, 3680 for N=4, and 18250 for N=5.
        System.out.printf("sum: %.6f\n", sum);
    }

    private void printTime(double time) {
        System.out.printf("time: %.6f sec\n", time);
    }
}