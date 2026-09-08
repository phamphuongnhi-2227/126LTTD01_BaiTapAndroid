import java.util.Scanner
data class Student(
    val id: String,
    val fullName: String,
    val age: Int,
    val major: String,
    val gpa: Double
) {
    override fun toString(): String {
        return "Ma SV: $id | Ten: $fullName | Tuoi: $age | Nganh: $major | GPA: $gpa"
    }
}
fun main() {
    val scanner = Scanner(System.`in`)
    val students = mutableListOf(
        Student("SV01", "Pham Phuong Nhi", 20, "Cong nghe Thong tin", 8.5),
        Student("SV02", "Nguyen Dang Huong Lan", 21, "Cong nghe Thong tin", 4.5),
        Student("SV03", "Lam Nhu Nguyen", 20, "Dien-Dien tu", 9.2),
        Student("SV04", "Pham Hoang An Nhien", 19, "Quan tri kinh doanh", 7.5),
        Student("SV05", "Dang Thi Xuan Ba", 22, "Ke toan", 6.8)
    )
    while (true) {
        println("\n========== QUAN LY SINH VIEN ==========")
        println("1. Them sinh vien")
        println("2. Hien thi tat ca sinh vien")
        println("3. Tim kiem sinh vien (theo Ma SV)")
        println("4. Tinh diem trung binh GPA tat ca")
        println("5. Tim sinh vien co GPA cao nhat")
        println("6. Xoa sinh vien")
        println("----------------------------------------")
        println("7. Menu Thong ke")
        println("8. Menu Tim kiem")
        println("9. Menu Sap xep")
        println("0. Thoat chuong trinh")
        println("========================================")
        print("Chon chuc nang: ")

        val choice = scanner.nextInt()
        scanner.nextLine()

        when (choice) {
            1 -> {
                println("\n--- THEM SINH VIEN MOI ---")
                print("Ma SV: ")
                val id = scanner.nextLine()
                print("Ho va ten: ")
                val name = scanner.nextLine()
                print("Tuoi: ")
                val age = scanner.nextInt()
                scanner.nextLine()
                print("Nganh hoc: ")
                val major = scanner.nextLine()
                print("GPA: ")
                val gpa = scanner.nextDouble()

                students.add(Student(id, name, age, major, gpa))
                println("=> Them sinh vien thanh cong!")
            }
            2 -> {
                println("\n--- DANH SACH SINH VIEN ---")
                if (students.isEmpty()) println("Danh sach trong!")
                else students.forEach { println(it) }
            }
            3 -> {
                println("\n--- TIM KIEM THEO MA SV ---")
                print("Nhap Ma SV can tim: ")
                val searchId = scanner.nextLine()
                val found = students.find { it.id.equals(searchId, ignoreCase = true) }
                if (found != null) println("=> Ket qua: $found")
                else println("=> Khong tim thay sinh vien mang ma $searchId")
            }
            4 -> {
                if (students.isEmpty()) {
                    println("\nDanh sach trong!")
                } else {
                    val avg = students.map { it.gpa }.average()
                    println("\n=> GPA trung binh cua tat ca sinh vien: %.2f".format(avg))
                }
            }
            5 -> {
                val highest = students.maxByOrNull { it.gpa }
                if (highest != null) println("\n=> Sinh vien co GPA cao nhat: $highest")
                else println("\nDanh sach trong!")
            }
            6 -> {
                println("\n--- XOA SINH VIEN ---")
                print("Nhap Ma SV can xoa: ")
                val removeId = scanner.nextLine()
                val isRemoved = students.removeIf { it.id.equals(removeId, ignoreCase = true) }
                if (isRemoved) println("=> Xoa thanh cong!")
                else println("=> Khong tim thay sinh vien de xoa!")
            }
            7 -> {
                println("\n--- MENU THONG KE ---")
                println("1. Dem so sinh vien co GPA >= 8.0")
                println("2. Dem so sinh vien co GPA < 5.0")
                println("3. Tinh GPA trung binh theo nganh hoc")
                print("Chon: ")
                val subChoice = scanner.nextInt()
                scanner.nextLine()
                when (subChoice) {
                    1 -> {
                        val count = students.count { it.gpa >= 8.0 }
                        println("=> Co $count sinh vien dat GPA >= 8.0")
                    }
                    2 -> {
                        val count = students.count { it.gpa < 5.0 }
                        println("=> Co $count sinh vien co GPA < 5.0")
                    }
                    3 -> {
                        print("Nhap ten nganh hoc can tinh (VD: Ky thuat Phan mem): ")
                        val searchMajor = scanner.nextLine()
                        val majorStudents = students.filter { it.major.equals(searchMajor, ignoreCase = true) }
                        if (majorStudents.isNotEmpty()) {
                            val majorAvg = majorStudents.map { it.gpa }.average()
                            println("=> GPA trung binh nganh $searchMajor la: %.2f".format(majorAvg))
                        } else {
                            println("=> Khong co sinh vien nao thuoc nganh $searchMajor")
                        }
                    }
                    else -> println("Lua chon khong hop le!")
                }
            }
            8 -> {
                println("\n--- MENU TIM KIEM NANG CAO ---")
                println("1. Tim sinh vien lon tuoi nhat")
                println("2. Tim sinh vien co GPA tu 7.0 den 8.5")
                println("3. Tim tat ca sinh vien thuoc mot nganh")
                println("4. Tim sinh vien theo mot phan ten")
                print("Chon: ")
                val subChoice = scanner.nextInt()
                scanner.nextLine()
                when (subChoice) {
                    1 -> {
                        val oldest = students.maxByOrNull { it.age }
                        println("=> Sinh vien lon tuoi nhat: $oldest")
                    }
                    2 -> {
                        println("=> Danh sach sinh vien co GPA (7.0 - 8.5):")
                        val filtered = students.filter { it.gpa in 7.0..8.5 }
                        if (filtered.isEmpty()) println("Khong co ai!") else filtered.forEach { println(it) }
                    }
                    3 -> {
                        print("Nhap ten nganh can tim: ")
                        val sMajor = scanner.nextLine()
                        println("=> Danh sach sinh vien nganh $sMajor:")
                        val filtered = students.filter { it.major.equals(sMajor, ignoreCase = true) }
                        if (filtered.isEmpty()) println("Khong co ai!") else filtered.forEach { println(it) }
                    }
                    4 -> {
                        print("Nhap mot phan ten de tim kiem (VD: Nhi): ")
                        val sName = scanner.nextLine()
                        println("=> Ket qua tim kiem ten chua '$sName':")
                        val filtered = students.filter { it.fullName.contains(sName, ignoreCase = true) }
                        if (filtered.isEmpty()) println("Khong tim thay!") else filtered.forEach { println(it) }
                    }
                    else -> println("Lua chon khong hop le!")
                }
            }
            9 -> {
                println("\n--- MENU SAP XEP ---")
                println("1. Sap xep sinh vien theo GPA giam dan")
                println("2. Hien thi 3 sinh vien co GPA cao nhat")
                println("3. Sap xep sinh vien theo tuoi tang dan")
                println("4. Sap xep sinh vien theo ten (A-Z)")
                print("Chon: ")
                val subChoice = scanner.nextInt()
                scanner.nextLine()
                when (subChoice) {
                    1 -> {
                        println("=> Danh sach xep theo GPA giam dan:")
                        students.sortedByDescending { it.gpa }.forEach { println(it) }
                    }
                    2 -> {
                        println("=> Top 3 sinh vien GPA cao nhat:")
                        students.sortedByDescending { it.gpa }.take(3).forEach { println(it) }
                    }
                    3 -> {
                        println("=> Danh sach xep theo Tuoi tang dan:")
                        students.sortedBy { it.age }.forEach { println(it) }
                    }
                    4 -> {
                        println("=> Danh sach xep theo Ten (A-Z):")
                        students.sortedBy { it.fullName.substringAfterLast(" ") }.forEach { println(it) }
                    }
                    else -> println("Lua chon khong hop le!")
                }
            }
            0 -> {
                println("Dang thoat chuong trinh... Tam biet!")
                return
            }
            else -> println("Lua chon khong hop le, vui long nhap lai!")
        }
    }
}