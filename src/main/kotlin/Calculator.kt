class Calculator() {
    fun checkingExpression(expression: String): Boolean {
        val operations = listOf<Char>('+', '-', '*', '/')
        val invalidCharacters = listOf<Char>(',', '[', ']', '{', '}')
        val bracket = listOf('(', ')')
        var tmp = false
        for (i in expression.indices) {
            if (expression[i] in operations && expression[i + 1] in operations) return false
            if (expression[i] in 'a'..'z' || expression[i] in 'A'..'Z') return false
            if (expression[i] in invalidCharacters) return false
            if (expression[i] == '(' && expression[i + 1] in operations) return false
            if (expression[i] == ')' && expression[i - 1] in operations) return false
        }
        return expression.count { simbol -> simbol == '(' } == expression.count { simbol -> simbol == ')' }
    }
}
