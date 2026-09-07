import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)

    print("Nhap ho ten sinh vien: ")
    val studentName = scanner.nextLine()

    print("Nhap ma so sinh vien: ")
    val studentId = scanner.nextLine()

    print("Nhap diem Math: ")
    val math = scanner.nextDouble()

    print("Nhap diem Programming: ")
    val programming = scanner.nextDouble()

    print("Nhap diem Database: ")
    val database = scanner.nextDouble()

    val totalScore = math + programming + database
    val averageScore = totalScore / 3
    val highestScore = maxOf(math, programming, database)
    val isPassed = averageScore >= 5.0

    println("\n=======================================")
    println("KET QUA HOC TAP CUA SINH VIEN")
    println("Ho ten: $studentName")
    println("MSSV: $studentId")
    println("---------------------------------------")

    println("- Tong diem: $totalScore")
    println("- Diem trung binh: %.2f".format(averageScore))
    println("- Diem cao nhat: $highestScore")

    print("- Sinh vien co dat khong? (GPA >= 5.0): ")
    if (isPassed) {
        println("DAT")
    } else {
        println("KHONG DAT")
    }
    println("=======================================")
}