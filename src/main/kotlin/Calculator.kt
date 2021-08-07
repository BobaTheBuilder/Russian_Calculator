class Calculator {
    fun translationToPostfixRecord(expression: MutableList<Char>): MutableList<Char> {
        val highPriority = listOf('*', '/')
        val lowPriority = listOf('+', '-')
        val bracket = listOf('(', ')')
        val stack: MutableList<Char> = mutableListOf()
        val postfixExpression: MutableList<Char> = mutableListOf()
        for (i in expression.indices) {
            if (expression[i] in '0'..'9' || expression[i] == '.') {
                postfixExpression.add(expression[i])
            } else {
                if (expression[i] != ' ') {
                    if (stack.isNotEmpty()) {
                        when (expression[i]) {
                            in highPriority -> {
                                when (stack.last()) {
                                    in lowPriority -> stack.add(expression[i])
                                    in highPriority -> {
                                        postfixExpression.add(stack.last())
                                        stack.remove(stack.last())
                                        stack.add(expression[i])
                                    }
                                    else -> stack.add(expression[i])
                                }
                            }
                            in lowPriority -> {
                                when (stack.last()) {
                                    in highPriority -> {
                                        postfixExpression.add(stack.last())
                                        stack.remove(stack.last())
                                        stack.add(expression[i])
                                    }
                                    in lowPriority -> {
                                        postfixExpression.add(stack.last())
                                        stack.remove(stack.last())
                                        stack.add(expression[i])
                                    }
                                    else -> stack.add(expression[i])
                                }
                            }
                            in bracket -> {
                                if (expression[i] == '(') stack.add(expression[i])
                                else {
                                    if ('(' in stack) {
                                        while (stack.last() != '(') {
                                            postfixExpression.add(stack.last())
                                            stack.removeAt(stack.lastIndexOf(stack.last()))
                                        }
                                        stack.removeAt(stack.lastIndexOf(stack.last()))
                                    }
                                }
                            }
                        }
                    } else stack.add(expression[i])
                } else {
                    if (expression[i + 1] in '0'..'9' && expression[i] != '.') postfixExpression.add(' ')
                }
            }
        }
        while (stack.isNotEmpty()) {
            postfixExpression.add(stack.last())
            stack.remove(stack.last())
        }
        return postfixExpression
    }
}
