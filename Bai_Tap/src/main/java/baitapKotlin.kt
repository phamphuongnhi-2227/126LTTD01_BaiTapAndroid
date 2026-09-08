import java.util.Scanner
fun main() {
    val scanner = Scanner(System.`in`)
    val studentName = "Pham Phuong Nhi"
    val studentId = "2415053122227"

    println("Sinh vien: $studentName - MSSV: $studentId")
    println("---------------------------------------")

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