// Original code
// https://github.com/xharaken/step2015/blob/master/Matrix.java

class Matrix {

    public static void main(String args[]) {


        if (args.length < 1 || !(args[0].equals("test") || args[0].equals("run"))) {
            System.out.println(args[0]);
            System.out.println(args.length);
            System.out.println("usage: 'java Matrix test N' or 'java Matrix run'");
            return;
        }

        MatrixImpl impl = new MatrixImpl();

        if (args[0].charAt(0) == 't') {
            // For a test
            impl.test(Integer.parseInt(args[1]));
        } else {
            // For recording the result to a file.
            // Calculate 10 * 100 times automatically.
            impl.run();
        }

    }
}