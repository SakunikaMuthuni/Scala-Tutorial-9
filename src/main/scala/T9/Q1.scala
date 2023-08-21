package T9

object Q1 {
  class Rational(n:Int , d:Int){
    // check whether d is Zero or not. Use require method to throw an expectation.
    require(d != 0, "Denominator cannot be zero");

    val GCD = gcd(n.abs, d.abs);

    val numerator :Int=n/GCD;
    val denominator :Int=d/GCD;

    override def toString: String = s"$numerator/$denominator";

    //Auxiliary constructor
    def this(numerator :Int) = this(numerator,1);

    //Find GCD
    def gcd(n:Int, d:Int): Int = {
      if(d==0){
        n
      }else{
        gcd(d,n%d);
      }
    }

    // negation
    def neg: Rational = new Rational(-numerator, denominator);

  }

  object RationalTest extends App {
    val x = new Rational(16,44);
    val y = new Rational(5);

    val negx=x.neg;
    val negy=y.neg;

    println(s"x = $x");
    println(s"-x= $negx");
    println(s"y = $y");
    println(s"-y= $negy");
  }

  def main(args :Array[String]): Unit = {
    RationalTest.main(Array());
  }

}
