var ind: Int = 1
var vpaoF: Float = 1F
var vpaoM: Float = 1F
var vpaoL: Float = 1F
var vxbacon : Float = 1F
var vxsalada: Float = 1F
var vxegg: Float = 1.0F
var vbrigadeiro: Float = 1F
var vbeijinho: Float = 1F
var vsonhoDeValsa: Float = 1F
var quantidadeTotal:Float = 0F
var paoF: Float = 0.60F
var quantidadepaoF:Float = 0F
var paoM: Float = 0.50F
var quantidadepaoM:Float = 0F
var paoL: Float = 0.40F
var quantidadepaoL:Float = 0F
var xbacon : Float = 20.0F
var quantidadexbacon:Float = 0F
var xsalada: Float = 15.40F
var quantidadexsalada:Float = 0F
var xegg: Float = 10.50F
var quantidadexegg:Float = 0F
var brigadeiro: Float = 2.0F
var quantidadebrigadeiro:Float = 0F
var beijinho: Float = 2.0F
var quantidadebeijinho:Float = 0F
var sonhoDeValsa: Float = 2.0F
var quantidadesonhoDeValsa:Float = 0F
var cupom: String = ""
var SouN: String = ""
var vTotal: Float = 0.0F
fun main(){
    val opcao: String
    println("=====Bem vindo a E-Padoca=====\n" +
            "======Escolha uma opção=======\n" +
            "1..................Pães\n" +
            "2..............Salgados\n" +
            "3.................Doces\n" +
            "0......Finalizar compra\n")
    opcao = readln()
    when(opcao){
        "1" -> paes()
        "2" -> salgados()
        "3" -> doces()
        "0" -> finalizar()
        else -> {println("Codigo invalido")
            main()}
    }
}

