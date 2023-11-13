package utility

class Quotations {

    var listaDeCitas: ArrayList<Quotation> = ArrayList()

    constructor()

    constructor(c: Quotations) {
        this.listaDeCitas = ArrayList(c.listaDeCitas)
    }

    fun anyadeCita(q: Quotation?) {
        q?.let { listaDeCitas.add(it) }
    }

    fun anyadeCita(quoteText: String?, quoteAuthor: String?) {
        anyadeCita(quoteText?.let { quoteAuthor?.let { it1 -> Quotation(it, it1) } })
    }
}