package Week_2.Part_I.Exercise_3_PMs


sealed trait Expr
case class Number(n: Int) extends Expr
case class Sum(e1: Expr, e2: Expr) extends Expr
case class Prod(e1: Expr, e2: Expr) extends Expr
case class Div(e1: Expr, e2: Expr) extends Expr

object ReadyToGo {
  // Q2, Q3, Q4
  def show(expr: Expr): String = expr match {
    case expr: Number => s"${expr.n}"
    case expr: Sum => s"${show(expr.e1)} + ${show(expr.e2)}"
    case expr: Prod =>
      if (expr.e1.isInstanceOf[Sum]) s"(${show(expr.e1)}) * ${show(expr.e2)}"
      else s"${show(expr.e1)} * ${show(expr.e2)}"
    case expr: Div =>
      if (expr.e1.isInstanceOf[Prod]) s"(${show(expr.e1)})/${show(expr.e2)}"
      else s"${show(expr.e1)}/${show(expr.e2)}"
  }
}