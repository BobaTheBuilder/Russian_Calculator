class Calculator {
    fun plus(leftOperand: Double, rightOperand:Double) =  leftOperand + rightOperand
    fun minus(leftOperand: Double, rightOperand: Double) = leftOperand - rightOperand
    fun multiply(leftOperand: Double, rightOperand: Double) = leftOperand * rightOperand
    fun divide(leftOperand: Double, rightOperand: Double): Double?{
        try {
            if (rightOperand == 0.0)
                throw Exception("Division by zero!")
            else
                return leftOperand/rightOperand
        }
        catch (e: Exception){
            print(e.message)
            return null
        }
    }
}
