import java.util.ArrayList;

public class VerifyCorrectInput {
    private Excecao excecao = new Excecao();
    public int verifyId(ArrayList<Employee> employees, int id) {
        int code = 0;
        for (Employee e : employees) {
            if (e.getId() == id) {
                code = 1;
                break;
            }
        }
        return code;
    }

    public int verifySalary(double salary) {
        if (salary >= 0) {
            return 0;
        }
        System.out.println("Digite um valor válido para o salário!");
        return 1;
    }

    public int verifyPaymentMethod(int paymentMethod) {
        if (paymentMethod > 0 && paymentMethod < 4) {
            return 0;
        }
        System.out.println("Digite um valor válido para o metódo de pagamento!");
        return 1;
    }

    public int verifyOptionSyndicate(int optionSyndicate) {
        if (optionSyndicate == 0 || optionSyndicate == 1) {
            return 0;
        }
        System.out.println("Digite um valor válido para a opção de sindicato!");
        return 1;
    }

    public int verifyIdSyndicate(ArrayList<Employee> employees, int idSyndicate) {
        int code = 0;
        for (Employee e : employees) {
            if (e.getSindycate().getIdSyndicate() == idSyndicate) {
                code = 1;
                break;
            }
        }
        return code;
    }

    public int verifySyndicateTax(double syndicateTax) {
        if (syndicateTax >= 0) {
            return 0;
        }
        System.out.println("Digite um valor válido para a taxa de sindicato!");
        return 1;
    }

    public int verifyActualPayment(double actualPayment) {
        if (actualPayment >= 0) {
            return 0;
        }
        System.out.println("Digite um valor válido!");
        return 1;
    }

    public int verifyServiceTax(double serviceTax) {
        if (serviceTax >= 0) {
            return 0;
        }
        System.out.println("Digite um valor válido!");
        return 1;
    }

    public int verifyEmployee(int option) {
        if (option > 0 && option < 4) {
            return 0;
        }
        System.out.println("Digite um valor válido!");
        return 1;
    }

    public int verifyCommission(double commission) {
        if (commission >= 0) {
            return 0;
        }
        System.out.println("Digite um valor válido!");
        return 1;
    }

    public int verifyMenuOption() {
        int option = 0;
        while(true) {
            System.out.printf("Escolha uma opção:\n(0) - Sair\n(1) - Adicionar um empregado\n(2) - Remover um empregado\n(3) - Lançar cartão de ponto\n(4) - Lancar uma venda\n(5) - Adicionar taxa de serviço\n(6) - Alterar dados\n(7) - Rodar a folha de pagamento\n(8) - Undo/Redo\n(9) - Aderir à uma agenda de pagamento\n(10) - Criar uma nova agenda de pagamento\n");
            option = excecao.loadInt();
            if(option >= 0 && option <= 10) {
                break;
            }
            System.out.println("Digite um valor válido!");
        }

        return option;
    }

    public int verifyInitialDay() {
        int option = 0;
        System.out.println("Digite o primeiro dia do ano:");
        while(true) {
            System.out.printf("(1) - Segunda\n(2) - Terça\n(3) - Quarta\n(4) - Quinta\n(5) - Sexta\n(6) - Sábado\n(7) - Domingo\n");
            option = excecao.loadInt();
            if(option >= 1 && option <= 7) {
                break;
            }
            System.out.println("Digite um valor válido!");
        }
        return option;
    }

    public int verifyWeekDay() {
        int option = 0;
        System.out.println("Digite o dia da semana atual:");
        while(true) {
            System.out.printf("(1) - Segunda\n(2) - Terça\n(3) - Quarta\n(4) - Quinta\n(5) - Sexta\n(6) - Sábado\n(7) - Domingo\n");
            option = excecao.loadInt();
            if(option >= 1 && option <= 7) {
                break;
            }
            System.out.println("Digite um valor válido!");
        }
        return option;
    }

    public int verifyDay() {
        int option = 0;
        while(true) {
            System.out.println("Digite o dia atual:");
            option = excecao.loadInt();
            if(option >= 1 && option <= 31) {
                break;
            }
            System.out.println("Digite um valor válido!");
        }
        return option;
    }

    public int verifyMonth() {
        int option = 0;
        while(true) {
            System.out.println("Digite o mês atual:");
            option = excecao.loadInt();
            if(option >= 1 && option <= 12) {
                break;
            }
            System.out.println("Digite um valor válido!");
        }
        return option;
    }

    public int verifyYear() {
        int option = 0;
        while(true) {
            System.out.println("Digite o ano atual:");
            option = excecao.loadInt();
            if(option >= 0 && option <= 100000000) {
                break;
            }
            System.out.println("Digite um valor válido!");
        }
        return option;
    }

    public int verifyPaymentSchedule() {
        int option = 0;
        while(true) {
            System.out.printf("Aderir a esta agenda?\n(0) - Não\n(1) - Sim\n");
            option = excecao.loadInt();
            if (option >= 0 && option <= 1) {
                break;
            }
            System.out.println("Digite um valor válido!");
        }

        return option;
    }

    public int verifyPaymentScheduleType() {
        int option = 0;
        System.out.println("Qual o tipo de agenda que o funcionário irá seguir?");
        while(true) {
            System.out.printf("(1) - Mensal\n(2) - Bi-semanal\n(3) - Semanal\n");
            option = excecao.loadInt();
            if (option >= 1 && option <= 3) {
                break;
            }
            System.out.println("Digite um valor válido!");
        }

        return option;
    }

    public int verifyDayMonth() {
        int option = 0;
        System.out.println("Digite o dia que será pago mensalmente, podendo escolher até o dia 28, caso deseje que o pagamento seja no último dia útil do mês digite -1:");
        while(true) {
            option = excecao.loadInt();
            if ((option >= 1 && option <= 28) || option == -1) {
                break;
            }
            System.out.println("Digite um valor válido!");
        }

        return option;
    }

    public int verifyDayBiWeekly() {
        int option = 0;
        System.out.println("Digite o dia que será pago bi-semanalmente:");
        while(true) {
            System.out.printf("(1) - Segunda\n(2) - Terça\n(3) - Quarta\n(4) - Quinta\n(5) - Sexta\n(6) - Sábado\n(7) - Domingo\n");
            option = excecao.loadInt();
            if (option >= 1 && option <= 7) {
                break;
            }
            System.out.println("Digite um valor válido!");
        }

        return option;
    }

    public int verifyDayWeekly() {
        int option = 0;
        System.out.println("Digite o dia que será pago semanalmente:");
        while(true) {
            System.out.printf("(1) - Segunda\n(2) - Terça\n(3) - Quarta\n(4) - Quinta\n(5) - Sexta\n(6) - Sábado\n(7) - Domingo\n");
            option = excecao.loadInt();
            if (option >= 1 && option <= 7) {
                break;
            }
            System.out.println("Digite um valor válido!");
        }

        return option;
    }
}
