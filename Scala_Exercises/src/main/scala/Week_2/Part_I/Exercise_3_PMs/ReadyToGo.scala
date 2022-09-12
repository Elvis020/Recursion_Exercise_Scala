package Week_2.Part_I.Exercise_3_PMs


sealed trait Expr
case class Num(n: Int) extends Expr
case class Sum(e1: Expr, e2: Expr) extends Expr
case class Prod(e1: Expr, e2: Expr) extends Expr
case class Div(e1: Expr, e2: Expr) extends Expr




object ReadyToGo {

  // Calvin's Version
  def show(expr: Expr): String = expr match {
    case Num(n) => n.toString
    case Sum(left, right) => show(left) + " + " + show(right)
    case Prod(left, right) =>
      def maybeShowParensProd(expr: Expr) = expr match {
        case Sum(_, _) => s"(${show(expr)})"
        case _ => show(expr)
      }

      maybeShowParensProd(left) + " * " + maybeShowParensProd(right)
    case Div(left, right) =>
      def maybeShowParensDiv(expr: Expr) = expr match {
        case Prod(_, _) | Sum(_, _) => s"(${show(expr)})"
        case _ => show(expr)
      }

      maybeShowParensDiv(left) + " / " + maybeShowParensDiv(right)
  }

  // My Version
  def show_II(expr: Expr): String = expr match {
    case expr: Num => s"${expr.n}"
    case expr: Sum => s"${show(expr.e1)} + ${show(expr.e2)}"
    case expr: Prod =>
      if (expr.e1.isInstanceOf[Sum]) s"(${show(expr.e1)}) * ${show(expr.e2)}"
      else s"${show(expr.e1)} * ${show(expr.e2)}"
    case expr: Div =>
      if ((expr.e1.isInstanceOf[Prod]) | (expr.e1.isInstanceOf[Sum])) s"(${show(expr.e1)}) / ${show(expr.e2)}"
      else s"${show(expr.e1)} / ${show(expr.e2)}"
  }
}