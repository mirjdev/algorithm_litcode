package min_stack;

import java.util.Stack;
//155 https://leetcode.com/problems/min-stack/description/
class MinStack {
    //Нужны две структуры данных
    //1 стэка
    //2 для списка минимальных элементов, нужно хранить последние значения
    private final Stack<Integer> dataStack;
    private final Stack<Integer> minStack;

    public MinStack() {
        dataStack = new Stack<>();
        minStack = new Stack<>();
    }

    //Добавление элемента в конец, вычисление нужно ли дополнить минимальную очередь
    public void push(int val) {
        dataStack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    //Получение и удаление из шапки
    public void pop() {
        // dataStack.pop() получаем и сразу удалим, если равны с шапкой стэка минимальных значений, то удалим
        if (dataStack.pop().equals(minStack.peek())) {
            minStack.pop();
        }
    }

    //получение из шапки
    public int top() {
        return dataStack.peek();
    }

    // получение из минимума. Минимальное значение будет всегда вверху стека
    public int getMin() {
        return minStack.peek();
    }
}
