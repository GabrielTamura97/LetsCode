import java.util.Scanner

// Classe que representa uma peça
class Peca(
    // Atributos da classe
    var id: Int,
    var nome: String,
    var quantidade: Int
) {
    // Construtor da classe
    constructor(id: Int, nome: String) : this(id, nome, 0)

    // Método que aumenta a quantidade de peças em estoque
    fun adicionar(quantidade: Int) {
        if (this.quantidade + quantidade > 999) {
            // Lança uma exceção caso a quantidade ultrapasse o limite máximo de estoque
            throw LimiteEstoqueMaxExcpetion()
        }
        this.quantidade += quantidade
    }
}

// Classe que representa uma exceção de limite máximo de estoque
class LimiteEstoqueMaxExcpetion : Exception()
class IdPecaJaExisteException : Exception()


// Classe que implementa o sistema de controle de estoque de peças
class ControleEstoque {
    // Atributos da classe
    var pecas: MutableList<Peca> = mutableListOf()

    // Método que adiciona uma nova peça ao estoque
    fun adicionarPeca(peca: Peca, quantidade: Int) {
        try {
            // Verifica se a peça já existe na lista de peças
            for (p in pecas) {
                if (p.id == peca.id) {
                    // Lança uma exceção de ID de peça já existe
                    throw IdPecaJaExisteException()
                }
            }
            peca.adicionar(quantidade)
            pecas.add(peca)
        } catch (e: LimiteEstoqueMaxExcpetion) {
            // Volta ao menu principal
            // ...
        }
    }


    // Método que edita uma peça do estoque
    fun editarPeca(id: Int, nome: String, quantidade: Int) {
        for (peca in pecas) {
            if (peca.id == id) {
                peca.nome = nome
                //if (quantidade == 0) {
                // Zerar a quantidade de peças
                //peca.zerarQuantidade()
                //} else {
                // Alterar a quantidade de peças
                peca.quantidade = quantidade
            }
            break
        }

        throw PecaNaoEncontradaException()
    }

    // Método que exibe todas as peças em estoque
    fun exibirPecasEmEstoque() {
        for (peca in pecas) {
            if (peca.quantidade > 0) {
                println("ID: ${peca.id} - Nome: ${peca.nome} - Quantidade: ${peca.quantidade}")
            }
        }
    }

    // Método que exibe todas as peças, independentemente da quantidade em estoque
    fun exibirTodasPecas() {
        for (peca in pecas) {
            println("ID: ${peca.id} - Nome: ${peca.nome} - Quantidade: ${peca.quantidade}")
        }
    }

    // Classe que representa uma exceção de peça não encontrada
    class PecaNaoEncontradaException : Exception()
}
// Método principal que inicia o sistema de controle de estoque de peças
fun main() {

    val scanner = Scanner(System.`in`)
    val controleEstoque = ControleEstoque()

    // Menu principal
    while (true) {
        println("Controle de Estoque de Peças")
        println("1 - Adicionar item")
        println("2 - Editar item")
        println("3 - Exibir itens em estoque")
        println("4 - Exibir todos os itens")
        println("5 - Fechar sistema")
        print("Escolha uma opção: ")
        val opcao = scanner.next()
        when (opcao) {
            "1" -> {
                // Adicionar peça ao estoque
                print("Informe o ID da peça: ")
                val id = scanner.nextInt()
                print("Informe o nome da peça: ")
                val nome = scanner.next()
                print("Informe a quantidade da peça: ")
                val quantidade = scanner.nextInt()
                try {
                    val peca = Peca(id, nome)
                    controleEstoque.adicionarPeca(peca, quantidade)
                    println("Peça adicionada com sucesso!")
                } catch (e: IdPecaJaExisteException) {
                    println("ERRO: ID de peça já existe!")
                } catch (e: LimiteEstoqueMaxExcpetion) {
                    println("Erro: a quantidade máxima de estoque é 999!")
                    continue
                }
            }

            "2" -> {
                // Editar peça do estoque
                print("Informe o ID da peça: ")
                val id = scanner.nextInt()
                print("Informe o novo nome da peça: ")
                val nome = scanner.next()
                print("Informe a nova quantidade da peça: ")
                val quantidade = scanner.nextInt()

                try {
                    controleEstoque.editarPeca(id, nome, quantidade)
                    println("Peça editada com sucesso!")
                } catch (e: ControleEstoque.PecaNaoEncontradaException) {
                    println("Erro: peça não encontrada!")
                }
            }

            "3" -> {
                println("Itens em estoque:")
                controleEstoque.exibirPecasEmEstoque()
            }

            "4" -> {
                // Exibir todas as peças
                println("Todos os itens:")
                controleEstoque.exibirTodasPecas()
            }

            "5" -> {
                // Fechar sistema
                println("Fechando o sistema...")
                break
            }

            else -> {
                // Opção inválida
                println("Opção inválida!")
            }
        }
    }
}