public class MultiplyingJava { public static void main(String[] args) {
int X = 0; System.out.println( " X = " + X );
X = X + 1; System.out.println( " X = " + X );
X = X + 1; System.out.println( " X = " + X );
int Y = 0; System.out.println( " Y = " + Y );
Y = Y + 1; System.out.println( " Y = " + Y );
Y = Y + 1; System.out.println( " Y = " + Y );
Y = Y + 1; System.out.println( " Y = " + Y );
int Z = 0; System.out.println( " Z = " + Z );
int X = 0; while ( X != 0) {
int W = 0; System.out.println( " W = " + W );
int Y = 0; while ( Y != 0) {
Z = Z + 1; System.out.println( " Z = " + Z );
W = W + 1; System.out.println( " W = " + W );
Y = Y - 1; System.out.println( " Y = " + Y );
}
int W = 0; while ( W != 0) {
Y = Y + 1; System.out.println( " Y = " + Y );
W = W - 1; System.out.println( " W = " + W );
}
X = X - 1; System.out.println( " X = " + X );
}
} }
