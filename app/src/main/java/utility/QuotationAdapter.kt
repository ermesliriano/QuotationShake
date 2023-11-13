package utility

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.quotationshake.R

class QuotationAdapter(context: Context, quotationes: ArrayList<Quotation>?) : RecyclerView.Adapter<QuotationAdapter.QuoteViewHolder>() {

    private val context: Context = context
    private var quotations: Quotations = Quotations()

    init {
        quotationes?.let { quotations.listaDeCitas = it }
    }

    constructor(context: Context, q: Quotations) : this(context, null) {
        this.quotations = q
    }

    override fun getItemCount(): Int = quotations.listaDeCitas.size

    inner class QuoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvQuote: TextView = itemView.findViewById(R.id.quoteTextView)
        val tvAuthor: TextView = itemView.findViewById(R.id.authorTextView)

        init {
            itemView.setOnClickListener {
                val pos = layoutPosition
                val toastMsg = "The " + quotations.listaDeCitas[pos].quoteAuthor + "'s quote has been clicked"
                Toast.makeText(context, toastMsg, Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.quotation_list_row, parent, false)
        return QuoteViewHolder(v)
    }

    override fun onBindViewHolder(holder: QuoteViewHolder, position: Int) {
        val quotation = quotations.listaDeCitas[position]

        holder.tvQuote.text = quotation.quoteText
        holder.tvAuthor.text = quotation.quoteAuthor
    }
    /*fun launchImplicitIntent(view: View) {
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
    }*/
}