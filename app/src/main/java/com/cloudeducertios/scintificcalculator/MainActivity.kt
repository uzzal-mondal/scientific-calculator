package com.cloudeducertios.scintificcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.cloudeducertios.scintificcalculator.databinding.ActivityMainBinding
import java.lang.RuntimeException

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        /**
         * logic for scientific calculator
         */
        binding.btn0.setOnClickListener {
            binding.tvMain.text = (binding.tvMain.text.toString() + "0")
        }

        binding.btn1.setOnClickListener {
            binding.tvMain.text = (binding.tvMain.text.toString() + "1")
        }

        binding.btn2.setOnClickListener {
            binding.tvMain.text = (binding.tvMain.text.toString() + "2")
        }

        binding.btn3.setOnClickListener {
            binding.tvMain.text = (binding.tvMain.text.toString() + "3")
        }

        binding.btn4.setOnClickListener {
            binding.tvMain.text = (binding.tvMain.text.toString() + "4")
        }

        binding.btn5.setOnClickListener {
            binding.tvMain.text = (binding.tvMain.text.toString() + "5")
        }

        binding.btn6.setOnClickListener {
            binding.tvMain.text = (binding.tvMain.text.toString() + "6")
        }

        binding.btn7.setOnClickListener {
            binding.tvMain.text = (binding.tvMain.text.toString() + "7")
        }

        binding.btn8.setOnClickListener {
            binding.tvMain.text = (binding.tvMain.text.toString() + "8")
        }

        binding.btn9.setOnClickListener {
            binding.tvMain.text = (binding.tvMain.text.toString() + "9")
        }


        /**
         * part : 2
         */
        binding.btnPoint.setOnClickListener {
            binding.tvMain.text = (binding.tvMain.text.toString() + ".")
        }
        binding.btnSubtraction.setOnClickListener {
            binding.tvMain.text = (binding.tvMain.text.toString() + "-")
        }

        binding.btnAdd.setOnClickListener {
            binding.tvMain.text = (binding.tvMain.text.toString() + "+")
        }

        binding.btnDiv.setOnClickListener {
            binding.tvMain.text = (binding.tvMain.text.toString() + "/")
        }

        binding.btnFirstBracket.setOnClickListener {
            binding.tvMain.text = (binding.tvMain.text.toString() + "(")
        }

        binding.btnSecondBracket.setOnClickListener {
            binding.tvMain.text = (binding.tvMain.text.toString() + ")")
        }

        binding.btnPie.setOnClickListener {
            binding.tvMain.text = (binding.tvMain.text.toString() + "3.1416")
            binding.tvSecondary.text = (binding.btnPie.text.toString())
        }

        binding.btnSin.setOnClickListener {
            binding.tvMain.text = (binding.tvMain.text.toString() + "sin")
        }

        binding.btnCos.setOnClickListener {
            binding.tvMain.text = (binding.tvMain.text.toString() + "cos")
        }

        binding.btnTan.setOnClickListener {
            binding.tvMain.text = (binding.tvMain.text.toString() + "tan")
        }

        binding.btnInv.setOnClickListener {
            binding.tvMain.text = (binding.tvMain.text.toString() + "^" + "-1")
        }

        /**
         * second part
         */

        /*binding.btnSubtraction.setOnClickListener {
            val str: String = binding.tvMain.text.toString()
            try {
                if (!str.get(index = str.length - 1).equals("-")) {
                    binding.tvMain.text = (binding.tvMain.text.toString() + "-")
                } else {
                    Toast.makeText(this, "store subtraction", Toast.LENGTH_SHORT).show()
                }

            } catch (e: Exception) {
                Toast.makeText(this, "store subtraction", Toast.LENGTH_SHORT).show()
            }

        }*/


        binding.btnMultiply.setOnClickListener {
            try {
                val str: String = binding.tvMain.text.toString()
                if (!str.get(index = str.length - 1).equals("*")) {
                    binding.tvMain.text = (binding.tvMain.text.toString() + "*")
                }
            } catch (e: Exception) {
                Toast.makeText(this, "please input first of Number", Toast.LENGTH_SHORT).show()
            }
        }


        /**
         * ok...
         */
        binding.btnRoot.setOnClickListener {
            if (binding.tvMain.toString().isEmpty()) {
                Toast.makeText(this, "please enter a valid number", Toast.LENGTH_SHORT).show()
            } else {
                val str: String = binding.tvMain.text.toString()
                val r = Math.sqrt(str.toDouble())
                val result = r.toString()
                binding.tvMain.text = result
            }
        }

        //done
        binding.btnAc.setOnClickListener {
            binding.tvMain.text = ""
            binding.tvSecondary.text = ""
            Toast.makeText(this, "All Clear.", Toast.LENGTH_SHORT).show()
        }

        /*done..*/
        binding.btnC.setOnClickListener {
            var str: String = binding.tvMain.text.toString()
            if (!str.equals("")) { //store data then working...
                str = str.substring(0, str.length - 1)
                binding.tvMain.text = str
                Toast.makeText(
                    this, "str object save successfully-remove pos : " + str.length,
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(this, "str object  string empty", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnSquare.setOnClickListener {
            if (binding.tvMain.text.toString().isEmpty()) {
                Toast.makeText(this, "please enter a square number", Toast.LENGTH_SHORT).show()
            } else {
                val d: Double = binding.tvMain.text.toString().toDouble()
                val square = d * d
                binding.tvMain.text = square.toString()
                binding.tvSecondary.text = square.toString()
            }
        }

        //todo: it's easy can be showing anisul video..
        binding.btnFactorial.setOnClickListener {
            if (binding.tvMain.text.toString().isEmpty()) {
                Toast.makeText(this, "Please enter a factorial number", Toast.LENGTH_SHORT).show()
            } else {
                val value: Int = binding.tvMain.text.toString().toInt()
                val fact: Int = showFactorial(value)
                binding.tvMain.text = fact.toString()
                binding.tvSecondary.text = fact.toString()
            }
        }

        binding.btnEqual.setOnClickListener {
            val str: String = binding.tvMain.text.toString()
            val result: Double = showEvaluate(str)
            // on below line we are getting result
            // and setting it to text view.
            val r = result.toString()
            binding.tvMain.setText(r)
            binding.tvSecondary.text = str
        }
    }

    /**
     * factorial number logic...
     */
    fun showFactorial(n: Int): Int {
        return if (n == 1 || n == 0) 1 else n * showFactorial(n - 1)
    }

    fun showEvaluate(str: String): Double {
        return object : Any() {
            var pos = -1
            var ch = 0

            fun nextChar() {
                ch = if (++pos < str.length) str[pos].toInt() else -1
            }

            fun eat(charToEdit: Int): Boolean {
                while (ch == ' '.toInt()) nextChar()
                if (ch == charToEdit) {
                    nextChar()
                    return true
                }
                return false
            }

            fun parse(): Double {
                nextChar()
                val x = parseExpression()
                if (pos < str.length) throw RuntimeException("Unexpected : " + ch.toChar())
                return x
            }

            fun parseExpression(): Double {
                var x = parseTerm()
                while (true) {
                    if (eat('+'.toInt())) x += parseTerm()
                    else if (eat('-'.toInt())) x -= parseTerm()
                    else return x
                }
            }

            fun parseTerm(): Double {
                var x = parseFactor()
                while (true) {
                    if (eat('*'.toInt())) x *= parseTerm()
                    else if (eat('/'.toInt())) x /= parseTerm()
                    else return x
                }
            }

            fun parseFactor(): Double {
                if (eat('+'.toInt())) return parseFactor()
                else if (eat('-'.toInt())) return -parseFactor()

                var x: Double
                val startPos = pos
                if (eat('('.toInt())) {
                    x = parseExpression()
                    eat(')'.toInt())
                } else if (ch >= '0'.toInt() && ch <= '9'.toInt() || ch == '.'.toInt()) {
                    while (ch >= '0'.toInt() && ch <= '9'.toInt() || ch == '.'.toInt()) nextChar()
                    x = str.substring(startPos, pos).toDouble()

                } else if (ch >= 'a'.toInt() && ch <= 'z'.toInt()) {
                    // on below function we are checking for the operator in our expression.
                    while (ch >= 'a'.toInt() && ch <= 'z'.toInt()) nextChar()
                    val func = str.substring(startPos, pos)
                    // calling a method to parse our factor.
                    x = parseFactor()
                    // on below line we are checking for square root.
                    x =
                        if (func == "sqrt") Math.sqrt(x)
                        // on below line we are checking for sin function
                        // and calculating sin function using Math class.
                        else if (func == "sin") Math.sin(
                            Math.toRadians(x)
                            // on below line we are calculating the cos value
                        ) else if (func == "cos") Math.cos(
                            Math.toRadians(x)
                            // on below line we are calculating
                            // the tan value of our expression.
                        ) else if (func == "tan")
                            Math.tan(Math.toRadians(x))
                        // on below line we are calculating
                        // log value of the expression.
                        else if (func == "log")
                            Math.log10(x)
                        // on below line we are calculating
                        // ln value of expression.
                        else if (func == "ln") Math.log(x)
                        // f we get any error then
                        // we simply return the exception.
                        else throw RuntimeException(
                            "Unknown function: $func"
                        )
                } else {
                    // if the condition not satisfy then we are returning the exception
                    throw RuntimeException("Unexpected: " + ch.toChar())
                }
                // on below line we are calculating the power of the expression.
                if (eat('^'.toInt())) x = Math.pow(x, parseFactor()) // exponentiation
                return x
            }
            // at last calling a parse for our expression.
        }.parse()

    }
}



