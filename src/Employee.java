import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

// tirar algumas coisas do sindicato que estão aqui e botar na classe sindicato. EX: newsyndicatetax... etc

public class Employee {
    private String name;
    private String address;
    private int id;
    private double salary;
    private double actualPayment;
    private int paymentMethod;
    private int daysToPayment;
    private int scheduleOption;
    private Syndicate syndicate = new Syndicate();
    private PaymentSchedule paymentSchedule = new PaymentSchedule();
    private GenericPayment genericPayment = new GenericPayment();
    private Excecao excecao = new Excecao();
    private VerifyCorrectInput verifyCorrectInput = new VerifyCorrectInput();
    Random generator = new Random();

    public VerifyCorrectInput getVerifyCorrectInput() { return verifyCorrectInput; }

    public void setVerifyCorrectInput(VerifyCorrectInput verifyCorrectInput) { this.verifyCorrectInput = verifyCorrectInput; }

    public Syndicate getSindycate() {
        return syndicate;
    }

    public void setSindycate(Syndicate sindycate) {
        this.syndicate = sindycate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getActualPayment() {
        return actualPayment;
    }

    public void setActualPayment(double actualPayment) {
        this.actualPayment = actualPayment;
    }

    public int getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(int paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public int getDaysToPayment() {
        return daysToPayment;
    }

    public void setDaysToPayment(int daysToPayment) {
        this.daysToPayment = daysToPayment;
    }

    public int getScheduleOption() {
        return scheduleOption;
    }

    public void setScheduleOption(int scheduleOption) {
        this.scheduleOption = scheduleOption;
    }

    public PaymentSchedule getPaymentSchedule() {
        return paymentSchedule;
    }

    public void setPaymentSchedule(PaymentSchedule paymentSchedule) {
        this.paymentSchedule = paymentSchedule;
    }

    public Excecao getExcecao() {
        return excecao;
    }

    public void setExcecao(Excecao excecao) {
        this.excecao = excecao;
    }

    public GenericPayment getGenericPayment() {
        return genericPayment;
    }

    public void setGenericPayment(GenericPayment genericPayment) {
        this.genericPayment = genericPayment;
    }

    public void allEmployees(ArrayList<Employee> employees) {
        EmployeeIterator employeeIterator = new EmployeeIterator(employees);
        while(employeeIterator.hasNext()) {
            Employee e = ((Employee)employeeIterator.next());
            System.out.printf("Nome: %s\n", e.getName());
            System.out.printf("ID: %d\n", e.getId());
            System.out.printf("ID Sindicato: %d\n", e.getSindycate().getIdSyndicate());
            System.out.printf("-------------\n\n");
        }
    }

    public Employee searchEmployee(ArrayList<Employee> employees, int id) {
        EmployeeIterator employeeIterator = new EmployeeIterator(employees);
        while (employeeIterator.hasNext()) {
            Employee e = ((Employee) employeeIterator.next());
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }

    public void copyEmployee(Employee oldEmployee, Employee newEmployee) {
        newEmployee.setName(oldEmployee.getName());
        newEmployee.setAddress(oldEmployee.getAddress());
        newEmployee.setId(oldEmployee.getId());
        newEmployee.setSalary(oldEmployee.getSalary());
        newEmployee.setActualPayment(oldEmployee.getActualPayment());
        newEmployee.setPaymentMethod(oldEmployee.getPaymentMethod());
        newEmployee.setSindycate(oldEmployee.getSindycate());
        newEmployee.setDaysToPayment(oldEmployee.getDaysToPayment());
        newEmployee.setPaymentSchedule(oldEmployee.getPaymentSchedule());
    }

    public void newName(Employee employee) {
        System.out.println("Digite o seu nome:");
        String name = excecao.loadString();
        employee.setName(name);
    }

    public void newAddress(Employee employee) {
        System.out.println("Digite o seu endereço:");
        String address = excecao.loadString();
        employee.setAddress(address);
    }

    public void newId(Employee employee, ArrayList<Employee> employees) {
        int id;
        System.out.println("Digite o valor do ID:");
        while (true) {
            id = excecao.loadInt();
            if (verifyCorrectInput.verifyId(employees, id) == 0) {
                break;
            }
        }
        employee.setId(id);
    }

    public void generateId(Employee employee, ArrayList<Employee> employees) {
        int id;
        while (true) {
            id = generator.nextInt(1000000000);
            if (verifyCorrectInput.verifyId(employees, id) == 0) {
                break;
            }
        }
        employee.setId(id);
    }

    public void newIdSyndicate(Syndicate syndicate, ArrayList<Employee> employees) {
        int idSyndicate;
        System.out.println("Digite o valor do ID de sindicato:");
        if (syndicate.getOptionSyndicate() == 0) {
            syndicate.setIdSyndicate(-1);
            return;
        }
        while (true) {
            idSyndicate = excecao.loadInt();
            if (verifyCorrectInput.verifyIdSyndicate(employees, idSyndicate) == 0) {
                break;
            }
        }
        syndicate.setIdSyndicate(idSyndicate);
    }

    public void generateIdSyndicate(Syndicate syndicate, ArrayList<Employee> employees) {
        int idSyndicate;
        if (syndicate.getOptionSyndicate() == 0) {
            syndicate.setIdSyndicate(-1);
            return;
        }
        while (true) {
            idSyndicate = generator.nextInt(1000000000);
            if (verifyCorrectInput.verifyIdSyndicate(employees, idSyndicate) == 0) {
                break;
            }
        }
        syndicate.setIdSyndicate(idSyndicate);
    }

    public void newSalary(Employee employee) {
        double salary;
        System.out.println("Digite o seu salário:");
        while (true) {
            salary = excecao.loadDouble();
            verifyCorrectInput.verifySalary(salary);
            if (verifyCorrectInput.verifySalary(salary) == 0) {
                break;
            }
        }
        employee.setSalary(salary);
    }

    public void newPaymentMethod(Employee employee) {
        int paymentMethod;
        System.out.println("Digite o método de pagamento:");
        System.out.printf("(1) - Cheque pelos correios\n(2) - Cheque em mãos\n(3) - Depósito na conta bancária\n");
        while (true) {
            paymentMethod = excecao.loadInt();
            if (verifyCorrectInput.verifyPaymentMethod(paymentMethod) == 0) {
                break;
            }
        }
        employee.setPaymentMethod(paymentMethod);
    }

    public void newSyndicateOption(Syndicate syndicate) {
        int optionSyndicate;
        System.out.printf("(0) - Não pertence ao sindicato\n(1) - Pertence ao sindicato\n");
        while (true) {
            optionSyndicate = excecao.loadInt();
            if (verifyCorrectInput.verifyOptionSyndicate(optionSyndicate) == 0) {
                break;
            }
        }
        syndicate.setOptionSyndicate(optionSyndicate);
    }

    public void newSyndicateTax(Syndicate syndicate) {
        double syndicateTax;
        if (syndicate.getOptionSyndicate() == 0) {
            syndicate.setSyndicateTax(0);
            return;
        }
        System.out.println("Digite a taxa do sindicato:");
        while (true) {
            syndicateTax = excecao.loadDouble();
            if (verifyCorrectInput.verifySyndicateTax(syndicateTax) == 0) {
                break;
            }
        }
        syndicate.setSyndicateTax(syndicateTax);
    }

    public void newActualPayment(Employee employee) {
        double actualPayment;
        System.out.println("Digite o novo contracheque:");
        while (true) {
            actualPayment = excecao.loadDouble();
            if (verifyCorrectInput.verifyActualPayment(actualPayment) == 0) {
                break;
            }
        }
        employee.setActualPayment(actualPayment);
    }

    public void newServiceTax(Syndicate syndicate) {
        double serviceTax;
        System.out.println("Digite a nova quantia da taxa de serviço:");
        while (true) {
            serviceTax = excecao.loadDouble();
            if (verifyCorrectInput.verifyServiceTax(serviceTax) == 0) {
                break;
            }
        }
        syndicate.setServiceTax(serviceTax);
    }

    public Employee createEmployee() {
        int option;
        System.out.printf("Digite o tipo de empregado:\n(1) - Assalariado\n(2) - Comissionado\n(3) - Horista\n");
        while (true) {
            option = excecao.loadInt();
            if (verifyCorrectInput.verifyEmployee(option) == 0) {
                break;
            }
        }
        if (option == 1) {
            Assalaried employee = new Assalaried();
            return employee;
        } else if (option == 2) {
            Commissioned employee = new Commissioned();
            return employee;
        } else {
            Hourly employee = new Hourly();
            return employee;
        }
    }

    public void removeRestartAndAddEmployee(ArrayList<Employee> employees, Employee employee, Employee newEmployee, Calendario calendario) {
        employees.remove(employee);
        getGenericPayment().restartPayment(newEmployee, calendario);
        employees.add(newEmployee);
    }

    public Syndicate createSyndicate(ArrayList<Employee> employees) {
        Syndicate newSyndicate = new Syndicate();
        newSyndicateOption(newSyndicate);
        generateIdSyndicate(newSyndicate, employees);
        newSyndicateTax(newSyndicate);
        newSyndicate.setServiceTax(0);

        return newSyndicate;
    }


    public Employee addEmployee(ArrayList<Employee> employees, PaymentSchedule paymentSchedule, Calendario calendario) {
        Employee employee = createEmployee();
        employee.setPaymentSchedule(paymentSchedule);
        newName(employee);
        newAddress(employee);
        generateId(employee, employees);
        newSalary(employee);
        newPaymentMethod(employee);
        Syndicate syndicate = createSyndicate(employees);
        employee.setSindycate(syndicate);
        if(employee instanceof Commissioned) {((Commissioned) employee).newCommission(((Commissioned) employee)); }
        employee.getGenericPayment().restartPayment(employee, calendario);
        employee.getGenericPayment().restartAcutalPayment(employee);
        System.out.println("Empregado adicionado com sucesso!");
        return employee;
    }


    public void removeEmployee(ArrayList<Employee> employees) {
        allEmployees(employees);
        System.out.println("Digite o id do funcionário que deseja remover:");
        int idToRemove = excecao.loadInt();
        Employee employee = searchEmployee(employees, idToRemove);
        if (employee == null) System.out.println("Funcionário não pôde ser removido!");
        else {
            employees.remove(employee);
            System.out.println("Funcionário removido com sucesso!");
        }
    }


    public void changeData(ArrayList<Employee> employees, Employee oldEmployee) {
        int counter = 0;
        ChangeMenuType changeMenuType;
        while (counter < 11) {
            changeMenuType = ChangeMenuType.values()[counter];
            ChangeDataMenu changeDataOption = changeMenuType.obterTipoChangeDataMenu();
            changeDataOption.makeChange(oldEmployee, employees);
            counter++;
        }

        System.out.println("Alterações completas!");
    }

    public void changeEmployeeData(ArrayList<Employee> employees){
        allEmployees(employees);
        System.out.println("Digite o id do funcionário que deseja alterar os dados:");
        int idToChange = excecao.loadInt();
        Employee oldEmployee = searchEmployee(employees, idToChange);
        if(oldEmployee == null) { System.out.println("Não pôde alterar os dados!"); }
        else { changeData(employees, oldEmployee); }
    }
}