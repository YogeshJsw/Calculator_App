package com.yogeshj.calculator

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.yogeshj.calculator.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private var res:String=""
    private var num1:Double=0.0
    private var isAdd:Boolean=false
    private var isSub:Boolean=false
    private var isMul:Boolean=false
    private var isDiv:Boolean=false
    private var isMod:Boolean=false
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.operations.text = res
        //clear
        binding.ac.setOnClickListener {
            res = ""
            binding.operations.text = res
            binding.result.text = "0"
        }

        setClickListenerFor1to9()

        clickListenerForOperations()

        binding.equal.setOnClickListener {
            var i=0
            val arr= res.toCharArray()
            while (i<arr.size)
            {
                if(arr[i]=='×')
                    arr[i]='*'
                if(arr[i]=='÷')
                    arr[i]='/'
                i++
            }
            res= String(arr)
            val str="Error"
            val result:Double
            try {
                result=calculateExpression(res)
                binding.result.text="$result"
            }
            catch (e:Exception)
            {
                Toast.makeText(this,"Cannot divide 1 by 0",Toast.LENGTH_SHORT).show()
                binding.result.text = str
                binding.operations.text = ""
                res=""
            }
        }
    }

//    private fun roundDouble(value: Double, decimalPlaces: Int): Double {
//        val factor = 10.0.pow(decimalPlaces.toDouble())
//        return (value * factor).toLong() / factor
//    }x

    private fun calculateExpression(expression: String): Double {

            val exp = ExpressionBuilder(expression).build()
            return  exp.evaluate()


//        return roundDouble(ans,2)
    }
    private fun clickListenerForOperations() {
        binding.add.setOnClickListener {
            if(res!="" && res[res.length-1].isDigit())
            {
                isAdd=true
                res+="+"
                binding.operations.text=res
            }
        }

        binding.sub.setOnClickListener {
            if(res!="" && res[res.length-1].isDigit())
            {
                isSub=true
                res+="-"
                binding.operations.text=res
            }
        }
        binding.mult.setOnClickListener {
            if(res!="" && res[res.length-1].isDigit())
            {
                isMul=true
                res+="×"
                binding.operations.text=res
            }
        }
        binding.divide.setOnClickListener {
            if(res!="" && res[res.length-1].isDigit())
            {
                isDiv=true
                res+="÷"
                binding.operations.text=res
            }
        }

        binding.mod.setOnClickListener {
            if(res!="" && res[res.length-1].isDigit())
            {
                isMod=true
                res+="%"
                binding.operations.text=res
            }
        }
        binding.negative.setOnClickListener {
            if(res.isNotEmpty())
            {
                res=res.dropLast(1)
//                res="$num2"
                binding.operations.text=res
                resultCal()
            }
        }
    }

    private fun setClickListenerFor1to9() {
        binding.one.setOnClickListener {
            res+="1"
            num1=(num1*10)+1
            binding.operations.text=res
            resultCal()
        }
        binding.two.setOnClickListener {
            res+="2"
            num1=(num1*10)+2
            binding.operations.text=res
            resultCal()
        }
        binding.three.setOnClickListener {
            res+="3"
            num1=(num1*10)+3
            binding.operations.text=res
            resultCal()
        }
        binding.four.setOnClickListener {
            res+="4"
            num1=(num1*10)+4
            binding.operations.text = res
            resultCal()
        }
        binding.five.setOnClickListener {
            res+="5"
            num1=(num1*10)+5
            binding.operations.text=res
            resultCal()
        }
        binding.six.setOnClickListener {
            res+="6"
            num1=(num1*10)+6
            binding.operations.text=res
            resultCal()
        }
        binding.seven.setOnClickListener {
            res+="7"
            num1=(num1*10)+7
            binding.operations.text=res
            resultCal()
        }
        binding.eight.setOnClickListener {
            res+="8"
            num1=(num1*10)+8
            binding.operations.text=res
            resultCal()
        }
        binding.nine.setOnClickListener {
            res+="9"
            num1=(num1*10)+9
            binding.operations.text=res
            resultCal()
        }
        binding.zero.setOnClickListener {
            res+="0"
            num1=(num1*10)+0
            binding.operations.text=res
            resultCal()
        }
        binding.point.setOnClickListener {
            res+="."
            num1=(num1*10)+0.0
            binding.operations.text=res
            resultCal()
        }

    }

    private fun resultCal() {
        if(isAdd || isSub || isMul || isDiv || isMod) {


            try {
                var i = 0
                val arr = res.toCharArray()
                while (i < arr.size) {
                    if (arr[i] == '×')
                        arr[i] = '*'
                    if (arr[i] == '÷')
                        arr[i] = '/'
                    i++
                }
                res = String(arr)
                val str="Error"
                val result:Double
                try {
                    result=calculateExpression(res)
                    binding.result.text="$result"
                }
                catch (e:Exception)
                {
                    binding.result.text = str
                    binding.operations.text = ""
                    res=""
                }


            } catch (e: Exception) {
                Toast.makeText(this,"Cannot divide 1 by 0",Toast.LENGTH_SHORT).show()
            }
        }
    }
}