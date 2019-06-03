// most parts were copied from
// https://github.com/xharaken/step2015/blob/master/Matrix.java

import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;


import java.lang.Exception;



class MatrixImpl {

    public void test(int n) {

        double[][] a = new double[n][n]; // Matrix A
        double[][] b = new double[n][n]; // Matrix B
        double[][] c = new double[n][n]; // Matrix C

        // Initialize the matrices to some values.
        int i, j;
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                a[i][j] = i * n + j;
                b[i][j] = j * n + i;
                c[i][j] = 0;
            }
        }


        long begin = System.currentTimeMillis();

        // calculation part
        int ii, jj, k;
        for (ii = 0; ii < n; ii++) {
            for (jj = 0; jj < n; jj++) {
                for (k = 0; k < n; k++) {
                    c[ii][jj] += a[ii][k] * b[k][jj];
                }
            }
        }

        long end = System.currentTimeMillis();

        double time = (end - begin) / 1000.0;

        System.out.printf("time: %.6f sec\n", time);


        // Print C for debugging. Comment out the print before measuring the execution time.
        double sum = 0;
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


    public void run() {

        try {
            File file = new File("data.txt");

            if (checkBeforeWriteFile(file)) {
                BufferedWriter bw = new BufferedWriter(new FileWriter(file));

                // change N from 100 to 1000 with step 100
                for (int n = 100; n <= 1000; n += 100) {

                    double[][] a = new double[n][n]; // Matrix A
                    double[][] b = new double[n][n]; // Matrix B
                    double[][] c = new double[n][n]; // Matrix C

                    // Initialize the matrices to some values.
                    int i, j;
                    for (i = 0; i < n; i++) {
                        for (j = 0; j < n; j++) {
                            a[i][j] = i * n + j;
                            b[i][j] = j * n + i;
                            c[i][j] = 0;
                        }
                    }

                    // experiment 100 times for each N
                    for (int loop = 0; loop < 100; loop++) {

                        long begin = System.currentTimeMillis();

                        // calculation part
                        int ii, jj, k;
                        for (ii = 0; ii < n; ii++) {
                            for (jj = 0; jj < n; jj++) {
                                for (k = 0; k < n; k++) {
                                    c[ii][jj] += a[ii][k] * b[k][jj];
                                }
                            }
                        }

                        long end = System.currentTimeMillis();

                        double time = (end - begin) / 1000.0;

                        //System.out.printf("time: %.6f sec\n", time);
                        System.out.printf("%d %.6f\n", n, time);

                        // write down into the file
                        bw.write(n + " " + time);
                        bw.newLine();
                    }

                    // Print C for debugging. Comment out the print before measuring the execution time.
                    double sum = 0;
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
                bw.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    boolean checkBeforeWriteFile(File file) {
        if (file.exists()) {
            if (file.isFile() && file.canWrite()) {
                return true;
            }
        }
        return false;
    }

}