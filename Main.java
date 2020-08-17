class Main {
	public static void main(String... args) {
		// Usage ex.
		RBM rbm = new RBM(2, 2); // 2 visible, 2 hidden
		
		for(int i=0; i<10000; i++) {
			rbm.train(new double[][]{ {0., 0.} });
			rbm.train(new double[][]{ {1., 1.} });
		}
		
		double[][] p = rbm.pvh(rbm.phv(new double[][]{ {0., 0.} }));
		System.out.println(p[0][0] + " " + p[0][1]);
	}
}
