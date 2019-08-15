<h1>Projeto de folha de pagamento</h1>
<h2>Funcionamento</h2>
-> A main serve apenas para chamar a classe que irá rodar todo o programa.<br>
-> Ao selecionar a opção de modificar um empregado, se você digitar qualquer número inteiro diferente de 1(um) ao ser questionado sobre a mudança de um atributo, significa que você não deseja realizar tal alteração.<br> 
-> Ao modificar um tipo de funcionário, a quantidade de dias para o pagamento será recalculado.<br>
-> Ao modificar uma agenda de pagamento, o funcionário receberá no dia que estava previsto para o pagamento e após receber o pagamento é que ele será reajustado de acordo com a nova agenda.<br>
-> O undo e redo funcionam para as funcionalidades de 1 a 7.<br>
-> O programa da folha de pagamento foi rodado utilizando o IntelliJ.<br><br>

<h2>Estratégias utilizadas no refatoramento</h2>
<h3>Strategy</h3>
<b>O strategy foi uma das estratégias utilizadas para reduzir os condicionais dos menus utilizados. As seguintes classes fazem parte do strategy:</b><br><br>
-> Menu (interface)<br>
-> AddEmployeeOption (implementa Menu)<br>
-> RemoveEmployeeOption (implementa Menu)<br>
-> AddPaymentScheduleOption (implementa Menu)<br>
-> AddSaleOption (implementa Menu)<br>
-> AddServiceOption (implementa Menu)<br>
-> ChangeEmployeeDataOption (implementa Menu)<br>
-> JoinPaymentScheduleOption (implementa Menu)<br>
-> PayrollOption (implementa Menu)<br>
-> TimecardOption (implementa Menu)<br>
-> UndoRedoOption (implementa Menu)<br>
-> SystemMenuType (enum de Menu)<br>
--------------------------------------------------------<br>
-> ChangeDataMenu (interface)<br>
-> ChangeAdressOption (implementa ChangeDataMenu)<br>
-> ChangeCommission (implementa ChangeDataMenu)<br>
-> ChangeEmployeeType (implementa ChangeDataMenu)<br>
-> ChangeIdOption (implementa ChangeDataMenu)<br>
-> ChangeNameOption (implementa ChangeDataMenu)<br>
-> ChangeNextPaymentOption (implementa ChangeDataMenu)<br>
-> ChangePaymentMethod (implementa ChangeDataMenu)<br>
-> ChangeSalaryOption (implementa ChangeDataMenu)<br>
-> ChangeServiceTax (implementa ChangeDataMenu)<br>
-> ChangeSyndicateId (implementa ChangeDataMenu)<br>
-> ChangeSyndicateParticipation (implementa ChangeDataMenu)<br>
-> ChangeSyndicateTax (implementa ChangeDataMenu)<br>
-> ChangeMenuType (enum de ChangeDataMenu)<br><br>

<h3>Iterator</h3>
<b>O iterator foi uma das estratégias utilizadas. As seguintes classes fazem parte do iterator:</b><br><br>
-> Iterator (interface)<br>
-> CalendaryIterator (implementa iterator)<br>
-> EmployeeIterator (implementa iterator)<br>
-> PaymentScheduleIterator (implementa iterator)<br><br>

<h3>Extract Method</h3>
<b>O extract method foi uma das estratégias utilizadas. Foi utilizada o extract method em quase todas as classes, mas as seguintes foram as mais significativas:</b><br><br>
-> Employee<br>
-> SystemMenu<br>
-> Calendario<br>
-> Commissioned<br>
-> Hourly<br>
-> Payment<br>
-> UndoRedo<br><br>

<h3>Extract Class</h3>
<b>O extract class foi uma das estratégias utilizadas. Foi utilizada o extract class em um caso, o qual foi criado a classe VerifyCorrectInput para abrigar vários métodos de verificação que estavam em inúmeras classes:</b><br><br>
-> VerifyCorrectInput (criado para armazenar os métodos de verificação)<br><br>

<h3>Singleton</h3>
<b>O singleton foi uma das estratégias utilizadas. As seguintes classes fazem parte do singleton:</b><br><br>
-> SingletonCalendario<br>
-> SingletonPaymentSchedule<br>
-> SingletonUndoRedo<br>
