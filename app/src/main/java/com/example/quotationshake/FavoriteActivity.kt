package com.example.quotationshake

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import utility.QuotationAdapter
import utility.Quotations


class FavoriteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite)

        val recyclerView = findViewById<RecyclerView>(R.id.favouriteRecyclerView)
        val layout = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = layout

        val adapter : RecyclerView.Adapter<QuotationAdapter.QuoteViewHolder> = QuotationAdapter(this, getMockQuotations())

        recyclerView.adapter = adapter

        val divider = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        recyclerView.addItemDecoration(divider)
    }

    fun getMockQuotations(): Quotations {
        val quotations = Quotations()
        quotations.anyadeCita("La vida es lo que pasa mientras estás ocupado haciendo otros planes.", "John Lennon")
        quotations.anyadeCita("No sólo no sabemos lo que nos pasa, sino que ni siquiera sabemos lo que hacemos.", "José Ortega y Gasset")
        quotations.anyadeCita("Nuestro carácter es el resultado de nuestra conducta.", "Aristóteles")
        quotations.anyadeCita("Todo lo que podemos decidir es qué hacer con el tiempo que se nos da.", "Gandalf (J.R.R. Tolkien)")
        quotations.anyadeCita("No cuentes los días, haz que los días cuenten.", "Muhammad Ali")
        quotations.anyadeCita("En tres tiempos se divide la vida: en presente, pasado y futuro. De éstos, el presente es brevísimo; el futuro, dudoso; el pasado, cierto.", "Séneca")
        quotations.anyadeCita("La vida es un sueño, y los sueños, sueños son.", "Pedro Calderón de la Barca")
        quotations.anyadeCita("El camino hacia la sabiduría es no tener miedo de equivocarse.", "Confucio")
        quotations.anyadeCita("Haz hoy lo que otros no quieren, haz mañana lo que otros no pueden.", "Jerry Rice")
        quotations.anyadeCita("La mejor manera de prever el futuro es creándolo.", "Peter Drucker")
        quotations.anyadeCita("Todo lo que tienes que decidir es qué hacer con el tiempo que se te ha dado.", "Gandalf (J.R.R. Tolkien)")
        quotations.anyadeCita("La vida es un 10% lo que nos pasa y un 90% cómo reaccionamos a ello.", "Charles R. Swindoll")
        return quotations
    }

    fun launchImplicitIntent(view: View) {
        // Construir la URL de búsqueda en Wikipedia
        val searchQuery = "Albert Einstein"
        val uri = Uri.parse("https://en.wikipedia.org/wiki/Special:Search?search=" + searchQuery)

        // Crear un Intent implícito con acción ACTION_VIEW
        val intent = Intent(Intent.ACTION_VIEW, uri)

        // Asegurarse de que existe alguna actividad capaz de realizar la acción deseada
        if (intent.resolveActivity(packageManager) != null) {
            // Lanzar a ejecución el Intent
            startActivity(intent)
        }
    }
}