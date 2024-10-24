package najuarahmahputri.polbeng.ac.id.temperatureconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var etName: EditText
    private lateinit var etCelsius: EditText
    private lateinit var btnCalculate: Button
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inisialisasi UI components
        etName = findViewById(R.id.etName)
        etCelsius = findViewById(R.id.etCelsius)
        btnCalculate = findViewById(R.id.btnCalculate)
        tvResult = findViewById(R.id.tvResult)

        // Set listener untuk tombol konversi
        btnCalculate.setOnClickListener {
            val name = etName.text.toString()
            val celsiusStr = etCelsius.text.toString()

            // Validasi input
            if (name.isEmpty() || celsiusStr.isEmpty()) {
                Toast.makeText(this, "Mohon isi semua kolom", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Coba konversi inputan suhu menjadi angka
            try {
                val celsius = celsiusStr.toDouble()
                val fahrenheit = (celsius * 9 / 5) + 32

                // Format hasil
                val resultText = "Halo $name, suhu $celsius°C sama dengan $fahrenheit°F"
                tvResult.text = resultText
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Mohon masukkan angka yang valid", Toast.LENGTH_SHORT).show()
            }
        }
    }
}