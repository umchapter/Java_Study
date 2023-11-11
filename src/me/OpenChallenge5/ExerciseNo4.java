package me.OpenChallenge5;

class Km2Mile extends Converter {
    public Km2Mile(double ratio) {
        this.ratio = ratio;
    }

    @Override
    protected double convert(double src) {
        return src / ratio;
    }

    @Override
    protected String getSrcString() {
        return "Km";
    }

    @Override
    protected String getDestString() {
        return "mile";
    }
}

public class ExerciseNo4 {
    public static void main(String[] args) {
        Km2Mile km2Mile = new Km2Mile(1.6);
        km2Mile.run();
    }
}
