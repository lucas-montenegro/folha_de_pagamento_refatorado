import java.util.ArrayList;

public class Hourly extends Employee {
    public int verifyHour(int hour) {
        if(hour >= 0 && hour < 24) {
            return 0;
        }
        System.out.println("Digite um valor válido!");
        return 1;
    }

    public int verifyMinute(int minute) {
        if(minute >= 0 && minute < 60) {
            return 0;
        }
        System.out.println("Digite um valor válido!");
        return 1;
    }

    public int enterEntryHour(Excecao excecao) {
        System.out.println("Digite a hora de entrada do funcionário:");
        int entryHour;
        while(true) {
            entryHour = excecao.loadInt();
            if(verifyHour(entryHour) == 0) { break; }
        }
        return entryHour;
    }

    public int enterDepartureHour(Excecao excecao) {
        System.out.println("Digite a hora de saída do funcionário:");
        int departureHour;
        while(true) {
            departureHour = excecao.loadInt();
            if(verifyHour(departureHour) == 0) { break; }
        }
        return departureHour;
    }

    public int enterEntryMinute(Excecao excecao) {
        System.out.println("Digite o minuto de entrada do funcionário:");
        int entryMinute;
        while(true) {
            entryMinute = excecao.loadInt();
            if(verifyMinute(entryMinute) == 0) { break; }
        }
        return entryMinute;
    }

    public int enterDepartureMinute(Excecao excecao) {
        System.out.println("Digite o minuto de saída do funcionário:");
        int departureMinute;
        while(true) {
            departureMinute = excecao.loadInt();
            if(verifyMinute(departureMinute) == 0) { break; }
        }
        return departureMinute;
    }

    public int calculateTotalHours(int entryHour, int entryMinute, int departureHour, int departureMinute) {
        int totalHours = 0;
        if (departureHour == entryHour) {
            totalHours = 24;
        } else if (entryHour > departureHour) {
            totalHours = 24 - entryHour + departureHour;
        } else {
            totalHours = departureHour - entryHour;
        }
        if (entryMinute > departureMinute) {
            totalHours--;
        }

        return totalHours;
    }

    public double calculatePaymentPerHour(double salary, int totalHours) {
        if (totalHours > 8) {
            return salary * 8 + (salary * 1.5 * (totalHours - 8));
        } else {
            return salary * totalHours;
        }
    }


    public void readTimecard(Employee employee) {
        int entryHour = enterEntryHour(employee.getExcecao());
        int entryMinute = enterEntryMinute(employee.getExcecao());
        int departureHour = enterDepartureHour(employee.getExcecao());
        int departureMinute = enterDepartureMinute(employee.getExcecao());
        int totalHours = calculateTotalHours(entryHour, entryMinute, departureHour, departureMinute);
        double money = calculatePaymentPerHour(employee.getSalary(), totalHours);
        employee.getGenericPayment().updateActualPayment(money, employee);
    }

    public void timecard(ArrayList<Employee> employees) {
        allEmployees(employees);
        System.out.println("Digite o id do funcionário que deseja lançar o cartão de ponto(apenas horistas):");
        int idToVerify = getExcecao().loadInt();
        Employee employee = searchEmployee(employees, idToVerify);
        if(employee == null || !(employee instanceof Hourly)) System.out.println("Não é possível lançar o cartão de ponto!");
        else {
            readTimecard(employee);
            System.out.println("Cartão de ponto adicionado com sucesso!");
        }
    }
}
