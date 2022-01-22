public class NodeManager {
    private Node[] nodes = new Node[100];
    private double[] closingPrices;

    public NodeManager(double[] closingPrices) {
        this.closingPrices = closingPrices;
    }

    public Node runNodes() {
        Node baseNode = new Node(this.closingPrices);
        nodes[0] = baseNode;
        for (int i = 1; i < nodes.length; i++) {
            nodes[i] = new Node(this.closingPrices, nodes[i - 1]);
        }

        return(findBest(nodes));
    }

    public Node findBest(Node[] nodes) {
        double fitness = -1;
        Node topNode = new Node();
        for (int i = 0; i < nodes.length; i++) {
            double thisFitness = 0;
            for (int c = 0; c < closingPrices.length; c++) {
                if (c != closingPrices.length - 1) {
                    if ((nodes[i].netCalculate()[c]) && closingPrices[i + 1] - closingPrices[i] > 0) {
                        thisFitness++;
                    }
                }
            }
            if (thisFitness > fitness) {
                fitness = thisFitness;
                topNode = nodes[i];
            }
        }

        topNode.setFitness(fitness / closingPrices.length);
        return(topNode);
    }

}
