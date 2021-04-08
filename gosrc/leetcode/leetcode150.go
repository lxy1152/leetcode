package main

import "strconv"

func evalRPN(tokens []string) int {

	stackNum := make([]int, 0)
	stackSign := make([]string, 0)

	for i := range tokens {
		if tokens[i] == "+" || tokens[i] == "-" || tokens[i] == "*" || tokens[i] == "/" {
			stackSign = append(stackSign, string(tokens[i]))
		} else {
			val, _ := strconv.Atoi(tokens[i])
			stackNum = append(stackNum, val)
		}

		if len(stackNum) > 1 && len(stackSign) > 0 {
			val1 := stackNum[len(stackNum)-1]
			val2 := stackNum[len(stackNum)-2]
			stackNum = stackNum[:len(stackNum)-2]
			sign := stackSign[len(stackSign)-1]
			stackSign = stackSign[:len(stackSign)-1]
			switch sign {
			case "+":
				stackNum = append(stackNum, val2+val1)
			case "-":
				stackNum = append(stackNum, val2-val1)
			case "*":
				stackNum = append(stackNum, val2*val1)
			case "/":
				stackNum = append(stackNum, int(val2/val1))
			}
		}

	}
	return stackNum[0]

}

func main() {
	evalRPN([]string{"4", "13", "5", "/", "+"})
}
