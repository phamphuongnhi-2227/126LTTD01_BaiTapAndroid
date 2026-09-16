package com.ute.studentprofile
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ute.studentprofile.databinding.ActivityMainBinding
import model.Student
import android.content.Intent
import android.net.Uri
import utils.* // Import các hàm extension từ package utils
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var currentStudent = Student(
        id = "2415053122227",
        name = "Pham Phuong Nhi",
        className = "24T2",
        email = "2415053122227@sv.ute.udn.vn",
        phone = "0868449920",
        gpa = 3.8
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        bindStudentData(currentStudent)
        binding.btnUpdateGpa.setOnClickListener {
            val inputStr = binding.edtNewGpa.text.toString().trim()
            val newGpa = inputStr.toDoubleOrNull()
            if (newGpa == null || newGpa !in 0.0..4.0) {
                binding.edtNewGpa.error = "Vui lòng nhập GPA hợp lệ (0.0 - 4.0)"
                toast("Điểm GPA không hợp lệ!")
                return@setOnClickListener
            }
            currentStudent = currentStudent.copy(gpa = newGpa)
            bindStudentData(currentStudent)
            toast("Cập nhật điểm thành công!")
        }
        binding.btnCall.setOnClickListener {
            val phoneNum = binding.edtPhone.text.toString().trim()
            if (phoneNum.isNotEmpty()) {
                val intent = Intent(Intent.ACTION_DIAL).apply {
                    data = Uri.parse("tel:$phoneNum")
                }
                startActivity(intent)
            } else {
                toast("Vui lòng nhập số điện thoại!")
            }
        }
        binding.btnDeleteStudent.setOnClickListener {
            showConfirmDialog(
                title = "Xác nhận xóa",
                message = "Bạn có chắc chắn muốn xóa hồ sơ sinh viên này không?"
            ) {
                deleteCurrentStudent()
                toast("Đã xóa hồ sơ thành công!")
            }
        }
    }
    private fun bindStudentData(student: Student) {
        with(binding) {
            tvName.text = student.name
            tvStudentId.text = "MSSV: ${student.id} • Lớp: ${student.className}"
            tvGpaBadge.text = "${student.gpa} GPA (${student.gpa.toAcademicRanking()})"
            edtNewGpa.setText(student.gpa.toString())
            edtPhone.setText(student.phone)
        }
    }
    private fun deleteCurrentStudent() {
        binding.cardProfile.visibility = android.view.View.GONE
        toast("Đã xóa thành công!")
    }
}