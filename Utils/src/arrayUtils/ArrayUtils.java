package arrayUtils;

public class ArrayUtils {

	public Object[] sortAonB(double[] a, double[] b) {
		double[] sortedA = new double[a.length];
		double[] sortedB = new double[b.length];
		for(int i = 0; i < a.length; i++) {
			int minFollowers = Integer.MAX_VALUE;
			double clusterVal = 0;
			double followerVal = 0;
			int index = 0;
			for(int j = 0; j < a.length; j++) {
				if(a[j] == 0) {
					continue;
				}
				if(b[j] < minFollowers) {
					minFollowers = (int)b[j];
					clusterVal = a[j];
					index = j;
				}
			}
			a[index] = 0;
			sortedA[i] = clusterVal;
			sortedB[i] = minFollowers;
		}
		return new Object[]{sortedA, sortedB};
	}
}
