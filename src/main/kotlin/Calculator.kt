class Calculator {
    fun translationToPostfixRecord(expression: String): String {
        val highPriority = "/*"
        val lowPriority = "+-"
        val bracket = "()"
        val stack: MutableList<Char> = mutableListOf()
        var postfixExpression = " "
        for (i in expression.indices) {
            if (expression[i] in '0'..'9' || expression[i] == '.') {
                postfixExpression += expression[i]
                continue
            }
            if (postfixExpression.last() != ' ' && expression[i] !in bracket) postfixExpression += ' '
            if (stack.isNotEmpty()) {
                when (expression[i]) {
                    in highPriority -> {
                        when (stack.last()) {
                            in lowPriority -> stack.add(expression[i])
                            in highPriority -> {
                                postfixExpression = postfixExpression.dropLast(1)
                                postfixExpression += stack.last()
                                postfixExpression += ' '
                                stack.removeAt(stack.lastIndexOf(stack.last()))
                                stack.add(expression[i])
                            }
                            else -> stack.add(expression[i])
                        }
                    }
                    in lowPriority -> {
                        when (stack.last()) {
                            in highPriority -> {
                                postfixExpression = postfixExpression.dropLast(1)
                                postfixExpression += stack.last()
                                postfixExpression += ' '
                                stack.removeAt(stack.lastIndexOf(stack.last()))
                                stack.add(expression[i])
                            }
                            in lowPriority -> {
                                postfixExpression = postfixExpression.dropLast(1)
                                postfixExpression += stack.last()
                                postfixExpression += ' '
                                stack.removeAt(stack.lastIndexOf(stack.last()))
                                stack.add(expression[i])
                            }
                            else -> stack.add(expression[i])
                        }
                    }
                    in bracket -> {
                        if (expression[i] == '(') stack.add(expression[i])
                        else if ('(' in stack) {
                            while (stack.last() != '(') {
                                postfixExpression += stack.last()
                                stack.removeAt(stack.lastIndexOf(stack.last()))
                            }
                            stack.removeAt(stack.lastIndexOf(stack.last()))
                        }
                    }
                }
            } else stack.add(expression[i])
        }
        while (stack.isNotEmpty()) {
            postfixExpression += stack.last()
            stack.removeAt(stack.lastIndexOf(stack.last()))
        }
        return postfixExpression
    }
}
