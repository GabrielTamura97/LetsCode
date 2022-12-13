class Produto(val nome: String, val preco: Double) {
    var quantidade = 0
    fun calcularTotal() = preco * quantidade
}
class Padoca {
    val produtos = arrayListOf<Produto>()
    private var desconto = 0.0

    fun adicionarProduto(produto: Produto) {
        produtos.add(produto)
    }

    fun aplicarDesconto(cupom: String) {
        when (cupom) {
            "5PADOCA" -> desconto = 0.05
            "10PADOCA" -> desconto = 0.1
            else -> desconto = 0.0
        }
    }

    fun exibirMenu() {
        println("""
            =====================Comanda E-padoca=======================
            |  Item  |  Produto  |  Qtd  |  Valor  |
            | 0 |  Finalizar  Compra  |
            ==========================================================
        """.trimIndent())
        for ((index, produto) in produtos.withIndex()) {
            println("|  ${index + 1}  |  ${produto.nome}  |  ${produto.quantidade}  |  ${produto.preco}  |")
        }
        println("""
            ==========================================================
        """.trimIndent())
    }
    fun exibirCategorias() {
        println("""
            =====================Categorias=========================
            |  1  |  Pães               |
            |  2  |  Salgados           |
            |  3  |  Doces              |
            |  0  |  Finalizar  Compra  |
            =======================================================
        """.trimIndent())
    }
    fun exibirSubMenuPao() {
        println("""
            =====================Submenu - Pães=========================
            |  1  |  Pão Francês   |  RS 0,60
            |  2  |  Pão de Leite  |  RS 0,40
            |  3  |  Pão de Milho  |  RS 0,50
            |  0  |  Voltar        |
            =======================================================
        """.trimIndent())
    }
    fun exibirSubMenuSalgados() {
        println("""
            =====================SubMenu - Salgados=========================
            |  1  |  Coxinha  |   RS 4,50
            |  2  |  Risole   |   RS 3,50
            |  3  |  Empada   |   RS 4,00
            |  0  |  Voltar   |
            =======================================================
        """.trimIndent())
    }
    fun exibirSubMenuDoces() {
        println("""
            =====================SubNenu - Doces=========================
            |  1  |  Sonho          |   RS 1,50
            |  2  |  Brigadeiro     |   RS 2,00
            |  3  |  Pão de Queijo  |   RS 2,50
            |  0  |  Voltar         |
            =======================================================
        """.trimIndent())
    }

    fun exibirComanda() {
        println("""
            =====================Comanda E-padoca=======================
            |  Item  |  Produto  |  Quantidade  |  Valor Por Produto  |  Total  |
            ==========================================================
        """.trimIndent())

        for ((index, produto) in produtos.withIndex()) {
            println("""
              ${index + 1}  |  ${produto.nome}  |  ${produto.quantidade}  |  ${String.format("%.2f", produto.preco)}  |  ${String.format("%.2f", produto.calcularTotal())}")
            """.trimIndent())
        }

        println("""
            ===============================================================
            Total ===========================================> R$ ${calcularTotal()}
            =======================VOLTE SEMPRE ^-^========================
        """.trimIndent())
    }

    fun calcularTotal(): Double {
        var total = 0.0

        produtos.forEach { total += it.calcularTotal() }

        return total * (1 - desconto)
    }
}

fun main() {
    val padoca = Padoca()

    while (true) {
        padoca.exibirCategorias()

        print("Digite a categoria desejada: ")
        val categoria:Int = readln().toInt()

        if (categoria == 0) {
            if (padoca.produtos.isNotEmpty()) {
                padoca.exibirMenu()
                break
            } else {
                print("Deseja mesmo cancelar compra? (S/N)")
                val desejaCancelar = readln().uppercase()

                if (desejaCancelar == "S") {
                    break
                }
            }
        }

        when (categoria) {
            1 -> {
                padoca.exibirSubMenuPao()

                print("Digite o produto desejado: ")
                val produtoPao = readln().toInt()

                if (produtoPao == 0) {
                    break
                }

                println("Digite a quantidade de Pães desejada: ")
                val quantidadePao = readln().toInt()

                when (produtoPao) {
                    1 -> padoca.adicionarProduto(Produto("Pão Francês", 0.60).apply { quantidade = quantidadePao })
                    2 -> padoca.adicionarProduto(Produto("Pão de Leite", 0.40).apply { quantidade = quantidadePao })
                    3 -> padoca.adicionarProduto(Produto("Pão de Milho", 0.50).apply { quantidade = quantidadePao })
                }
            }
            2 -> {
                padoca.exibirSubMenuSalgados()

                print("Digite o produto desejado: ")
                val produtoSalgado = readln().toInt()

                if (produtoSalgado == 0) {
                    break
                }

                println("Digite a quantidade de Salgados desejada: ")
                val quantidadeSalgado = readln().toInt()

                when (produtoSalgado) {
                    1 -> padoca.adicionarProduto(Produto("Coxinha", 4.50).apply { quantidade = quantidadeSalgado })
                    2 -> padoca.adicionarProduto(Produto("Risole", 3.50).apply { quantidade = quantidadeSalgado })
                    3 -> padoca.adicionarProduto(Produto("Empada", 4.00).apply { quantidade = quantidadeSalgado })
                }
            }
            3 -> {
                padoca.exibirSubMenuDoces()

                print("Digite o produto desejado: ")
                val produtoDoce = readln().toInt()

                if (produtoDoce == 0) {
                    break
                }

                println("Digite a quantidade de Doces desejada: ")
                val quantidadeDoce = readln().toInt()

                when (produtoDoce) {
                    1 -> padoca.adicionarProduto(Produto("Sonho", 1.50).apply { quantidade = quantidadeDoce })
                    2 -> padoca.adicionarProduto(Produto("Brigadeiro", 2.00).apply { quantidade = quantidadeDoce })
                    3 -> padoca.adicionarProduto(Produto("Pão de Queijo", 2.50).apply { quantidade = quantidadeDoce })
                }
            }
        }
    }

    print("Deseja aplicar um cupom de desconto? (S/N)")
    val aplicarCupom = readln().uppercase()

    if (aplicarCupom == "S") {
        print("Digite o código do cupom: ")
        val cupom = readln().uppercase()
        padoca.aplicarDesconto(cupom)
    }
    padoca.exibirComanda()
}