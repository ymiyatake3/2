// most parts were copied from
// https://github.com/xharaken/step2015/blob/master/Matrix.java

class Matrix {

    public static void main(String args[]) {

        MatrixImpl impl = new MatrixImpl();

        // for a test
        if (args.length != 1) {
            System.out.println("usage: java Matrix N");
            return;
        }

        impl.test(Integer.parseInt(args[0]));


        // for recording the result to a file
        //impl.run();

    }
}