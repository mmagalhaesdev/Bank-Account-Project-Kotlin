open class conta(){
    public var saldo: Double = 0.0

    public fun depositar(x:Double):Unit{
        if(x<=0){
            println("")
            println("Valor menor ou igual a zero")
        }
        else{
            saldo += x
        }
    }
    public fun sacar(x:Double):Unit{
        if(x<=0){
            println("")
            println("Valor menor ou igual a zero")
        }
        if(x>saldo){
            println("")
            println("Saldo insuficiente")
        }
        if(x<=saldo && x>0){
            saldo -= x
        }
    }
    public fun obterSaldo():Unit{
        println("")
        println("Seu saldo: R$ $saldo")
    }
}
open class contaCorrente(): conta(){

}
open class contaPoupança(): conta(){

}
class Tributavel(): contaCorrente(){
    public fun calcularTributos(x: Int):Double{
        var imposto: Double = 0.0
        if( saldo > 0){
            if(x == 0){
                var SeguroVida:Double = 42.0
                imposto = saldo*0.01
                saldo -= (saldo*0.01 + SeguroVida)
            }
        }
        return imposto
    }
}
open class testeTributavel(){
    var a = Tributavel()
    var b = contaPoupança()
    var z: Int = 0
    fun main() {
        println("")
        println("Informe a opção desejada:")
        println("1 - ContaCorrente")
        println("2 - Conta Poupança")
        println("0 - Finalizar programa")
        var decisão: Int = readLine()!!.toInt()
        if(decisão == 1){
            println("")
            println("Informe a opção que deseja: ")
            println("1 - Depositar")
            println("2 - Sacar")
            println("3 - Consultar saldo")
            println("0 - Encerrar programa")
            var d: Int = readLine()!!.toInt()
            if(d == 1){
                println("")
                println("Informe o valor de deposito:")
                var v: Double = readLine()!!.toDouble()
                a.depositar(v)
                main()
            }
            if(d == 2){
                println("")
                println("Informe o valor do saque:")
                var v: Double = readLine()!!.toDouble()
                a.sacar(v)
                main()
            }
            if(d == 3){
                println("")
                println("Consultando seu saldo:")
                var imposto = a.calcularTributos(z)
                a.obterSaldo()
                if( z ==0 ){
                    println("Seu saldo foi descontado 1% de Imposto, sendo o valor $imposto adicionado R$ 42 de Seguro de vida")
                }
                if(z > 0){
                    println("Informamos que você já pagou o imposto com o Seguro de Vida")
                }
                z++
                main()
            }
            if(d == 0){
                println("")
                println("Finalizando o programa... ;)")
            }
        }
        if(decisão == 2){
            println("")
            println("Informe a opção que deseja: ")
            println("1 - Depositar")
            println("2 - Sacar")
            println("3 - Consultar saldo")
            println("0 - Encerrar programa")
            var d: Int = readLine()!!.toInt()
            if(d == 1){
                println("")
                println("Informe o valor de deposito:")
                var v: Double = readLine()!!.toDouble()
                b.depositar(v)
            }
            if(d == 2){
                println("")
                println("Informe o valor do saque:")
                var v: Double = readLine()!!.toDouble()
                b.sacar(v)
            }
            if(d == 3){
                println("")
                println("Consultando seu saldo:")
                b.obterSaldo()
            }
            if(d == 0){
                println("")
                println("Finalizando o programa...;)")
            }
        }
        if(decisão == 0){
            println("Finalizando o programa...;)")
        }
    }
}
fun main(){
    var m = testeTributavel()
    m.main()
}
