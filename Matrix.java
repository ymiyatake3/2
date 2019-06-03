// Some parts were copied from
// https://github.com/xharaken/step2015/blob/master/Matrix.java

class Matrix {

    public static void main(String args[]) {

        MatrixImpl impl = new MatrixImpl();

        // For a test.
        if (args.length != 1) {
            System.out.println("usage: java Matrix N");
            return;
        }

        impl.test(Integer.parseInt(args[0]));


        // For recording the result to a file.
        // Calculate 100 * 100 times automatically.
        //impl.run();

    }
}