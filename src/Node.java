public class Node {

    private double[] closePrices;
    private double hiddenPred;
    private Node node;

    public Node(double[] closePrices) {
        this.closePrices = closePrices;
        this.hiddenPred = Math.random();
    }

    public Node(double[] closePrices, Node node) {
        this.closePrices = closePrices;
        this.node = node;
        this.hiddenPred = node.getHiddenPred() * Math.random();
    }

    public double getHiddenPred() {
        return hiddenPred;
    }

    boolean[] netCalculate() {
        boolean[] calculations = new boolean[closePrices.length];

        for (int i = 0;  i < closePrices.length; i++) {
            double[] pastPrices = new double[i];
            for (int j = 0; j < i; j++) {
                pastPrices[j] = closePrices[j];
            }
            calculations[i] = calculate(pastPrices);
        }

        return calculations;
    }

    boolean calculate(double[] pastPrices) {
        double prediction = 0;
        for (int i = 0; i < pastPrices.length; i ++) {
            double weight = ((double)i / (double)pastPrices.length);

            prediction += weight * pastPrices[i] * hiddenPred;

        }

    }
}
