package controladores;

import entidades.*;
import menus.MenuEntidade;
import repositorio.Repositorio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Objects;
import java.util.Scanner;

public class ControladorVenda {
    private final Scanner scanner = new Scanner(System.in);
    private final DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private static ControladorVenda controladorVendaInstancia;

    private ControladorVenda() {

    }

    public static ControladorVenda getInstanciaControladorVenda() {
        if (controladorVendaInstancia == null) {
            controladorVendaInstancia = new ControladorVenda();
        }
        return controladorVendaInstancia;
    }

    public void efetuarVenda() {
        System.out.println("==========================CADASTRAR VENDA=========================");
        int idvendaAtual = Repositorio.getInstanciaRepositorio().getListaVenda().size() + 1;
        Venda v = new Venda(idvendaAtual,0,0);
        LocalDate dataAtual = LocalDate.now();
        v.setDataVenda(dataAtual);

        boolean existeVendedor = false;
        while (!existeVendedor) {
            int idVendedor;
            if (ControladorLogin.getInstanciaControladorLogin().verificaVendedorParaVenda() == -1) {
                while (true) {
                    try {
                        System.out.print("Informe o ID do vendedor (digite 0 para voltar): ");
                        idVendedor = Integer.parseInt(scanner.nextLine());
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Digite apenas números inteiros.");
                    }
                }

                if (idVendedor == 0) {
                    MenuEntidade.getInstanciaMenuEntidade().escolhaMenuVendas();
                    return;
                }
            } else  {
                idVendedor = ControladorLogin.getInstanciaControladorLogin().verificaVendedorParaVenda();
            }

            for (Funcionario func : Repositorio.getInstanciaRepositorio().getListaFuncionarios()) {
                if (func.getIdFuncionario() == idVendedor && Objects.equals(func.getCargo().toLowerCase(),"vendedor")) {
                    existeVendedor = true;
                    v.setIdVendedorVenda(idVendedor);
                }
            }
            if (!existeVendedor){
                System.out.println("ID de vendedor inexistente.");
            }
        }

        boolean existeCliente = false;
        while (!existeCliente) {
            int idCliente;
            while (true) {
                try {
                    System.out.print("Informe o ID do cliente (digite 0 para voltar): ");
                    idCliente = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Digite apenas números inteiros.");
                }
            }
            if (idCliente == 0) {
                MenuEntidade.getInstanciaMenuEntidade().escolhaMenuVendas();
                return;
            }
            for (Cliente c : Repositorio.getInstanciaRepositorio().getListaClientes()) {
                if (c.getIdCliente() == idCliente) {
                    existeCliente = true;
                    v.setIdClienteVenda(idCliente);
                }
            }
            if (!existeCliente) {
                System.out.println("ID de cliente inexistente.");
            }
        }

        boolean fimProduto = false;
        boolean primeiroProduto = true;
        boolean existeProduto = false;
        while (!fimProduto) {
            if (primeiroProduto) {
                int idProduto;
                while (true) {
                    try {
                        System.out.print("Informe o ID do produto vendido (digite 0 para voltar): ");
                        idProduto = Integer.parseInt(scanner.nextLine());
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Digite apenas números inteiros.");
                    }
                }
                if (idProduto == 0) {
                    MenuEntidade.getInstanciaMenuEntidade().escolhaMenuVendas();
                    return;
                }
                for (Produto p : Repositorio.getInstanciaRepositorio().getListaProduto()) {
                    if (p.getIdProduto() == idProduto) {
                        existeProduto = true;
                        mostrarProdutoVenda(p);
                        int adicionaProduto;
                        while (true) {
                            try {
                                System.out.print("Adicionar produto a venda? (Digite 1 para Sim) ");
                                adicionaProduto = Integer.parseInt(scanner.nextLine());
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("Digite apenas números inteiros.");
                            }
                        }
                        if (adicionaProduto == 1) {
                            double quantidadeProduto;
                            while (true) {
                                try {
                                    System.out.print("Qual a quantidade do produto? (unidade, metros ou quilos) ");
                                    String quantidadeProdutoStr = scanner.nextLine();
                                    quantidadeProduto = Double.parseDouble(quantidadeProdutoStr.replace(",", "."));
                                    break;
                                } catch (Exception e) {
                                    System.out.print("A quantidade do produto deve ser informada em números. ");
                                }
                            }
                            p.setQuantidade(quantidadeProduto);
                            System.out.println(ControladorEstoque.getInstanciaControladorEstoque().diminuiQuantidadeEstoqueVenda(p));
                            primeiroProduto = false;
                            v.getListaProdutosVenda().add(p);
                        }
                        break;
                    }
                }
                if (!existeProduto) {
                    System.out.println("ID de produto inexistente.");
                }
            } else {
                int novoProduto;
                while (true) {
                    try {
                        System.out.print("Adicionar novo produto a venda? (Digite 1 para Sim) ");
                        novoProduto = Integer.parseInt(scanner.nextLine());
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Digite apenas números inteiros.");
                    }
                }
                if (novoProduto == 1) {
                    existeProduto =false;
                    int idProduto;
                    while (true) {
                        try {
                            System.out.print("Informe o ID do produto vendido: (digite 0 para voltar) ");
                            idProduto = Integer.parseInt(scanner.nextLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Digite apenas números inteiros.");
                        }
                    }
                    for (Produto p : Repositorio.getInstanciaRepositorio().getListaProduto()) {
                        if (p.getIdProduto() == idProduto) {
                            existeProduto = true;
                            mostrarProdutoVenda(p);
                            int adicionaProduto;
                            while (true) {
                                try {
                                    System.out.print("Adicionar produto a venda? (Digite 1 para Sim) ");
                                    adicionaProduto = Integer.parseInt(scanner.nextLine());
                                    break;
                                } catch (NumberFormatException e) {
                                    System.out.println("Digite apenas números inteiros.");
                                }
                            }
                            if (adicionaProduto == 1) {
                                double quantidadeProduto;
                                while (true) {
                                    try {
                                        System.out.print("Qual a quantidade do produto? (unidade, metros ou quilos) ");
                                        String quantidadeProdutoStr = scanner.nextLine();
                                        quantidadeProduto = Double.parseDouble(quantidadeProdutoStr.replace(",", "."));
                                        break;
                                    } catch (Exception e) {
                                        System.out.print("A quantidade do produto deve ser informada em números. ");
                                    }
                                }
                                p.setQuantidade(quantidadeProduto);
                                System.out.println(ControladorEstoque.getInstanciaControladorEstoque().diminuiQuantidadeEstoqueVenda(p));
                                v.getListaProdutosVenda().add(p);
                            }
                            break;
                        }
                    }
                    if (!existeProduto) {
                        if (idProduto != 0) {
                            System.out.println("ID de produto inexistente.");
                        }
                    }
                } else {
                    fimProduto = true;
                }
            }
        }
        Double valorTotalVenda = calcularValorTotalVenda(v);
        v.setValorTotalVenda(valorTotalVenda);
        if (v.getListaProdutosVenda().isEmpty()) {
            v.setVendaAtiva(false);
            System.out.println("Venda desativada: não existem produtos na lista.");
        } else {
            v.setVendaAtiva(true);
        }

        int concluir;
        while (true) {
            try {
                System.out.print("Concluir o procedimento? (1 para SIM): ");
                concluir = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Digite apenas números inteiros.");
            }
        }
        if (concluir != 1) {
            MenuEntidade.getInstanciaMenuEntidade().escolhaMenuVendas();
            return;
        }

        Repositorio.getInstanciaRepositorio().getListaVenda().add(v);
        comissaoVendedor();
        System.out.println("Venda cadastrada com sucesso com o ID: "+v.getIdVenda());
        System.out.println("==================================================================");
    }

    public void atualizarVenda() {
        System.out.println("====================ATUALIZAR CADASTRO DA VENDA===================");
        int idVenda;
        while (true) {
            try {
                System.out.print("Informe o ID da venda: ");
                idVenda = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Digite apenas números inteiros.");
            }
        }

        Venda vendaEncontrada = null;

        for (Venda v : Repositorio.getInstanciaRepositorio().getListaVenda()) {
            if (v.getIdVenda() == idVenda) {
                vendaEncontrada = v;
                break;
            }
        }
        if (vendaEncontrada == null) {
            System.out.println("ID da venda inexistente.");
            MenuEntidade.getInstanciaMenuEntidade().escolhaMenuVendas();
            return;
        }

        // Verificar permissão
        int idVendedorLogado = ControladorLogin.getInstanciaControladorLogin().verificaVendedorParaVenda();

        boolean ehVendedorDaVenda =
                vendaEncontrada.getIdVendedorVenda() == idVendedorLogado;

        boolean ehGerente =
                Objects.equals(
                        ControladorLogin.getInstanciaControladorLogin().verificaGerenteDeVendasParaVenda().toLowerCase(),
                        "gerente de vendas"
                );

        if (!ehVendedorDaVenda && !ehGerente) {
            System.out.println("Usuário não efetuou a venda e não possui cargo de Gerente de Vendas.");
            MenuEntidade.getInstanciaMenuEntidade().escolhaMenuVendas();
            return;
        }

        // Pode alterar
        mostrarVenda(vendaEncontrada);
        System.out.println("==================================================================");

        // Atualizar vendedor
        boolean existeVendedor = false;
        while (!existeVendedor) {
            int idVendedorNovoInt;
            String idVendedorNovoStr;
            while (true) {
                try {
                    System.out.print("Informe o novo ID do vendedor (enter para não alterar): ");
                    idVendedorNovoStr = scanner.nextLine();
                    if (!idVendedorNovoStr.isEmpty()) {
                        idVendedorNovoInt = Integer.parseInt(idVendedorNovoStr);
                    } else {
                        idVendedorNovoInt = vendaEncontrada.getIdVendedorVenda();
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.print("Digite apenas números inteiros.");
                }
            }

            if (!idVendedorNovoStr.isEmpty()) {
                for (Funcionario f : Repositorio.getInstanciaRepositorio().getListaFuncionarios()) {
                    if (f.getIdFuncionario() == idVendedorNovoInt &&
                            Objects.equals(f.getCargo().toLowerCase(), "vendedor")) {

                        existeVendedor = true;
                        vendaEncontrada.setIdVendedorVenda(idVendedorNovoInt);
                        break;
                    }
                }

                if (!existeVendedor) {
                    System.out.println("ID de vendedor inexistente.");
                    MenuEntidade.getInstanciaMenuEntidade().escolhaMenuVendas();
                    return;
                }
            } else {
                existeVendedor = true;
            }
        }

        // Atualizar cliente
        boolean existeCliente = false;
        while (!existeCliente) {
            String  idClienteNovo;
            int idCliNovoFormat;
            while (true) {
                try {
                    System.out.print("Informe o novo ID do cliente (enter para não alterar): ");
                    idClienteNovo = scanner.nextLine();
                    if (!idClienteNovo.isEmpty()) {
                        idCliNovoFormat = Integer.parseInt(idClienteNovo);
                    } else {
                        idCliNovoFormat = vendaEncontrada.getIdClienteVenda();
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Digite apenas números inteiros.");
                }
            }
            if (!idClienteNovo.isEmpty()) {
                for (Cliente c : Repositorio.getInstanciaRepositorio().getListaClientes()) {
                    if (c.getIdCliente() == idCliNovoFormat) {
                        existeCliente = true;
                        vendaEncontrada.setIdClienteVenda(idCliNovoFormat);
                        break;
                    }
                }

                if (!existeCliente) {
                    System.out.println("ID de cliente inexistente.");
                    MenuEntidade.getInstanciaMenuEntidade().escolhaMenuVendas();
                    return;
                }
            } else {
                existeCliente = true;
            }
        }

        // Alterar itens da venda

        while (true) {
            int alterarItensVenda;
            while (true) {
                try {
                    System.out.print("O que deseja fazer?\n1 - Alterar itens de venda\n2 - Adicionar itens na venda\nQualquer outro número para concluir ");
                    alterarItensVenda = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Digite apenas números inteiros.");
                }
            }

            if (alterarItensVenda == 1) {
                Iterator<Produto> it = vendaEncontrada.getListaProdutosVenda().iterator();

                while (it.hasNext()) {
                    Produto p = it.next();

                    mostrarProdutoVenda(p);
                    System.out.println("Quantidade vendida: "+p.getQuantidade());
                    System.out.println("Valor total do item: "+p.getQuantidade()*p.getPrecoVenda());
                    int escolhaItemVenda;
                    while (true) {
                        try {
                            System.out.print("1 - Próximo item, 2 - Alterar quantidade, 3 - Excluir item: ");
                            escolhaItemVenda = Integer.parseInt(scanner.nextLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Digite apenas números inteiros.");
                        }
                    }

                    if (escolhaItemVenda == 2) {
                        double novaQuant;
                        while (true) {
                            try {
                                System.out.print("Informe a nova quantidade do produto: (unidade, metros ou quilos) ");
                                String novaQuantStr = scanner.nextLine();
                                novaQuant = Double.parseDouble(novaQuantStr.replace(",", "."));
                                break;
                            } catch (Exception e) {
                                System.out.print("A quantidade do produto deve ser informada em números. ");
                            }
                        }
                        Double alteraEstoque = p.getQuantidade() - novaQuant;

                        if (p.getQuantidade() < novaQuant) {
                            System.out.println(ControladorEstoque.getInstanciaControladorEstoque().alteraDiminuiQuantidadeEstoqueVenda(p, alteraEstoque));
                        } else if (p.getQuantidade() > novaQuant) {
                            ControladorEstoque.getInstanciaControladorEstoque().alteraAumentaQuantidadeEstoqueVenda(p,alteraEstoque);
                        }

                        p.setQuantidade(novaQuant);
                        System.out.println("Quantidade de produto da venda alterada com sucesso.");
                        System.out.println("==================================================================");

                    } else if (escolhaItemVenda == 3) {
                        ControladorEstoque.getInstanciaControladorEstoque().alteraAumentaQuantidadeEstoqueVenda(p,p.getQuantidade());
                        it.remove();
                        System.out.println("Item removido da venda com sucesso.");
                        System.out.println("==================================================================");
                    }
                }
                if (vendaEncontrada.getListaProdutosVenda().isEmpty()) {
                    vendaEncontrada.setVendaAtiva(false);
                    System.out.println("Venda desativada: não restam produtos na lista.");
                } else {
                    if (!vendaEncontrada.getVendaAtiva()) {
                        System.out.println("Venda reativada.");
                        vendaEncontrada.setVendaAtiva(true);
                    }
                }
            } else if (alterarItensVenda == 2) {
                boolean maisProduto = true;
                while (maisProduto) {
                    boolean existeProduto = false;
                    int idProduto;
                    while (true) {
                        try {
                            System.out.print("Informe o ID do produto vendido: ");
                            idProduto = Integer.parseInt(scanner.nextLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Digite apenas números inteiros.");
                        }
                    }
                    for (Produto p : Repositorio.getInstanciaRepositorio().getListaProduto()) {
                        if (p.getIdProduto() == idProduto) {
                            existeProduto = true;
                            mostrarProdutoVenda(p);
                            int adicionaProduto;
                            while (true) {
                                try {
                                    System.out.print("Adicionar produto a venda? (Digite 1 para Sim) ");
                                    adicionaProduto = Integer.parseInt(scanner.nextLine());
                                    break;
                                } catch (NumberFormatException e) {
                                    System.out.print("Digite apenas números inteiros. ");
                                }
                            }
                            if (adicionaProduto == 1) {
                                double quantidadeProduto;
                                while (true) {
                                    try {
                                        System.out.print("Qual a quantidade do produto? (unidade, metros ou quilos) ");
                                        String quantidadeProdutoStr = scanner.nextLine();
                                        quantidadeProduto = Double.parseDouble(quantidadeProdutoStr.replace(",", "."));
                                        break;
                                    } catch (Exception e) {
                                        System.out.print("A quantidade do produto deve ser informada em números. ");
                                    }
                                }
                                p.setQuantidade(quantidadeProduto);
                                System.out.println(ControladorEstoque.getInstanciaControladorEstoque().diminuiQuantidadeEstoqueVenda(p));
                                vendaEncontrada.getListaProdutosVenda().add(p);

                                int escolheMaisItensVenda;
                                while (true) {
                                    try {
                                        System.out.print("Deseja adicionar mais itens a venda? (Digite 1 para Sim) ");
                                        escolheMaisItensVenda = Integer.parseInt(scanner.nextLine());
                                        break;
                                    } catch (Exception e) {
                                        System.out.print("Digite apenas números inteiros. ");
                                    }
                                }
                                if (escolheMaisItensVenda != 1) {
                                    maisProduto = false;
                                }
                            }
                            break;
                        }
                    }
                    if (!existeProduto) {
                        System.out.println("ID de produto inexistente.");
                    }
                }
            } else {
                break;
            }
        }
        vendaEncontrada.setValorTotalVenda(calcularValorTotalVenda(vendaEncontrada));
        comissaoVendedor();
        System.out.println("Venda alterada com sucesso.");
        System.out.println("==================================================================");
    }

    public void consultarVendaPorID() {
        int idVenda;
        while (true) {
            try {
                System.out.print("Informe o ID da venda: ");
                idVenda = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Digite apenas números inteiros.");
            }
        }
        boolean existeVenda = false;
        for (Venda v : Repositorio.getInstanciaRepositorio().getListaVenda()) {
            if (v.getIdVenda() == idVenda) {
                mostrarVenda(v);
                existeVenda = true;
            }
        }
        if (!existeVenda) {
            System.out.println("ID de venda inexistente.");
        }
        System.out.println("==================================================================");
    }

    public void consultarVendaAtivaVendedor() {
        int idVendedor;
        while (true) {
            try {
                System.out.print("Informe o ID do vendedor: ");
                idVendedor = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Digite apenas números inteiros.");
            }
        }
        boolean existeVenda = false;
        for (Venda v : Repositorio.getInstanciaRepositorio().getListaVenda()) {
            if (v.getIdVendedorVenda() == idVendedor && v.getVendaAtiva()) {
                mostrarVenda(v);
                existeVenda = true;
            }
        }
        if (!existeVenda) {
            System.out.println("Não existem vendas ativas do vendedor informado.");
        }
        System.out.println("==================================================================");
    }

    public void consultarVendaInativaVendedor() {
        int idVendedor;
        while (true) {
            try {
                System.out.print("Informe o ID do vendedor: ");
                idVendedor = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Digite apenas números inteiros.");
            }
        }
        boolean existeVenda = false;
        for (Venda v : Repositorio.getInstanciaRepositorio().getListaVenda()) {
            if (v.getIdVendedorVenda() == idVendedor && !v.getVendaAtiva()) {
                mostrarVenda(v);
                existeVenda = true;
            }
        }
        if (!existeVenda) {
            System.out.println("Não existem vendas inativas do vendedor informado.");
        }
        System.out.println("==================================================================");
    }

    public void consultarVendaAtivaCliente() {
        int idCliente;
        while (true) {
            try {
                System.out.print("Informe o ID do cliente: ");
                idCliente = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Digite apenas números inteiros.");
            }
        }
        boolean existeVenda = false;
        for (Venda v : Repositorio.getInstanciaRepositorio().getListaVenda()) {
            if (v.getIdClienteVenda() == idCliente && v.getVendaAtiva()) {
                mostrarVenda(v);
                existeVenda = true;
            }
        }
        if (!existeVenda) {
            System.out.println("Não existem vendas ativas do cliente informado.");
        }
        System.out.println("==================================================================");
    }

    public void consultarVendaInativaCliente() {
        int idCliente;
        while (true) {
            try {
                System.out.print("Informe o ID do cliente: ");
                idCliente = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Digite apenas números inteiros.");
            }
        }
        boolean existeVenda = false;
        for (Venda v : Repositorio.getInstanciaRepositorio().getListaVenda()) {
            if (v.getIdClienteVenda() == idCliente && !v.getVendaAtiva()) {
                mostrarVenda(v);
                existeVenda = true;
            }
        }
        if (!existeVenda) {
            System.out.println("Não existem vendas inativas do cliente informado.");
        }
        System.out.println("==================================================================");
    }

    public void cancelarVenda() {
        System.out.println("==========================CANCELAR VENDA==========================");
        int idVenda;
        while (true) {
            try {
                System.out.print("Informe o ID da venda: ");
                idVenda = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Digite apenas números inteiros.");
            }
        }
        boolean existeVenda = false;
        for (Venda v : Repositorio.getInstanciaRepositorio().getListaVenda()) {
            if (v.getIdVenda() == idVenda && v.getVendaAtiva()) {
                mostrarVenda(v);
                existeVenda = true;
                int escolhaCancela;
                while (true) {
                    try {
                        System.out.print("Deseja cancelar a venda? (Digite 1 para Sim) ");
                        escolhaCancela = Integer.parseInt(scanner.nextLine());
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Digite apenas números inteiros.");
                    }
                }
                if (escolhaCancela == 1) {
                    for (Produto p : v.getListaProdutosVenda()) {
                        ControladorEstoque.getInstanciaControladorEstoque().alteraAumentaQuantidadeEstoqueVenda(p,p.getQuantidade());
                    }
                    v.setVendaAtiva(false);
                    comissaoVendedor();
                    System.out.println("Venda cancelada com sucesso.");
                }
            }
        }
        if (!existeVenda) {
            System.out.println("Não existem venda ativa para o ID informado.");
        }
    }

    public void listarVendas () {
        System.out.println("==========================LISTA DE VENDAS=========================");
        for (Venda v : Repositorio.getInstanciaRepositorio().getListaVenda()) {
            mostrarVenda(v);
            System.out.println("==================================================================");
        }
    }

    public void mostrarProdutoVenda(Produto p) {
        System.out.println("ID do produto: "+p.getIdProduto());
        System.out.println("Nome: "+p.getNome());
        System.out.println("Descrição: "+p.getDescricao());
        System.out.println("Preço de venda: R$ "+p.getPrecoVenda());
        System.out.println("Quantidade em estoque: "+p.getQuantidadeEstoque());
    }

    public void mostrarVenda(Venda v) {
        System.out.println("ID venda: " + v.getIdVenda());
        System.out.print("Situação: ");
        if (v.getVendaAtiva()) {
            System.out.println("Ativa");
        } else {
            System.out.println("Inativa");
        }
        System.out.print("ID vendedor: " + v.getIdVendedorVenda()+" - ");
        for (Funcionario func : Repositorio.getInstanciaRepositorio().getListaFuncionarios()) {
            if (v.getIdVendedorVenda() == func.getIdFuncionario()) {
                System.out.println(func.getNome());
                break;
            }
        }
        System.out.print("ID Cliente: " + v.getIdClienteVenda()+" - ");
        for (Cliente cli : Repositorio.getInstanciaRepositorio().getListaClientes()) {
            if (v.getIdClienteVenda() == cli.getIdCliente()) {
                System.out.println(cli.getNome());
                break;
            }
        }
        System.out.println("Data da venda: "+v.getDataVenda().format(formatador));
        System.out.printf("Valor total da venda: R$ %.2f%n", calcularValorTotalVenda(v));
        System.out.println("Itens vendidos:");
        for (Produto p : v.getListaProdutosVenda()) {
            mostrarProdutoVenda(p);
            System.out.println("Quantidade: "+p.getQuantidade());
            System.out.printf("Valor parcial do item: R$ %.2f%n", (p.getQuantidade()*p.getPrecoVenda()));
            System.out.println("==================================================================");
        }
    }

    public Double calcularValorTotalVenda(Venda v) {
        double valorTotal = 0.0;
        for (Produto p : v.getListaProdutosVenda()) {
            valorTotal += p.getPrecoVenda()*p.getQuantidade();
        }
        return valorTotal;
    }

    public void comissaoVendedor() {

        LocalDate dataAtual = LocalDate.now();

        LocalDate primeiroDia = dataAtual.withDayOfMonth(1);
        LocalDate ultimoDia = dataAtual.withDayOfMonth(dataAtual.lengthOfMonth());

        for (Funcionario func : Repositorio.getInstanciaRepositorio().getListaFuncionarios()) {

            if (func.getCargo().equalsIgnoreCase("vendedor")) {

                double acumulado = 0.0;

                for (Venda v : Repositorio.getInstanciaRepositorio().getListaVenda()) {

                    if (v.getVendaAtiva()
                            && !v.getDataVenda().isBefore(primeiroDia)
                            && !v.getDataVenda().isAfter(ultimoDia)
                            && v.getIdVendedorVenda() == func.getIdFuncionario()) {

                        acumulado += v.getValorTotalVenda();
                    }
                }

                // comissão de 1%
                double comissao = acumulado * 0.01;
                func.setComissaoVendedor(comissao);
            }
        }
    }
}
