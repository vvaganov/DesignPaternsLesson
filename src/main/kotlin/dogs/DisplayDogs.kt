package dogs

import java.awt.Dimension
import java.awt.Font
import java.awt.Insets
import javax.swing.JFrame
import javax.swing.JScrollPane
import javax.swing.JTextArea

class DisplayDogs {

    fun show() {
        val textArea = JTextArea().apply {
            isEditable = false
            font = Font(Font.SERIF, Font.PLAIN, 16)
            margin = Insets(32, 32, 32, 32)
        }
        val scrollPane = JScrollPane(textArea)

        JFrame().apply {
            isVisible = true
            size = Dimension(600, 600)
            isResizable = false
            add(scrollPane)
        }
        DogRepository
            .getInstance()
            .listDogs
            .joinToString("\n")
            .let { textArea.text = it }
    }
}