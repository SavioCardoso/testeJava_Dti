package sistemamariana;

import java.util.*;
import java.text.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SistemaMariana {
    public static List<Cliente> listaCliente = new ArrayList<>();
    public static List<Consulta> listaConsulta = new ArrayList<>();
    public static List<Alimentos> listaGrupo1 = new ArrayList<>();
    public static List<Alimentos> listaGrupo2 = new ArrayList<>();
    public static List<Alimentos> listaGrupo3 = new ArrayList<>();
    public static Scanner tec = new Scanner(System.in);
    public static SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");

    public static void main(String[] args){
        
        exibirMenu();
    }
    
    public static void exibirMenu(){
        int opcao = 0;
       
        do{
            //Menu
            System.out.println("================ MENU ================");
            System.out.println("======================================");
            System.out.println("1 - Cadastrar cliente");
            System.out.println("2 - Visualizar clientes cadastrados");
            System.out.println("3 - Cadastrar consultas realizadas");
            System.out.println("4 - Visualizar consultas realizadas");
            System.out.println("5 - Visualizar alimentos");
            System.out.println("6 - Sair");
            System.out.println("======================================");

            opcao = Integer.parseInt(tec.nextLine());
            switch(opcao){
                case 1 : {
                    cadastrarCliente();
                    break;
                }
                case 2: {
                    visualizarCliente();
                    break;
                }
                case 3 : {
                    cadastrarConsulta();
                    break;
                }
                case 4 : {
                    visualizarConsulta();
                    break;
                }
                case 5 : {
                    visualizarAlimentos();
                    break;
                }
            }}while(opcao != 6);
        	System.exit(0);
            
    }
    
    public static void cadastrarCliente() {
        //Cadastro de Clientes
        System.out.println("======== CADASTRO DE CLIENTES ========");
        System.out.println("======================================");     
        //Nome do cliente
        String nomeCliente = receberNome();      
        
        //Email do cliente
        String emailCliente = receberEmail();       
        
        //Endereco do cliente
        String enderecoCliente = receberEndereco();      
        
        //Telefone do cliente
        String telefoneCliente = receberTelefone();
        
        //Data de nascimento do cliente
        Date dataNascimentoCliente = receberDataNascimento();
       
        //Settando Objeto cliente
        Cliente cliente = new Cliente(nomeCliente, enderecoCliente, telefoneCliente, emailCliente, dataNascimentoCliente);
        
        //Adicionando Objeto cliente na Lista listaCliente
        listaCliente.add(cliente);
    }
    
    public static void visualizarCliente(){
        System.out.println("======== CLIENTES CADASTRADOS ========");
        listaCliente.forEach(cliente -> {
            System.out.println("======================================");
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("Email: " + cliente.getEmail());
            System.out.println("Telefone: " + cliente.getTelefone());
            System.out.println("Endereco: " + cliente.getEndereco());
            System.out.println("Data de Nascimento: " +formatador.format(cliente.getDataNascimento()));
            System.out.println("======================================");
        });
    }
    
    public static void cadastrarConsulta(){
        
        //Cadastrar Consulta
        System.out.println("======== CADASTRO DE CONSULTAS =======");
        System.out.println("======================================");
        
        //Email do paciente
        Cliente paciente = receberEmailConsulta();
         if(paciente == null)
             exibirMenu();

        //Data da consulta
        Date dataConsulta = receberDataConsulta();

        //HorÃ¡rio da consulta
        String horarioConsulta = receberHorarioConsulta();

        //Peso do paciente
        Double pesoPaciente = receberPesoPaciente();

        //Percentual de gordura corporal do paciente
        Double gorduraCorporalPaciente = receberGorduraCorporalPaciente();

        //Sensacao fisica do paciente
        String sensacaoPaciente = receberSensacaoPaciente();

        //Quantidade de calorias por refeicao do paciente
        Double caloriasPaciente = receberCaloriasPaciente();
        
        //Settando Objeto consulta
        Consulta consulta = new Consulta(paciente, dataConsulta, horarioConsulta, pesoPaciente, gorduraCorporalPaciente, sensacaoPaciente, caloriasPaciente);
        
        //Adicionando Objeto consulta na Lista listaConsulta
        listaConsulta.add(consulta);
        
        exibirMenu();


        System.out.println("================ ERRO ================");
        System.out.println("======================================");
        System.out.println("Digite um email valido, ou 0 para voltar ao menu");
        System.out.println("======================================");
        cadastrarConsulta();
    }
    
    public static void visualizarConsulta(){
        System.out.println("======== CONSULTAS CADASTRADAS =======");
        System.out.println("======================================");
        listaConsulta.forEach(consulta -> {
            System.out.println("Nome do paciente: " + consulta.getPaciente().getNome());
            System.out.println("Data: " + formatador.format(consulta.getData()));
            System.out.println("Horario: " + consulta.getHorario());
            System.out.println("Peso: " + consulta.getPeso() + " Kg");
            System.out.println("Percentual de Gordura Corporal: " + consulta.getPercGordura() + "%");
            System.out.println("Sensacao fisica: " + consulta.getSensacao());
            System.out.println("Calorias: " + consulta.getQtdCalorias() + " Kcal");
            System.out.println("--------------------------------------");
            System.out.println("Dietas possiveis: ");
            calculoDieta(consulta);
            System.out.println("======================================");
        });
    }
    
    public static void visualizarAlimentos(){
    	setAlimentos();
        System.out.println("======== Alimentos do Grupo 1 ========");
        listaGrupo1.forEach(alimento1 ->{
            System.out.println("Nome: " + alimento1.getNome());
            System.out.println("Calorias: " + alimento1.getCalorias());
            System.out.println("======================================");
        });
        
        System.out.println("======== Alimentos do Grupo 2 ========");
        listaGrupo2.forEach(alimento2 -> {
            System.out.println("Nome: " + alimento2.getNome());
            System.out.println("Calorias: " + alimento2.getCalorias());
            System.out.println("======================================");
        });
        
        System.out.println("======== Alimentos do Grupo 3 ========");
        listaGrupo3.forEach(alimento3 -> {
            System.out.println("Nome: " + alimento3.getNome());
            System.out.println("Calorias: " + alimento3.getCalorias());
            System.out.println("======================================");
        });
    }
    
    public static List<String> calculoDieta(Consulta consulta){
    	setAlimentos();
        List<String> listaDieta = new ArrayList<>();
        
        listaGrupo3.forEach(alimento3 ->{
            listaGrupo2.forEach(alimento2 -> {
                listaGrupo1.forEach(alimento1 -> {
                    if (alimento3.getCalorias() + alimento2.getCalorias() + alimento1.getCalorias() <= consulta.getQtdCalorias()){
                        String elementoDieta = (alimento3.getNome() + ", " + alimento2.getNome() + ", " + alimento1.getNome() + "\n");
                        if(listaDieta.contains(elementoDieta) == false) {
                        	listaDieta.add(elementoDieta);
                        }
                    }
                });
            });
        });
        listaDieta.forEach(dieta -> {
        	System.out.println(dieta);
        });
        return listaDieta;
    }
     
    public static boolean validacaoEmail(String email) {
        boolean isEmailIdValido = false;
        if (email != null && email.length() > 0) {
            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) {
                isEmailIdValido = true;
            }
        }
        return isEmailIdValido;
    }
    
    public static boolean validacaoTelefone(String telefone) {
        boolean isTelefoneValido = false;
        if(telefone.length() > 7 && telefone.length() < 15){
            if(telefone.matches("[0-9]+")){
                isTelefoneValido = true;
            }
        }
        return isTelefoneValido;
    }
    
    public static String receberEmail(){
        System.out.println("Digite o email do cliente: ");
        String emailCliente = (tec.nextLine());
        while(!validacaoEmail(emailCliente)){
            System.out.println("================ ERRO ================");
            System.out.println("======================================");
            System.out.println("Email invalido, digite o email novamente");
            System.out.println("======================================");
            System.out.println("Digite o email do cliente: ");
            emailCliente = (tec.nextLine());
        }
        return emailCliente;
    }
    
    public static String receberNome(){
        System.out.println("Digite o nome do cliente: ");
        String nomeCliente = (tec.nextLine());
        if(nomeCliente.isEmpty()){
            System.out.println("================ ERRO ================");
            System.out.println("======================================");
            System.out.println("Campo nome vazio, digite um nome valido");
            System.out.println("======================================");
            return receberNome();
        } else return nomeCliente;
    }
    
    public static String receberEndereco(){
        System.out.println("Digite o endereco do cliente: ");
        String enderecoCliente = (tec.nextLine());
        if(enderecoCliente.isEmpty()) {
            System.out.println("================ ERRO ================");
            System.out.println("======================================");
            System.out.println("Campo nome vazio, digite um endereco valido");
            System.out.println("======================================");
            return receberEndereco();
        } return enderecoCliente;
    }
    
    public static String receberTelefone(){
        System.out.println("Digite o telefone do cliente: ");
        String telefoneCliente = (tec.nextLine());
            
        while(!validacaoTelefone(telefoneCliente)) {
            System.out.println("================ ERRO ================");
            System.out.println("======================================");
            System.out.println("Telefone invalido");
            System.out.println("======================================");
            System.out.println("Digite o telefone do cliente: ");
            telefoneCliente = tec.nextLine();
        }
        return telefoneCliente;
    }
    
    public static Date receberDataNascimento(){
        System.out.println("Data de nascimento do cliente");
        System.out.println("Dia: ");
        String dia = tec.nextLine();
        System.out.println("Mes: ");
        String mes = tec.nextLine();
        System.out.println("Ano: ");
        String ano = tec.nextLine();
        
        
        Date dataNascimento = null;
        
        try {
            dataNascimento = formatador.parse(dia + "/" + mes + "/" + ano);
            System.out.println("======================================");
            return dataNascimento;            
        } catch (ParseException ex) {
            System.out.println("================ ERRO ================");
            System.out.println("======================================");
            System.out.println("Digite apenas numeros nos campos de dia, mes e ano");
            System.out.println("======================================");
            return receberDataNascimento();
        }
    }
    
    public static Cliente receberEmailConsulta(){
        System.out.println("Email do paciente: ");
        String emailPaciente = tec.nextLine();
        
        //Verificacao de email (esta ou nao cadastrado em um cliente)
        while(!emailPaciente.equalsIgnoreCase("0")){
            for(Cliente cliente : listaCliente){
                if(cliente.getEmail().equalsIgnoreCase(emailPaciente)){
                    return cliente;
                }
            }
            System.out.println("================ ERRO ================");
            System.out.println("======================================");
            System.out.println("Digite um email cadstrado, ou 0 para voltar ao menu");
            System.out.println("======================================");
            System.out.println("Email do paciente: ");
            emailPaciente = tec.nextLine();
        }
        return null;
    }
    
    public static Date receberDataConsulta(){
        Date dataConsulta = null;
        System.out.println("Data da Consulta");
        System.out.println("Dia: ");
        String dia = tec.nextLine();
        System.out.println("Mes: ");
        String mes = tec.nextLine();
        System.out.println("Ano: ");
        String ano = tec.nextLine();
        try {
            dataConsulta = formatador.parse(dia + "/" + mes + "/" + ano);
        } catch (ParseException ex) {
            System.out.println("================ ERRO ================");
            System.out.println("======================================");
            System.out.println("Formato invalido de data, formato aceito (dd/MM/yyyy)");
            System.out.println("======================================");
            System.out.println("Data da Consulta");
            System.out.println("Dia: ");
            dia = tec.nextLine();
            System.out.println("Mes: ");
            mes = tec.nextLine();
            System.out.println("Ano: ");
            ano = tec.nextLine();
            
        }
        return dataConsulta;
    }
    
    public static String receberHorarioConsulta(){
        String horarioConsulta = null;
        
        System.out.println("Horario da Consulta");
        System.out.println("Hora: ");
        String hora = tec.nextLine();
        System.out.println("Minuto: ");
        String minuto = tec.nextLine();
        
        if(hora.matches("[0-9]+") && hora.length() == 2 && minuto.matches("[0-9]+") && minuto.length() == 2 && Integer.parseInt(hora) >= 0 && Integer.parseInt(hora) <= 23 && Integer.parseInt(minuto) >= 0 && Integer.parseInt(minuto) <= 59){
            horarioConsulta = (hora + ":" + minuto);
            return horarioConsulta;
        } else{
            System.out.println("================ ERRO ================");
            System.out.println("======================================");
            System.out.println("Formato invalido de hora, formato aceito (hh:mm)");
            System.out.println("======================================");
            return receberHorarioConsulta();
        }   
    }
    
    public static Double receberPesoPaciente(){
        System.out.println("Peso do paciente: ");
        String pesoPaciente = tec.nextLine();
        //Verifica se existem somente números e "." na String
        if(pesoPaciente.matches("^(-?)(0|([1-9][0-9]*))(\\.[0-9]+)?$")){
            if(Double.parseDouble(pesoPaciente) > 0){
               return Double.parseDouble(pesoPaciente);
            }else{
                System.out.println("================ ERRO ================");
                System.out.println("======================================");
                System.out.println("Digite um peso maior que 0");
                System.out.println("======================================");
                return receberPesoPaciente();
            }
        }else{
            System.out.println("================ ERRO ================");
            System.out.println("======================================");
            System.out.println("Digite apenas numeros no campo de peso");
            System.out.println("======================================");
            return receberPesoPaciente();
        }
    }
    
    public static Double receberGorduraCorporalPaciente(){
        System.out.println("Porcentagem de gordura corporal do paciente: ");
        String gorduraCorporal = tec.nextLine();
        //Verifica se existem somente números e "." na String
        if(gorduraCorporal.matches("^(-?)(0|([1-9][0-9]*))(\\.[0-9]+)?$")){
            if(Double.parseDouble(gorduraCorporal) > 0 && Double.parseDouble(gorduraCorporal) < 100){
               return Double.parseDouble(gorduraCorporal);
            }else{
                System.out.println("================ ERRO ================");
                System.out.println("======================================");
                System.out.println("Digite uma porcentagem de gordura corporal acima de 0 e abaixo de 100");
                System.out.println("======================================");
                return receberGorduraCorporalPaciente();
            }
        }else{
            System.out.println("================ ERRO ================");
            System.out.println("======================================");
            System.out.println("Digite apenas numeros no campo de porcentagem");
            System.out.println("======================================");
            return receberGorduraCorporalPaciente();
        }
    }
    
    public static String receberSensacaoPaciente(){
        System.out.println("Digite a sensacao fisica do paciente: ");
        String sensacao = (tec.nextLine());
        if(sensacao.isEmpty()){
            System.out.println("================ ERRO ================");
            System.out.println("======================================");
            System.out.println("Campo sensacao fisica vazio, digite a sensacao fisica do paciente");
            System.out.println("======================================");
            return receberSensacaoPaciente();
        } else return sensacao;
    }
    
    public static Double receberCaloriasPaciente(){
        System.out.println("Calorias por refeicao do paciente: ");
        String caloriasPaciente = tec.nextLine();
        //Verifica se existem somente números e "." na String
        if(caloriasPaciente.matches("^(-?)(0|([1-9][0-9]*))(\\.[0-9]+)?$")){
            if(Double.parseDouble(caloriasPaciente) > 0){
               return Double.parseDouble(caloriasPaciente);
            }else{
                System.out.println("================ ERRO ================");
                System.out.println("======================================");
                System.out.println("Digite uma caloria acima de 0");
                System.out.println("======================================");
                return receberCaloriasPaciente();
            }
        }else{
            System.out.println("================ ERRO ================");
            System.out.println("======================================");
            System.out.println("Digite apenas numeros no campo de caloria");
            System.out.println("======================================");
            return receberCaloriasPaciente();
        }
    }
    
    public static void setAlimentos() {
    	//Verifica se as listas estão vazias
    	if(listaGrupo1.size() != 0 && listaGrupo2.size() != 0 && listaGrupo3.size() != 0) {
    		return;
    	}
        listaGrupo1.add(new Alimentos("Leite desnatado", 50.0));
        listaGrupo1.add(new Alimentos("Banana", 60.0));
        listaGrupo1.add(new Alimentos("Iogurte", 100.0));
        listaGrupo2.add(new Alimentos("Arroz", 200.0));
        listaGrupo2.add(new Alimentos("Feijao", 250.0));
        listaGrupo2.add(new Alimentos("Macarrao", 300.0));
        listaGrupo3.add(new Alimentos("Batata frita", 400.0));
        listaGrupo3.add(new Alimentos("Chocolate", 500.0));
        listaGrupo3.add(new Alimentos("Pizza", 900.0));
    }
}