fun cupomDesconto(){
    println("Digite o Cupom")
    cupom = readln().uppercase()
    when(cupom){
        "5PADOCA" -> { vTotal = vTotal.times(0.95).toFloat()
            println("Valor Total R$: $vTotal\n=====================VOLTE SEMPRE ^-^======================")}
        "10PADOCA " -> {vTotal = vTotal.times(0.90).toFloat()
            println("Valor Total R$: $vTotal\n=====================VOLTE SEMPRE ^-^======================")}
        "5OFF" -> {vTotal = vTotal.minus(5)
            println("Valor Total R$: $vTotal\n=====================VOLTE SEMPRE ^-^======================")}
        "S" -> println("R$: $vTotal")
        else -> {println("Cupom Invalido\nPara Sair Digite 'S'")
            cupomDesconto()}
    }
}
fun finalizar(){
    if(quantidadeTotal<=0){
        println("Deseja mesmo cancelar compra? (S/N)")
        SouN = readln().uppercase()
        when(SouN){
            "S" -> return println("Compra encerrada\n" +
                    "=====================VOLTE SEMPRE ^-^======================")
            else -> main()
        }
    }
    println("========================Comanda E-padoca============================\n" +
            "====================================================================\n" +
            "Produto..................Qtd.......Valor......................Total\n" +
            "====================================================================\n")
    if(quantidadepaoF>0){
        println("$ind.... Pao Frances..............$quantidadepaoF.......R$0,60...................R$ $vpaoF\n")
        vTotal = vTotal + vpaoF
        ind = ind +1}
    if(quantidadepaoL>0){
        println("$ind.... Pao de Leite.............$quantidadepaoL.......R$0,40...................R$ $vpaoL\n")
        vTotal = vTotal + vpaoL
        ind = ind +1}
    if(quantidadepaoM>0){
        println("$ind.... Pao de Milho.............$quantidadepaoM.......R$0,50...................R$ $vpaoM\n")
        vTotal = vTotal + vpaoM
        ind = ind +1}
    if(quantidadexbacon>0){
        println("$ind.... X-Bacon..................$quantidadexbacon.......R$20,00..................R$ $vxbacon\n")
        vTotal = vTotal + vxbacon
        ind = ind +1}
    if(quantidadexsalada>0){
        println("$ind.... X-Salada.................$quantidadexsalada.......R$15,40..................R$ $vxsalada\n")
        vTotal = vTotal + vxsalada
        ind = ind +1}
    if(quantidadexegg>0){
        println("$ind.... X-Egg....................$quantidadexegg.......R$10,50..................R$ $vxegg\n")
        vTotal = vTotal + vxegg
        ind = ind +1}
    if(quantidadebrigadeiro>0){
        println("$ind..... Brigandeiro..............$quantidadebrigadeiro.......R$2,00...................R$ $vbrigadeiro\n")
        vTotal = vTotal + vbrigadeiro
        ind = ind +1}
    if(quantidadebeijinho>0){
        println("$ind..... Beijinho.................$quantidadebeijinho.......R$2,00...................R$ $vbeijinho\n")
        vTotal = vTotal + vbeijinho
        ind = ind +1}
    if(quantidadesonhoDeValsa>0){
        println("$ind.... Sonho de Valsa...........$quantidadesonhoDeValsa.......R$2,00...................R$ $vsonhoDeValsa\n")
        vTotal = vTotal + vsonhoDeValsa
        ind = ind +1}

    println("Total =====================================================> R$ $vTotal\n")
    println("Possui Cupom de desconto? (S/N) ")
    SouN = readln()
    when(SouN){
        "s" -> cupomDesconto()
        else -> println("Valor total a ser pago é igual a: R$:$vTotal\n=====================VOLTE SEMPRE ^-^======================")
    }
}
fun paes() {
    var acao: String
    val pao: List<String> = listOf(
        "1 - Pão Francês...........R\$ 0,60",
        "2 - Pão de Leite..........R\$ 0,40",
        "3 - Pão de Milho..........R\$ 0,50",
        "0 - Voltar")
    println("${pao[0]}\n${pao[1]}\n${pao[2]}\n${pao[3]}")
    acao = readln()
    when(acao){

        "1" -> {println("Digite a quantidade do Pão Francês :")
            quantidadepaoF = readln().toFloat()
            vpaoF = paoF * quantidadepaoF
            quantidadeTotal += 1
            return paes()}
        "2" -> {println("Digite a quantidade do Pão de Leite :")
            quantidadepaoL = readln().toFloat()
            vpaoL = paoL * quantidadepaoL
            quantidadeTotal += 1
            return paes()}
        "3" -> { println("Digite a quantidade do Pão de Milho :")
            quantidadepaoM = readln().toFloat()
            vpaoM = paoM * quantidadepaoM
            quantidadeTotal += 1
            return paes()}
        "0" -> main()
        else-> {println("Codigo errado")
            paes()}
    }
}
fun salgados(){
    val acao: String
    val pao: List<String> = listOf(
        "1 - X-Bacon...........R\$ 20,00",
        "2 - X-Salada..........R\$ 15,40",
        "3 - X-Egg.............R\$ 10,50",
        "0 - Voltar")
    println("${pao[0]}\n${pao[1]}\n${pao[2]}\n${pao[3]}")
    acao = readln()
    when(acao){
        "1" -> {println("Digite a quantidade do X-Bacon :")
            quantidadexbacon = readln().toFloat()
            vxbacon = xbacon * quantidadexbacon
            quantidadeTotal += 1
            return salgados()
        }
        "2" -> {println("Digite a quantidade do X-Salada:")
            quantidadexsalada = readln().toFloat()
            vxsalada = xsalada * quantidadexsalada
            quantidadeTotal += 1
            return salgados()
        }
        "3" -> { println("Digite a quantidade do X-Egg:")
            quantidadexegg = readln().toFloat()
            vxegg = xegg * quantidadexegg
            quantidadeTotal += 1
            return salgados()
        }
        "0" -> main()
        else -> {println("Codigo errado")
            return salgados()}
    }
}
fun doces() {
    val acao: String
    val pao: List<String> = listOf(
        "1 - Brigadeiro..............R\$ 2,00",
        "2 - Beijinho................R\$ 2,00",
        "3 - Sonho de Valsa..........R\$ 2,00",
        "0 - Voltar")
    println("${pao[0]}\n${pao[1]}\n${pao[2]}\n${pao[3]}")
    acao = readln()
    when(acao){
        "1" -> {println("Digite a quantidade do Brigadeiro :")
            quantidadebrigadeiro = readln().toFloat()
            vbrigadeiro = brigadeiro * quantidadebrigadeiro
            quantidadeTotal += 1
            return doces()}
        "2" -> {println("Digite a quantidade do Beijinho:")
            quantidadebeijinho = readln().toFloat()
            vbeijinho = beijinho * quantidadebeijinho
            quantidadeTotal += 1
            return doces()}
        "3" -> { println("Digite a quantidade do Sonho de Valsa:")
            quantidadesonhoDeValsa = readln().toFloat()
            vsonhoDeValsa = sonhoDeValsa * quantidadesonhoDeValsa
            quantidadeTotal += 1
            return doces()
        }
        "0" -> main()
        else -> {println("Codigo invalido")
            return doces()
        }
    }
}
