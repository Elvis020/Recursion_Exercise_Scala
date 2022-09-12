package Week_2.Part_I.Exercise_3_PMs


sealed trait Expression
case class Variable(name:String) extends Expression
case class Number(myNumber:Double) extends Expression
case class UnaryOperation(operator:String,argument:Expression) extends Expression
case class BinaryOperation(operator:String,left:Expression,right:Expression) extends Expression



object ReadyToGo_II{

  def simplify(expr:Expression):Expression = expr match {
    case UnaryOperation("-",UnaryOperation("-",x)) =>  x
    case BinaryOperation("+",x,Number(0))  =>  x
    case BinaryOperation("*",x,Number(0))  =>  Number(0)
    case BinaryOperation("*",x,Number(1))  =>  x
    case BinaryOperation("+",c,d) if c == d  =>  BinaryOperation("*",c,Number(2))
  }


}