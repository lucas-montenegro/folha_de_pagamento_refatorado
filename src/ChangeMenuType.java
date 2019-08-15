public enum ChangeMenuType {
    CHANGENAMEOPTION{
        @Override
        public ChangeDataMenu obterTipoChangeDataMenu() {
            return new ChangeNameOption();
        }
    },
    CHANGEADRESSOPTION{
        @Override
        public ChangeDataMenu obterTipoChangeDataMenu() {
            return new ChangeAdressOption();
        }
    },
    CHANGESALARYOPTION{
        @Override
        public ChangeDataMenu obterTipoChangeDataMenu() {
            return new ChangeSalaryOption();
        }
    },
    CHANGEIDOPTION{
        @Override
        public ChangeDataMenu obterTipoChangeDataMenu() {
            return new ChangeIdOption();
        }
    },
    CHANGENEXTPAYMENTOPTION{
        @Override
        public ChangeDataMenu obterTipoChangeDataMenu() {
            return new ChangeNextPaymentOption();
        }
    },
    CHANGESYNDICATEPARTICIPATIONOPTION{
        @Override
        public ChangeDataMenu obterTipoChangeDataMenu() {
            return new ChangeSyndicateParticipation();
        }
    },
    CHANGESYNDICATEIDOPTION{
        @Override
        public ChangeDataMenu obterTipoChangeDataMenu() {
            return new ChangeSyndicateId();
        }
    },
    CHANGESYNDICATETAXOPTION{
        @Override
        public ChangeDataMenu obterTipoChangeDataMenu() {
            return new ChangeSyndicateTax();
        }
    },
    CHANGESERVICETAXOPTION{
        @Override
        public ChangeDataMenu obterTipoChangeDataMenu() {
            return new ChangeServiceTax();
        }
    },
    CHANGEPAYMENTMETHODOPTION{
        @Override
        public ChangeDataMenu obterTipoChangeDataMenu() {
            return new ChangePaymentMethod();
        }
    },
    CHANGEEMPLOYEETYPEOPTION{
        @Override
        public ChangeDataMenu obterTipoChangeDataMenu() {
            return new ChangeEmployeeType();
        }
    };

    public abstract ChangeDataMenu obterTipoChangeDataMenu();
}
