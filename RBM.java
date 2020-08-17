
// Restricted_Boltzmann_machine
class RBM {
  int V;
  int H;

  double[][] w;
  double[][] a;
  double[][] b;

  double[][] vE;

  double ETA = 0.1;

  RBM(int _V, int _H) {
    V = _V;
    H = _H;

    w = Matrix.random(V, H, -0.1, 0.1);
    a = Matrix.random(1, V, -0.1, 0.1);
    b = Matrix.random(1, H, -0.1, 0.1);
  }

  // get hidden from given visible
  double[][] phv(double[][] inputs) {
    double[][] h = Matrix.dot(w, inputs);
    h = Matrix.add(h, b);
    h = sigmoid(h);
    return h;
  }

  // get visible from given hidden
  double[][] pvh(double[][] inputs) {
    double[][] v = Matrix.dot(Matrix.T(w), inputs);
    v = Matrix.add(v, a);
    v = sigmoid(v);
    return v;
  }

  void train(double[][] inputs) {
    double[][] pos_h_activ = Matrix.dot(w, inputs);
    pos_h_activ = Matrix.add(pos_h_activ, b);
    double[][] pos_prob = sigmoid(pos_h_activ);

    double[][] pos_ass = Matrix.dot(pos_prob, Matrix.T(inputs));

    double[][] neg_v_activ = Matrix.dot(Matrix.T(w), pos_prob);
    neg_v_activ = Matrix.add(neg_v_activ, a);
    double[][] neg_v_prob = sigmoid(neg_v_activ);
    double[][] neg_h_activ = Matrix.dot(w, neg_v_prob);
    neg_h_activ = Matrix.add(neg_h_activ, b);
    double[][] neg_h_prob = sigmoid(neg_h_activ);

    double[][] neg_ass = Matrix.dot(neg_h_prob, Matrix.T(neg_v_prob));

    w = Matrix.add(w, Matrix.mult(Matrix.subtract(pos_ass, neg_ass), ETA));
    a = Matrix.add(a, Matrix.mult(Matrix.subtract(inputs, neg_v_prob), ETA));
    b = Matrix.add(b, Matrix.mult(Matrix.subtract(pos_prob, neg_h_prob), ETA));
  }

  double[][] sigmoid(double[][] inputs) {
    double[][] b = new double[inputs.length][inputs[0].length];
    for(int x=0; x<inputs.length; x++)
      for(int y=0; y<inputs[0].length; y++)
        b[x][y] = 1 / (1 + Math.exp(-inputs[x][y]));
    return b;
  }
}
