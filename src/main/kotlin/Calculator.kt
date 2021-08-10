class Calculator {
    fun plus(leftOperand: Double, rightOperand:Double) =  leftOperand + rightOperand
    fun minus(leftOperand: Double, rightOperand: Double) = leftOperand - rightOperand
    fun multiply(leftOperand: Double, rightOperand: Double) = leftOperand * rightOperand
    fun divide(leftOperand: Double, rightOperand: Double): Double?{
        try {
            if (rightOperand == 0.0)
                throw Exception("Division by zero!\n")
            else
                return leftOperand/rightOperand
        }
        catch (e: Exception){
            print(e.message)
            return null
        }
    }
    fun postfixNotationToAnswer(postfixNotation: String): Double?{
        var answer: MutableList<Double?> = mutableListOf()
        var temp: String = ""
        fun addNumberToArray(){
            if (temp!="")
                answer.add(temp.toDoubleOrNull())
            temp = ""
        }
        for (i in postfixNotation.indices){
            when (postfixNotation[i]){
                ' ' -> {
                    addNumberToArray()
                }
                in '0'..'9', '.'-> {
                    temp += postfixNotation[i]
                }
                '+' -> {
                    addNumberToArray()
                    var lastIndex = answer.lastIndexOf(answer.last())
                    answer[lastIndex - 1] = plus(answer[lastIndex - 1] ?: 0.0,answer.last() ?: 0.0)
                    answer.removeAt(lastIndex)
                }
                '-' -> {
                    addNumberToArray()
                    var lastIndex = answer.lastIndex
                    answer[lastIndex - 1] = minus(answer[lastIndex - 1] ?: 0.0,answer.last() ?: 0.0)
                    answer.removeAt(lastIndex)
                }
                '*' -> {
                    addNumberToArray()
                    var lastIndex = answer.lastIndexOf(answer.last())
                    answer[lastIndex - 1] = multiply(answer[lastIndex - 1] ?: 0.0,answer.last() ?: 0.0)
                    answer.removeAt(lastIndex)
                }
                '/' -> {
                    addNumberToArray()
                    var lastIndex = answer.lastIndexOf(answer.last())
                    answer[lastIndex - 1] = divide(answer[lastIndex - 1] ?: 0.0,answer.last() ?: 0.0)
                    answer.removeAt(lastIndex)
                }
            }
        }
        return answer[0]
    }
}
