package my.edu.tarc.insurance

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import my.edu.tarc.insurance.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCalculate.setOnClickListener{
            var basic: Int = 0
            var extra: Int= 0
            var total = 0
            //Get age grooup
            val age = binding.spinnerAge.selectedItemPosition
            if(age == 0){ //Less than 17
                basic = 60
            }
            else if(age == 1){
                basic = 70
            }
            else if(age == 2){
                basic = 90
            }
            else if(age == 3){
                basic = 120
            }
            else{
                basic = 150
            }
            //Get the gender
            val gender = binding.radioGroupGender.checkedRadioButtonId
            if(gender == binding.radioButtonMale.id){
            //Calculate the extra premium for male
                if(age == 0){ //Less than 17
                    extra = 0
                }
                else if(age == 1){
                    extra = 50
                }
                else if(age == 2){
                    extra = 100
                }
                else if(age == 3){
                    extra = 150
                }
                else{
                    extra = 200
                }
            }

            //Get the smoker status
            val smoker = binding.checkBoxSmoker.isChecked
            if(smoker){
            //Calculate the extra premium for a smoker
                if(age == 0){ //Less than 17
                    extra += 0
                }
                else if(age == 1){
                    extra += 100
                }
                else if(age == 2){
                    extra += 150
                }
                else if(age == 3){
                    extra += 200
                }
                else if(age == 4){
                    extra += 250
                }
                else if(age == 5){
                    extra += 300
                }
            }
            total = basic + extra
            binding.myPremium = Premium(basic, extra , total)
        }

        binding.buttonReset.setOnClickListener{
            binding.myPremium = Premium()
            binding.checkBoxSmoker.isChecked = false
            binding.radioButtonMale.isChecked = true
            binding.spinnerAge.setSelection(0)
        }

    }
}