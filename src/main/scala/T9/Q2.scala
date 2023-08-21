package T9

object Q2 {
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

    //Sub method
    def sub(number :Rational): Rational = {
      new Rational(numerator*number.denominator - number.numerator*denominator,denominator*number.denominator);
    }

  }

  object RationalTest extends App {
    val x = new Rational(3, 4)
    val y = new Rational(5, 8)
    val z = new Rational(2, 7)

    val result = x.sub(y).sub(z)

    println(s"x = $x")
    println(s"y = $y")
    println(s"z = $z")
    println(s"x - y - z = $result")
  }

  def main(args :Array[String]): Unit = {
    RationalTest.main(Array());
  }

}