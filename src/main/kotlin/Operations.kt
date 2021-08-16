class Operations {
    fun divide(leftOperand: Double, rightOperand: Double): Double{
        if (rightOperand == 0.0)
            throw Exception("Division by zero!")
        else
            return leftOperand/rightOperand
    }
}
