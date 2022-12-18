import java.util.Random

data class Peixe(val nome: String, val cor: CorPeixe, val tamanho: TamanhoPeixe)

enum class CorPeixe {
    VERDE, AZUL, ROSA
}

enum class TamanhoPeixe {
    PEQUENO, MEDIO, GRANDE
}

enum class TamanhoAquario(val capacidade: Int) {
    PEQUENO(5), MEDIO(10), GRANDE(15);
}

class Aquario(var tamanho: TamanhoAquario = TamanhoAquario.PEQUENO) {
    var peixes = mutableListOf<Peixe>()
    var sujo = false
    var multiplo = 3

    fun adicionarPeixe() {
        if (peixes.size == tamanho.capacidade) {
            println("O aquário já está cheio.")
            return
        }

        if (sujo) {
            println("O aquário está sujo, não é possível adicionar peixes no momento.")
            return
        }
        print("Digite o nome do peixe: ")
        val nome:String = readln()
        print("Digite a cor do peixe \n1 -> Verde\n2 -> Azul\n3 -> Rosa\n: ")
        val cor:CorPeixe = CorPeixe.values()[readln().toInt() - 1]
        print("Digite o tamanho do peixe \n1 -> Pequeno,\n2 -> Médio,\n3 -> Grande\n: ")
        val tamanho:TamanhoPeixe = TamanhoPeixe.values()[readln().toInt() - 1]
        peixes.add(Peixe(nome, cor, tamanho))
        if (peixes.size % multiplo == 0) sujo = true
        println("Peixe adicionado com sucesso.")
    }

    fun alimentarPeixes() {
        val quantidade:Int = Random().nextInt(peixes.size + 1)
        if (quantidade == 0) {
            println("Falha, nenhum peixe se alimentou.")
        } else if (quantidade == peixes.size) {
            println("Sucesso, todos os peixes se alimentaram.")
        } else {
            println("Parcial, $quantidade peixes se alimentaram.")
        }
    }

    fun limparAquario() {
        if (!sujo) {
            println("O aquário já está limpo.")
            return
        }
        sujo = false
        println("O aquário foi limpo.")
    }

    fun alterarTamanho(novoTamanho: TamanhoAquario) {
        tamanho = novoTamanho
    }

    fun listarPeixes() {
        if (peixes.isEmpty()) {
            println("Não há peixes no aquário.")
            return
        }
        peixes.forEach {
            println("Nome: ${it.nome}, Cor: ${it.cor}, Tamanho: ${it.tamanho}")
        }
    }
}
    fun main() {
        val aquario = Aquario()
        while (true) {
            println("\nMenu:")
            println("1 -> Adicionar peixe")
            println("2 -> Alimentar peixes")
            println("3 -> Limpar aquário")
            println("4 -> Alterar tamanho do aquário")
            println("5 -> Listar peixes")
            println("6 -> Sair")
            print("Opção: ")
            when (readln()) {
                "1" -> aquario.adicionarPeixe()
                "2" -> aquario.alimentarPeixes()
                "3"-> aquario.limparAquario()
                "4"-> {
                    print("Digite o novo tamanho do aquário\n1 -> Pequeno\n 2 -> Médio\n 3 -> Grande\n: ")
                    aquario.alterarTamanho(TamanhoAquario.values()[readln().toInt() - 1])
                }
                "5"-> aquario.listarPeixes()
                "6"-> return
                else -> println("Opção inválida.")
            }
        }
    }
