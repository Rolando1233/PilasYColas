import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

class MiPila {
    private LinkedList<Integer> items;

    public MiPila() {
        this.items = new LinkedList<>();
    }

    public void push(int elemento) {
        items.add(elemento);
    }

    public int pop() {
        if (!isEmpty()) {
            return items.removeLast();
        } else {
            throw new RuntimeException("La pila está vacía");
        }
    }

    public int peek() {
        if (!isEmpty()) {
            return items.getLast();
        } else {
            throw new RuntimeException("La pila está vacía");
        }
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public int size() {
        return items.size();
    }

    @Override
    public String toString() {
        return items.toString();
    }
}

public class PilasYColas {
    public static void main(String[] args) {
        MiPila miPila = new MiPila();
        Queue<Integer> cola = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("Menu:");
            System.out.println("1. Agregar a la pila");
            System.out.println("2. Eliminar de la pila");
            System.out.println("3. Ver elemento en la cima de la pila");
            System.out.println("4. Agregar a la cola");
            System.out.println("5. Eliminar de la cola");
            System.out.println("6. Ver primer elemento de la cola");
            System.out.println("7. Verificar si la pila está vacía");
            System.out.println("8. Verificar si la cola está vacía");
            System.out.println("9. Contar elementos en la pila");
            System.out.println("10. Contar elementos en la cola");
            System.out.println("11. Mostrar elementos");
            System.out.println("12. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el elemento a agregar a la pila: ");
                    int elementoPila = scanner.nextInt();
                    miPila.push(elementoPila);
                    break;

                case 2:
                    try {
                        System.out.println("Elemento eliminado de la pila: " + miPila.pop());
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    try {
                        System.out.println("Elemento en la cima de la pila: " + miPila.peek());
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    System.out.print("Ingrese el elemento a agregar a la cola: ");
                    int elementoCola = scanner.nextInt();
                    cola.offer(elementoCola);
                    break;

                case 5:
                    if (!cola.isEmpty()) {
                        System.out.println("Elemento eliminado de la cola: " + cola.poll());
                    } else {
                        System.out.println("La cola está vacía.");
                    }
                    break;

                case 6:
                    try {
                        System.out.println("Primer elemento de la cola: " + (cola.isEmpty() ? "La cola está vacía" : cola.peek()));
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 7:
                    System.out.println(miPila.isEmpty() ? "La pila está vacía" : "La pila tiene elementos");
                    break;

                case 8:
                    System.out.println(cola.isEmpty() ? "La cola está vacía" : "La cola tiene elementos");
                    break;

                case 9:
                    System.out.println("Número de elementos en la pila: " + miPila.size());
                    break;

                case 10:
                    System.out.println("Número de elementos en la cola: " + cola.size());
                    break;

                case 11:
                    System.out.println("Elementos en la pila: " + miPila);
                    System.out.println("Elementos en la cola: " + (cola.isEmpty() ? "La cola está vacía" : cola));
                    break;

                case 12:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }

        } while (opcion != 12);

        scanner.close();
    }
}
