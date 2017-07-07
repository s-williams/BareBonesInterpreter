public class Today2TomorrowJava { public static void main(String[] args) {
int Aux = 0; System.out.println( " Aux = " + Aux );
int Tomorrow = 0; System.out.println( " Tomorrow = " + Tomorrow );
while ( int Today != 0) {
Aux = Aux + 1; System.out.println( " Aux = " + Aux );
Today = Today - 1; System.out.println( " Today = " + Today );
}
int Aux = 0; while ( Aux != 0) {
Today = Today + 1; System.out.println( " Today = " + Today );
Tomorrow = Tomorrow + 1; System.out.println( " Tomorrow = " + Tomorrow );
Aux = Aux - 1; System.out.println( " Aux = " + Aux );
}
} }
