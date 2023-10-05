// Продемонстрировать статические переменные, методы и блоки кода.
package Chapter07;

public class UseStatic09 {
    static int a = 3;
    static int b;

    static void meth(int x) {
        System.out.println("x = " + x);
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }

    static {
        System.out.println("Статический блок инициализирован.");
        b = a * 4;
    }

    public static void main(String[] args) {
        meth(42);
    }
}

/*
----------------------------
Как только загружается класс UseStatic09, выполняются все статические операторы.
Сначала в переменной а устанавливается значение 3, затем выполняется
статический блок кода, в котором выводится сообщение, а переменная Ь инициализируется
значением а*4, т.е. 12. После этого вызывается метод main(), который, в свою очередь,
вызывает метод meth(),передавая параметру х значение 42.
В трех вызовах метода println () делаются ссылки на две статические переменные, а и Ь,
а также на локальную переменную х. Результат, выводимый этой программой, выглядит следующим образом:

Статический блок инициализирован.
x = 42
a = 3
b = 12

 */