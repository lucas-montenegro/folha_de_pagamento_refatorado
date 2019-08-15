public abstract class Payment {
    public void showPaymentMethod(Employee employee) {
        if (employee.getPaymentMethod() == 1) { System.out.printf("Recebeu o pagamento através de um cheque para %s\n\n", employee.getAddress()); }
        else if (employee.getPaymentMethod() == 2) { System.out.println("Recebeu o pagamento através de um cheque em mãos\n\n"); }
        else if (employee.getPaymentMethod() == 3) { System.out.println("Recebeu o pagamento através de um depósito na conta bancária\n\n"); }
    }

    public void restartPayment(Employee employee, Calendario calendario) {
        if(employee instanceof Assalaried) { employee.setScheduleOption(1); }
        else if(employee instanceof Commissioned) { employee.setScheduleOption(2); }
        else if(employee instanceof Hourly) { employee.setScheduleOption(3); }
        employee.getGenericPayment().calculateNextPayment(calendario, employee);
    }

    public void restartAcutalPayment(Employee employee) {
        if (employee instanceof Assalaried) { employee.setActualPayment(employee.getSalary()); }
        else if (employee instanceof Commissioned) { employee.setActualPayment(employee.getSalary() / 2); }
        else if (employee instanceof Hourly) { employee.setActualPayment(0); }
    }

    public void updateActualPayment(double money, Employee employee){
        employee.setActualPayment(employee.getActualPayment() + money);
    }

    public void calculateNextMonthlyPayment(Employee employee, Calendario calendario, int dayOfWeek) {
        int daysToPayment = 0, dayOfPayment = employee.getPaymentSchedule().getDayMonth();
        int initialDay = calendario.getInitialDay();
        int day = calendario.getDay();
        int month = calendario.getMonth();
        int [][] calendary = calendario.getCalendary();

        if (month < 12) {
            if (dayOfPayment == -1) {
                daysToPayment = (calendary[month - 1][2] - day) + calendary[month][1];
            } else {
                daysToPayment = (calendary[month - 1][2] - day) + dayOfPayment;
            }
        } else {
            int auxDayOfWeek = (dayOfWeek + (31 - day) + 1) % 7;
            calendario.setInitialDay(auxDayOfWeek);
            if (dayOfPayment == -1) {
                daysToPayment = (31 - day) + calendary[1][1];
            } else {
                daysToPayment = (31 - day) + dayOfPayment;
            }
            calendario.setInitialDay(initialDay);
            calendario.initializeCalendary();
        }

        employee.setDaysToPayment(daysToPayment);
    }

    public void calculateNextBiWeeklyPayment(Employee employee, int dayOfWeek) {
        int daysToPayment = 0, dayOfPayment = employee.getPaymentSchedule().getDayBiWeekly();

        if (dayOfWeek % 7 == dayOfPayment % 7) {
            daysToPayment = 14;
        } else if ((dayOfWeek % 7) > (dayOfPayment % 7)) {
            daysToPayment = (dayOfPayment - (dayOfWeek % 7)) + 21;
        } else if ((dayOfWeek % 7) < (dayOfPayment % 7)) {
            daysToPayment = (dayOfPayment - (dayOfWeek % 7)) + 14;
        }

        employee.setDaysToPayment(daysToPayment);
    }

    public void calculateNextWeeklyPayment(Employee employee, Calendario calendario, int dayOfWeek) {
        int daysToPayment = 0, dayOfPayment = employee.getPaymentSchedule().getDayWeekly();
        if (calendario.getDayOfWeek() % 7 == dayOfPayment % 7) {
            daysToPayment = 7;
        } else if ((dayOfWeek % 7) > (dayOfPayment % 7)) {
            daysToPayment = (dayOfPayment - (dayOfWeek % 7)) + 14;
        } else if ((dayOfWeek % 7) < (dayOfPayment % 7)) {
            daysToPayment = (dayOfPayment - (dayOfWeek % 7)) + 7;
        }

        employee.setDaysToPayment(daysToPayment);
    }


    public void calculateNextPayment(Calendario calendario, Employee employee) {
        int dayOfWeek = calendario.getDayOfWeek();
        int scheduleOption = employee.getScheduleOption();

        if (scheduleOption == 3) { calculateNextWeeklyPayment(employee, calendario, dayOfWeek);
        } else if (scheduleOption == 2) { calculateNextBiWeeklyPayment(employee, dayOfWeek);
        } else if (scheduleOption == 1) { calculateNextMonthlyPayment(employee, calendario, dayOfWeek); }
    }
}
