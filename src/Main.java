import java.util.Date;

public class Main {
    public static void main(String[] args) {

        Cliente joao = new PessoaFisica("João", "Av. Antonio Carlos, 6627",
                new Date(), "111.111.111-11", 36, 'm');

        Cliente icaro = new PessoaFisica("Icaro", "Rua Carlos torrezani, 367",
                new Date(), "111.111.111-12", 16, 'm');

        Cliente lojinha = new PessoaJuridica("Loja R$1,99", "Av. Afonso Pena, 3000",
                new Date(), "000.00000.0000/0001", 25, "Comércio");

        Cliente mercado = new PessoaJuridica("Mercadão do seu zé", "Av. Antonio Carlos, 1997",
                new Date(), "000.00000.0000/0005", 5, "Comércio");


        OperacaoDeposito deposito = new OperacaoDeposito(5000);
        OperacaoSaque saque = new OperacaoSaque(2500);

        System.out.println(deposito.toString());
        System.out.println(saque.toString());

        Conta conta1 = new Conta(1234,joao, 0, 1500);
        Conta conta2 = new Conta(1234, lojinha, 10000, 1500);

        conta1.depositar(3000);
        conta1.depositar(2000);
        conta1.sacar(500);

        conta2.transferir(conta1, 777);
        conta2.depositar(234);

        System.out.println("=========CLIENTES PESSOA FÍSICA=========\n========================================\n");

        System.out.println(joao.toString());
        System.out.println(icaro.toString());

        System.out.println("=========CLIENTES PESSOA JURÍDICA=========\n==========================================\n");

        System.out.println(lojinha.toString());
        System.out.println(mercado.toString());

        System.out.println("=========CONTAS=========\n========================\n");

        System.out.println(conta1.toString());
        System.out.println(conta2.toString());

        conta1.imprimirExtrato();
        conta2.imprimirExtrato();

        int media = Operacao.getTotalOperacoes() / Conta.getTotalContas();
        System.out.println("Média de operações por conta aberta: " + media + "\n");

       //contas

        System.out.println("Sobre as contas:");
       if(conta1.equals(conta2)){
           System.out.println("É a mesma conta, pois é o mesmo número indentificador!\n");
       }else{
           System.out.println("É uma conta diferente, o número indentificador é diferente!\n");
       }

       //pessoa fisica
        System.out.println("Sobre as pessoas físicas:");
        if(joao.equals(icaro)){
            System.out.println("É o mesmo cliente, pois o cpf é igual para ambos clientes!\n");
        }else{
            System.out.println("São clientes diferentes, os cpfs são diferentes!\n");
        }

        //pessoa Jurídica
        System.out.println("Sobre as pessoas jurídicas:");
        if(lojinha.equals(mercado)){
            System.out.println("É o mesmo cliente, pois o cnpj é igual para ambos clientes!\n");

        }else{
            System.out.println("São clientes diferentes, os cnpjs são diferentes!\n");
        }

    }
}