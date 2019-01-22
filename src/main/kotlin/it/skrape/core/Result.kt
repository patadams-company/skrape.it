package it.skrape.core

import org.jsoup.nodes.Element
import org.jsoup.select.Elements

class Result(
        private val response: Response,
        private val document: Doc = response.parse(),
        val statusCode: Int = response.statusCode(),
        val statusMessage: String = response.statusMessage(),
        val contentType: String? = response.contentType()

) {

    fun document(): Doc {
        return document
    }

    @SkrapeItDslMarker
    fun document(init: Doc.() -> Unit) {
        document.apply(init)
    }

    @SkrapeItDslMarker
    fun element(selector: String, init: Element.() -> Unit) {
        document.selectFirst(selector).apply(init)
    }

    @SkrapeItDslMarker
    fun elements(selector: String, init: Elements.() -> Unit) {
        document.select(selector).apply(init)
    }
}