import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class UndoRedo {
    private Stack<ArrayList<Employee>> undoEmployee = new Stack<>();
    private Stack<ArrayList<Employee>> redoEmployee = new Stack<>();
    private Stack<Calendario> undoCalendario = new Stack<>();
    private Stack<Calendario> redoCalendario = new Stack<>();
    private Excecao excecao = new Excecao();

    public Excecao getExcecao() { return excecao; }

    public void setExcecao(Excecao excecao) { this.excecao = excecao; }

    public Stack<ArrayList<Employee>> getUndoEmployee() {
        return undoEmployee;
    }

    public void setUndoEmployee(Stack<ArrayList<Employee>> undoEmployee) {
        this.undoEmployee = undoEmployee;
    }

    public Stack<ArrayList<Employee>> getRedoEmployee() {
        return redoEmployee;
    }

    public void setRedoEmployee(Stack<ArrayList<Employee>> redoEmployee) {
        this.redoEmployee = redoEmployee;
    }

    public Stack<Calendario> getUndoCalendario() {
        return undoCalendario;
    }

    public void setUndoCalendario(Stack<Calendario> undoCalendario) {
        this.undoCalendario = undoCalendario;
    }

    public Stack<Calendario> getRedoCalendario() {
        return redoCalendario;
    }

    public void setRedoCalendario(Stack<Calendario> redoCalendario) {
        this.redoCalendario = redoCalendario;
    }

    public void copyArrayList(ArrayList<Employee> oldEmployee, ArrayList<Employee> newEmployee) {
        EmployeeIterator employeeIterator = new EmployeeIterator(newEmployee);
        oldEmployee.clear();

        while(employeeIterator.hasNext()) {
            Employee e = ((Employee)employeeIterator.next());
            if(e instanceof Assalaried) {
                Assalaried employee = new Assalaried();
                employee.copyEmployee(e, employee);
                oldEmployee.add(employee);
            }
            else if(e instanceof Commissioned) {
                Commissioned employee = new Commissioned();
                employee.copyEmployee(e, employee);
                employee.setCommission(((Commissioned) e).getCommission());
                oldEmployee.add(employee);
            }
            else if(e instanceof Hourly) {
                Hourly employee = new Hourly();
                employee.copyEmployee(e, employee);
                oldEmployee.add(employee);
            }
        }
    }

    public void clearRedo() {
        redoEmployee.clear();
        redoCalendario.clear();
    }

    public void addUndo(ArrayList<Employee> employees, Calendario calendario) {
        ArrayList<Employee> auxiliar = new ArrayList<>();
        copyArrayList(auxiliar, employees);
        undoEmployee.push(auxiliar);
        Calendario auxiliar2 = new Calendario();
        auxiliar2.copy(calendario, auxiliar2);
        undoCalendario.push(auxiliar2);
    }

    public void addRedo() {
        ArrayList<Employee> auxiliar = new ArrayList<>();
        copyArrayList(auxiliar, undoEmployee.peek());
        redoEmployee.push(auxiliar);
        Calendario auxiliar2 = new Calendario();
        auxiliar2.copy(undoCalendario.peek(), auxiliar2);
        redoCalendario.push(auxiliar2);
    }

    public void removeUndo() {
        undoEmployee.pop();
        undoCalendario.pop();
    }

    public void removeRedo() {
        redoEmployee.pop();
        redoCalendario.pop();
    }

    public int verifyUndoRedo() {
        int option = 0;
        while(true) {
            System.out.printf("(0) - Encerrar\n(1) - Undo\n(2) - Redo\n");
            option = excecao.loadInt();
            if(option >= 0 && option <= 2) {
                break;
            }
            System.out.println("Digite um valor válido!");
        }
        return option;
    }

    public void tryUndo() {
        if (undoEmployee.size() > 1 && undoCalendario.size() > 1) {
            addRedo();
            removeUndo();
            System.out.println("Undo efetuado com sucesso!");
        } else {
            System.out.println("Não foi possível realizar o Undo!");
        }
    }

    public void tryRedo() {
        if (redoEmployee.size() > 0 && redoCalendario.size() > 0) {
            addUndo(redoEmployee.peek(), redoCalendario.peek());
            removeRedo();
            System.out.println("Redo efetuado com sucesso!");
        } else {
            System.out.println("Não foi possível realizar o Redo!");
        }
    }


    public void doUndoRedo(ArrayList<Employee> employees, Calendario calendario) {
        int option = verifyUndoRedo();
        while(option != 0) {
            if(option == 1) { tryUndo(); }
            else if(option == 2) { tryRedo(); }
            option = verifyUndoRedo();
        }

        System.out.println("Undo/Redo encerrado!");
        copyArrayList(employees, undoEmployee.peek());
        calendario.copy(undoCalendario.peek(), calendario);
    }
}
