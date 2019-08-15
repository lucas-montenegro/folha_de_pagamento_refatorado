public enum SystemMenuType {

    ADDOPTION {
        public Menu obterTipoMenu() {
            return new AddEmployeeOption();
        }
    },
    REMOVEOPTION {
        public Menu obterTipoMenu() {
            return new RemoveEmployeeOption();
        }
    },
    TIMECARDOPTION {
        public Menu obterTipoMenu() {
            return new TimecardOption();
        }
    },
    ADDSALEOPTION {
        public Menu obterTipoMenu() {
            return new AddSaleOption();
        }
    },
    ADDSERVICEOPTION {
        public Menu obterTipoMenu() {
            return new AddServiceOption();
        }
    },
    CHANGEDATAOPTION {
        public Menu obterTipoMenu() {
            return new ChangeEmployeeDataOption();
        }
    },
    PAYROLLOPTION {
        public Menu obterTipoMenu() {
            return new PayrollOption();
        }
    },
    UNDOREDOOPTION {
        public Menu obterTipoMenu() {
            return new UndoRedoOption();
        }
    },
    JOINSCHEDULEOPTION {
        public Menu obterTipoMenu() {
            return new JoinPaymentScheduleOption();
        }
    },
    ADDSCHEDULEOPTION {
        public Menu obterTipoMenu() {
            return new AddPaymentScheduleOption();
        }
    };

    public abstract Menu obterTipoMenu();
}
