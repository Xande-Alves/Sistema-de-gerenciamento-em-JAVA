import java.util.*;

public class Venda {
    private final Scanner scanner = new Scanner(System.in);
    private Funcionario sistemaFuncionario;
    private Menu sistemaMenu;
    private Login sistemaLogin;
    private Cliente sistemaCliente;
    private Produto sistemaProduto;
    private Estoque sistemaEstoque;

    private final List<Venda> listaVendas = new ArrayList<>();
    private final List<Produto> listaProdutosVenda = new ArrayList<>();
    private int idVenda;
    private int idVendedorVenda;
    private int idClienteVenda;
    private Double valorTotalVenda;
    private boolean vendaAtiva;
    private static Venda vendaInstancia;

    private Venda(int idVenda, int idVendedor, int idCliente) {
        this.idVendedorVenda = idVendedor;
        this.idClienteVenda = idCliente;
    }

    public static Venda getInstanciaVenda() {
        if (vendaInstancia == null) {
            vendaInstancia = new Venda(0,0,0);
        }
        return vendaInstancia;
    }

    public void efetuarVenda() {
        System.out.println("==========================CADASTRAR VENDA=========================");
        int idvendaAtual = listaVendas.size() + 1;
        Venda v = new Venda(0,0,0);
        v.setIdVenda(idvendaAtual);

        boolean existeVendedor = false;
        while (!existeVendedor) {
            int idVendedor;
            if (sistemaLogin.verificaVendedorParaVenda() == -1) {
                System.out.print("Informe o ID do vendedor (digite 0 para voltar): ");
                idVendedor = Integer.parseInt(scanner.nextLine());

                if (idVendedor == 0) {
                    sistemaMenu.escolhaMenuVendas();
                }
            } else  {
                idVendedor = sistemaLogin.verificaVendedorParaVenda();
            }

            for (Funcionario func : sistemaFuncionario.exportaListaFuncionario()) {
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
            System.out.print("Informe o ID do cliente (digite 0 para voltar): ");
            int idCliente = Integer.parseInt(scanner.nextLine());
            if (idCliente == 0) {
                sistemaMenu.escolhaMenuVendas();
            }
            for (Cliente c : sistemaCliente.exportaListaCliente()) {
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
                System.out.print("Informe o ID do produto vendido (digite 0 para voltar): ");
                int idProduto = Integer.parseInt(scanner.nextLine());
                if (idProduto == 0) {
                    sistemaMenu.escolhaMenuVendas();
                }
                for (Produto p : sistemaProduto.exportaListaProduto()) {
                    if (p.getIdProduto() == idProduto) {
                        existeProduto = true;
                        mostrarProdutoVenda(p);
                        System.out.print("Adicionar produto a venda? (1 - Sim / 2 - Não) ");
                        int adicionaProduto = Integer.parseInt(scanner.nextLine());
                        if (adicionaProduto == 1) {
                            System.out.print("Qual a quantidade do produto? (unidade, metros ou quilos) ");
                            Double quantidadeProduto = Double.parseDouble(scanner.nextLine());
                            p.setQuantidade(quantidadeProduto);
                            System.out.println(sistemaEstoque.diminuiQuantidadeEstoqueVenda(p));
                            primeiroProduto = false;
                            v.listaProdutosVenda.add(p);
                        }
                        break;
                    }
                }
                if (!existeProduto) {
                    System.out.println("ID de produto inexistente.");
                }
            } else {
                System.out.print("Adicionar novo produto? (1 - Sim / 2 - Não) ");
                int novoProduto = Integer.parseInt(scanner.nextLine());
                if (novoProduto == 1) {
                    existeProduto =false;
                    System.out.print("Informe o ID do produto vendido: (digite 0 para voltar) ");
                    int idProduto = Integer.parseInt(scanner.nextLine());
                    if (idProduto == 0) {
                        continue;
                    }
                    for (Produto p : sistemaProduto.exportaListaProduto()) {
                        if (p.getIdProduto() == idProduto) {
                            existeProduto = true;
                            mostrarProdutoVenda(p);
                            System.out.print("Adicionar produto a venda? (1 - Sim / 2 - Não) ");
                            int adicionaProduto = Integer.parseInt(scanner.nextLine());
                            if (adicionaProduto == 1) {
                                System.out.print("Qual a quantidade do produto? (unidade, metros ou quilos) ");
                                Double quantidadeProduto = Double.parseDouble(scanner.nextLine());
                                p.setQuantidade(quantidadeProduto);
                                System.out.println(sistemaEstoque.diminuiQuantidadeEstoqueVenda(p));
                                v.listaProdutosVenda.add(p);
                            }
                            break;
                        }
                    }
                    if (!existeProduto) {
                        System.out.println("ID de produto inexistente.");
                    }
                } else {
                    fimProduto = true;
                }
            }
        }
        Double valorTotalVenda = calcularValorTotalVenda(v);
        v.setValorTotalVenda(valorTotalVenda);
        if (v.listaProdutosVenda.isEmpty()) {
            v.setVendaAtiva(false);
            System.out.println("Venda desativada: não existem produtos na lista.");
        } else {
            v.setVendaAtiva(true);
        }
        listaVendas.add(v);
        System.out.println("Venda cadastrada com sucesso com o ID: "+v.getIdVenda());
        System.out.println("==================================================================");
    }

    public void atualizarVenda() {
        System.out.println("====================ATUALIZAR CADASTRO DA VENDA===================");
        System.out.print("Informe o ID da venda: ");
        int idVenda = Integer.parseInt(scanner.nextLine());

        Venda vendaEncontrada = null;

        for (Venda v : listaVendas) {
            if (v.getIdVenda() == idVenda) {
                vendaEncontrada = v;
                break;
            }
        }
        if (vendaEncontrada == null) {
            System.out.println("ID da venda inexistente.");
            sistemaMenu.escolhaMenuVendas();
        }

        // Verificar permissão
        int idVendedorLogado = sistemaLogin.verificaVendedorParaVenda();

        boolean ehVendedorDaVenda =
                vendaEncontrada.getIdVendedorVenda() == idVendedorLogado;

        boolean ehGerente =
                Objects.equals(
                        sistemaLogin.verificaGerenteDeVendasParaVenda().toLowerCase(),
                        "gerente de vendas"
                );

        if (!ehVendedorDaVenda && !ehGerente) {
            System.out.println("Usuário não efetuou a venda e não possui cargo de Gerente de Vendas.");
            sistemaMenu.escolhaMenuVendas();
        }

        // Pode alterar
        mostrarVenda(vendaEncontrada);
        System.out.println("==================================================================");

        // Atualizar vendedor
        boolean existeVendedor = false;
        while (!existeVendedor) {
            System.out.print("Informe o novo ID do vendedor (enter para não alterar): ");
            String idVendedorNovo = scanner.nextLine();

            if (!idVendedorNovo.isEmpty()) {
                int idVendNovoFormat = Integer.parseInt(idVendedorNovo);

                for (Funcionario f : sistemaFuncionario.exportaListaFuncionario()) {
                    if (f.getIdFuncionario() == idVendNovoFormat &&
                            Objects.equals(f.getCargo().toLowerCase(), "vendedor")) {

                        existeVendedor = true;
                        vendaEncontrada.setIdVendedorVenda(idVendNovoFormat);
                        break;
                    }
                }

                if (!existeVendedor) {
                    System.out.println("ID de vendedor inexistente.");
                    sistemaMenu.escolhaMenuVendas();
                }
            } else {
                existeVendedor = true;
            }
        }

        // Atualizar cliente
        boolean existeCliente = false;
        while (!existeCliente) {
            System.out.print("Informe o novo ID do cliente (enter para não alterar): ");
            String idClienteNovo = scanner.nextLine();

            if (!idClienteNovo.isEmpty()) {
                int idCliNovoFormat = Integer.parseInt(idClienteNovo);

                for (Cliente c : sistemaCliente.exportaListaCliente()) {
                    if (c.getIdCliente() == idCliNovoFormat) {
                        existeCliente = true;
                        vendaEncontrada.setIdClienteVenda(idCliNovoFormat);
                        break;
                    }
                }

                if (!existeCliente) {
                    System.out.println("ID de cliente inexistente.");
                    sistemaMenu.escolhaMenuVendas();
                }
            } else {
                existeCliente = true;
            }
        }

        // Alterar itens da venda
        System.out.print("Deseja alterar itens de venda? 1 - Sim / 2 - Não: ");
        int alterarItensVenda = Integer.parseInt(scanner.nextLine());

        if (alterarItensVenda == 1) {
            Iterator<Produto> it = vendaEncontrada.listaProdutosVenda.iterator();

            while (it.hasNext()) {
                Produto p = it.next();

                mostrarProdutoVenda(p);
                System.out.print("1 - Próximo item, 2 - Alterar quantidade, 3 - Excluir item: ");
                int escolhaItemVenda = Integer.parseInt(scanner.nextLine());

                if (escolhaItemVenda == 2) {
                    System.out.print("Informe a nova quantidade do produto: ");
                    Double novaQuant = Double.parseDouble(scanner.nextLine());
                    Double alteraEstoque = p.getQuantidade() - novaQuant;

                    if (p.getQuantidade() < novaQuant) {
                        System.out.println(sistemaEstoque.alteraDiminuiQuantidadeEstoqueVenda(p, alteraEstoque));
                    } else if (p.getQuantidade() > novaQuant) {
                        sistemaEstoque.alteraAumentaQuantidadeEstoqueVenda(p,alteraEstoque);
                    }

                    p.setQuantidade(novaQuant);
                    System.out.println("Quantidade de produto da venda alterada com sucesso.");
                    System.out.println("==================================================================");

                } else if (escolhaItemVenda == 3) {
                    it.remove();
                    System.out.println("Item removido da venda com sucesso.");
                    System.out.println("==================================================================");
                }
            }
            if (vendaEncontrada.listaProdutosVenda.isEmpty()) {
                vendaEncontrada.setVendaAtiva(false);
                System.out.println("Venda desativada: não restam produtos na lista.");
            }
        }
        System.out.println("Venda alterada com sucesso.");
        System.out.println("==================================================================");
    }

    public void consultarVendaAtivaVendedor() {
        System.out.print("Informe o ID do vendedor: ");
        int idVendedor = Integer.parseInt(scanner.nextLine());
        boolean existeVenda = false;
        for (Venda v : listaVendas) {
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
        System.out.print("Informe o ID do vendedor: ");
        int idVendedor = Integer.parseInt(scanner.nextLine());
        boolean existeVenda = false;
        for (Venda v : listaVendas) {
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
        System.out.print("Informe o ID do cliente: ");
        int idCliente = Integer.parseInt(scanner.nextLine());
        boolean existeVenda = false;
        for (Venda v : listaVendas) {
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
        System.out.print("Informe o ID do cliente: ");
        int idCliente = Integer.parseInt(scanner.nextLine());
        boolean existeVenda = false;
        for (Venda v : listaVendas) {
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
        System.out.print("Informe o ID da venda: ");
        int idVenda = Integer.parseInt(scanner.nextLine());
        boolean existeVenda = false;
        for (Venda v : listaVendas) {
            if (v.getIdVenda() == idVenda && v.getVendaAtiva()) {
                mostrarVenda(v);
                existeVenda = true;
                System.out.print("Deseja cancelar a venda? 1 - Sim / 2 - Não ");
                int escolhaCancela = Integer.parseInt(scanner.nextLine());
                if (escolhaCancela == 1) {
                    for (Produto p : v.listaProdutosVenda) {
                        sistemaEstoque.alteraAumentaQuantidadeEstoqueVenda(p,p.getQuantidade());
                    }
                    v.setVendaAtiva(false);
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
        for (Venda v : listaVendas) {
            mostrarVenda(v);
            System.out.println("==================================================================");
        }
    }

    public void mostrarProdutoVenda(Produto p) {
        System.out.println("ID do produto: "+p.getIdProduto());
        System.out.println("Nome: "+p.getNome());
        System.out.println("Descrição: "+p.getDescricao());
        System.out.println("Preço de venda: R$ "+p.getPrecoVenda());
    }

    public void mostrarVenda(Venda v) {
        System.out.println("ID venda: " + v.getIdVenda());
        System.out.println("ID vendedor: " + v.getIdVendedorVenda());
        System.out.println("ID Cliente: " + v.getIdClienteVenda());
        System.out.println("Valor total da venda: R$ "+ calcularValorTotalVenda(v));
        System.out.println("Itens vendidos:");
        for (Produto p : v.listaProdutosVenda) {
            mostrarProdutoVenda(p);
            System.out.println("Quantidade: "+p.getQuantidade());
            System.out.println("Valor parcial do item: R$ "+p.getQuantidade()*p.getPrecoVenda());
            System.out.println("==================================================================");
        }

    }

    public Double calcularValorTotalVenda(Venda v) {
        double valorTotal = 0.0;
        for (Produto p : v.listaProdutosVenda) {
            valorTotal += p.getPrecoVenda()*p.getQuantidade();
        }
        return valorTotal;
    }

    public void setSistemaLogin(Login sistemaLogin) {
        this.sistemaLogin = sistemaLogin;
    }

    public void setSistemaProduto(Produto sistemaProduto) {
        this.sistemaProduto = sistemaProduto;
    }

    public void setSistemaCliente(Cliente sistemaCliente) {
        this.sistemaCliente = sistemaCliente;
    }

    public void setSistemaFuncionario(Funcionario sistemaFuncionario) {
        this.sistemaFuncionario = sistemaFuncionario;
    }

    public void setSistemaMenu(Menu sistemaMenu) {
        this.sistemaMenu = sistemaMenu;
    }

    public void setSistemaEstoque(Estoque sistemaEstoque) {
        this.sistemaEstoque = sistemaEstoque;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public int getIdVendedorVenda() {
        return idVendedorVenda;
    }

    public void setIdVendedorVenda(int idVendedorVenda) {
        this.idVendedorVenda = idVendedorVenda;
    }

    public int getIdClienteVenda() {
        return idClienteVenda;
    }

    public void setIdClienteVenda(int idClienteVenda) {
        this.idClienteVenda = idClienteVenda;
    }

    public void setValorTotalVenda(Double valorTotalVenda) {
        this.valorTotalVenda = valorTotalVenda;
    }

    public boolean getVendaAtiva() {
        return vendaAtiva;
    }

    public void setVendaAtiva(boolean vendaAtiva) {
        this.vendaAtiva = vendaAtiva;
    }
}
