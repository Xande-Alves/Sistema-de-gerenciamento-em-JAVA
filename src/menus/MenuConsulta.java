package menus;

import controladores.ControladorCliente;
import controladores.ControladorFuncionario;
import controladores.ControladorProduto;
import controladores.ControladorVenda;
import controladores.ControladorFornecedor;

import java.util.Scanner;

public class MenuConsulta {
    private final Scanner scanner = new Scanner(System.in);
    private static MenuConsulta menuConsultaInstancia;

    private MenuConsulta() {

    }

    public static MenuConsulta getInstanciaMenuConsulta() {
        if (menuConsultaInstancia == null) {
            menuConsultaInstancia = new MenuConsulta();
        }
        return menuConsultaInstancia;
    }

    public void escolhaAtributoConsultaCliente() {
        while (true) {
            System.out.println("=======================CONSULTA DE CLIENTES========================");
            int atributoConsultaCliente;
            while (true) {
                try {
                    System.out.println("1 - Nome\n2 - CPF\n3 - E-mail\n4 - Telefone\n5 - Sair");
                    System.out.print("Deseja consultar por que dado? ");
                    atributoConsultaCliente = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Digite apenas números inteiros.");
                }
            }
            if (atributoConsultaCliente == 1) {
                ControladorCliente.getInstanciaControladorCliente().consultarClientesNome();
            } else if (atributoConsultaCliente == 2) {
                ControladorCliente.getInstanciaControladorCliente().consultarClientesCpf();
            } else if (atributoConsultaCliente == 3) {
                ControladorCliente.getInstanciaControladorCliente().consultarClientesEmail();
            } else if (atributoConsultaCliente == 4) {
                ControladorCliente.getInstanciaControladorCliente().consultarClientesTelefone();
            } else if (atributoConsultaCliente == 5) {
                break;
            } else {
                System.out.println("Opção inválida!");
            }
        }
    }

    public void escolhaAtributoConsultaFuncionario() {
        while (true) {
            System.out.println("=====================CONSULTA DE FUNCIONARIOS======================");
            int atributoConsultaFuncionario;
            while (true) {
                try {
                    System.out.println("1 - Nome\n2 - CPF\n3 - E-mail\n4 - Telefone\n5 - Cargo\n6 - Sair");
                    System.out.print("Deseja consultar por que dado? ");
                    atributoConsultaFuncionario = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Digite apenas números inteiros.");
                }
            }
            if (atributoConsultaFuncionario == 1) {
                ControladorFuncionario.getInstanciaControladorFuncionario().consultarFuncionarioNome();
            } else if (atributoConsultaFuncionario == 2) {
                ControladorFuncionario.getInstanciaControladorFuncionario().consultarFuncionarioCpf();
            } else if (atributoConsultaFuncionario == 3) {
                ControladorFuncionario.getInstanciaControladorFuncionario().consultarFuncionarioEmail();
            } else if (atributoConsultaFuncionario == 4) {
                ControladorFuncionario.getInstanciaControladorFuncionario().consultarFuncionarioTelefone();
            } else if (atributoConsultaFuncionario == 5) {
                ControladorFuncionario.getInstanciaControladorFuncionario().consultarFuncionarioCargo();
            } else if (atributoConsultaFuncionario == 6) {
                break;
            } else {
                System.out.println("Opção inválida!");
            }
        }
    }

    public void escolhaAtributoConsultaProduto() {
        while (true) {
            System.out.println("=======================CONSULTA DE PRODUTOS========================");
            int atributoConsultaProduto;
            while (true) {
                try {
                    System.out.println("1 - ID do fornecedor\n2 - Nome\n3 - Descrição\n4 - Sair");
                    System.out.print("Deseja consultar por que dado? ");
                    atributoConsultaProduto = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Digite apenas números inteiros.");
                }
            }
            if (atributoConsultaProduto == 1) {
                ControladorProduto.getInstanciaControladorProduto().consultarProdutoIdFornecedor();
            } else if (atributoConsultaProduto == 2) {
                ControladorProduto.getInstanciaControladorProduto().consultarProdutoNome();
            } else if (atributoConsultaProduto == 3) {
                ControladorProduto.getInstanciaControladorProduto().consultarProdutoDescricao();
            } else if (atributoConsultaProduto == 4) {
                break;
            } else {
                System.out.println("Opção inválida!");
            }
        }
    }

    public void escolhaAtributoConsultaFornecedor() {
        while (true) {
            System.out.println("=====================CONSULTA DE FORNECEDORES======================");
            int atributoConsultaFornecedor;
            while (true) {
                try {
                    System.out.println("1 - Nome\n2 - CPF\n3 - E-mail\n4 - Telefone\n5 - Nome da empresa\n6 - CNPJ da empresa\n7 - Sair");
                    System.out.print("Deseja consultar por que dado? ");
                    atributoConsultaFornecedor = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Digite apenas números inteiros.");
                }
            }
            if (atributoConsultaFornecedor == 1) {
                ControladorFornecedor.getInstanciaControladorFornecedor().consultarFornecedorNome();
            } else if (atributoConsultaFornecedor == 2) {
                ControladorFornecedor.getInstanciaControladorFornecedor().consultarFornecedorCpf();
            } else if (atributoConsultaFornecedor == 3) {
                ControladorFornecedor.getInstanciaControladorFornecedor().consultarFornecedorEmail();
            } else if (atributoConsultaFornecedor == 4) {
                ControladorFornecedor.getInstanciaControladorFornecedor().consultarFornecedorTelefone();
            } else if (atributoConsultaFornecedor == 5) {
                ControladorFornecedor.getInstanciaControladorFornecedor().consultarFornecedorNomeEmpresa();
            } else if (atributoConsultaFornecedor == 6) {
                ControladorFornecedor.getInstanciaControladorFornecedor().consultarFornecedorCnpjEmpresa();
            } else if (atributoConsultaFornecedor == 7) {
                break;
            } else {
                System.out.println("Opção inválida!");
            }
        }
    }

    public void escolhaAtributoConsultaVendas() {
        while (true) {
            System.out.println("========================CONSULTA DE VENDAS=========================");
            int atributoConsultaVenda;
            while (true) {
                try {
                    System.out.println("1 - ID de venda\n2 - Vendas ativas por vendedor\n3 - Vendas ativas por cliente\n4 - Vendas inativas por vendedor\n5 - Vendas inativas por cliente\n6 - Sair");
                    System.out.print("Deseja consultar por que dado? ");
                    atributoConsultaVenda = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Digite apenas números inteiros.");
                }
            }
            if (atributoConsultaVenda==1) {
                ControladorVenda.getInstanciaControladorVenda().consultarVendaPorID();
            } else if (atributoConsultaVenda == 2) {
                ControladorVenda.getInstanciaControladorVenda().consultarVendaAtivaVendedor();
            } else if (atributoConsultaVenda == 3) {
                ControladorVenda.getInstanciaControladorVenda().consultarVendaAtivaCliente();
            } else if (atributoConsultaVenda == 4) {
                ControladorVenda.getInstanciaControladorVenda().consultarVendaInativaVendedor();
            } else if (atributoConsultaVenda == 5) {
                ControladorVenda.getInstanciaControladorVenda().consultarVendaInativaCliente();
            } else if (atributoConsultaVenda == 6) {
                break;
            } else {
                System.out.println("Opção inválida!");
            }
        }
    }
}
