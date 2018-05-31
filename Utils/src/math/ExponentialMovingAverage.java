package math;

public class ExponentialMovingAverage {
    private double alpha;
    private Double oldValue;
    public ExponentialMovingAverage(double alpha) {
        this.alpha = alpha;
    }

    public double average(double value) {
        if (oldValue == null) {
            oldValue = value;
            return value;
        }
        double newValue = oldValue + alpha * (value - oldValue);
        oldValue = newValue;
        return newValue;
    }
    
    public double[] average(double[] values) {
    	double[] res = new double[values.length];
    	if (oldValue == null) {
            oldValue = values[0];
            res[0] = oldValue;
        }
        for(int i = 1; i < values.length; i++) {
        	res[i] = average(values[i]);
        }
        return res;
    }
}
