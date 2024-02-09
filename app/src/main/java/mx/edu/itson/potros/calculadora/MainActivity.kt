package mx.edu.itson.potros.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var tvArriba: TextView
    private lateinit var tvAbajo: TextView
    private lateinit var tvError: TextView

    private var operacion: String? = null
    private var numeroArriba: Double = 0.0
    private var numeroAbajo: Double = 0.0
    private var ultimoNumero: String = ""
    private var resultado: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        tvArriba=findViewById<TextView>(R.id.tvArriba)

        tvAbajo = findViewById(R.id.tvAbajo)
        tvError = findViewById(R.id.tvError)




    }

    fun onClickNumero(view: View) {
        val numero = (view as TextView).text.toString()
        ultimoNumero += numero
        tvAbajo.text = ultimoNumero
    }

    fun onClickOperacion(view: View) {
        operacion = (view as TextView).text.toString()
        numeroArriba = tvAbajo.text.toString().toDouble()
        tvArriba.text = tvAbajo.text
        tvAbajo.text = "0"
        ultimoNumero = ""
    }

    fun onClickIgual(view: View) {
        if (operacion != null && ultimoNumero.isNotEmpty()) {
            numeroAbajo = ultimoNumero.toDouble()
            when (operacion) {
                "+" -> resultado = numeroArriba + numeroAbajo
                "-" -> resultado = numeroArriba - numeroAbajo
                "*" -> resultado = numeroArriba * numeroAbajo
                "/" -> {
                    if (numeroAbajo != 0.0) {
                        resultado = numeroArriba / numeroAbajo
                    } else {
                        tvError.text = "Error: División por cero"
                        return
                    }
                }
            }
            tvArriba.text = resultado.toString()
            tvAbajo.text = "0"
            ultimoNumero = ""
            operacion = null
            tvError.text = ""
        }
    }

    fun onClickLimpiar(view: View) {
        tvArriba.text = ""
        tvAbajo.text = "0"
        tvError.text = ""
        operacion = null
        numeroArriba = 0.0
        numeroAbajo = 0.0
        ultimoNumero = ""
        resultado = 0.0
    }
}