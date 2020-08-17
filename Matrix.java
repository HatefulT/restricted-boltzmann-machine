import java.lang.ArithmeticException;
import java.util.Random;

public class Matrix {
  public static double[][] add(double[][] a, double[][] b) {
    if(a.length != b.length || a[0].length != b[0].length) throw new ArithmeticException("Sizes must be equal in Matrix.add");
    double[][] c = new double[a.length][a[0].length];
    for(int x=0; x<a.length; x++)
      for(int y=0; y<a[0].length; y++)
        c[x][y] = a[x][y] + b[x][y];
    return c;
  }
  public static double[][] subtract(double[][] a, double[][] b) {
    if(a.length != b.length || a[0].length != b[0].length) throw new ArithmeticException("Sizes must be equal in Matrix.subtract");
    double[][] c = new double[a.length][a[0].length];
    for(int x=0; x<a.length; x++)
      for(int y=0; y<a[0].length; y++)
        c[x][y] = a[x][y] - b[x][y];
    return c;
  }
  public static double[][] mult(double[][] a, double[][] b) {
    if(a.length != b.length || a[0].length != b[0].length) throw new ArithmeticException("Sizes must be equal in Matrix.mult");
    double[][] c = new double[a.length][a[0].length];
    for(int x=0; x<a.length; x++)
      for(int y=0; y<a[0].length; y++)
        c[x][y] = a[x][y] * b[x][y];
    return c;
  }
  public static double[][] mult(double[][] a, double b) {
    double[][] c = new double[a.length][a[0].length];
    for(int x=0; x<a.length; x++)
      for(int y=0; y<a[0].length; y++)
        c[x][y] = a[x][y] * b;
    return c;
  }

  public static double[][] dot(double[][] a, double[][] b) {
    if(a.length != b[0].length) throw new ArithmeticException("Sizes must be equal in Matrix.dot");
    double[][] c = new double[b.length][a[0].length];
    for(int x=0; x<b.length; x++) {
      for(int y=0; y<a[0].length; y++) {
        for(int x1=0; x1<a.length; x1++)
          c[x][y] += a[x1][y] * b[x][x1];
      }
    }
    return c;
  }
  public static double[][] random(int w, int h, double min, double max) {
    Random r = new Random();
    double[][] c = new double[w][h];
    for(int x=0; x<w; x++)
      for(int y=0; y<h; y++)
        c[x][y] = r.nextDouble()*(max-min) + min;
    return c;
  }
  public static double[][] zeros(int W, int H) {
    return new double[W][H];
  }

  public static double[] dot(double[][] m, double[] v) {
    double[] v1 = new double[m[0].length];
    for(int i=0; i<m[0].length; i++)
      for(int x=0; x<m.length; x++)
        v1[i] += m[x][i] * v[x];
    return v1;
  }

  public static double[][] T(double[][] a) {
    double[][] c = new double[a[0].length][a.length];
    for(int x=0; x<a.length; x++)
      for(int y=0; y<a[0].length; y++)
        c[y][x] = a[x][y];
    return c;
  }
}
