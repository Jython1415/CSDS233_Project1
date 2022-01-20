public class NumArrayList implements NumList {
    
    public static boolean run() {
        return true;
    }

    public double lookup(int i) {
        return 0.0;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof NumArrayList) {
            NumArrayList l = (NumArrayList)o
            for (int i = 0; i < this.size(); i++) {
                if (i == l.size())
                    return false;
                if (this.lookup(i) != l.lookup(i))
                    return false;
            }

            return true;
        }
        else
            return false;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
