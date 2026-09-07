fun main() {
    println("--- Bai 1: In cac so tu 1 den 10 ---")
    for (i in 1..10) {
        print("$i ")
    }
    println("\n")

    println("--- Bai 2: Tinh tong tu 1 den 100 ---")
    var sum = 0
    for (i in 1..100) {
        sum += i
    }
    println("Tong = $sum\n")

    println("--- Bai 3: In cac so chan tu 1 den 20 ---")
    for (i in 1..20) {
        if (i % 2 == 0) {
            print("$i ")
        }
    }
    println()
}