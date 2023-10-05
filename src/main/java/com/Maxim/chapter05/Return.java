
package Chapter05;
// Оператор return немедленно прекращает выполнение метода, в теле которого он находится.
public class Return {
    public static void main (String[] args) {
        boolean t = true;
        System.out.println("До возврата.");
        if (t) return; // возврат в вызывающий код
//  Сразу после выполнения оператора return управление возвращается вызывающему объекту.
        System.out.println("Этот оператор не выполнится.");
    }
}
/*
И наконец, в приведенном выше примере программы наличие условного оператора if (t) обязательно.
Без него компилятор Java сигнализировал бы об ошибке типа "unreachaЫe code" (недостижимый код),
поскольку он выяснил бы, что последний вызов метода println( ) вообще не будет выполняться.
Во избежание подобной ошибки в данном примере пришлось прибегнуть к помощи условного оператора if,
чтобы ввести компилятор в заблуждение. Это сделано исключительно с целью продемонстрировать
применение оператора return.
----------------
До возврата.
 */